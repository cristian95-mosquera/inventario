package inventario.controller;

import inventario.dto.DtoMercancia;
import inventario.entity.Mercancia;
import inventario.service.ServiceMercancia;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/mercancia")
public class ControllerMercancia {

    @Autowired
    ServiceMercancia serviceMercancia;

    @GetMapping
    public List<Mercancia> listar() {
        return serviceMercancia.listar();
    }

    @GetMapping("/{nombreProducto}")
    public Mercancia consultarPorNombre(@PathVariable("nombreProducto") String nombreProducto) {
        return serviceMercancia.consultarPorNombre(nombreProducto);
    }

    @PostMapping
    public void guardarMercancia(@RequestBody DtoMercancia dtoMercancia) {
        serviceMercancia.agregar(dtoMercancia);
    }

    @PutMapping("/{id}")
    public void editar(@PathVariable("id") int id, @RequestBody DtoMercancia dtoMercancia) {
        serviceMercancia.actualizar(dtoMercancia, id);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable("id") int id) {
        serviceMercancia.eliminar(id);

    }
}
