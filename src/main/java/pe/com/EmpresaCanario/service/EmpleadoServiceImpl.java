package pe.com.EmpresaCanario.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import pe.com.EmpresaCanario.entity.Empleado;
import pe.com.EmpresaCanario.repository.EmpleadoRepository;

public class EmpleadoServiceImpl implements EmpleadoService{

    @Autowired
    private EmpleadoRepository repositorio;
    
    @Override
    public List<Empleado> findAll() {
        return repositorio.findAll();
    }

    @Override
    public List<Empleado> findAllCustom() {
        return repositorio.findAllCustom();
    }

    @Override
    public Optional<Empleado> findById(long id) {
        return repositorio.findById(id);
    }

    @Override
    public Empleado add(Empleado p) {
        return repositorio.save(p);
    }

    @Override
    public Empleado update(Empleado p) {
        Empleado objproducto=repositorio.getById(p.getIdempleado());
        BeanUtils.copyProperties(p, objproducto);
        return repositorio.save(objproducto);
    }

    @Override
    public Empleado delete(Empleado p) {
        Empleado objproducto=repositorio.getById(p.getIdempleado());
        objproducto.setEstado(false);
        return repositorio.save(objproducto);
    }
    
}
