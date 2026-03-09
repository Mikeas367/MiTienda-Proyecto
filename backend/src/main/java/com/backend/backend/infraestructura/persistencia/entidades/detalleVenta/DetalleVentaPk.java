package com.backend.backend.infraestructura.persistencia.entidades.detalleVenta;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class DetalleVentaPk implements Serializable {

    @Column(name = "id_venta")
    private long idVenta;
    @Column(name = "id_producto")
    private long idProducto;



    public DetalleVentaPk() {
    }

    public DetalleVentaPk(long idVenta, long idProducto) {
        this.idVenta = idVenta;
        this.idProducto = idProducto;
    }

    public long getIdVenta() {
        return idVenta;
    }

    public long getIdProducto() {
        return idProducto;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        DetalleVentaPk that = (DetalleVentaPk) o;
        return idVenta == that.idVenta && idProducto == that.idProducto;
    }

    @Override
    public int hashCode() {
        return Objects.hash(idVenta, idProducto);
    }
}
