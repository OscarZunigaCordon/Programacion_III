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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author oscar
 */
@Entity
@Table(name = "genero")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Genero.findAll", query = "SELECT g FROM Genero g")
    , @NamedQuery(name = "Genero.findByCodigoGenero", query = "SELECT g FROM Genero g WHERE g.codigoGenero = :codigoGenero")
    , @NamedQuery(name = "Genero.findByDescripcion", query = "SELECT g FROM Genero g WHERE g.descripcion = :descripcion")})
public class Genero implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "codigo_genero")
    private Integer codigoGenero;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "descripcion")
    private String descripcion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "generoCodigoGenero")
    private Collection<Alumno> alumnoCollection;

    public Genero() {
    }

    public Genero(Integer codigoGenero) {
        this.codigoGenero = codigoGenero;
    }

    public Genero(Integer codigoGenero, String descripcion) {
        this.codigoGenero = codigoGenero;
        this.descripcion = descripcion;
    }

    public Integer getCodigoGenero() {
        return codigoGenero;
    }

    public void setCodigoGenero(Integer codigoGenero) {
        this.codigoGenero = codigoGenero;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
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
        hash += (codigoGenero != null ? codigoGenero.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Genero)) {
            return false;
        }
        Genero other = (Genero) object;
        if ((this.codigoGenero == null && other.codigoGenero != null) || (this.codigoGenero != null && !this.codigoGenero.equals(other.codigoGenero))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Genero[ codigoGenero=" + codigoGenero + " ]";
    }
    
}
