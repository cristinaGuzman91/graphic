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
@Table(name = "sensor_catalog_log")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SensorCatalogLog.findAll", query = "SELECT s FROM SensorCatalogLog s"),
    @NamedQuery(name = "SensorCatalogLog.findByIdSensorCatalogLog", query = "SELECT s FROM SensorCatalogLog s WHERE s.idSensorCatalogLog = :idSensorCatalogLog"),
    @NamedQuery(name = "SensorCatalogLog.findByColumnName", query = "SELECT s FROM SensorCatalogLog s WHERE s.columnName = :columnName"),
    @NamedQuery(name = "SensorCatalogLog.findByOldValue", query = "SELECT s FROM SensorCatalogLog s WHERE s.oldValue = :oldValue"),
    @NamedQuery(name = "SensorCatalogLog.findByNewValue", query = "SELECT s FROM SensorCatalogLog s WHERE s.newValue = :newValue"),
    @NamedQuery(name = "SensorCatalogLog.findByUserMod", query = "SELECT s FROM SensorCatalogLog s WHERE s.userMod = :userMod"),
    @NamedQuery(name = "SensorCatalogLog.findByUpdDate", query = "SELECT s FROM SensorCatalogLog s WHERE s.updDate = :updDate")})
public class SensorCatalogLog implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_sensor_catalog_log")
    private Integer idSensorCatalogLog;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
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
    @JoinColumn(name = "id_sensor_catalog", referencedColumnName = "id_sensor_catalog")
    @ManyToOne(optional = false)
    private SensorCatalog idSensorCatalog;

    public SensorCatalogLog() {
    }

    public SensorCatalogLog(Integer idSensorCatalogLog) {
        this.idSensorCatalogLog = idSensorCatalogLog;
    }

    public SensorCatalogLog(Integer idSensorCatalogLog, String columnName, String userMod, Date updDate) {
        this.idSensorCatalogLog = idSensorCatalogLog;
        this.columnName = columnName;
        this.userMod = userMod;
        this.updDate = updDate;
    }

    public Integer getIdSensorCatalogLog() {
        return idSensorCatalogLog;
    }

    public void setIdSensorCatalogLog(Integer idSensorCatalogLog) {
        this.idSensorCatalogLog = idSensorCatalogLog;
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

    public SensorCatalog getIdSensorCatalog() {
        return idSensorCatalog;
    }

    public void setIdSensorCatalog(SensorCatalog idSensorCatalog) {
        this.idSensorCatalog = idSensorCatalog;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idSensorCatalogLog != null ? idSensorCatalogLog.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SensorCatalogLog)) {
            return false;
        }
        SensorCatalogLog other = (SensorCatalogLog) object;
        if ((this.idSensorCatalogLog == null && other.idSensorCatalogLog != null) || (this.idSensorCatalogLog != null && !this.idSensorCatalogLog.equals(other.idSensorCatalogLog))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.SensorCatalogLog[ idSensorCatalogLog=" + idSensorCatalogLog + " ]";
    }
    
}
