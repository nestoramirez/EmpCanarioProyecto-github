package pe.com.EmpresaCanario.service;

import java.util.List;
import java.util.Optional;
import pe.com.EmpresaCanario.entity.Personalizacion;


public interface PersonalizacionService {
    public List<Personalizacion> findAll();

    public List<Personalizacion> findAllCustom();

    public Optional<Personalizacion> findById(long id);

    public Personalizacion add(Personalizacion p);

    public Personalizacion update(Personalizacion p);

    public Personalizacion delete(Personalizacion p);
}
