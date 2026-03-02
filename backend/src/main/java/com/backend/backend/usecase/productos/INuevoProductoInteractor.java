package com.backend.backend.usecase.productos;

import com.backend.backend.dominio.modelos.Producto;

public interface INuevoProductoInteractor {
    Producto nuevoProducto(Producto producto);
}
