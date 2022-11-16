package pe.com.EmpresaCanario.service;

import java.util.List;
import java.util.Optional;
import pe.com.EmpresaCanario.entity.Detalle;


public interface DetalleService {
    public List<Detalle> findAll();

    public List<Detalle> findAllCustom();

    public Optional<Detalle> findById(long id);

    public Detalle add(Detalle d);

    public Detalle update(Detalle d);

    public Detalle delete(Detalle d);
}
