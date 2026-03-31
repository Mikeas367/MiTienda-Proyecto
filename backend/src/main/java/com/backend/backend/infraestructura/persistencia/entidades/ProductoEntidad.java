package com.backend.backend.infraestructura.persistencia.entidades;

import jakarta.persistence.*;

@Entity
@Table(name = "productos")
public class ProductoEntidad {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(unique = true, nullable = false)
    private String codigoProducto;
    private String nombre;
    private double precioCosto;
    private double precioVenta;
    private int stock;

    public ProductoEntidad(String codigoProducto, String nombre, double precioCosto, double precioVenta, int stock) {
        this.codigoProducto = codigoProducto;
        this.nombre = nombre;
        this.precioCosto = precioCosto;
        this.precioVenta = precioVenta;
        this.stock = stock;
    }

    public ProductoEntidad() {
    }

    public long getId() {
        return id;
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

    @Override
    public String toString() {
        return "ProductoEntidad{" +
                "id=" + id +
                ", codigoProducto='" + codigoProducto + '\'' +
                ", nombre='" + nombre + '\'' +
                ", precioCosto=" + precioCosto +
                ", precioVenta=" + precioVenta +
                ", stock=" + stock +
                '}';
    }
}
