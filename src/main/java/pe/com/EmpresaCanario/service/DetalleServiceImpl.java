package pe.com.EmpresaCanario.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.com.EmpresaCanario.entity.Detalle;
import pe.com.EmpresaCanario.repository.DetalleRepository;

@Service
public class DetalleServiceImpl implements DetalleService{

    @Autowired
    private DetalleRepository repositorio;
    
    @Override
    public List<Detalle> findAll() {
        return repositorio.findAll();
    }

    @Override
    public List<Detalle> findAllCustom() {
        return repositorio.findAllCustom();
    }

    @Override
    public Optional<Detalle> findById(long id) {
        return repositorio.findById(id);
    }

    @Override
    public Detalle add(Detalle d) {
        return repositorio.save(d);
    }

    @Override
    public Detalle update(Detalle d) {
        Detalle objdetalle=repositorio.getById(d.getIddetalle());
        BeanUtils.copyProperties(d, objdetalle);
        return repositorio.save(objdetalle);
    }

    @Override
    public Detalle delete(Detalle d) {
        Detalle objdetalle=repositorio.getById(d.getIddetalle());
        objdetalle.setEstado(false);
        return repositorio.save(objdetalle);
    }
}
