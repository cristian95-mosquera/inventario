package inventario.service;

import inventario.dto.DtoMercancia;
import inventario.entity.Mercancia;
import inventario.entity.Usuario;
import inventario.excepcion.CargoException;
import inventario.excepcion.MercanciaException;
import inventario.repository.RepositoryMercancia;
import inventario.repository.RepositoryUsuario;
import inventario.util.Constante;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static java.time.temporal.ChronoUnit.DAYS;

@Service
@Transactional
public class ServiceMercancia {

    @Autowired
    RepositoryMercancia repositoryMercancia;

    @Autowired
    RepositoryUsuario repositoryUsuario;

    @Autowired
    ServiceUsuario serviceUsuario;

    public List<Mercancia> listar() {
        return repositoryMercancia.findAll();
    }

    public Mercancia consultarPorNombre(@PathVariable("nombreProducto") String nombreProducto) {
        Optional<Mercancia> mercanciaOptional = repositoryMercancia.findByNombreProducto(nombreProducto);
        VerificarLaMercanciaExistente(mercanciaOptional);
        return mercanciaOptional.get();
    }

    public void agregar(DtoMercancia dtoMercancia) {
        Optional<Usuario> usuarioOptional = repositoryUsuario.findById(dtoMercancia.getUsuario());
        validarMercanciaPorNombre(dtoMercancia);
        serviceUsuario.validarExisteUsuario(usuarioOptional);
        validarfechaSeaMenorAFechaActual(dtoMercancia.getFechaIngreso());
        Usuario usuario = usuarioOptional.get();
        Mercancia mercancia = new Mercancia(dtoMercancia.getNombreProducto(), dtoMercancia.getCantidad(), dtoMercancia.getFechaIngreso());
        mercancia.setUsuario(usuario);
        repositoryMercancia.save(mercancia);
    }

    public void actualizar(DtoMercancia dtoMercancia, int id) {
        Optional<Usuario> usuarioOptional = repositoryUsuario.findById(dtoMercancia.getUsuario());
        Optional<Mercancia> mercanciaOptional = repositoryMercancia.findById(id);
        VerificarLaMercanciaExistente(mercanciaOptional);
        validarMercanciaPorNombre(dtoMercancia);
        serviceUsuario.validarExisteUsuario(usuarioOptional);
        validarfechaSeaMenorAFechaActual(dtoMercancia.getFechaIngreso());
        actualizarMercancia(usuarioOptional, mercanciaOptional, dtoMercancia);
    }

    public void actualizarMercancia(Optional<Usuario> usuarioOptional, Optional<Mercancia> mercanciaOptional, DtoMercancia dtoMercancia) {
        Usuario usuario = usuarioOptional.get();
        Mercancia mercancia = mercanciaOptional.get();
        mercancia.setUsuario(usuario);
        mercancia.setNombreProducto(dtoMercancia.getNombreProducto());
        mercancia.setCantidad(dtoMercancia.getCantidad());
        mercancia.setFechaIngreso(dtoMercancia.getFechaIngreso());
        repositoryMercancia.save(mercancia);
    }

    public void eliminar(int id) {
        Optional<Mercancia> mercanciaOptional = repositoryMercancia.findById(id);
        VerificarLaMercanciaExistente(mercanciaOptional);
        repositoryMercancia.deleteById(id);
    }

    public void VerificarLaMercanciaExistente(Optional<Mercancia> mercanciaOptional) {
        if (!mercanciaOptional.isPresent()) {
            throw new CargoException(Constante.LA_MERCANCIA_NO_EXISTE);
        }
    }

    public void validarMercanciaPorNombre(DtoMercancia dtoMercancia) {
        boolean existeMercancia = repositoryMercancia.existsByNombreProducto(dtoMercancia.getNombreProducto());
        if (existeMercancia) {
            throw new MercanciaException(Constante.MERCANCIA_REPETIDA);
        }
    }

    public void validarfechaSeaMenorAFechaActual(LocalDate fechaIngreso) {
        LocalDate fechaActual = LocalDate.now();
        Long diferenciaEnDias = getDaysCountBetweenDates(fechaIngreso, fechaActual);
        System.out.println(diferenciaEnDias);
        if (diferenciaEnDias < 0) {
            throw new MercanciaException(Constante.LA_FECHA_DE_INGRESO_ES_INCORRECTA);
        }
    }

    public long getDaysCountBetweenDates(LocalDate dateBefore, LocalDate dateAfter) {
        return DAYS.between(dateBefore, dateAfter);
    }

}
