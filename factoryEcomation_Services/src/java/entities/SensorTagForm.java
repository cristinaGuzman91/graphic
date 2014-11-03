/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entities;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 *
 * @author usuario
 */
@Entity
public class SensorTagForm implements Serializable {

    @Id
    
    private String sensorTag;
    
    private int slId;
    
    private String company;
    
    private float maxValue;
    
    private float minValue;
    
    private boolean active;
    
    private int idSensorCatalog;
    
    private int idMeasurementUnit;
    
    private int idLocation;
    
    private String commDeviceTag;
    
    public SensorTagForm() {
    }
    
    public SensorTagForm(String tag){
        this.sensorTag = tag;
    }

    public SensorTagForm(String sensorTag, int slId, String company, float maxValue, float minValue, boolean active, int idSensorCatalog, int idMeasurementUnit, String commDeviceTag,int idLocation) {
        this.sensorTag = sensorTag;
        this.slId = slId;
        this.company = company;
        this.maxValue = maxValue;
        this.minValue = minValue;
        this.active = active;
        this.idSensorCatalog = idSensorCatalog;
        this.idMeasurementUnit = idMeasurementUnit;
        this.commDeviceTag = commDeviceTag;
        this.idLocation = idLocation;
    }
    
    
    public String getSensorTag() {
        return sensorTag;
    }

    public void setSensorTag(String sensorTag) {
        this.sensorTag = sensorTag;
    }

    public int getSlId() {
        return slId;
    }

    public void setSlId(int slId) {
        this.slId = slId;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public float getMaxValue() {
        return maxValue;
    }

    public void setMaxValue(float maxValue) {
        this.maxValue = maxValue;
    }

    public float getMinValue() {
        return minValue;
    }

    public void setMinValue(float minValue) {
        this.minValue = minValue;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public int getIdSensorCatalog() {
        return idSensorCatalog;
    }

    public void setIdSensorCatalog(int idSensorCatalog) {
        this.idSensorCatalog = idSensorCatalog;
    }

    public int getIdMeasurementUnit() {
        return idMeasurementUnit;
    }

    public void setIdMeasurementUnit(int idMeasurementUnit) {
        this.idMeasurementUnit = idMeasurementUnit;
    }

    public String getCommDeviceTag() {
        return commDeviceTag;
    }

    public void setCommDeviceTag(String commDeviceTag) {
        this.commDeviceTag = commDeviceTag;
    }
    
    public int getIdLocation(){
        return idLocation;
    }
    
    public void setIdLocation(int idLocation){
        this.idLocation = idLocation;
    }
    
    public String getId() {
        return sensorTag;
    }

    public void setId(String sensorTag) {
        this.sensorTag = sensorTag;
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
        if (!(object instanceof SensorTagForm)) {
            return false;
        }
        SensorTagForm other = (SensorTagForm) object;
        return (this.sensorTag != null || other.sensorTag == null) && (this.sensorTag == null || this.sensorTag.equals(other.sensorTag));
    }

    @Override
    public String toString() {
        return "entities.sensorTagForm[ id=" + sensorTag + " ]";
    }
    
}
