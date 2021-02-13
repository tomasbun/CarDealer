/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Tomas
 */
@Entity
@Table(name = "sales")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Sales.findAll", query = "SELECT s FROM Sales s"),
    @NamedQuery(name = "Sales.findBySalesID", query = "SELECT s FROM Sales s WHERE s.salesID = :salesID"),
    @NamedQuery(name = "Sales.findByTradein", query = "SELECT s FROM Sales s WHERE s.tradein = :tradein"),
    @NamedQuery(name = "Sales.findByTradeinValue", query = "SELECT s FROM Sales s WHERE s.tradeinValue = :tradeinValue"),
    @NamedQuery(name = "Sales.findByAmountPaid", query = "SELECT s FROM Sales s WHERE s.amountPaid = :amountPaid")})
public class Sales implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "salesID")
    private Integer salesID;
    @Size(max = 15)
    @Column(name = "tradein")
    private String tradein;
    @Column(name = "tradein_value")
    private Integer tradeinValue;
    @Basic(optional = false)
    @NotNull
    @Column(name = "amount_paid")
    private int amountPaid;
    @JoinColumn(name = "staffID", referencedColumnName = "staffID")
    @ManyToOne(optional = false)
    private Staff staffID;
    @JoinColumn(name = "listingNumber", referencedColumnName = "listingNumber")
    @ManyToOne(optional = false)
    private Car listingNumber;
    @JoinColumn(name = "customerID", referencedColumnName = "customerID")
    @ManyToOne(optional = false)
    private Customer customerID;

    public Sales() {
    }

    public Sales(Integer salesID) {
        this.salesID = salesID;
    }

    public Sales(Integer salesID, int amountPaid) {
        this.salesID = salesID;
        this.amountPaid = amountPaid;
    }

    public Integer getSalesID() {
        return salesID;
    }

    public void setSalesID(Integer salesID) {
        this.salesID = salesID;
    }

    public String getTradein() {
        return tradein;
    }

    public void setTradein(String tradein) {
        this.tradein = tradein;
    }

    public Integer getTradeinValue() {
        return tradeinValue;
    }

    public void setTradeinValue(Integer tradeinValue) {
        this.tradeinValue = tradeinValue;
    }

    public int getAmountPaid() {
        return amountPaid;
    }

    public void setAmountPaid(int amountPaid) {
        this.amountPaid = amountPaid;
    }

    public Staff getStaffID() {
        return staffID;
    }

    public void setStaffID(Staff staffID) {
        this.staffID = staffID;
    }

    public Car getListingNumber() {
        return listingNumber;
    }

    public void setListingNumber(Car listingNumber) {
        this.listingNumber = listingNumber;
    }

    public Customer getCustomerID() {
        return customerID;
    }

    public void setCustomerID(Customer customerID) {
        this.customerID = customerID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (salesID != null ? salesID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Sales)) {
            return false;
        }
        Sales other = (Sales) object;
        if ((this.salesID == null && other.salesID != null) || (this.salesID != null && !this.salesID.equals(other.salesID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Sales[ salesID=" + salesID + " ]";
    }
    
}
