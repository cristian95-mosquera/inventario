package inventario.service;

import inventario.repository.RepositoryMercancia;
import inventario.repository.RepositoryUsuario;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;

class ServiceMercanciaTest {

    @Mock
    private RepositoryMercancia repositoryMercancia;

    @InjectMocks
    private ServiceMercancia serviceMercancia;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void listar() {
        // arrange - act
        serviceMercancia.listar();
        // assert
        Mockito.verify(repositoryMercancia, Mockito.times(1))
                .findAll();
    }

    @Test
    void consultarPorNombre() {
    }

    @Test
    void agregar() {
    }

    @Test
    void actualizar() {
    }

    @Test
    void actualizarMercancia() {
    }

    @Test
    void eliminar() {
    }

    @Test
    void verificarLaMercanciaExistente() {
    }

    @Test
    void validarMercanciaPorNombre() {
    }

    @Test
    void validarfechaSeaMenorAFechaActual() {
    }

    @Test
    void getDaysCountBetweenDates() {
    }
}