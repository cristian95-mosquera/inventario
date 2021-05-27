import { Usuario } from "./usuario";

export class Mercancia {

    id?: number;
    nombreProducto: string;
    cantidad: number;
    fechaIngreso: Date;
    usuario: Usuario;

    constructor(nombreProducto: string, cantidad: number, fechaIngreso: Date, usuario: Usuario){
        this.nombreProducto = nombreProducto;
        this.cantidad = cantidad;
        this.fechaIngreso = fechaIngreso;
        this.usuario = usuario;
    }
}
