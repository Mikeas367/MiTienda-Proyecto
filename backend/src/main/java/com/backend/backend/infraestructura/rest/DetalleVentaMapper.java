package com.backend.backend.infraestructura.rest;

import com.backend.backend.dominio.modelos.DetalleVenta;
import com.backend.backend.infraestructura.dtos.DetalleVentaDTO;

import java.util.ArrayList;
import java.util.List;

public class DetalleVentaMapper {


    public static DetalleVenta DetalleVentaDTOToDetalleVenta(DetalleVentaDTO detalleVentaDTO) {
        return new DetalleVenta(detalleVentaDTO.getProducto(), detalleVentaDTO.getCantidad());
    }

    public static List<DetalleVenta> ListOfDetalleVentaDTOToListOfDetalleVenta(List<DetalleVentaDTO> detallesVentaDTO) {
        List<DetalleVenta> detallesVenta = new ArrayList<>();
        for (DetalleVentaDTO detalleVentaDTO : detallesVentaDTO) {
            DetalleVenta detalle = DetalleVentaMapper.DetalleVentaDTOToDetalleVenta(detalleVentaDTO);
            detallesVenta.add(detalle);
        }
        return detallesVenta;
    }


}
