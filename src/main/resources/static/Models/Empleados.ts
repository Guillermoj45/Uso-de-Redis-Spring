export class Empleados {
    id_empleado: number;
    nombre: string;
    apellido: string;
    direccion: string;
    telefono: string;

    constructor(id_empleado: number, nombre: string, apellido: string, direccion: string, telefono: string) {
        this.id_empleado = id_empleado;
        this.nombre = nombre;
        this.apellido = apellido;
        this.direccion = direccion;
        this.telefono = telefono;
    }
}