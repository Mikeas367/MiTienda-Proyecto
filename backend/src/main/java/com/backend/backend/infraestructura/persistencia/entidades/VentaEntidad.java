package com.backend.backend.infraestructura.persistencia.entidades;

import com.backend.backend.infraestructura.persistencia.entidades.detalleVenta.DetalleVentaEntidad;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Ventas")
public class VentaEntidad {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private LocalDateTime fechaVenta;
    private double total;
    @OneToMany(mappedBy = "venta", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<DetalleVentaEntidad> detalles = new ArrayList<>();

    public VentaEntidad(LocalDateTime fechaVenta, double total, List<DetalleVentaEntidad> detalles) {
        this.fechaVenta = fechaVenta;
        this.total = total;
        this.detalles = detalles;
    }



    public VentaEntidad() {
    }

    public long getId() {
        return id;
    }

    public LocalDateTime getFechaVenta() {
        return fechaVenta;
    }

    public double getTotal() {
        return total;
    }

    public List<DetalleVentaEntidad> getDetalles() {
        return detalles;
    }

    @Override
    public String toString() {
        return "VentaEntidad{" +
                "id=" + id +
                ", fechaVenta=" + fechaVenta +
                ", total=" + total +
                '}';
    }
}
