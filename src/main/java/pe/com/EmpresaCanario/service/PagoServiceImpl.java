package pe.com.EmpresaCanario.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.com.EmpresaCanario.entity.Pago;
import pe.com.EmpresaCanario.repository.PagoRepository;

@Service
public class PagoServiceImpl implements PagoService{

    @Autowired
    private PagoRepository repositorio;
    
    @Override
    public List<Pago> findAll() {
        return repositorio.findAll();
    }

    @Override
    public List<Pago> findAllCustom() {
        return repositorio.findAllCustom();
    }

    @Override
    public Optional<Pago> findById(long id) {
        return repositorio.findById(id);
    }

    @Override
    public Pago add(Pago p) {
        return repositorio.save(p);
    }

    @Override
    public Pago update(Pago p) {
        Pago objpago=repositorio.getById(p.getIdpago());
        BeanUtils.copyProperties(p, objpago);
        return repositorio.save(objpago);
    }

    @Override
    public Pago delete(Pago p) {
        Pago objpago=repositorio.getById(p.getIdpago());
        objpago.setEstado(false);
        return repositorio.save(objpago);
    }
    
}
