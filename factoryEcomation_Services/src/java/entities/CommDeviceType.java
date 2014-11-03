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
@Table(name = "comm_device_type")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CommDeviceType.findAll", query = "SELECT c FROM CommDeviceType c"),
    @NamedQuery(name = "CommDeviceType.findByIdCommDeviceType", query = "SELECT c FROM CommDeviceType c WHERE c.idCommDeviceType = :idCommDeviceType"),
    @NamedQuery(name = "CommDeviceType.findByCommDeviceType", query = "SELECT c FROM CommDeviceType c WHERE c.commDeviceType = :commDeviceType"),
    @NamedQuery(name = "CommDeviceType.findByActive", query = "SELECT c FROM CommDeviceType c WHERE c.active = :active"),
    @NamedQuery(name = "CommDeviceType.findByLastUpdateDate", query = "SELECT c FROM CommDeviceType c WHERE c.lastUpdateDate = :lastUpdateDate")})
public class CommDeviceType implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_comm_device_type")
    private Integer idCommDeviceType;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "comm_device_type")
    private String commDeviceType;
    @Basic(optional = false)
    @NotNull
    @Column(name = "active")
    private boolean active;
    @Basic(optional = false)
    @NotNull
    @Column(name = "last_update_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastUpdateDate;
    @OneToMany(mappedBy = "idCommDeviceType")
    private Collection<CommDeviceCatalog> commDeviceCatalogCollection;

    public CommDeviceType() {
    }

    public CommDeviceType(Integer idCommDeviceType) {
        this.idCommDeviceType = idCommDeviceType;
    }

    public CommDeviceType(Integer idCommDeviceType, String commDeviceType, boolean active, Date lastUpdateDate) {
        this.idCommDeviceType = idCommDeviceType;
        this.commDeviceType = commDeviceType;
        this.active = active;
        this.lastUpdateDate = lastUpdateDate;
    }

    public Integer getIdCommDeviceType() {
        return idCommDeviceType;
    }

    public void setIdCommDeviceType(Integer idCommDeviceType) {
        this.idCommDeviceType = idCommDeviceType;
    }

    public String getCommDeviceType() {
        return commDeviceType;
    }

    public void setCommDeviceType(String commDeviceType) {
        this.commDeviceType = commDeviceType;
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
    public Collection<CommDeviceCatalog> getCommDeviceCatalogCollection() {
        return commDeviceCatalogCollection;
    }

    public void setCommDeviceCatalogCollection(Collection<CommDeviceCatalog> commDeviceCatalogCollection) {
        this.commDeviceCatalogCollection = commDeviceCatalogCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCommDeviceType != null ? idCommDeviceType.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CommDeviceType)) {
            return false;
        }
        CommDeviceType other = (CommDeviceType) object;
        if ((this.idCommDeviceType == null && other.idCommDeviceType != null) || (this.idCommDeviceType != null && !this.idCommDeviceType.equals(other.idCommDeviceType))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.CommDeviceType[ idCommDeviceType=" + idCommDeviceType + " ]";
    }
    
}
