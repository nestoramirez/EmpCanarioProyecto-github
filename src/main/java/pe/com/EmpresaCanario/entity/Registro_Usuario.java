package pe.com.EmpresaCanario.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity(name="Registro_Usuario")
@Table(name="registro_usuario")
public class Registro_Usuario implements Serializable {
    private static final long serialVersionUID=1L;
    @Id
    @Column(name="id_registro")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idregistro;
    @Column(name="nombre")
    private String nombre;
    @Column(name="apellido")
    private String apellido;
    @Column(name="dni")
    private String dni;
    @Column(name="correo")
    private String correo;
    @Column(name="telefono")
    private String telefono;
    @Column(name="direccion")
    private String direccion;
    @Column(name="contrasena")
    private String contrasena;
    @Column(name="estado")
    private boolean estado;
    
}
