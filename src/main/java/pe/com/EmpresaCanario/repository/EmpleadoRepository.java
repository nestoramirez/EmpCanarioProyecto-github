package pe.com.EmpresaCanario.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pe.com.EmpresaCanario.entity.Empleado;

public interface EmpleadoRepository extends JpaRepository<Empleado, Long>{
    @Query("select c from Categoria c where c.estado='1'")
        List<Empleado> findAllCustom();
}
