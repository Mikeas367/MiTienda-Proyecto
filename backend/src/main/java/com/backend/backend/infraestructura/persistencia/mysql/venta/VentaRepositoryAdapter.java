package com.backend.backend.infraestructura.persistencia.mysql.venta;

import com.backend.backend.dominio.modelos.Venta;
import com.backend.backend.dominio.repositorio.VentaRepositoryPort;
import com.backend.backend.infraestructura.mappers.VentaMapper;
import com.backend.backend.infraestructura.persistencia.entidades.VentaEntidad;
import com.backend.backend.infraestructura.persistencia.entidades.detalleVenta.DetalleVentaEntidad;
import org.springframework.stereotype.Component;

@Component
public class VentaRepositoryAdapter implements VentaRepositoryPort {

    private final VentaJPARepository repository;

    public VentaRepositoryAdapter(VentaJPARepository repository) {
        this.repository = repository;
    }

    @Override
    public Venta nuevaVenta(Venta venta) {
        VentaEntidad ventaEntidad = VentaMapper.fromVentaToVentaEntidad(venta);
        for(DetalleVentaEntidad detalleVentaEntidad : ventaEntidad.getDetalles()){
            detalleVentaEntidad.setVenta(ventaEntidad);
        }
        VentaEntidad ventaGuardada = repository.save(ventaEntidad);

        System.out.println("Venta Guardada: " + ventaGuardada);
        System.out.println("Detalles de venta: %s\n");
        for (DetalleVentaEntidad detalleVentaEntidad : ventaGuardada.getDetalles()){
            System.out.println(detalleVentaEntidad.toString());
        }
        return null;
    }
}
