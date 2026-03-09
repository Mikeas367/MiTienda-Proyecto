package com.backend.backend.infraestructura.rest;

import com.backend.backend.dominio.modelos.DetalleVenta;
import com.backend.backend.infraestructura.dtos.DetalleVentaDTO;

public class DetalleVentaMapper {


    public static DetalleVenta DetalleVentaDTOToDetalleVenta(DetalleVentaDTO detalleVentaDTO) {
        return new DetalleVenta(detalleVentaDTO.getProducto(), detalleVentaDTO.getCantidad());
    }


}
