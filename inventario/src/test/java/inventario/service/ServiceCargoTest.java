package inventario.service;

import inventario.dto.DtoCargo;
import inventario.repository.RepositoryCargo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

class ServiceCargoTest {

    @Mock
    private RepositoryCargo repositoryCargo;

    @InjectMocks
    private ServiceCargo serviceCargo;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void validarlistarTest() {
        // arrange - act
        serviceCargo.listar();
        // assert
        Mockito.verify(repositoryCargo, Mockito.times(1))
                .findAll();
    }

    @Test
    void consultarId() {
    }

    @Test
    void guardarCargo() {
    }

    @Test
    public  void validarExceptionExistenciaDeCargoTest() {



    }

    @Test
    void eliminarCargo() {
    }

    @Test
    void validarExistenciaCargo() {
    }
}