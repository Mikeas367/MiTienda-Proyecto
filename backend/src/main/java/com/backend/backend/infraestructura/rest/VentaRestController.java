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

    // este va a ser un endpoint solo para el calculo en tiempo real del total de la venta para el front
    @PostMapping("/presupuestar")
    public double presupuestar(@RequestBody List<DetalleVentaDTO> detallesVentaDTO) {
        List<DetalleVenta> detallesVenta = DetalleVentaMapper.ListOfDetalleVentaDTOToListOfDetalleVenta(detallesVentaDTO);
        // creo una venta para setearle los detalle y luego calcular el total
        Venta venta = new Venta();
        for (DetalleVenta detalle : detallesVenta) {
            System.out.println("Producto: " + detalle.getProducto().getNombre());
            System.out.println("Precio: " + detalle.getProducto().getPrecioVenta());

        }
        venta.setDetalleVentas(detallesVenta);
        venta.calcularTotal();
        System.out.println("Se calcula el total: " + venta.getTotal());
        return venta.getTotal();
    }

    @PostMapping("/nueva-venta")
    public Venta nuevaVenta(@RequestBody List<DetalleVentaDTO> detallesVentaDTO) {
        // voy a mapear aqui los detalles de venta ya que creo que hacer una Interfaz del iteractor que reciba DTO
        // no estaria tan bien ya que los iteractor deberian trabajar con clases del dominio
        List<DetalleVenta> detallesVenta = DetalleVentaMapper.ListOfDetalleVentaDTOToListOfDetalleVenta(detallesVentaDTO);
        return nuevaVentaInteractor.nuevaVenta(detallesVenta);
    }
}
