package com.backend.backend.infraestructura.persistencia.mysql;

import com.backend.backend.dominio.modelos.Producto;
import com.backend.backend.dominio.repositorio.ProductRepositoryPort;
import com.backend.backend.infraestructura.persistencia.entidades.ProductoEntidad;
import com.backend.backend.infraestructura.mappers.ProductMapper;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ProductRepositoryAdapter implements ProductRepositoryPort {

    private final ProductJPARepository productJPARepository;

    public ProductRepositoryAdapter(ProductJPARepository productJPARepository) {
        this.productJPARepository = productJPARepository;
    }

    @Override
    public Producto findByCodigoProducto(String codigoProducto) {
        ProductoEntidad productoEntidad = productJPARepository.findByCodigoProducto(codigoProducto);
        return ProductMapper.fromProductoEntidadToProducto(productoEntidad);
    }

    @Override
    public List<Producto> getAllProductos() {
        List<ProductoEntidad> productoEntidades = productJPARepository.findAll();
        List<Producto> productos = new ArrayList<>();
        for (ProductoEntidad productoEntidad : productoEntidades) {
            productos.add(ProductMapper.fromProductoEntidadToProducto(productoEntidad));
        }
        return productos;
    }

    @Override
    public Producto nuevoProducto(Producto producto) {
        ProductoEntidad productoEntidad = ProductMapper.fromProductoToProductoEntidad(producto);
        ProductoEntidad productoEntidadGuardado = productJPARepository.save(productoEntidad);
        return ProductMapper.fromProductoEntidadToProducto(productoEntidadGuardado);
    }



}
