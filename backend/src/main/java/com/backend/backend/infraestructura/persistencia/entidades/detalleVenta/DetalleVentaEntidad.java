package com.backend.backend.infraestructura.persistencia.entidades.detalleVenta;

import com.backend.backend.infraestructura.persistencia.entidades.ProductoEntidad;
import com.backend.backend.infraestructura.persistencia.entidades.VentaEntidad;
import jakarta.persistence.*;

@Entity
@Table(name = "DetalleVentas")

public class DetalleVentaEntidad {
    @EmbeddedId
    private DetalleVentaPk detalleVentaPk = new DetalleVentaPk();;
    private int cantidad;
    private double subtotal;

    @ManyToOne
    @MapsId("idVenta")
    @JoinColumn(name = "id_venta")
    private VentaEntidad venta;

    @ManyToOne
    @MapsId("idProducto")
    @JoinColumn(name = "id_producto")
    private ProductoEntidad producto;

    public DetalleVentaEntidad(int cantidad, double subtotal, ProductoEntidad producto) {
        this.cantidad = cantidad;
        this.subtotal = subtotal;
        this.producto = producto;
    }

    public DetalleVentaEntidad() {

    }

    public DetalleVentaPk getDetalleVentaPk() {
        return detalleVentaPk;
    }

    public int getCantidad() {
        return cantidad;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public VentaEntidad getVenta() {
        return venta;
    }

    public ProductoEntidad getProducto() {
        return producto;
    }

    public void setVenta(VentaEntidad venta) {
        this.venta = venta;
    }

    @Override
    public String toString() {
        return "DetalleVentaEntidad{" +
                "cantidad=" + cantidad +
                ", subtotal=" + subtotal +
                ", venta=" + venta +
                ", producto=" + producto.toString() +
                '}';
    }
}
