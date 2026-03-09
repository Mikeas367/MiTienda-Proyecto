package com.backend.backend.usecase.ventas;

import com.backend.backend.dominio.modelos.DetalleVenta;
import com.backend.backend.dominio.modelos.Venta;

import java.util.List;

public interface INuevaVentaInteractor {
    Venta nuevaVenta(List<DetalleVenta> detallesVenta);
}
