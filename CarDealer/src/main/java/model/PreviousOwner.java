/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

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
 * @author Tomas
 */
@Entity
@Table(name = "previous_owner")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PreviousOwner.findAll", query = "SELECT p FROM PreviousOwner p"),
    @NamedQuery(name = "PreviousOwner.findById", query = "SELECT p FROM PreviousOwner p WHERE p.id = :id"),
    @NamedQuery(name = "PreviousOwner.findByPhone", query = "SELECT p FROM PreviousOwner p WHERE p.phone = :phone"),
    @NamedQuery(name = "PreviousOwner.findByFullName", query = "SELECT p FROM PreviousOwner p WHERE p.fullName = :fullName"),
    @NamedQuery(name = "PreviousOwner.findByAddress", query = "SELECT p FROM PreviousOwner p WHERE p.address = :address")})
public class PreviousOwner implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private Integer id;
    // @Pattern(regexp="^\\(?(\\d{3})\\)?[- ]?(\\d{3})[- ]?(\\d{4})$", message="Invalid phone/fax format, should be as xxx-xxx-xxxx")//if the field contains phone or fax number consider using this annotation to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "phone")
    private String phone;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "fullName")
    private String fullName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 90)
    @Column(name = "address")
    private String address;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "lastOwnerID")
    private Collection<Car> carCollection;

    public PreviousOwner() {
    }

    public PreviousOwner(Integer id) {
        this.id = id;
    }

    public PreviousOwner(Integer id, String phone, String fullName, String address) {
        this.id = id;
        this.phone = phone;
        this.fullName = fullName;
        this.address = address;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @XmlTransient
    public Collection<Car> getCarCollection() {
        return carCollection;
    }

    public void setCarCollection(Collection<Car> carCollection) {
        this.carCollection = carCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PreviousOwner)) {
            return false;
        }
        PreviousOwner other = (PreviousOwner) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.PreviousOwner[ id=" + id + " ]";
    }
    
}
