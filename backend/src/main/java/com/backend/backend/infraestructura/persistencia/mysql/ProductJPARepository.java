package com.backend.backend.infraestructura.persistencia.mysql;

import com.backend.backend.infraestructura.persistencia.entidades.ProductoEntidad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductJPARepository extends JpaRepository<ProductoEntidad, Long> {
    ProductoEntidad findByCodigoProducto(String codigoProducto);

}
