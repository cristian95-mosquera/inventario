package inventario.service;

import inventario.dto.DtoUsuario;
import inventario.entity.Cargo;
import inventario.entity.Usuario;
import inventario.excepcion.CargoException;
import inventario.repository.RepositoryCargo;
import inventario.repository.RepositoryUsuario;
import inventario.util.Constante;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ServiceUsuario {

    @Autowired
    RepositoryUsuario repositoryUsuario;

    @Autowired
    RepositoryCargo repositoryCargo;

    @Autowired
    ServiceCargo serviceCargo;

    public List<Usuario> listar() {
        return repositoryUsuario.findAll();
    }

    public Usuario consultarIdUsuario(@PathVariable("id") int id) {
        Optional<Usuario> usuarioOptional = repositoryUsuario.findById(id);
        validarExisteUsuario(usuarioOptional);
        return usuarioOptional.get();
    }

    public void agregarUsuario(DtoUsuario dtoUsuario) {

        Optional<Cargo> cargoOptional = repositoryCargo.findById(dtoUsuario.getIdCargo());
        serviceCargo.validarExistenciaCargo(cargoOptional);
        Cargo cargo = cargoOptional.get();
        Usuario usuario = new Usuario(dtoUsuario.getNombre(), dtoUsuario.getEdad(), dtoUsuario.getFechaIngresoCompaia());
        usuario.setCargo(cargo);
        repositoryUsuario.save(usuario);
    }

    public void actualizarUsuario(DtoUsuario dtoUsuario, int id) {
        Optional<Cargo> cargoOptional = repositoryCargo.findById(dtoUsuario.getIdCargo());
        Optional<Usuario> usuarioOptional = repositoryUsuario.findById(id);
        serviceCargo.validarExistenciaCargo(cargoOptional);
        validarExisteUsuario(usuarioOptional);
        Cargo cargo = cargoOptional.get();
        Usuario usuario = usuarioOptional.get();
        usuario.setCargo(cargo);
        usuario.setNombre(dtoUsuario.getNombre());
        usuario.setEdad(dtoUsuario.getEdad());
        usuario.setFechaIngresoCompaia(dtoUsuario.getFechaIngresoCompaia());
        repositoryUsuario.save(usuario);
    }

    public void eliminarUsuario(int id) {
        Optional<Usuario> usuarioOptional = repositoryUsuario.findById(id);
        validarExisteUsuario(usuarioOptional);
        repositoryUsuario.deleteById(id);
    }

    public void validarExisteUsuario(Optional<Usuario> usuarioOptional) {
        if (!usuarioOptional.isPresent()) {
            throw new CargoException(Constante.EL_USUARIO_NO_PUDO_SER_ENCONTRADO);
        }
    }
}
