import axios from "axios"
import type { Producto } from "../models"
import { apiRoutes } from "../api/api"

export const getAllProducts = async () => {
    const response = axios.get<Producto[]>(apiRoutes.PRODUCTOS.ALL_PRODUCTOS)
    return response
}

export const getByCodigoDeProducto = async (codigoDeProducto: string) => {
    const response = axios.get<Producto>(apiRoutes.PRODUCTOS.BY_CODIGO_PRODUCTO(codigoDeProducto))
    return response
}

export const deleteProducto = async  (codigoDeProducto: string) => {
    const response = axios.delete(apiRoutes.PRODUCTOS.ELIMINAR_PRODUCTO(codigoDeProducto))
    return response
}

export const nuevoProducto = async(producto : Producto) => {
    const response = axios.post(apiRoutes.PRODUCTOS.NUEVO_PRODUCTO, producto)
    return response
}