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
        validarDatos(producto);
        if (existeProductoEnDB(producto)) {
            return productRepositoryPort.nuevoProducto(producto);
        }

        throw new RuntimeException("Ya existe un producto con el codigo: " + producto.getCodigoProducto());
    }

    private void validarDatos(Producto producto) {
        if (producto.getCodigoProducto() == null || producto.getCodigoProducto().isEmpty()) {
            throw new RuntimeException("El codigo de producto no puede ser nulo");
        }
        if (producto.getNombre() == null || producto.getNombre().isEmpty()) {
            throw new RuntimeException("El nombre del producto no puede ser nulo");
        }
        if (producto.getStock() < 0){
            throw new RuntimeException("El stock del producto no puede ser negativo");
        }
        if(producto.getPrecioCosto() < 0){
            throw new RuntimeException("El precio de costo del producto no puede ser negativo");
        }
        if(producto.getPrecioVenta() < 0){
            throw new RuntimeException("El precio de venta del producto no puede ser negativo");
        }

    }

    private Boolean existeProductoEnDB(Producto producto) {
        Producto productoEnDB = productRepositoryPort.findByCodigoProducto(producto.getCodigoProducto());
        if (productoEnDB == null) {
            return true;
        }
        return false;
    }
}
