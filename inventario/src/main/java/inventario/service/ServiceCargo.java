package inventario.service;

import inventario.entity.Cargo;
import inventario.excepcion.CargoException;
import inventario.repository.RepositoryCargo;
import inventario.util.Constante;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ServiceCargo {

    @Autowired
    RepositoryCargo repositoryCargo;

    public List<Cargo> listar() {
        return repositoryCargo.findAll();
    }

    public Cargo consultarId(@PathVariable("id") int id) {
        Optional<Cargo> cargoOptional = repositoryCargo.findById(id);
        validarExistenciaCargo(cargoOptional);
        return cargoOptional.get();
    }

    public void guardarCargo(Cargo cargo) {
        repositoryCargo.save(cargo);
    }

    public void actualizarCargo(Cargo cargo, int id) {
        Optional<Cargo> cargoOptional = repositoryCargo.findById(id);
        validarExistenciaCargo(cargoOptional);
        cargo.setNombre(cargo.getNombre());
        repositoryCargo.save(cargo);
    }

    public void eliminarCargo(int id) {
        Optional<Cargo> cargoOptional = repositoryCargo.findById(id);
        validarExistenciaCargo(cargoOptional);
        repositoryCargo.deleteById(id);
    }

    public void validarExistenciaCargo(Optional<Cargo> cargoOptional) {
        if (!cargoOptional.isPresent()) {
            throw new CargoException(Constante.EL_CARGO_NO_PUEDO_SER_ENCONTRADO);
        }
    }
}
