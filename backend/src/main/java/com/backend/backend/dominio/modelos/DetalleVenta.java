package com.backend.backend.dominio.modelos;

public class DetalleVenta {

    private Producto producto;
    private int cantidad;
    private double subtotal;

    public void calcularSubtotal() {
        subtotal = this.producto.getPrecioVenta() * this.cantidad;
    }

    public DetalleVenta(Producto producto, int cantidad) {
        this.producto = producto;
        this.cantidad = cantidad;
    }

    public DetalleVenta() {
    }
    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }
}
