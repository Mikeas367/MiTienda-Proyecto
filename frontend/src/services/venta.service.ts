import axios from "axios";
import type { DetalleVenta } from "../models";

export const presupuestoVenta = async (carrito: DetalleVenta[]) => {
    const response = await axios.post("http://localhost:8080/api/ventas/presupuestar", carrito)
    return response   
}