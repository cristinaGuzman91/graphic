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
@Table(name = "measurement_units")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MeasurementUnits.findAll", query = "SELECT m FROM MeasurementUnits m"),
    @NamedQuery(name = "MeasurementUnits.findByIdMeasurementUnit", query = "SELECT m FROM MeasurementUnits m WHERE m.idMeasurementUnit = :idMeasurementUnit"),
    @NamedQuery(name = "MeasurementUnits.findByUnitName", query = "SELECT m FROM MeasurementUnits m WHERE m.unitName = :unitName"),
    @NamedQuery(name = "MeasurementUnits.findByActive", query = "SELECT m FROM MeasurementUnits m WHERE m.active = :active"),
    @NamedQuery(name = "MeasurementUnits.findByLastUpdateDate", query = "SELECT m FROM MeasurementUnits m WHERE m.lastUpdateDate = :lastUpdateDate")})
public class MeasurementUnits implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_measurement_unit")
    private Integer idMeasurementUnit;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "unit_name")
    private String unitName;
    @Basic(optional = false)
    @NotNull
    @Column(name = "active")
    private boolean active;
    @Basic(optional = false)
    @NotNull
    @Column(name = "last_update_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastUpdateDate;
    @OneToMany(mappedBy = "idMeasurementUnit")
    private Collection<SensorTags> sensorTagsCollection;

    public MeasurementUnits() {
    }

    public MeasurementUnits(Integer idMeasurementUnit) {
        this.idMeasurementUnit = idMeasurementUnit;
    }

    public MeasurementUnits(Integer idMeasurementUnit, String unitName, boolean active, Date lastUpdateDate) {
        this.idMeasurementUnit = idMeasurementUnit;
        this.unitName = unitName;
        this.active = active;
        this.lastUpdateDate = lastUpdateDate;
    }

    public Integer getIdMeasurementUnit() {
        return idMeasurementUnit;
    }

    public void setIdMeasurementUnit(Integer idMeasurementUnit) {
        this.idMeasurementUnit = idMeasurementUnit;
    }

    public String getUnitName() {
        return unitName;
    }

    public void setUnitName(String unitName) {
        this.unitName = unitName;
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
    public Collection<SensorTags> getSensorTagsCollection() {
        return sensorTagsCollection;
    }

    public void setSensorTagsCollection(Collection<SensorTags> sensorTagsCollection) {
        this.sensorTagsCollection = sensorTagsCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idMeasurementUnit != null ? idMeasurementUnit.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MeasurementUnits)) {
            return false;
        }
        MeasurementUnits other = (MeasurementUnits) object;
        if ((this.idMeasurementUnit == null && other.idMeasurementUnit != null) || (this.idMeasurementUnit != null && !this.idMeasurementUnit.equals(other.idMeasurementUnit))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.MeasurementUnits[ idMeasurementUnit=" + idMeasurementUnit + " ]";
    }
    
}
