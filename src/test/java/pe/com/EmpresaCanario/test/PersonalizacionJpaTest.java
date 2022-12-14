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
import pe.com.EmpresaCanario.repository.PersonalizacionRepository;

@DataJpaTest
@AutoConfigureTestDatabase(replace=Replace.NONE)
public class PersonalizacionJpaTest {
    
    private static Personalizacion objpersonalizacion;
    @Autowired
    private PersonalizacionRepository repositorio;
    
    @BeforeAll
    public static void Inicio(){
        objpersonalizacion=new Personalizacion();
        System.out.println("@BeforeAll -->Inicio");
        
    }
    
    @AfterAll
    public static void Final(){
        objpersonalizacion=null;
        System.out.println("@AfterAll -->Final()");
    }
    
    @Test
    public void Mensaje(){
        System.out.println("Prueba Inicial");
        System.out.println("@Test -->PruabaInicial");
    }
    
    @Test
    public void findAllTest(){
        List<Personalizacion> personalizacion=repositorio.findAll();
        assertNotNull(personalizacion);
        System.out.println("@Test -->findAllTest()");
    }
    
    @Test
    public void findAllCustomTest(){
        List<Personalizacion> personalizacion=repositorio.findAllCustom();
        assertNotNull(personalizacion);
        System.out.println("@Test -->findAllCustomTest()");
    }
    
    @Test
    public void findByIdTest(){
        long id=1;
        Optional<Personalizacion> personalizacion=repositorio.findById(id);
        assertNotNull(personalizacion);
        System.out.println("@Test -->findByIdTest()");
    }
    
    @Test
    @Rollback(false)
    public void addTest(){
        
        objpersonalizacion.setTamano(50);
        objpersonalizacion.setDiseno("Ladybug con plumas2");
        objpersonalizacion.setPreciopersonal(50);
        objpersonalizacion.setEstado(true);
        
        Personalizacion personalizacion= repositorio.save(objpersonalizacion);
        assertNotNull(personalizacion);
        System.out.println("@Test --> addTest()");
    }
    
    @Test
    @Rollback(false)
    public void updateTest(){
        
        objpersonalizacion.setIdpersonalizado(2);
        
        objpersonalizacion.setTamano(40);
        objpersonalizacion.setDiseno("Ben 10");
        objpersonalizacion.setPreciopersonal(50);
        objpersonalizacion.setEstado(true);
        
        Personalizacion personalizacion= repositorio.save(objpersonalizacion);
        assertNotNull(personalizacion);
        System.out.println("@Test --> updateTest()");
    }
    
    @Test
    @Rollback(false)
    public void deleteTest(){
        
        objpersonalizacion.setIdpersonalizado(2);
        
        objpersonalizacion.setTamano(40);
        objpersonalizacion.setDiseno("Ben 10");
        objpersonalizacion.setPreciopersonal(50);
        objpersonalizacion.setEstado(false);
        
        Personalizacion personalizacion= repositorio.save(objpersonalizacion);
        assertNotNull(personalizacion);
        System.out.println("@Test --> deleteTest()");
    }

}
