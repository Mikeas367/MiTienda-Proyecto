package com.backend.backend.infraestructura.rest;

import com.backend.backend.dominio.modelos.Producto;
import com.backend.backend.usecase.productos.IEncontrarProductoInteractor;
import com.backend.backend.usecase.productos.INuevoProductoInteractor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RequestMapping("/api/productos")
@RestController

public class ProductoRestController {

    @Autowired
    private  IEncontrarProductoInteractor encontrarProductoInteractor;
    @Autowired
    private INuevoProductoInteractor nuevoProductoInteractor;


    @GetMapping("/{codigoProducto}")
    public Producto getProducto(@PathVariable String codigoProducto) {
        return encontrarProductoInteractor.findByCodigoProducto(codigoProducto);
    }

    @GetMapping()
    public List<Producto> getProductos() {
        return encontrarProductoInteractor.getAllProductos();
    }

    @PostMapping("/nuevo-producto")
    public Producto nuevoProducto(@RequestBody Producto producto) {
        return nuevoProductoInteractor.nuevoProducto(producto);
    }
}
