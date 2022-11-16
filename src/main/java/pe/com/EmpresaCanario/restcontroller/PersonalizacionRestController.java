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
import pe.com.EmpresaCanario.entity.Personalizacion;
import pe.com.EmpresaCanario.service.PersonalizacionService;

@RestController
@RequestMapping("/personalizacion")
public class PersonalizacionRestController {
    
    @Autowired
    private PersonalizacionService servicio;

    @GetMapping
    public List<Personalizacion> findAll() {
        return servicio.findAll();
    }

    @GetMapping("/custom")
    public List<Personalizacion> findAllCustom() {
        return servicio.findAllCustom();
    }

    @GetMapping("/{id}")
    public Optional<Personalizacion> findById(@PathVariable Long id) {
        return servicio.findById(id);
    }

    @PostMapping
    public Personalizacion add(@RequestBody Personalizacion p) {
        return servicio.add(p);
    }

    @PutMapping("/{id}")
    public Personalizacion update(@PathVariable Long id,@RequestBody Personalizacion p) {
        p.setIdpersonalizado(id);
        return servicio.add(p);
    }
    
    @DeleteMapping("/{id}")
    public Personalizacion delete(@PathVariable Long id) {
        Personalizacion objpersonalizacion=new Personalizacion();
        objpersonalizacion.setEstado(false);
        return servicio.delete(Personalizacion.builder().idpersonalizado(id).build());
    }
}
