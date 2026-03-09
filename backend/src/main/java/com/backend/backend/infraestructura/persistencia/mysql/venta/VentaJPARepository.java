package com.backend.backend.infraestructura.persistencia.mysql.venta;

import com.backend.backend.infraestructura.persistencia.entidades.VentaEntidad;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VentaJPARepository extends JpaRepository<VentaEntidad, Long> {

}
