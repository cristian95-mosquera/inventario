package inventario.excepcion;

public class MercanciaException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public MercanciaException(String message) {
        super(message);
    }
}

