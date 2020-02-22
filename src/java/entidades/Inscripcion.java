/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author oscar
 */
@Entity
@Table(name = "inscripcion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Inscripcion.findAll", query = "SELECT i FROM Inscripcion i")
    , @NamedQuery(name = "Inscripcion.findByCodigoInscripcion", query = "SELECT i FROM Inscripcion i WHERE i.codigoInscripcion = :codigoInscripcion")
    , @NamedQuery(name = "Inscripcion.findByFecha", query = "SELECT i FROM Inscripcion i WHERE i.fecha = :fecha")})
public class Inscripcion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "codigo_inscripcion")
    private Integer codigoInscripcion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @JoinColumn(name = "asignacion_codigo_asignacion", referencedColumnName = "codigo_asignacion")
    @ManyToOne(optional = false)
    private Asignacion asignacionCodigoAsignacion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "inscripcionCodigoInscripcion")
    private Collection<Alumno> alumnoCollection;

    public Inscripcion() {
    }

    public Inscripcion(Integer codigoInscripcion) {
        this.codigoInscripcion = codigoInscripcion;
    }

    public Inscripcion(Integer codigoInscripcion, Date fecha) {
        this.codigoInscripcion = codigoInscripcion;
        this.fecha = fecha;
    }

    public Integer getCodigoInscripcion() {
        return codigoInscripcion;
    }

    public void setCodigoInscripcion(Integer codigoInscripcion) {
        this.codigoInscripcion = codigoInscripcion;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Asignacion getAsignacionCodigoAsignacion() {
        return asignacionCodigoAsignacion;
    }

    public void setAsignacionCodigoAsignacion(Asignacion asignacionCodigoAsignacion) {
        this.asignacionCodigoAsignacion = asignacionCodigoAsignacion;
    }

    @XmlTransient
    public Collection<Alumno> getAlumnoCollection() {
        return alumnoCollection;
    }

    public void setAlumnoCollection(Collection<Alumno> alumnoCollection) {
        this.alumnoCollection = alumnoCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigoInscripcion != null ? codigoInscripcion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Inscripcion)) {
            return false;
        }
        Inscripcion other = (Inscripcion) object;
        if ((this.codigoInscripcion == null && other.codigoInscripcion != null) || (this.codigoInscripcion != null && !this.codigoInscripcion.equals(other.codigoInscripcion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Inscripcion[ codigoInscripcion=" + codigoInscripcion + " ]";
    }
    
}
