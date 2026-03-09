package com.backend.backend.infraestructura.rest;

import com.backend.backend.dominio.modelos.DetalleVenta;
import com.backend.backend.dominio.modelos.Venta;
import com.backend.backend.infraestructura.dtos.DetalleVentaDTO;
import com.backend.backend.usecase.ventas.INuevaVentaInteractor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RequestMapping("/api/ventas")
@RestController
public class VentaRestController {
    private final INuevaVentaInteractor nuevaVentaInteractor;

    public VentaRestController(INuevaVentaInteractor nuevaVentaInteractor) {
        this.nuevaVentaInteractor = nuevaVentaInteractor;
    }

    @PostMapping("/nueva-venta")
    public Venta nuevaVenta(@RequestBody List<DetalleVentaDTO> detallesVentaDTO) {
        // voy a mapear aqui los detalles de venta ya que creo que hacer una Interfaz del iteractor que reciba DTO
        // no estaria tan bien ya que los iteractor deberian trabajar con clases del dominio
        List<DetalleVenta> detalleVenta = new ArrayList<>();
        for (DetalleVentaDTO detalleVentaDTO : detallesVentaDTO) {
            DetalleVenta detalle = DetalleVentaMapper.DetalleVentaDTOToDetalleVenta(detalleVentaDTO);
            detalleVenta.add(detalle);
        }
        return nuevaVentaInteractor.nuevaVenta(detalleVenta);
    }
}
