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
@Table(name = "przedmiot")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Przedmiot.findAll", query = "SELECT p FROM Przedmiot p"),
    @NamedQuery(name = "Przedmiot.findByIdPrzedmiotu", query = "SELECT p FROM Przedmiot p WHERE p.idPrzedmiotu = :idPrzedmiotu"),
    @NamedQuery(name = "Przedmiot.findByNazwa", query = "SELECT p FROM Przedmiot p WHERE p.nazwa = :nazwa")})
public class Przedmiot implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_przedmiotu")
    private Integer idPrzedmiotu;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "nazwa")
    private String nazwa;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idPrzedmiotu")
    private Collection<Wyniki> wynikiCollection;

    public Przedmiot() {
    }

    public Przedmiot(Integer idPrzedmiotu) {
        this.idPrzedmiotu = idPrzedmiotu;
    }

    public Przedmiot(Integer idPrzedmiotu, String nazwa) {
        this.idPrzedmiotu = idPrzedmiotu;
        this.nazwa = nazwa;
    }

    public Integer getIdPrzedmiotu() {
        return idPrzedmiotu;
    }

    public void setIdPrzedmiotu(Integer idPrzedmiotu) {
        this.idPrzedmiotu = idPrzedmiotu;
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
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
        hash += (idPrzedmiotu != null ? idPrzedmiotu.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Przedmiot)) {
            return false;
        }
        Przedmiot other = (Przedmiot) object;
        if ((this.idPrzedmiotu == null && other.idPrzedmiotu != null) || (this.idPrzedmiotu != null && !this.idPrzedmiotu.equals(other.idPrzedmiotu))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entityClasses.Przedmiot[ idPrzedmiotu=" + idPrzedmiotu + " ]";
    }
    
}
