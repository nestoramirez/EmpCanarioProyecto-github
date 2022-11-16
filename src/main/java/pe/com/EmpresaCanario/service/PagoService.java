package pe.com.EmpresaCanario.service;

import java.util.List;
import java.util.Optional;
import pe.com.EmpresaCanario.entity.Pago;

public interface PagoService {
    public List<Pago> findAll();

    public List<Pago> findAllCustom();

    public Optional<Pago> findById(long id);

    public Pago add(Pago p);

    public Pago update(Pago p);

    public Pago delete(Pago p);
}
