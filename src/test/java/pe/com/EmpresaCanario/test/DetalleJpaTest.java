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
import pe.com.EmpresaCanario.entity.Detalle;
import pe.com.EmpresaCanario.entity.Factura;
import pe.com.EmpresaCanario.entity.Personalizacion;
import pe.com.EmpresaCanario.entity.Producto;
import pe.com.EmpresaCanario.repository.DetalleRepository;

@DataJpaTest
@AutoConfigureTestDatabase(replace=Replace.NONE)
public class DetalleJpaTest {

    private static Detalle objdetalle;
    private static Factura objfactura;
    private static Producto objproducto;
    private static Personalizacion objpersonalizacion;
    
    @Autowired
    private DetalleRepository repositorio;
    
    @BeforeAll
    public static void Inicio(){
        objdetalle=new Detalle();
        objfactura=new Factura();
        objproducto=new Producto();
        objpersonalizacion=new Personalizacion();
        System.out.println("@BeforeAll -->Inicio");
        
    }
    
    @AfterAll
    public static void Final(){
        objdetalle=null;
        objfactura=null;
        objproducto=null;
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
        List<Detalle> detalle=repositorio.findAll();
        assertNotNull(detalle);
        System.out.println("@Test -->findAllTest()");
    }
    
    @Test
    public void findAllCustomTest(){
        List<Detalle> detalle=repositorio.findAllCustom();
        assertNotNull(detalle);
        System.out.println("@Test -->findAllCustomTest()");
    }
    
    @Test
    public void findByIdTest(){
        long id=1;
        Optional<Detalle> detalle=repositorio.findById(id);
        assertNotNull(detalle);
        System.out.println("@Test -->findByIdTest()");
    }
    
    @Test
    @Rollback(false)
    public void addTest(){
        
        objfactura.setIdfactura(2);
        objdetalle.setFactura(objfactura);
        
        objproducto.setIdproducto(1);
        objdetalle.setProducto(objproducto);
        
        objpersonalizacion.setIdpersonalizado(1);
        objdetalle.setPersonalizacion(objpersonalizacion);
        
        objdetalle.setCantidad(500);
        objdetalle.setPrecio(99);
        objdetalle.setEstado(true);
        
        Detalle detalle= repositorio.save(objdetalle);
        assertNotNull(detalle);
        System.out.println("@Test --> addTest()");
    }
    
    @Test
    @Rollback(false)
    public void updateTest(){
        
        objdetalle.setIddetalle(2);
        
        objfactura.setIdfactura(2);
        objdetalle.setFactura(objfactura);
        
        objproducto.setIdproducto(1);
        objdetalle.setProducto(objproducto);
        
        objpersonalizacion.setIdpersonalizado(1);
        objdetalle.setPersonalizacion(objpersonalizacion);
        
        objdetalle.setCantidad(500);
        objdetalle.setPrecio(99);
        objdetalle.setEstado(true);
        
        Detalle detalle= repositorio.save(objdetalle);
        assertNotNull(detalle);
        System.out.println("@Test --> updateTest()");
    }
    
    @Test
    @Rollback(false)
    public void deleteTest(){
        
        objdetalle.setIddetalle(1);
        
        objfactura.setIdfactura(2);
        objdetalle.setFactura(objfactura);
        
        objproducto.setIdproducto(1);
        objdetalle.setProducto(objproducto);
        
        objpersonalizacion.setIdpersonalizado(1);
        objdetalle.setPersonalizacion(objpersonalizacion);
        
        objdetalle.setCantidad(500);
        objdetalle.setPrecio(99);
        objdetalle.setEstado(false);
        
        Detalle detalle= repositorio.save(objdetalle);
        assertNotNull(detalle);
        System.out.println("@Test --> deleteTest()");
    }
}
