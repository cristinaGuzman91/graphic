/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entities;

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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author cguzman
 */
@Entity
@Table(name = "sensor_tags_log")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SensorTagsLog.findAll", query = "SELECT s FROM SensorTagsLog s"),
    @NamedQuery(name = "SensorTagsLog.findByIdSensorTagsLog", query = "SELECT s FROM SensorTagsLog s WHERE s.idSensorTagsLog = :idSensorTagsLog"),
    @NamedQuery(name = "SensorTagsLog.findByColumnName", query = "SELECT s FROM SensorTagsLog s WHERE s.columnName = :columnName"),
    @NamedQuery(name = "SensorTagsLog.findByOldValue", query = "SELECT s FROM SensorTagsLog s WHERE s.oldValue = :oldValue"),
    @NamedQuery(name = "SensorTagsLog.findByNewValue", query = "SELECT s FROM SensorTagsLog s WHERE s.newValue = :newValue"),
    @NamedQuery(name = "SensorTagsLog.findByUserMod", query = "SELECT s FROM SensorTagsLog s WHERE s.userMod = :userMod"),
    @NamedQuery(name = "SensorTagsLog.findByUpdDate", query = "SELECT s FROM SensorTagsLog s WHERE s.updDate = :updDate")})
public class SensorTagsLog implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_sensor_tags_log")
    private Integer idSensorTagsLog;
    @Size(max = 50)
    @Column(name = "column_name")
    private String columnName;
    @Size(max = 100)
    @Column(name = "old_value")
    private String oldValue;
    @Size(max = 100)
    @Column(name = "new_value")
    private String newValue;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "user_mod")
    private String userMod;
    @Basic(optional = false)
    @NotNull
    @Column(name = "upd_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updDate;
    @JoinColumn(name = "sensor_tag", referencedColumnName = "sensor_tag")
    @ManyToOne(optional = false)
    private SensorTags sensorTag;

    public SensorTagsLog() {
    }

    public SensorTagsLog(Integer idSensorTagsLog) {
        this.idSensorTagsLog = idSensorTagsLog;
    }

    public SensorTagsLog(Integer idSensorTagsLog, String userMod, Date updDate) {
        this.idSensorTagsLog = idSensorTagsLog;
        this.userMod = userMod;
        this.updDate = updDate;
    }

    public Integer getIdSensorTagsLog() {
        return idSensorTagsLog;
    }

    public void setIdSensorTagsLog(Integer idSensorTagsLog) {
        this.idSensorTagsLog = idSensorTagsLog;
    }

    public String getColumnName() {
        return columnName;
    }

    public void setColumnName(String columnName) {
        this.columnName = columnName;
    }

    public String getOldValue() {
        return oldValue;
    }

    public void setOldValue(String oldValue) {
        this.oldValue = oldValue;
    }

    public String getNewValue() {
        return newValue;
    }

    public void setNewValue(String newValue) {
        this.newValue = newValue;
    }

    public String getUserMod() {
        return userMod;
    }

    public void setUserMod(String userMod) {
        this.userMod = userMod;
    }

    public Date getUpdDate() {
        return updDate;
    }

    public void setUpdDate(Date updDate) {
        this.updDate = updDate;
    }

    public SensorTags getSensorTag() {
        return sensorTag;
    }

    public void setSensorTag(SensorTags sensorTag) {
        this.sensorTag = sensorTag;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idSensorTagsLog != null ? idSensorTagsLog.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SensorTagsLog)) {
            return false;
        }
        SensorTagsLog other = (SensorTagsLog) object;
        if ((this.idSensorTagsLog == null && other.idSensorTagsLog != null) || (this.idSensorTagsLog != null && !this.idSensorTagsLog.equals(other.idSensorTagsLog))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.SensorTagsLog[ idSensorTagsLog=" + idSensorTagsLog + " ]";
    }
    
}
