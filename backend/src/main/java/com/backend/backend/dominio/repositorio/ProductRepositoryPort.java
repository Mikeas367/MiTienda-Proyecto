package com.backend.backend.dominio.repositorio;

import com.backend.backend.dominio.modelos.Producto;
import org.springframework.stereotype.Component;

import java.util.List;

public interface ProductRepositoryPort {
    Producto findByCodigoProducto(String codigoProducto);
    List<Producto> getAllProductos();
    Producto nuevoProducto(Producto producto);

}
