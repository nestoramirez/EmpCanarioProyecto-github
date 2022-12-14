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
import pe.com.EmpresaCanario.entity.Cliente;
import pe.com.EmpresaCanario.entity.Pago;
import pe.com.EmpresaCanario.entity.Registro_Usuario;
import pe.com.EmpresaCanario.repository.ClienteRepository;
import pe.com.EmpresaCanario.repository.PagoRepository;

@DataJpaTest
@AutoConfigureTestDatabase(replace=Replace.NONE)
public class PagoJpaTest {

    private static Pago objpago;
    private static Cliente objcliente;
    @Autowired
    private PagoRepository repositorio;
    
    @BeforeAll
    public static void Inicio(){
        objpago=new Pago();
        objcliente=new Cliente();
        System.out.println("@BeforeAll -->Inicio");
        
    }
    
    @AfterAll
    public static void Final(){
        objpago=null;
        objcliente=null;
        System.out.println("@AfterAll -->Final()");
    }
    
    @Test
    public void Mensaje(){
        System.out.println("Prueba Inicial");
        System.out.println("@Test -->PruabaInicial");
    }
    
    @Test
    public void findAllTest(){
        List<Pago> pago=repositorio.findAll();
        assertNotNull(pago);
        System.out.println("@Test -->findAllTest()");
    }
    
    @Test
    public void findAllCustomTest(){
        List<Pago> pago=repositorio.findAllCustom();
        assertNotNull(pago);
        System.out.println("@Test -->findAllCustomTest()");
    }
    
    @Test
    public void findByIdTest(){
        long id=1;
        Optional<Pago> pago=repositorio.findById(id);
        assertNotNull(pago);
        System.out.println("@Test -->findByIdTest()");
    }
    
    @Test
    @Rollback(false)
    public void addTest(){
        
        objcliente.setIdcliente(3);
        objpago.setCliente(objcliente);
        
        objpago.setTipopago("Efectivo");
        objpago.setEstado(true);
        
        Pago pago= repositorio.save(objpago);
        assertNotNull(pago);
        System.out.println("@Test --> addTest()");
    }
    
    @Test
    @Rollback(false)
    public void updateTest(){
        
        objpago.setIdpago(2);
        
        objcliente.setIdcliente(2);
        objpago.setCliente(objcliente);
        
        objpago.setTipopago("Tarjeta de Debito");
        objpago.setEstado(true);
        
        Pago pago= repositorio.save(objpago);
        assertNotNull(pago);
        System.out.println("@Test --> updateTest()");
    }
    
    @Test
    @Rollback(false)
    public void deleteTest(){
        
        objpago.setIdpago(3);
        
        objcliente.setIdcliente(2);
        objpago.setCliente(objcliente);
        
        objpago.setTipopago("Tarjeta de Debito");
        objpago.setEstado(false);
        
        Pago pago= repositorio.save(objpago);
        assertNotNull(pago);
        System.out.println("@Test --> deleteTest()");
    }
    
}
