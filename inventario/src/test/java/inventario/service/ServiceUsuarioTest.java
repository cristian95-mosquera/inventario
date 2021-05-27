package inventario.service;

import inventario.dto.DtoUsuario;
import inventario.repository.RepositoryUsuario;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class ServiceUsuarioTest {

    @Mock
    private RepositoryUsuario repositoryUsuario;

    @InjectMocks
    private ServiceUsuario serviceUsuario;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void listar() {
        // arrange - act
        serviceUsuario.listar();
        // assert
        Mockito.verify(repositoryUsuario, Mockito.times(1))
                .findAll();
    }

    @Test
    void consultarIdUsuario() {
    }

    @Test
    void agregarUsuario() {
    }

    @Test
    void actualizarUsuario() {
    }

    @Test
    void eliminarUsuario() {

        int id = 1;
        // arrange - act
        serviceUsuario.eliminarUsuario(id);
        // assert
        Mockito.verify(repositoryUsuario, Mockito.times(1))
                .deleteById(id);
    }

    @Test
    void validarExisteUsuario() {
    }
}