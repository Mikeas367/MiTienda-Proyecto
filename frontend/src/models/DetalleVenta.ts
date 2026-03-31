import type { Producto } from ".";

export interface DetalleVenta {
    producto: Producto,
    cantidad: number
}