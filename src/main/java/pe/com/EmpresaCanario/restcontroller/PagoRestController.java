package pe.com.EmpresaCanario.restcontroller;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.com.EmpresaCanario.entity.Pago;
import pe.com.EmpresaCanario.service.PagoService;

@RestController
@RequestMapping("/pago")
public class PagoRestController {
    
    @Autowired
    private PagoService servicio;

    @GetMapping
    public List<Pago> findAll() {
        return servicio.findAll();
    }

    @GetMapping("/custom")
    public List<Pago> findAllCustom() {
        return servicio.findAllCustom();
    }

    @GetMapping("/{id}")
    public Optional<Pago> findById(@PathVariable Long id) {
        return servicio.findById(id);
    }

    @PostMapping
    public Pago add(@RequestBody Pago p) {
        return servicio.add(p);
    }

    @PutMapping("/{id}")
    public Pago update(@PathVariable Long id,@RequestBody Pago p) {
        p.setIdpago(id);
        return servicio.add(p);
    }
    
    @DeleteMapping("/{id}")
    public Pago delete(@PathVariable Long id) {
        Pago objpago=new Pago();
        objpago.setEstado(false);
        return servicio.delete(Pago.builder().idpago(id).build());
    }
}
