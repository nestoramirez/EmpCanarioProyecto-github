package pe.com.EmpresaCanario.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pe.com.EmpresaCanario.entity.Pago;

public interface PagoRepository extends JpaRepository<Pago, Long>{
    @Query("select p from Pago p where p.estado='1'")
    List<Pago> findAllCustom();
}
