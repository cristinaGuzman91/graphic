/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author cguzman
 */
@Entity
@Table(name = "location")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Location.findAll", query = "SELECT l FROM Location l"),
    @NamedQuery(name = "Location.findByIdLocation", query = "SELECT l FROM Location l WHERE l.idLocation = :idLocation"),
    @NamedQuery(name = "Location.findByLocationName", query = "SELECT l FROM Location l WHERE l.locationName = :locationName"),
    @NamedQuery(name = "Location.findByLocationDescription", query = "SELECT l FROM Location l WHERE l.locationDescription = :locationDescription"),
    @NamedQuery(name = "Location.findByActive", query = "SELECT l FROM Location l WHERE l.active = :active"),
    @NamedQuery(name = "Location.findByLastUpdateDate", query = "SELECT l FROM Location l WHERE l.lastUpdateDate = :lastUpdateDate")})
public class Location implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_location")
    private Integer idLocation;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "location_name")
    private String locationName;
    @Size(max = 300)
    @Column(name = "location_description")
    private String locationDescription;
    @Basic(optional = false)
    @NotNull
    @Column(name = "active")
    private boolean active;
    @Basic(optional = false)
    @NotNull
    @Column(name = "last_update_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastUpdateDate;
    @OneToMany(mappedBy = "idLocation")
    private Collection<CommDeviceTags> commDeviceTagsCollection;
    @OneToMany(mappedBy = "idLocation")
    private Collection<SensorTags> sensorTagsCollection;

    public Location() {
    }

    public Location(Integer idLocation) {
        this.idLocation = idLocation;
    }

    public Location(Integer idLocation, String locationName, boolean active, Date lastUpdateDate) {
        this.idLocation = idLocation;
        this.locationName = locationName;
        this.active = active;
        this.lastUpdateDate = lastUpdateDate;
    }

    public Integer getIdLocation() {
        return idLocation;
    }

    public void setIdLocation(Integer idLocation) {
        this.idLocation = idLocation;
    }

    public String getLocationName() {
        return locationName;
    }

    public void setLocationName(String locationName) {
        this.locationName = locationName;
    }

    public String getLocationDescription() {
        return locationDescription;
    }

    public void setLocationDescription(String locationDescription) {
        this.locationDescription = locationDescription;
    }

    public boolean getActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public Date getLastUpdateDate() {
        return lastUpdateDate;
    }

    public void setLastUpdateDate(Date lastUpdateDate) {
        this.lastUpdateDate = lastUpdateDate;
    }

    @XmlTransient
    public Collection<CommDeviceTags> getCommDeviceTagsCollection() {
        return commDeviceTagsCollection;
    }

    public void setCommDeviceTagsCollection(Collection<CommDeviceTags> commDeviceTagsCollection) {
        this.commDeviceTagsCollection = commDeviceTagsCollection;
    }

    @XmlTransient
    public Collection<SensorTags> getSensorTagsCollection() {
        return sensorTagsCollection;
    }

    public void setSensorTagsCollection(Collection<SensorTags> sensorTagsCollection) {
        this.sensorTagsCollection = sensorTagsCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idLocation != null ? idLocation.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Location)) {
            return false;
        }
        Location other = (Location) object;
        if ((this.idLocation == null && other.idLocation != null) || (this.idLocation != null && !this.idLocation.equals(other.idLocation))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Location[ idLocation=" + idLocation + " ]";
    }
    
}
