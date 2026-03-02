package com.backend.backend.usecase.productos;

import com.backend.backend.dominio.modelos.Producto;
import com.backend.backend.dominio.repositorio.ProductRepositoryPort;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class EncontrarProductoInteractor implements  IEncontrarProductoInteractor {

    private final ProductRepositoryPort productRepositoryPort;

    public EncontrarProductoInteractor(ProductRepositoryPort productRepositoryPort) {
        this.productRepositoryPort = productRepositoryPort;
    }

    @Override
    public Producto findByCodigoProducto(String codigoProducto) {
        return productRepositoryPort.findByCodigoProducto(codigoProducto);
    }

    @Override
    public List<Producto> getAllProductos() {
        return productRepositoryPort.getAllProductos();
    }
}
