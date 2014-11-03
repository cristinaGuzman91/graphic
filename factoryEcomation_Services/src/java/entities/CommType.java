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
@Table(name = "comm_type")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CommType.findAll", query = "SELECT c FROM CommType c"),
    @NamedQuery(name = "CommType.findByIdCommType", query = "SELECT c FROM CommType c WHERE c.idCommType = :idCommType"),
    @NamedQuery(name = "CommType.findByCommType", query = "SELECT c FROM CommType c WHERE c.commType = :commType"),
    @NamedQuery(name = "CommType.findByActive", query = "SELECT c FROM CommType c WHERE c.active = :active"),
    @NamedQuery(name = "CommType.findByLastUpdateDate", query = "SELECT c FROM CommType c WHERE c.lastUpdateDate = :lastUpdateDate")})
public class CommType implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_comm_type")
    private Integer idCommType;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "comm_type")
    private String commType;
    @Basic(optional = false)
    @NotNull
    @Column(name = "active")
    private boolean active;
    @Basic(optional = false)
    @NotNull
    @Column(name = "last_update_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastUpdateDate;
    @OneToMany(mappedBy = "idCommType")
    private Collection<CommDeviceCatalog> commDeviceCatalogCollection;

    public CommType() {
    }

    public CommType(Integer idCommType) {
        this.idCommType = idCommType;
    }

    public CommType(Integer idCommType, String commType, boolean active, Date lastUpdateDate) {
        this.idCommType = idCommType;
        this.commType = commType;
        this.active = active;
        this.lastUpdateDate = lastUpdateDate;
    }

    public Integer getIdCommType() {
        return idCommType;
    }

    public void setIdCommType(Integer idCommType) {
        this.idCommType = idCommType;
    }

    public String getCommType() {
        return commType;
    }

    public void setCommType(String commType) {
        this.commType = commType;
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
        hash += (idCommType != null ? idCommType.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CommType)) {
            return false;
        }
        CommType other = (CommType) object;
        if ((this.idCommType == null && other.idCommType != null) || (this.idCommType != null && !this.idCommType.equals(other.idCommType))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.CommType[ idCommType=" + idCommType + " ]";
    }
    
}
