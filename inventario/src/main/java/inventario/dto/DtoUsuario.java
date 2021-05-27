package inventario.dto;

import java.time.LocalDate;
import java.util.Date;

public class DtoUsuario {

    private int id;
    private String nombre;
    private int edad;
    private LocalDate fechaIngresoCompaia;
    private int idCargo;

    public DtoUsuario() {
    }

    public DtoUsuario(int id, String nombre, int edad, LocalDate fechaIngresoCompaia, int idCargo) {
        this.id = id;
        this.nombre = nombre;
        this.edad = edad;
        this.fechaIngresoCompaia = fechaIngresoCompaia;
        this.idCargo = idCargo;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public int getEdad() {
        return edad;
    }

    public LocalDate getFechaIngresoCompaia() {
        return fechaIngresoCompaia;
    }

    public int getIdCargo() {
        return idCargo;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public void setFechaIngresoCompaia(LocalDate fechaIngresoCompaia) {
        this.fechaIngresoCompaia = fechaIngresoCompaia;
    }

    public void setIdCargo(int idCargo) {
        this.idCargo = idCargo;
    }
}
