package pe.com.EmpresaCanario.entity;

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
@Entity(name="Categoria")
@Table(name="categoria")
public class Categoria {
    private static final long serialVersionUID=1L;
    @Id
    @Column(name="id_categoria")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idcategoria;
    @Column(name="nombre")
    private String nombre;
    @Column(name="estado")
    private boolean estado;
}
