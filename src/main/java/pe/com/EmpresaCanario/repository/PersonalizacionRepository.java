package pe.com.EmpresaCanario.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pe.com.EmpresaCanario.entity.Personalizacion;

public interface PersonalizacionRepository extends JpaRepository<Personalizacion, Long> {
    @Query("select p from Personalizacion p where p.estado='1'")
    List<Personalizacion> findAllCustom();
}
