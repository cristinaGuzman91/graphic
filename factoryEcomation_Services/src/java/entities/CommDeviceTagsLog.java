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
@Table(name = "comm_device_tags_log")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CommDeviceTagsLog.findAll", query = "SELECT c FROM CommDeviceTagsLog c"),
    @NamedQuery(name = "CommDeviceTagsLog.findByIdCommDeviceTagsLog", query = "SELECT c FROM CommDeviceTagsLog c WHERE c.idCommDeviceTagsLog = :idCommDeviceTagsLog"),
    @NamedQuery(name = "CommDeviceTagsLog.findByColumnName", query = "SELECT c FROM CommDeviceTagsLog c WHERE c.columnName = :columnName"),
    @NamedQuery(name = "CommDeviceTagsLog.findByOldValue", query = "SELECT c FROM CommDeviceTagsLog c WHERE c.oldValue = :oldValue"),
    @NamedQuery(name = "CommDeviceTagsLog.findByNewValue", query = "SELECT c FROM CommDeviceTagsLog c WHERE c.newValue = :newValue"),
    @NamedQuery(name = "CommDeviceTagsLog.findByUserMod", query = "SELECT c FROM CommDeviceTagsLog c WHERE c.userMod = :userMod"),
    @NamedQuery(name = "CommDeviceTagsLog.findByUpdDate", query = "SELECT c FROM CommDeviceTagsLog c WHERE c.updDate = :updDate")})
public class CommDeviceTagsLog implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_comm_device_tags_log")
    private Integer idCommDeviceTagsLog;
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
    @JoinColumn(name = "comm_device_tag", referencedColumnName = "comm_device_tag")
    @ManyToOne(optional = false)
    private CommDeviceTags commDeviceTag;

    public CommDeviceTagsLog() {
    }

    public CommDeviceTagsLog(Integer idCommDeviceTagsLog) {
        this.idCommDeviceTagsLog = idCommDeviceTagsLog;
    }

    public CommDeviceTagsLog(Integer idCommDeviceTagsLog, String userMod, Date updDate) {
        this.idCommDeviceTagsLog = idCommDeviceTagsLog;
        this.userMod = userMod;
        this.updDate = updDate;
    }

    public Integer getIdCommDeviceTagsLog() {
        return idCommDeviceTagsLog;
    }

    public void setIdCommDeviceTagsLog(Integer idCommDeviceTagsLog) {
        this.idCommDeviceTagsLog = idCommDeviceTagsLog;
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

    public CommDeviceTags getCommDeviceTag() {
        return commDeviceTag;
    }

    public void setCommDeviceTag(CommDeviceTags commDeviceTag) {
        this.commDeviceTag = commDeviceTag;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCommDeviceTagsLog != null ? idCommDeviceTagsLog.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CommDeviceTagsLog)) {
            return false;
        }
        CommDeviceTagsLog other = (CommDeviceTagsLog) object;
        if ((this.idCommDeviceTagsLog == null && other.idCommDeviceTagsLog != null) || (this.idCommDeviceTagsLog != null && !this.idCommDeviceTagsLog.equals(other.idCommDeviceTagsLog))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.CommDeviceTagsLog[ idCommDeviceTagsLog=" + idCommDeviceTagsLog + " ]";
    }
    
}
