import { Cargo } from "./cargo";

export class Usuario {
    id?: number;
    nombre: string;
    edad: number;
    fechaIngresoCompaia: Date;
    cargo: Cargo;

    constructor(nombre: string, edad: number, fechaIngresoCompaia: Date, cargo: Cargo){
        this.nombre = nombre;
        this.edad = edad;
        this.fechaIngresoCompaia = fechaIngresoCompaia;
        this.cargo = cargo;
    }

}
