/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
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
@Table(name = "sensor_tags")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SensorTags.findAll", query = "SELECT s FROM SensorTags s"),
    @NamedQuery(name = "SensorTags.findBySensorTag", query = "SELECT s FROM SensorTags s WHERE s.sensorTag = :sensorTag"),
    @NamedQuery(name = "SensorTags.findByMaxValue", query = "SELECT s FROM SensorTags s WHERE s.maxValue = :maxValue"),
    @NamedQuery(name = "SensorTags.findByMinValue", query = "SELECT s FROM SensorTags s WHERE s.minValue = :minValue"),
    @NamedQuery(name = "SensorTags.findByActive", query = "SELECT s FROM SensorTags s WHERE s.active = :active"),
    @NamedQuery(name = "SensorTags.findByInsertDate", query = "SELECT s FROM SensorTags s WHERE s.insertDate = :insertDate"),
    @NamedQuery(name = "SensorTags.findByLastUpdateDate", query = "SELECT s FROM SensorTags s WHERE s.lastUpdateDate = :lastUpdateDate"),
    @NamedQuery(name=  "SensorTags.findBySensorList",query="SELECT s FROM SensorTags s WHERE s.slId = :slId")})

public class SensorTags implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "sensor_tag")
    private String sensorTag;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "max_value")
    private Float maxValue;
    @Column(name = "min_value")
    private Float minValue;
    @Basic(optional = false)
    @NotNull
    @Column(name = "active")
    private boolean active;
    @Column(name = "insert_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date insertDate;
    @Basic(optional = false)
    @NotNull
    @Column(name = "last_update_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastUpdateDate;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "sensorTag")
    private Collection<SensorTagsLog> sensorTagsLogCollection;
    @JoinColumn(name = "id_sensor_catalog", referencedColumnName = "id_sensor_catalog")
    @ManyToOne
    private SensorCatalog idSensorCatalog;
    @JoinColumn(name = "slId", referencedColumnName = "slId")
    @ManyToOne
    private Sensorlist slId;
    @JoinColumn(name = "id_measurement_unit", referencedColumnName = "id_measurement_unit")
    @ManyToOne
    private MeasurementUnits idMeasurementUnit;
    @JoinColumn(name = "comm_device_tag", referencedColumnName = "comm_device_tag")
    @ManyToOne(optional = false)
    private CommDeviceTags commDeviceTag;
    @JoinColumn(name = "id_location", referencedColumnName = "id_location")
    @ManyToOne
    private Location idLocation;

    public SensorTags() {
    }

    public SensorTags(String sensorTag) {
        this.sensorTag = sensorTag;
    }

    public SensorTags(String sensorTag, boolean active, Date lastUpdateDate) {
        this.sensorTag = sensorTag;
        this.active = active;
        this.lastUpdateDate = lastUpdateDate;
    }

    
 public void fillAll(SensorTags newSensor){
        this.sensorTag = newSensor.getSensorTag();
        this.maxValue = newSensor.getMaxValue();
        this.minValue = newSensor.getMinValue();
        this.active = newSensor.getActive();
        this.insertDate = newSensor.getInsertDate();
        this.lastUpdateDate = newSensor.getLastUpdateDate();
        this.sensorTagsLogCollection = newSensor.getSensorTagsLogCollection();
        this.idSensorCatalog = newSensor.getIdSensorCatalog();
        this.idMeasurementUnit = newSensor.getIdMeasurementUnit();
        this.commDeviceTag = newSensor.getCommDeviceTag();
        this.slId = newSensor.getSlId();
    }
    
    
    public String getSensorTag() {
        return sensorTag;
    }

    public void setSensorTag(String sensorTag) {
        this.sensorTag = sensorTag;
    }

    public Float getMaxValue() {
        return maxValue;
    }

    public void setMaxValue(Float maxValue) {
        this.maxValue = maxValue;
    }

    public Float getMinValue() {
        return minValue;
    }

    public void setMinValue(Float minValue) {
        this.minValue = minValue;
    }

    public boolean getActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public Date getInsertDate() {
        return insertDate;
    }

    public void setInsertDate(Date insertDate) {
        this.insertDate = insertDate;
    }

    public Date getLastUpdateDate() {
        return lastUpdateDate;
    }

    public void setLastUpdateDate(Date lastUpdateDate) {
        this.lastUpdateDate = lastUpdateDate;
    }

    @XmlTransient
    public Collection<SensorTagsLog> getSensorTagsLogCollection() {
        return sensorTagsLogCollection;
    }

    public void setSensorTagsLogCollection(Collection<SensorTagsLog> sensorTagsLogCollection) {
        this.sensorTagsLogCollection = sensorTagsLogCollection;
    }

    public SensorCatalog getIdSensorCatalog() {
        return idSensorCatalog;
    }

    public void setIdSensorCatalog(SensorCatalog idSensorCatalog) {
        this.idSensorCatalog = idSensorCatalog;
    }

    public Sensorlist getSlId() {
        return slId;
    }

    public void setSlId(Sensorlist slId) {
        this.slId = slId;
    }

    public MeasurementUnits getIdMeasurementUnit() {
        return idMeasurementUnit;
    }

    public void setIdMeasurementUnit(MeasurementUnits idMeasurementUnit) {
        this.idMeasurementUnit = idMeasurementUnit;
    }

    public CommDeviceTags getCommDeviceTag() {
        return commDeviceTag;
    }

    public void setCommDeviceTag(CommDeviceTags commDeviceTag) {
        this.commDeviceTag = commDeviceTag;
    }

    public Location getIdLocation() {
        return idLocation;
    }

    public void setIdLocation(Location idLocation) {
        this.idLocation = idLocation;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (sensorTag != null ? sensorTag.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SensorTags)) {
            return false;
        }
        SensorTags other = (SensorTags) object;
        if ((this.sensorTag == null && other.sensorTag != null) || (this.sensorTag != null && !this.sensorTag.equals(other.sensorTag))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.SensorTags[ sensorTag=" + sensorTag + " ]";
    }
    
}
