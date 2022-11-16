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
@Entity(name="Personalizacion")
@Table(name="personalizacion")
public class Personalizacion implements Serializable{
    @Id
    @Column(name="id_personalizado")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idpersonalizado;
    @Column(name="tamano")
    private float tamano;
    @Column(name="diseno")
    private String diseno;
    @Column(name="precio_personal")
    private float preciopersonal;
    @Column(name="estado")
    private boolean estado;
}

