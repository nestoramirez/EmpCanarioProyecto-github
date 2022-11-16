package pe.com.EmpresaCanario.service;

import java.util.List;
import java.util.Optional;
import pe.com.EmpresaCanario.entity.Registro_Usuario;

public interface Registro_UsuarioService {
    public List<Registro_Usuario> findAll();

    public List<Registro_Usuario> findAllCustom();

    public Optional<Registro_Usuario> findById(long id);

    public Registro_Usuario add(Registro_Usuario p);

    public Registro_Usuario update(Registro_Usuario p);

    public Registro_Usuario delete(Registro_Usuario p);
}
