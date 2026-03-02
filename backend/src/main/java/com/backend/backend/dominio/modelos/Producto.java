package com.backend.backend.dominio.modelos;

public class Producto {
    private String codigoProducto;
    private String nombre;
    private double precioCosto;
    private double precioVenta;
    private int stock;

    public Producto(String codigoProducto, String nombre, double precioCosto, double precioVenta, int stock) {
        this.codigoProducto = codigoProducto;
        this.nombre = nombre;
        this.precioCosto = precioCosto;
        this.precioVenta = precioVenta;
        this.stock = stock;
    }

    public Producto() {
    }

    public String getCodigoProducto() {
        return codigoProducto;
    }


    public String getNombre() {
        return nombre;
    }

    public double getPrecioCosto() {
        return precioCosto;
    }



    public double getPrecioVenta() {
        return precioVenta;
    }


    public int getStock() {
        return stock;
    }

}
