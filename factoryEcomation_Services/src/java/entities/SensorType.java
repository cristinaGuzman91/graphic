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
@Table(name = "sensor_type")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SensorType.findAll", query = "SELECT s FROM SensorType s"),
    @NamedQuery(name = "SensorType.findByIdSensorType", query = "SELECT s FROM SensorType s WHERE s.idSensorType = :idSensorType"),
    @NamedQuery(name = "SensorType.findBySensorType", query = "SELECT s FROM SensorType s WHERE s.sensorType = :sensorType"),
    @NamedQuery(name = "SensorType.findByActive", query = "SELECT s FROM SensorType s WHERE s.active = :active"),
    @NamedQuery(name = "SensorType.findByLastUpdateDate", query = "SELECT s FROM SensorType s WHERE s.lastUpdateDate = :lastUpdateDate")})
public class SensorType implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_sensor_type")
    private Integer idSensorType;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "sensor_type")
    private String sensorType;
    @Basic(optional = false)
    @NotNull
    @Column(name = "active")
    private boolean active;
    @Basic(optional = false)
    @NotNull
    @Column(name = "last_update_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastUpdateDate;
    @OneToMany(mappedBy = "idSensorType")
    private Collection<SensorCatalog> sensorCatalogCollection;

    public SensorType() {
    }

    public SensorType(Integer idSensorType) {
        this.idSensorType = idSensorType;
    }

    public SensorType(Integer idSensorType, String sensorType, boolean active, Date lastUpdateDate) {
        this.idSensorType = idSensorType;
        this.sensorType = sensorType;
        this.active = active;
        this.lastUpdateDate = lastUpdateDate;
    }

    public Integer getIdSensorType() {
        return idSensorType;
    }

    public void setIdSensorType(Integer idSensorType) {
        this.idSensorType = idSensorType;
    }

    public String getSensorType() {
        return sensorType;
    }

    public void setSensorType(String sensorType) {
        this.sensorType = sensorType;
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
    public Collection<SensorCatalog> getSensorCatalogCollection() {
        return sensorCatalogCollection;
    }

    public void setSensorCatalogCollection(Collection<SensorCatalog> sensorCatalogCollection) {
        this.sensorCatalogCollection = sensorCatalogCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idSensorType != null ? idSensorType.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SensorType)) {
            return false;
        }
        SensorType other = (SensorType) object;
        if ((this.idSensorType == null && other.idSensorType != null) || (this.idSensorType != null && !this.idSensorType.equals(other.idSensorType))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.SensorType[ idSensorType=" + idSensorType + " ]";
    }
    
}
