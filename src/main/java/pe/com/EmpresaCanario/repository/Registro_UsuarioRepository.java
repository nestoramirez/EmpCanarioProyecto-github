package pe.com.EmpresaCanario.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pe.com.EmpresaCanario.entity.Registro_Usuario;

public interface Registro_UsuarioRepository extends JpaRepository<Registro_Usuario, Long>{
    @Query("select r from Registro_Usuario r where r.estado='1'")
    List<Registro_Usuario> findAllCustom();
}
