package com.backend.backend.dominio.modelos;

import java.time.LocalDateTime;
import java.util.List;

public class Venta {

    private long idVenta;
    private LocalDateTime fechaVenta;
    private double total;

    private List<DetalleVenta> detalleVentas;

    public void calcularTotal() {
        for(DetalleVenta detalleVenta : this.detalleVentas){
            detalleVenta.calcularSubtotal();
            total += detalleVenta.getSubtotal();
        }
    }





    public Venta() {
    }

    public Venta(int idVenta, LocalDateTime fechaVenta, double total, List<DetalleVenta> detalleVentas) {
        this.idVenta = idVenta;
        this.fechaVenta = fechaVenta;
        this.total = total;
        this.detalleVentas = detalleVentas;
    }

    public long getIdVenta() {
        return idVenta;
    }

    public void setIdVenta(int idVenta) {
        this.idVenta = idVenta;
    }

    public LocalDateTime getFechaVenta() {
        return fechaVenta;
    }

    public void setFechaVenta(LocalDateTime fechaVenta) {
        this.fechaVenta = fechaVenta;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public List<DetalleVenta> getDetalleVentas() {
        return detalleVentas;
    }

    public void setDetalleVentas(List<DetalleVenta> detalleVentas) {
        this.detalleVentas = detalleVentas;
    }
}
