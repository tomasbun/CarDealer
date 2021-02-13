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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "car")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Car.findAll", query = "SELECT c FROM Car c"),
    @NamedQuery(name = "Car.findByListingNumber", query = "SELECT c FROM Car c WHERE c.listingNumber = :listingNumber"),
    @NamedQuery(name = "Car.findByCarReg", query = "SELECT c FROM Car c WHERE c.carReg = :carReg"),
    @NamedQuery(name = "Car.findByYear", query = "SELECT c FROM Car c WHERE c.year = :year"),
    @NamedQuery(name = "Car.findByMake", query = "SELECT c FROM Car c WHERE c.make = :make"),
    @NamedQuery(name = "Car.findByModel", query = "SELECT c FROM Car c WHERE c.model = :model"),
    @NamedQuery(name = "Car.findByColour", query = "SELECT c FROM Car c WHERE c.colour = :colour"),
    @NamedQuery(name = "Car.findByOdometer", query = "SELECT c FROM Car c WHERE c.odometer = :odometer"),
    @NamedQuery(name = "Car.findByTo62", query = "SELECT c FROM Car c WHERE c.to62 = :to62"),
    @NamedQuery(name = "Car.findByEngine", query = "SELECT c FROM Car c WHERE c.engine = :engine"),
    @NamedQuery(name = "Car.findByFuel", query = "SELECT c FROM Car c WHERE c.fuel = :fuel"),
    @NamedQuery(name = "Car.findByTransmision", query = "SELECT c FROM Car c WHERE c.transmision = :transmision"),
    @NamedQuery(name = "Car.findByBody", query = "SELECT c FROM Car c WHERE c.body = :body"),
    @NamedQuery(name = "Car.findByIsofix", query = "SELECT c FROM Car c WHERE c.isofix = :isofix"),
    @NamedQuery(name = "Car.findByTax", query = "SELECT c FROM Car c WHERE c.tax = :tax"),
    @NamedQuery(name = "Car.findByPreviousOwners", query = "SELECT c FROM Car c WHERE c.previousOwners = :previousOwners"),
    @NamedQuery(name = "Car.findByServiceHistory", query = "SELECT c FROM Car c WHERE c.serviceHistory = :serviceHistory"),
    @NamedQuery(name = "Car.findByBuyPrice", query = "SELECT c FROM Car c WHERE c.buyPrice = :buyPrice"),
    @NamedQuery(name = "Car.findBySold", query = "SELECT c FROM Car c WHERE c.sold = :sold"),
    @NamedQuery(name = "Car.findByDescription", query = "SELECT c FROM Car c WHERE c.description = :description"),
    @NamedQuery(name = "Car.findByListPrice", query = "SELECT c FROM Car c WHERE c.listPrice = :listPrice"),
    @NamedQuery(name = "Car.findByNote", query = "SELECT c FROM Car c WHERE c.note = :note"),
    @NamedQuery(name = "Car.findByMakeModelYearPrice", query = "SELECT c FROM Car c WHERE c.model = :model AND c.make = :make And c.year = :year AND c.listPrice  > :minPrice AND c.listPrice < :maxPrice"),
    @NamedQuery(name = "Car.findByPriceRange", query = "SELECT c FROM Car c WHERE c.listPrice  > :minPrice AND c.listPrice < :maxPrice")})

public class Car implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "listingNumber")
    private Integer listingNumber;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "car_reg")
    private String carReg;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "year")
    private String year;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "make")
    private String make;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "model")
    private String model;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "colour")
    private String colour;
    @Basic(optional = false)
    @NotNull
    @Column(name = "odometer")
    private int odometer;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "0to62")
    private Double to62;
    @Column(name = "engine")
    private Double engine;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "fuel")
    private String fuel;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "transmision")
    private String transmision;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "body")
    private String body;
    @Basic(optional = false)
    @NotNull
    @Column(name = "isofix")
    private short isofix;
    @Column(name = "tax")
    private Integer tax;
    @Basic(optional = false)
    @NotNull
    @Column(name = "previous_owners")
    private int previousOwners;
    @Column(name = "serviceHistory")
    private Short serviceHistory;
    @Basic(optional = false)
    @NotNull
    @Column(name = "buyPrice")
    private int buyPrice;
    @Basic(optional = false)
    @NotNull
    @Column(name = "sold")
    private short sold;
    @Size(max = 1100)
    @Column(name = "description")
    private String description;
    @Column(name = "listPrice")
    private Integer listPrice;
    @Size(max = 200)
    @Column(name = "note")
    private String note;
    @JoinColumn(name = "lastOwnerID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private PreviousOwner lastOwnerID;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "listingNumber")
    private Collection<Sales> salesCollection;

    public Car() {
    }

    public Car(Integer listingNumber) {
        this.listingNumber = listingNumber;
    }

    public Car(Integer listingNumber, String carReg, String year, String make, 
            String model, String colour, int odometer, String fuel, String transmision,
            String body, short isofix, int previousOwners, int buyPrice, short sold) {
        this.listingNumber = listingNumber;
        this.carReg = carReg;
        this.year = year;
        this.make = make;
        this.model = model;
        this.colour = colour;
        this.odometer = odometer;
        this.fuel = fuel;
        this.transmision = transmision;
        this.body = body;
        this.isofix = isofix;
        this.previousOwners = previousOwners;
        this.buyPrice = buyPrice;
        this.sold = sold;
    }

    public Integer getListingNumber() {
        return listingNumber;
    }

    public void setListingNumber(Integer listingNumber) {
        this.listingNumber = listingNumber;
    }

    public String getCarReg() {
        return carReg;
    }

    public void setCarReg(String carReg) {
        this.carReg = carReg;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    public int getOdometer() {
        return odometer;
    }

    public void setOdometer(int odometer) {
        this.odometer = odometer;
    }

    public Double getTo62() {
        return to62;
    }

    public void setTo62(Double to62) {
        this.to62 = to62;
    }

    public Double getEngine() {
        return engine;
    }

    public void setEngine(Double engine) {
        this.engine = engine;
    }

    public String getFuel() {
        return fuel;
    }

    public void setFuel(String fuel) {
        this.fuel = fuel;
    }

    public String getTransmision() {
        return transmision;
    }

    public void setTransmision(String transmision) {
        this.transmision = transmision;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public short getIsofix() {
        return isofix;
    }

    public void setIsofix(short isofix) {
        this.isofix = isofix;
    }

    public Integer getTax() {
        return tax;
    }

    public void setTax(Integer tax) {
        this.tax = tax;
    }

    public int getPreviousOwners() {
        return previousOwners;
    }

    public void setPreviousOwners(int previousOwners) {
        this.previousOwners = previousOwners;
    }

    public Short getServiceHistory() {
        return serviceHistory;
    }

    public void setServiceHistory(Short serviceHistory) {
        this.serviceHistory = serviceHistory;
    }

    public int getBuyPrice() {
        return buyPrice;
    }

    public void setBuyPrice(int buyPrice) {
        this.buyPrice = buyPrice;
    }

    public short getSold() {
        return sold;
    }

    public void setSold(short sold) {
        this.sold = sold;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getListPrice() {
        return listPrice;
    }

    public void setListPrice(Integer listPrice) {
        this.listPrice = listPrice;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public PreviousOwner getLastOwnerID() {
        return lastOwnerID;
    }

    public void setLastOwnerID(PreviousOwner lastOwnerID) {
        this.lastOwnerID = lastOwnerID;
    }

    @XmlTransient
    public Collection<Sales> getSalesCollection() {
        return salesCollection;
    }

    public void setSalesCollection(Collection<Sales> salesCollection) {
        this.salesCollection = salesCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (listingNumber != null ? listingNumber.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Car)) {
            return false;
        }
        Car other = (Car) object;
        if ((this.listingNumber == null && other.listingNumber != null) || (this.listingNumber != null && !this.listingNumber.equals(other.listingNumber))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Car[ listingNumber=" + listingNumber + " ]";
    }
    
}
