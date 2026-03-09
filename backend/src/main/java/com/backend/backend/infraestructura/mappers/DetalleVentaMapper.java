package com.backend.backend.infraestructura.mappers;

import com.backend.backend.dominio.modelos.DetalleVenta;
import com.backend.backend.infraestructura.persistencia.entidades.ProductoEntidad;
import com.backend.backend.infraestructura.persistencia.entidades.detalleVenta.DetalleVentaEntidad;

public class DetalleVentaMapper {
    public static DetalleVentaEntidad fromDetalleVentaToDetalleVentaEntidad(DetalleVenta detalleVenta) {
        ProductoEntidad productoEntidad = ProductMapper.fromProductoToProductoEntidad(detalleVenta.getProducto());

        return new DetalleVentaEntidad(detalleVenta.getCantidad(),
                detalleVenta.getSubtotal(),
                productoEntidad);
    }
}
