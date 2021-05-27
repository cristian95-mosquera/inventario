import { Cargo } from "./cargo";

export class Usuario {
    id?: number;
    nombre: string;
    edad: number;
    fechaIngresoCompania: Date;
    cargo: Cargo;

    constructor(nombre: string, edad: number, fechaIngresoCompania: Date, cargo: Cargo){
        this.nombre = nombre;
        this.edad = edad;
        this.fechaIngresoCompania = fechaIngresoCompania;
        this.cargo = cargo;
    }

}
