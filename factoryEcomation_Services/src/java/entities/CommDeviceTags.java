/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entities;


import entities.SensorTags;
import java.io.Serializable;
import java.util.Collection;
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
@Table(name = "comm_device_tags")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CommDeviceTags.findAll", query = "SELECT c FROM CommDeviceTags c"),
    @NamedQuery(name = "CommDeviceTags.findByCommDeviceTag", query = "SELECT c FROM CommDeviceTags c WHERE c.commDeviceTag = :commDeviceTag"),
    @NamedQuery(name = "CommDeviceTags.findByPeriodMs", query = "SELECT c FROM CommDeviceTags c WHERE c.periodMs = :periodMs"),
    @NamedQuery(name = "CommDeviceTags.findByActive", query = "SELECT c FROM CommDeviceTags c WHERE c.active = :active"),
    @NamedQuery(name = "CommDeviceTags.findByInsertDate", query = "SELECT c FROM CommDeviceTags c WHERE c.insertDate = :insertDate"),
    @NamedQuery(name = "CommDeviceTags.findByLocation", query = "SELECT c FROM CommDeviceTags c WHERE c.idLocation = :idLocation"),
    @NamedQuery(name = "CommDeviceTags.findByLastUpdateDate", query = "SELECT c FROM CommDeviceTags c WHERE c.lastUpdateDate = :lastUpdateDate")})
public class CommDeviceTags implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "comm_device_tag")
    private String commDeviceTag;
    @Column(name = "period_ms")
    private Integer periodMs;
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "commDeviceTag")
    private Collection<CommDeviceTagsLog> commDeviceTagsLogCollection;
    @JoinColumn(name = "id_location", referencedColumnName = "id_location")
    @ManyToOne
    private Location idLocation;
    @JoinColumn(name = "id_comm_device_catalog", referencedColumnName = "id_comm_device_catalog")
    @ManyToOne
    private CommDeviceCatalog idCommDeviceCatalog;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "commDeviceTag")
    private Collection<SensorTags> sensorTagsCollection;

    public CommDeviceTags() {
    }

    public CommDeviceTags(String commDeviceTag) {
        this.commDeviceTag = commDeviceTag;
    }

    public CommDeviceTags(String commDeviceTag, boolean active, Date insertDate, Date lastUpdateDate) {
        this.commDeviceTag = commDeviceTag;
        this.active = active;
        this.insertDate = insertDate;
        this.lastUpdateDate = lastUpdateDate;
    }

    public String getCommDeviceTag() {
        return commDeviceTag;
    }

    public void setCommDeviceTag(String commDeviceTag) {
        this.commDeviceTag = commDeviceTag;
    }

    public Integer getPeriodMs() {
        return periodMs;
    }

    public void setPeriodMs(Integer periodMs) {
        this.periodMs = periodMs;
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
    public Collection<CommDeviceTagsLog> getCommDeviceTagsLogCollection() {
        return commDeviceTagsLogCollection;
    }

    public void setCommDeviceTagsLogCollection(Collection<CommDeviceTagsLog> commDeviceTagsLogCollection) {
        this.commDeviceTagsLogCollection = commDeviceTagsLogCollection;
    }

    public Location getIdLocation() {
        return idLocation;
    }

    public void setIdLocation(Location idLocation) {
        this.idLocation = idLocation;
    }

    public CommDeviceCatalog getIdCommDeviceCatalog() {
        return idCommDeviceCatalog;
    }

    public void setIdCommDeviceCatalog(CommDeviceCatalog idCommDeviceCatalog) {
        this.idCommDeviceCatalog = idCommDeviceCatalog;
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
        hash += (commDeviceTag != null ? commDeviceTag.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CommDeviceTags)) {
            return false;
        }
        CommDeviceTags other = (CommDeviceTags) object;
        if ((this.commDeviceTag == null && other.commDeviceTag != null) || (this.commDeviceTag != null && !this.commDeviceTag.equals(other.commDeviceTag))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.CommDeviceTags[ commDeviceTag=" + commDeviceTag + " ]";
    }
    
}
