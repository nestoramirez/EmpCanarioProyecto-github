package pe.com.EmpresaCanario.service;

import java.util.List;
import java.util.Optional;
import pe.com.EmpresaCanario.entity.Factura;

public interface FacturaService {
    public List<Factura> findAll();

    public List<Factura> findAllCustom();

    public Optional<Factura> findById(long id);

    public Factura add(Factura f);

    public Factura update(Factura f);

    public Factura delete(Factura f);
}
