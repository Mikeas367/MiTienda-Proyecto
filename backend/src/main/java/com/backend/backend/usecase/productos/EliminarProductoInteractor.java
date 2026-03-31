package com.backend.backend.usecase.productos;

import com.backend.backend.dominio.modelos.Producto;
import com.backend.backend.dominio.repositorio.ProductRepositoryPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EliminarProductoInteractor implements IEliminarProductoInteractor {

    private final ProductRepositoryPort productRepositoryPort;

    public EliminarProductoInteractor(ProductRepositoryPort productRepositoryPort) {
        this.productRepositoryPort = productRepositoryPort;
    }

    @Override
    public void eliminarProducto(String codigoProducto) {
        Producto existe = productRepositoryPort.findByCodigoProducto(codigoProducto);

        if (existe == null) {
            throw new RuntimeException("No se puede eliminar: El producto " + codigoProducto + " no existe.");
        }
        productRepositoryPort.eliminarProducto(codigoProducto);
    }
}
