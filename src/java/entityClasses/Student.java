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
@Table(name = "student")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Student.findAll", query = "SELECT s FROM Student s"),
    @NamedQuery(name = "Student.findByIdStudenta", query = "SELECT s FROM Student s WHERE s.idStudenta = :idStudenta"),
    @NamedQuery(name = "Student.findByPesel", query = "SELECT s FROM Student s WHERE s.pesel = :pesel"),
    @NamedQuery(name = "Student.findByImie", query = "SELECT s FROM Student s WHERE s.imie = :imie"),
    @NamedQuery(name = "Student.findByNazwisko", query = "SELECT s FROM Student s WHERE s.nazwisko = :nazwisko")})
public class Student implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_studenta")
    private Integer idStudenta;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 11)
    @Column(name = "pesel")
    private String pesel;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "imie")
    private String imie;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "nazwisko")
    private String nazwisko;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idStudenta")
    private Collection<Wyniki> wynikiCollection;

    public Student() {
    }

    public Student(Integer idStudenta) {
        this.idStudenta = idStudenta;
    }

    public Student(Integer idStudenta, String pesel, String imie, String nazwisko) {
        this.idStudenta = idStudenta;
        this.pesel = pesel;
        this.imie = imie;
        this.nazwisko = nazwisko;
    }

    public Integer getIdStudenta() {
        return idStudenta;
    }

    public void setIdStudenta(Integer idStudenta) {
        this.idStudenta = idStudenta;
    }

    public String getPesel() {
        return pesel;
    }

    public void setPesel(String pesel) {
        this.pesel = pesel;
    }

    public String getImie() {
        return imie;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
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
        hash += (idStudenta != null ? idStudenta.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Student)) {
            return false;
        }
        Student other = (Student) object;
        if ((this.idStudenta == null && other.idStudenta != null) || (this.idStudenta != null && !this.idStudenta.equals(other.idStudenta))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return imie + " "+ nazwisko + " ("+pesel+")" ;
    }
    
}
