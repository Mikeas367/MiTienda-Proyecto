package com.backend.backend.infraestructura.dtos;

import com.backend.backend.dominio.modelos.Producto;

public class DetalleVentaDTO {
    Producto producto;
    int cantidad;

    public Producto getProducto() {
        return producto;
    }


    public int getCantidad() {
        return cantidad;
    }

}
