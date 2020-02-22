/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author oscar
 */
@Entity
@Table(name = "asignacion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Asignacion.findAll", query = "SELECT a FROM Asignacion a")
    , @NamedQuery(name = "Asignacion.findByCodigoAsignacion", query = "SELECT a FROM Asignacion a WHERE a.codigoAsignacion = :codigoAsignacion")})
public class Asignacion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "codigo_asignacion")
    private Integer codigoAsignacion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "asignacionCodigoAsignacion")
    private Collection<Inscripcion> inscripcionCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "asignacionCodigoAsignacion")
    private Collection<Curso> cursoCollection;

    public Asignacion() {
    }

    public Asignacion(Integer codigoAsignacion) {
        this.codigoAsignacion = codigoAsignacion;
    }

    public Integer getCodigoAsignacion() {
        return codigoAsignacion;
    }

    public void setCodigoAsignacion(Integer codigoAsignacion) {
        this.codigoAsignacion = codigoAsignacion;
    }

    @XmlTransient
    public Collection<Inscripcion> getInscripcionCollection() {
        return inscripcionCollection;
    }

    public void setInscripcionCollection(Collection<Inscripcion> inscripcionCollection) {
        this.inscripcionCollection = inscripcionCollection;
    }

    @XmlTransient
    public Collection<Curso> getCursoCollection() {
        return cursoCollection;
    }

    public void setCursoCollection(Collection<Curso> cursoCollection) {
        this.cursoCollection = cursoCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigoAsignacion != null ? codigoAsignacion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Asignacion)) {
            return false;
        }
        Asignacion other = (Asignacion) object;
        if ((this.codigoAsignacion == null && other.codigoAsignacion != null) || (this.codigoAsignacion != null && !this.codigoAsignacion.equals(other.codigoAsignacion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Asignacion[ codigoAsignacion=" + codigoAsignacion + " ]";
    }
    
}
