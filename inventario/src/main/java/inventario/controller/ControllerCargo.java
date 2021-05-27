package inventario.controller;

import inventario.entity.Cargo;
import inventario.service.ServiceCargo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cargo")
public class ControllerCargo {

    @Autowired
    ServiceCargo serviceCargo;

    @GetMapping
    public List<Cargo> listarCargo() {
        return serviceCargo.listar();

    }

    @GetMapping("/{id}")
    public Cargo consultarId(@PathVariable("id") int id) {
        return serviceCargo.consultarId(id);
    }

    @PostMapping
    public void crearCargo(@RequestBody Cargo cargo) {
        serviceCargo.guardarCargo(cargo);
    }

    @PutMapping("/{id}")
    public void actualizarCargo(@PathVariable("id") int id, @RequestBody Cargo cargo) {
        serviceCargo.actualizarCargo(cargo, id);
    }

    @DeleteMapping("/{id}")
    public void eliminarCargo(@PathVariable("id") int id) {
        serviceCargo.eliminarCargo(id);
    }
}
