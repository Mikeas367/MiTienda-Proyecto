package com.backend.backend.usecase.productos;

import com.backend.backend.dominio.modelos.Producto;

public interface IEliminarProductoInteractor {
    void eliminarProducto(String codigoProducto);
}
