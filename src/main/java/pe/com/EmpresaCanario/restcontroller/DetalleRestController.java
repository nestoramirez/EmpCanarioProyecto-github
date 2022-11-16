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
import pe.com.EmpresaCanario.entity.Detalle;
import pe.com.EmpresaCanario.service.DetalleService;

@RestController
@RequestMapping("/detalle")
public class DetalleRestController {
    @Autowired
    private DetalleService servicio;

    @GetMapping
    public List<Detalle> findAll() {
        return servicio.findAll();
    }

    @GetMapping("/custom")
    public List<Detalle> findAllCustom() {
        return servicio.findAllCustom();
    }

    @GetMapping("/{id}")
    public Optional<Detalle> findById(@PathVariable Long id) {
        return servicio.findById(id);
    }

    @PostMapping
    public Detalle add(@RequestBody Detalle d) {
        return servicio.add(d);
    }

    @PutMapping("/{id}")
    public Detalle update(@PathVariable Long id,@RequestBody Detalle d) {
        d.setIddetalle(id);
        return servicio.add(d);
    }
    
    @DeleteMapping("/{id}")
    public Detalle delete(@PathVariable Long id) {
        Detalle objdetalle=new Detalle();
        objdetalle.setEstado(false);
        return servicio.delete(Detalle.builder().iddetalle(id).build());
    }
}
