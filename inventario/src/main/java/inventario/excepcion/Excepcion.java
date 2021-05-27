package inventario.excepcion;

public class Excepcion extends Exception {

    public Excepcion() {
    }

    public Excepcion(String message, Throwable e) {
        super(message, e);
    }
}
