package com.backend.backend.usecase.ventas;

import com.backend.backend.dominio.modelos.DetalleVenta;
import com.backend.backend.dominio.modelos.Venta;
import com.backend.backend.dominio.repositorio.VentaRepositoryPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Component
public class NuevaVentaInteractor implements INuevaVentaInteractor {
    @Autowired
    private VentaRepositoryPort ventaRepositoryPort;

    @Override
    public Venta nuevaVenta(List<DetalleVenta> detallesVenta) {
        LocalDateTime fechaActual = LocalDateTime.now();
        long codigoVenta = Long.parseLong(System.currentTimeMillis() + "" + (int)(Math.random() * 90 + 10));

        for (DetalleVenta detalleVenta : detallesVenta) {
            detalleVenta.calcularSubtotal();
            System.out.println("Subtotal: " + detalleVenta.getSubtotal());
        }
        Venta venta = new Venta(codigoVenta, fechaActual,detallesVenta);
        venta.calcularTotal();
        System.out.println("Total: " + venta.getTotal());

        ventaRepositoryPort.nuevaVenta(venta);
        return null;
    }
}
