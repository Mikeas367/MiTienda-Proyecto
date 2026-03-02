package com.backend.backend.usecase.productos;

import com.backend.backend.dominio.modelos.Producto;

import java.util.List;


public interface IEncontrarProductoInteractor {
    Producto findByCodigoProducto(String codigoProducto);
    List<Producto> getAllProductos();
}
