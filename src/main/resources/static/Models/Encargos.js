"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
exports.Encargos = void 0;
var Encargos = /** @class */ (function () {
    function Encargos(id, menu, cliente, fechaEncargo, fechaEntrega) {
        this.id = id;
        this.menu = menu;
        this.cliente = cliente;
        this.fechaEncargo = fechaEncargo;
        this.fechaEntrega = fechaEntrega;
    }
    return Encargos;
}());
exports.Encargos = Encargos;
