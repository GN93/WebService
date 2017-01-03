/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entityClasses;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author gnajd
 */
@Entity
@Table(name = "wyniki")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Wyniki.findAll", query = "SELECT w FROM Wyniki w"),
    @NamedQuery(name = "Wyniki.findByIdWyniku", query = "SELECT w FROM Wyniki w WHERE w.idWyniku = :idWyniku"),
    @NamedQuery(name = "Wyniki.findByData", query = "SELECT w FROM Wyniki w WHERE w.data = :data")})
public class Wyniki implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_wyniku")
    private Integer idWyniku;
    @Basic(optional = false)
    @NotNull
    @Column(name = "data")
    @Temporal(TemporalType.TIMESTAMP)
    private Date data;
    @JoinColumn(name = "id_studenta", referencedColumnName = "id_studenta")
    @ManyToOne(optional = false)
    private Student idStudenta;
    @JoinColumn(name = "id_przedmiotu", referencedColumnName = "id_przedmiotu")
    @ManyToOne(optional = false)
    private Przedmiot idPrzedmiotu;
    @JoinColumn(name = "id_oceny", referencedColumnName = "id_oceny")
    @ManyToOne(optional = false)
    private Ocena idOceny;

    public Wyniki() {
    }

    public Wyniki(Integer idWyniku) {
        this.idWyniku = idWyniku;
    }

    public Wyniki(Integer idWyniku, Date data) {
        this.idWyniku = idWyniku;
        this.data = data;
    }

    public Integer getIdWyniku() {
        return idWyniku;
    }

    public void setIdWyniku(Integer idWyniku) {
        this.idWyniku = idWyniku;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Student getIdStudenta() {
        return idStudenta;
    }

    public void setIdStudenta(Student idStudenta) {
        this.idStudenta = idStudenta;
    }

    public Przedmiot getIdPrzedmiotu() {
        return idPrzedmiotu;
    }

    public void setIdPrzedmiotu(Przedmiot idPrzedmiotu) {
        this.idPrzedmiotu = idPrzedmiotu;
    }

    public Ocena getIdOceny() {
        return idOceny;
    }

    public void setIdOceny(Ocena idOceny) {
        this.idOceny = idOceny;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idWyniku != null ? idWyniku.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Wyniki)) {
            return false;
        }
        Wyniki other = (Wyniki) object;
        if ((this.idWyniku == null && other.idWyniku != null) || (this.idWyniku != null && !this.idWyniku.equals(other.idWyniku))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entityClasses.Wyniki[ idWyniku=" + idWyniku + " ]";
    }
    
}
