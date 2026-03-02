package com.backend.backend.usecase.productos;

import com.backend.backend.dominio.modelos.Producto;
import com.backend.backend.dominio.repositorio.ProductRepositoryPort;
import org.springframework.stereotype.Component;

@Component
public class NuevoProductoInteractor implements INuevoProductoInteractor {

    private final ProductRepositoryPort productRepositoryPort;

    public NuevoProductoInteractor(ProductRepositoryPort productRepositoryPort) {
        this.productRepositoryPort = productRepositoryPort;
    }

    @Override
    public Producto nuevoProducto(Producto producto) {
        // puede ir mas logica, como validar que no exista nombres duplicados, codigos duplicados,
        // puede validar precios
        Producto productoEnDB = productRepositoryPort.findByCodigoProducto(producto.getCodigoProducto());
        if (productoEnDB == null) {
            return productRepositoryPort.nuevoProducto(producto);
        }
        throw new RuntimeException("Ya existe un producto con ese codigo de Producto");
    }
}
