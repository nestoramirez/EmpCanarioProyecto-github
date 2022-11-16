package pe.com.EmpresaCanario.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.com.EmpresaCanario.entity.Personalizacion;
import pe.com.EmpresaCanario.repository.PersonalizacionRepository;

@Service
public class PersonalizacionServiceImpl implements PersonalizacionService{

    @Autowired
    private PersonalizacionRepository repositorio;
    
    @Override
    public List<Personalizacion> findAll() {
        return repositorio.findAll();
    }

    @Override
    public List<Personalizacion> findAllCustom() {
        return repositorio.findAllCustom();
    }

    @Override
    public Optional<Personalizacion> findById(long id) {
        return repositorio.findById(id);
    }

    @Override
    public Personalizacion add(Personalizacion p) {
        return repositorio.save(p);
    }

    @Override
    public Personalizacion update(Personalizacion p) {
        Personalizacion objpersonalizacion=repositorio.getById(p.getIdpersonalizado());
        BeanUtils.copyProperties(p, objpersonalizacion);
        return repositorio.save(objpersonalizacion);
    }

    @Override
    public Personalizacion delete(Personalizacion p) {
        Personalizacion objpersonalizacion=repositorio.getById(p.getIdpersonalizado());
        objpersonalizacion.setEstado(false);
        return repositorio.save(objpersonalizacion);
    }
    
}
