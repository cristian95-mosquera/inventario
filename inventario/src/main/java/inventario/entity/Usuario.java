package inventario.entity;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Entity
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nombre;
    private int edad;
    private LocalDate fechaIngresoCompaia;

    @ManyToOne
    @JoinColumn(name = "id_cargo")
    private Cargo cargo;

    public Usuario() {
    }

    public Usuario(String nombre, int edad, LocalDate fechaIngresoCompaia) {
        this.nombre = nombre;
        this.edad = edad;
        this.fechaIngresoCompaia = fechaIngresoCompaia;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public LocalDate getFechaIngresoCompaia() {
        return fechaIngresoCompaia;
    }

    public void setFechaIngresoCompaia(LocalDate fechaIngresoCompaia) {
        this.fechaIngresoCompaia = fechaIngresoCompaia;
    }

    public Cargo getCargo() {
        return cargo;
    }

    public void setCargo(Cargo cargo) {
        this.cargo = cargo;
    }
}
