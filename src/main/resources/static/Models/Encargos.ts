import { Menu } from './Menus';
import { Cliente } from './Cliente';

export class Encargos {
    id: number;
    menu: Menu;
    cliente: Cliente;
    fechaEncargo: string;
    fechaEntrega: string;

    constructor(id: number, menu: Menu, cliente: Cliente, fechaEncargo: string, fechaEntrega: string) {
        this.id = id;
        this.menu = menu;
        this.cliente = cliente;
        this.fechaEncargo = fechaEncargo;
        this.fechaEntrega = fechaEntrega;
    }
}