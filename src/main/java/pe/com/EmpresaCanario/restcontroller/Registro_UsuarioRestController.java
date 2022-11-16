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
import pe.com.EmpresaCanario.entity.Registro_Usuario;
import pe.com.EmpresaCanario.service.Registro_UsuarioService;

@RestController
@RequestMapping("/registro_usuario")
public class Registro_UsuarioRestController {
    
    @Autowired
    private Registro_UsuarioService servicio;

    @GetMapping
    public List<Registro_Usuario> findAll() {
        return servicio.findAll();
    }

    @GetMapping("/custom")
    public List<Registro_Usuario> findAllCustom() {
        return servicio.findAllCustom();
    }

    @GetMapping("/{id}")
    public Optional<Registro_Usuario> findById(@PathVariable Long id) {
        return servicio.findById(id);
    }

    @PostMapping
    public Registro_Usuario add(@RequestBody Registro_Usuario r) {
        return servicio.add(r);
    }

    @PutMapping("/{id}")
    public Registro_Usuario update(@PathVariable Long id,@RequestBody Registro_Usuario r) {
        r.setIdregistro(id);
        return servicio.add(r);
    }
    
    @DeleteMapping("/{id}")
    public Registro_Usuario delete(@PathVariable Long id) {
        Registro_Usuario objregistro=new Registro_Usuario();
        objregistro.setEstado(false);
        return servicio.delete(Registro_Usuario.builder().idregistro(id).build());
    }
}
