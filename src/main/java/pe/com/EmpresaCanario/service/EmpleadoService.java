package pe.com.EmpresaCanario.service;

import java.util.List;
import java.util.Optional;
import pe.com.EmpresaCanario.entity.Empleado;

public interface EmpleadoService {
    public List<Empleado> findAll();

    public List<Empleado> findAllCustom();

    public Optional<Empleado> findById(long id);

    public Empleado add(Empleado c);

    public Empleado update(Empleado c);

    public Empleado delete(Empleado c);
}
