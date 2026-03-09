package com.backend.backend.infraestructura.mappers;

import com.backend.backend.dominio.modelos.Producto;
import com.backend.backend.infraestructura.persistencia.entidades.ProductoEntidad;

public class ProductMapper {

    public static Producto fromProductoEntidadToProducto(ProductoEntidad productoEntidad) {
        return  new Producto(
                productoEntidad.getCodigoProducto(),
                productoEntidad.getNombre(),
                productoEntidad.getPrecioCosto(),
                productoEntidad.getPrecioVenta(),
                productoEntidad.getStock());
    }

    public static ProductoEntidad fromProductoToProductoEntidad(Producto producto) {
        return  new ProductoEntidad(producto.getCodigoProducto(),
                producto.getNombre(),
                producto.getPrecioCosto(),
                producto.getPrecioVenta(),
                producto.getStock());
    }
}
