/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entityClasses;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
 * @author gnajd
 */
@Entity
@Table(name = "ocena")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Ocena.findAll", query = "SELECT o FROM Ocena o"),
    @NamedQuery(name = "Ocena.findByIdOceny", query = "SELECT o FROM Ocena o WHERE o.idOceny = :idOceny"),
    @NamedQuery(name = "Ocena.findByOpis", query = "SELECT o FROM Ocena o WHERE o.opis = :opis")})
public class Ocena implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_oceny")
    private Short idOceny;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "opis")
    private String opis;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idOceny")
    private Collection<Wyniki> wynikiCollection;

    public Ocena() {
    }

    public Ocena(Short idOceny) {
        this.idOceny = idOceny;
    }

    public Ocena(Short idOceny, String opis) {
        this.idOceny = idOceny;
        this.opis = opis;
    }

    public Short getIdOceny() {
        return idOceny;
    }

    public void setIdOceny(Short idOceny) {
        this.idOceny = idOceny;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    @XmlTransient
    public Collection<Wyniki> getWynikiCollection() {
        return wynikiCollection;
    }

    public void setWynikiCollection(Collection<Wyniki> wynikiCollection) {
        this.wynikiCollection = wynikiCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idOceny != null ? idOceny.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ocena)) {
            return false;
        }
        Ocena other = (Ocena) object;
        if ((this.idOceny == null && other.idOceny != null) || (this.idOceny != null && !this.idOceny.equals(other.idOceny))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entityClasses.Ocena[ idOceny=" + idOceny + " ]";
    }
    
}
