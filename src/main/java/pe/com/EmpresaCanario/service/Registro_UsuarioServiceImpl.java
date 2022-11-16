package pe.com.EmpresaCanario.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.com.EmpresaCanario.entity.Registro_Usuario;
import pe.com.EmpresaCanario.repository.Registro_UsuarioRepository;

@Service
public class Registro_UsuarioServiceImpl implements Registro_UsuarioService {

    @Autowired
    private Registro_UsuarioRepository repositorio;
    
    @Override
    public List<Registro_Usuario> findAll() {
        return repositorio.findAll();
    }

    @Override
    public List<Registro_Usuario> findAllCustom() {
        return repositorio.findAllCustom();
    }

    @Override
    public Optional<Registro_Usuario> findById(long id) {
        return repositorio.findById(id);
    }

    @Override
    public Registro_Usuario add(Registro_Usuario r) {
        return repositorio.save(r);
    }

    @Override
    public Registro_Usuario update(Registro_Usuario r) {
        Registro_Usuario objregistro=repositorio.getById(r.getIdregistro());
        BeanUtils.copyProperties(r, objregistro);
        return repositorio.save(objregistro);
    }

    @Override
    public Registro_Usuario delete(Registro_Usuario r) {
        Registro_Usuario objregistro=repositorio.getById(r.getIdregistro());
        objregistro.setEstado(false);
        return repositorio.save(objregistro);
    }
    
}
