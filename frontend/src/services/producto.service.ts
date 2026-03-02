import axios from "axios"
import type { Producto } from "../models"
import { apiRoutes } from "../config"

export const getAllProducts = async () => {
    const response = axios.get<Producto[]>(apiRoutes.PRODUCTS)
    return response
}