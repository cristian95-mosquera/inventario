package inventario.controller;

import inventario.dto.DtoUsuario;
import inventario.entity.Usuario;
import inventario.service.ServiceUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuario")
public class ControllerUsuario {

    @Autowired
    ServiceUsuario serviceUsuario;

    @GetMapping
    public List<Usuario> listarUsuairo() {
        return serviceUsuario.listar();
    }

    @GetMapping("/{id}")
    public Usuario consultarId(@PathVariable("id") int id) {
        return serviceUsuario.consultarIdUsuario(id);
    }

    @PostMapping
    public void guardarUsuario(@RequestBody DtoUsuario dtoUsuario) {
        serviceUsuario.agregarUsuario(dtoUsuario);
    }

    @PutMapping("/{id}")
    public void actualizarUsuario(@PathVariable("id") int id, @RequestBody DtoUsuario dtoUsuario) {
        serviceUsuario.actualizarUsuario(dtoUsuario, id);
    }

    @DeleteMapping("/{id}")
    public void eliminarUsuario(@PathVariable("id") int id) {
        serviceUsuario.eliminarUsuario(id);
    }
}
