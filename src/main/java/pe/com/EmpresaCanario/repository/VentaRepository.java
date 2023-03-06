package pe.com.EmpresaCanario.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pe.com.EmpresaCanario.entity.Venta;

public interface VentaRepository extends JpaRepository<Venta, Long> {
    @Query("select v from venta v where v.estado='1'")
    List<Venta> findAllCustom();
}