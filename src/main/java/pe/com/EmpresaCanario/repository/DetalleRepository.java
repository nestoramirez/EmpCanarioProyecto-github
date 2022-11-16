package pe.com.EmpresaCanario.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pe.com.EmpresaCanario.entity.Detalle;

public interface DetalleRepository extends JpaRepository<Detalle, Long> {
    @Query("select d from Detalle d where d.estado='1'")
    List<Detalle> findAllCustom();
}