package com.backend.backend.infraestructura.mappers;

import com.backend.backend.dominio.modelos.DetalleVenta;
import com.backend.backend.dominio.modelos.Venta;
import com.backend.backend.infraestructura.persistencia.entidades.VentaEntidad;
import com.backend.backend.infraestructura.persistencia.entidades.detalleVenta.DetalleVentaEntidad;

import java.util.ArrayList;
import java.util.List;

public class VentaMapper {

    public static VentaEntidad fromVentaToVentaEntidad(Venta venta) {
        List<DetalleVentaEntidad> detallesEntidad = new ArrayList<>();

        for(DetalleVenta detalleVenta : venta.getDetalleVentas()){
            DetalleVentaEntidad detalleVentaEntidad = DetalleVentaMapper.fromDetalleVentaToDetalleVentaEntidad(detalleVenta);
            detallesEntidad.add(detalleVentaEntidad);
        }

        return new VentaEntidad(venta.getFechaVenta(), venta.getTotal(), detallesEntidad);
    }

    public static Venta fromVentaEntidadToVenta(VentaEntidad ventaGuardada) {
        return null;
    }
}
