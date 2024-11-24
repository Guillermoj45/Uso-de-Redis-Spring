import {ClienteService} from "../Services/ClienteService";

document.addEventListener("DOMContentLoaded", function() {
    let cuerpo_tabla = document.getElementById("cuerpo_tabla");

    ClienteService.getClientes().then((clientes) => {
        clientes.forEach((cliente) => {
            let fila = document.createElement("tr");
            fila.innerHTML = `
                <td>${cliente.id}</td>
                <td>${cliente.nombre}</td>
                <td>${cliente.apellido}</td>
                <td>${cliente.direccion}</td>
                <td>${cliente.telefono}</td>
            `;
            cuerpo_tabla.appendChild(fila);
        });
    });
    console.log("Hola");
});
