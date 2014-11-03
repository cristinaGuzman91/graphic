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
@Table(name = "comm_device_catalog_log")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CommDeviceCatalogLog.findAll", query = "SELECT c FROM CommDeviceCatalogLog c"),
    @NamedQuery(name = "CommDeviceCatalogLog.findByIdCommDeviceCatalogLog", query = "SELECT c FROM CommDeviceCatalogLog c WHERE c.idCommDeviceCatalogLog = :idCommDeviceCatalogLog"),
    @NamedQuery(name = "CommDeviceCatalogLog.findByColumnName", query = "SELECT c FROM CommDeviceCatalogLog c WHERE c.columnName = :columnName"),
    @NamedQuery(name = "CommDeviceCatalogLog.findByOldValue", query = "SELECT c FROM CommDeviceCatalogLog c WHERE c.oldValue = :oldValue"),
    @NamedQuery(name = "CommDeviceCatalogLog.findByNewValue", query = "SELECT c FROM CommDeviceCatalogLog c WHERE c.newValue = :newValue"),
    @NamedQuery(name = "CommDeviceCatalogLog.findByUserMod", query = "SELECT c FROM CommDeviceCatalogLog c WHERE c.userMod = :userMod"),
    @NamedQuery(name = "CommDeviceCatalogLog.findByUpdDate", query = "SELECT c FROM CommDeviceCatalogLog c WHERE c.updDate = :updDate")})
public class CommDeviceCatalogLog implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_comm_device_catalog_log")
    private Integer idCommDeviceCatalogLog;
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
    @JoinColumn(name = "id_comm_device_catalog", referencedColumnName = "id_comm_device_catalog")
    @ManyToOne(optional = false)
    private CommDeviceCatalog idCommDeviceCatalog;

    public CommDeviceCatalogLog() {
    }

    public CommDeviceCatalogLog(Integer idCommDeviceCatalogLog) {
        this.idCommDeviceCatalogLog = idCommDeviceCatalogLog;
    }

    public CommDeviceCatalogLog(Integer idCommDeviceCatalogLog, String userMod, Date updDate) {
        this.idCommDeviceCatalogLog = idCommDeviceCatalogLog;
        this.userMod = userMod;
        this.updDate = updDate;
    }

    public Integer getIdCommDeviceCatalogLog() {
        return idCommDeviceCatalogLog;
    }

    public void setIdCommDeviceCatalogLog(Integer idCommDeviceCatalogLog) {
        this.idCommDeviceCatalogLog = idCommDeviceCatalogLog;
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

    public CommDeviceCatalog getIdCommDeviceCatalog() {
        return idCommDeviceCatalog;
    }

    public void setIdCommDeviceCatalog(CommDeviceCatalog idCommDeviceCatalog) {
        this.idCommDeviceCatalog = idCommDeviceCatalog;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCommDeviceCatalogLog != null ? idCommDeviceCatalogLog.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CommDeviceCatalogLog)) {
            return false;
        }
        CommDeviceCatalogLog other = (CommDeviceCatalogLog) object;
        if ((this.idCommDeviceCatalogLog == null && other.idCommDeviceCatalogLog != null) || (this.idCommDeviceCatalogLog != null && !this.idCommDeviceCatalogLog.equals(other.idCommDeviceCatalogLog))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.CommDeviceCatalogLog[ idCommDeviceCatalogLog=" + idCommDeviceCatalogLog + " ]";
    }
    
}
