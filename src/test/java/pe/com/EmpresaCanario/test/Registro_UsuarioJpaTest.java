package pe.com.EmpresaCanario.test;

import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;
import pe.com.EmpresaCanario.entity.Personalizacion;
import pe.com.EmpresaCanario.entity.Producto;
import pe.com.EmpresaCanario.entity.Registro_Usuario;
import pe.com.EmpresaCanario.repository.PersonalizacionRepository;
import pe.com.EmpresaCanario.repository.ProductoRepository;
import pe.com.EmpresaCanario.repository.Registro_UsuarioRepository;

@DataJpaTest
@AutoConfigureTestDatabase(replace=Replace.NONE)
public class Registro_UsuarioJpaTest {

    private static Registro_Usuario objregistrousuario;
    @Autowired
    private Registro_UsuarioRepository repositorio;
    
    @BeforeAll
    public static void Inicio(){
        objregistrousuario=new Registro_Usuario();
        System.out.println("@BeforeAll -->Inicio");
        
    }
    
    @AfterAll
    public static void Final(){
        objregistrousuario=null;
        System.out.println("@AfterAll -->Final()");
    }
    
    @Test
    public void Mensaje(){
        System.out.println("Prueba Inicial");
        System.out.println("@Test -->PruabaInicial");
    }
    
    @Test
    public void findAllTest(){
        List<Registro_Usuario> registro_usuario=repositorio.findAll();
        assertNotNull(registro_usuario);
        System.out.println("@Test -->findAllTest()");
    }
    
    @Test
    public void findAllCustomTest(){
        List<Registro_Usuario> registro_usuario=repositorio.findAllCustom();
        assertNotNull(registro_usuario);
        System.out.println("@Test -->findAllCustomTest()");
    }
    
    @Test
    public void findByIdTest(){
        long id=1;
        Optional<Registro_Usuario> registro_usuario=repositorio.findById(id);
        assertNotNull(registro_usuario);
        System.out.println("@Test -->findByIdTest()");
    }
    
    @Test
    @Rollback(false)
    public void addTest(){
        
        objregistrousuario.setNombre("Diego");
        objregistrousuario.setApellido("Davila");
        objregistrousuario.setDni("87654321");
        objregistrousuario.setCorreo("jalb@gmail.com");
        objregistrousuario.setTelefono("987654321");
        objregistrousuario.setDireccion("Av.Leon Prado");
        objregistrousuario.setContrasena("123juan");
        objregistrousuario.setEstado(true);
        
        Registro_Usuario registro_usuario= repositorio.save(objregistrousuario);
        assertNotNull(registro_usuario);
        System.out.println("@Test --> addTest()");
    }
    
    @Test
    @Rollback(false)
    public void updateTest(){
        
        objregistrousuario.setIdregistro(3);
        
        objregistrousuario.setNombre("Juan Leonardo");
        objregistrousuario.setApellido("Albornoz Alejo");
        objregistrousuario.setDni("87654321");
        objregistrousuario.setCorreo("jalb@gmail.com");
        objregistrousuario.setTelefono("987654321");
        objregistrousuario.setDireccion("Av.Leon Prado");
        objregistrousuario.setContrasena("123juan");
        objregistrousuario.setEstado(true);
        
        Registro_Usuario registro_usuario= repositorio.save(objregistrousuario);
        assertNotNull(registro_usuario);
        System.out.println("@Test --> updateTest()");
    }
    
    @Test
    @Rollback(false)
    public void deleteTest(){
        
        objregistrousuario.setIdregistro(2);
        
        objregistrousuario.setNombre("Juan Leonardo");
        objregistrousuario.setApellido("Albornoz Alejo");
        objregistrousuario.setDni("87654321");
        objregistrousuario.setCorreo("jalb@gmail.com");
        objregistrousuario.setTelefono("987654321");
        objregistrousuario.setDireccion("Av.Leon Prado");
        objregistrousuario.setContrasena("123juan");
        objregistrousuario.setEstado(false);
        
        Registro_Usuario registro_usuario= repositorio.save(objregistrousuario);
        assertNotNull(registro_usuario);
        System.out.println("@Test --> deleteTest()");
    }
}
