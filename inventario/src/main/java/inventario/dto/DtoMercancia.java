package inventario.dto;

import java.time.LocalDate;

public class DtoMercancia {

    private int id;
    private String nombreProducto;
    private int cantidad;
    private LocalDate fechaIngreso;
    private int usuario;

    public DtoMercancia() {


    }

    public DtoMercancia(int id, String nombreProducto, int cantidad, LocalDate fechaIngreso, int usuario) {
        this.id = id;
        this.nombreProducto = nombreProducto;
        this.cantidad = cantidad;
        this.fechaIngreso = fechaIngreso;
        this.usuario = usuario;
    }

    public int getId() {
        return id;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public LocalDate getFechaIngreso() {
        return fechaIngreso;
    }

    public int getUsuario() {
        return usuario;
    }
}
