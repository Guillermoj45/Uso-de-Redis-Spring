import {Cliente} from "../Models/Cliente";
import {peticion} from "./ApiService";

export class ClienteService {
    static async getClientes() {
        let promesa = peticion("/cliente");
        let clientes:Cliente[] = [];
        promesa.then((data) => {
            data.forEach((cliente:any) => {
                clientes.push(new Cliente(cliente.id, cliente.nombre, cliente.apellido, cliente.direccion, cliente.telefono));
            });
        });
        return clientes;
    }
}

