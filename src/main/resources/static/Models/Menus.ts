export class Menu {
    id: number;
    nombre: string;
    descripcion: string;
    precio: number;

    constructor(id: number, nombre: string, descripcion: string, precio: number) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
    }
}