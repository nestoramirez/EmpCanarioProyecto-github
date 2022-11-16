package pe.com.EmpresaCanario.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity(name="Detalle")
@Table(name="detalle")
public class Detalle implements Serializable {
    private static final long serialVersionUID=1L;
    @Id
    @Column(name="id_detalle")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long iddetalle;
    @ManyToOne
    @JoinColumn(name="id_factura", nullable=false)
    private Factura factura;
    @ManyToOne
    @JoinColumn(name="id_producto", nullable=false)
    private Producto producto;
    @ManyToOne
    @JoinColumn(name="id_personalizado", nullable=false)
    private Personalizacion personalizacion;
    @Column(name="cantidad")
    private int cantidad;
    @Column(name="precio")
    private float precio;
    @Column(name="estado")
    private boolean estado;
}
