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
@Table(name = "comm_protocol")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CommProtocol.findAll", query = "SELECT c FROM CommProtocol c"),
    @NamedQuery(name = "CommProtocol.findByIdCommProtocol", query = "SELECT c FROM CommProtocol c WHERE c.idCommProtocol = :idCommProtocol"),
    @NamedQuery(name = "CommProtocol.findByCommProtocol", query = "SELECT c FROM CommProtocol c WHERE c.commProtocol = :commProtocol"),
    @NamedQuery(name = "CommProtocol.findByActive", query = "SELECT c FROM CommProtocol c WHERE c.active = :active"),
    @NamedQuery(name = "CommProtocol.findByLastUpdateDate", query = "SELECT c FROM CommProtocol c WHERE c.lastUpdateDate = :lastUpdateDate")})
public class CommProtocol implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_comm_protocol")
    private Integer idCommProtocol;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "comm_protocol")
    private String commProtocol;
    @Basic(optional = false)
    @NotNull
    @Column(name = "active")
    private boolean active;
    @Basic(optional = false)
    @NotNull
    @Column(name = "last_update_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastUpdateDate;
    @OneToMany(mappedBy = "idCommProtocol")
    private Collection<CommDeviceCatalog> commDeviceCatalogCollection;

    public CommProtocol() {
    }

    public CommProtocol(Integer idCommProtocol) {
        this.idCommProtocol = idCommProtocol;
    }

    public CommProtocol(Integer idCommProtocol, String commProtocol, boolean active, Date lastUpdateDate) {
        this.idCommProtocol = idCommProtocol;
        this.commProtocol = commProtocol;
        this.active = active;
        this.lastUpdateDate = lastUpdateDate;
    }

    public Integer getIdCommProtocol() {
        return idCommProtocol;
    }

    public void setIdCommProtocol(Integer idCommProtocol) {
        this.idCommProtocol = idCommProtocol;
    }

    public String getCommProtocol() {
        return commProtocol;
    }

    public void setCommProtocol(String commProtocol) {
        this.commProtocol = commProtocol;
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
        hash += (idCommProtocol != null ? idCommProtocol.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CommProtocol)) {
            return false;
        }
        CommProtocol other = (CommProtocol) object;
        if ((this.idCommProtocol == null && other.idCommProtocol != null) || (this.idCommProtocol != null && !this.idCommProtocol.equals(other.idCommProtocol))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.CommProtocol[ idCommProtocol=" + idCommProtocol + " ]";
    }
    
}
