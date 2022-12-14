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
import pe.com.EmpresaCanario.entity.Factura;
import pe.com.EmpresaCanario.entity.Pago;
import pe.com.EmpresaCanario.repository.FacturaRepository;

@DataJpaTest
@AutoConfigureTestDatabase(replace=Replace.NONE)
public class FacturaJpaTest {

    private static Factura objfactura;
    private static Cliente objcliente;
    private static Pago objpago;
    @Autowired
    private FacturaRepository repositorio;
    
    @BeforeAll
    public static void Inicio(){
        objfactura=new Factura();
        objcliente=new Cliente();
        objpago=new Pago();
        System.out.println("@BeforeAll -->Inicio");
        
    }
    
    @AfterAll
    public static void Final(){
        objfactura=null;
        objcliente=null;
        objpago=null;
        System.out.println("@AfterAll -->Final()");
    }
    
    @Test
    public void Mensaje(){
        System.out.println("Prueba Inicial");
        System.out.println("@Test -->PruabaInicial");
    }
    
    @Test
    public void findAllTest(){
        List<Factura> factura=repositorio.findAll();
        assertNotNull(factura);
        System.out.println("@Test -->findAllTest()");
    }
    
    @Test
    public void findAllCustomTest(){
        List<Factura> factura=repositorio.findAllCustom();
        assertNotNull(factura);
        System.out.println("@Test -->findAllCustomTest()");
    }
    
    @Test
    public void findByIdTest(){
        long id=1;
        Optional<Factura> factura=repositorio.findById(id);
        assertNotNull(factura);
        System.out.println("@Test -->findByIdTest()");
    }
    
    @Test
    @Rollback(false)
    public void addTest(){
        
        objcliente.setIdcliente(2);
        objfactura.setCliente(objcliente);
        
        objpago.setIdpago(2);
        objfactura.setPago(objpago);
        
        objfactura.setFecha("2022-02-22");
        objfactura.setEstado(true);
        
        Factura factura= repositorio.save(objfactura);
        assertNotNull(factura);
        System.out.println("@Test --> addTest()");
    }
    
    @Test
    @Rollback(false)
    public void updateTest(){
        
        objfactura.setIdfactura(3);
        
        objcliente.setIdcliente(3);
        objfactura.setCliente(objcliente);
        
        objpago.setIdpago(3);
        objfactura.setPago(objpago);
        
        objfactura.setFecha("2022-02-22");
        objfactura.setEstado(true);
        
        Factura factura= repositorio.save(objfactura);
        assertNotNull(factura);
        System.out.println("@Test --> updateTest()");
    }
    
    @Test
    @Rollback(false)
    public void deleteTest(){
        
        objfactura.setIdfactura(3);
        
        objcliente.setIdcliente(3);
        objfactura.setCliente(objcliente);
        
        objpago.setIdpago(3);
        objfactura.setPago(objpago);
        
        objfactura.setFecha("2022-02-22");
        objfactura.setEstado(false);
        
        Factura factura= repositorio.save(objfactura);
        assertNotNull(factura);
        System.out.println("@Test --> deleteTest()");
    }
}
