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
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
@Table(name = "comm_device_catalog")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CommDeviceCatalog.findAll", query = "SELECT c FROM CommDeviceCatalog c"),
    @NamedQuery(name = "CommDeviceCatalog.findByIdCommDeviceCatalog", query = "SELECT c FROM CommDeviceCatalog c WHERE c.idCommDeviceCatalog = :idCommDeviceCatalog"),
    @NamedQuery(name = "CommDeviceCatalog.findBySerialNumber", query = "SELECT c FROM CommDeviceCatalog c WHERE c.serialNumber = :serialNumber"),
    @NamedQuery(name = "CommDeviceCatalog.findByReference", query = "SELECT c FROM CommDeviceCatalog c WHERE c.reference = :reference"),
    @NamedQuery(name = "CommDeviceCatalog.findByActive", query = "SELECT c FROM CommDeviceCatalog c WHERE c.active = :active"),
    @NamedQuery(name = "CommDeviceCatalog.findByLastUpdateDate", query = "SELECT c FROM CommDeviceCatalog c WHERE c.lastUpdateDate = :lastUpdateDate")})
public class CommDeviceCatalog implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_comm_device_catalog")
    private Integer idCommDeviceCatalog;
    @Size(max = 50)
    @Column(name = "serial_number")
    private String serialNumber;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "reference")
    private String reference;
    @Basic(optional = false)
    @NotNull
    @Column(name = "active")
    private boolean active;
    @Basic(optional = false)
    @NotNull
    @Column(name = "last_update_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastUpdateDate;
    @JoinColumn(name = "id_output_type", referencedColumnName = "id_output_type")
    @ManyToOne
    private OutputType idOutputType;
    @JoinColumn(name = "id_company", referencedColumnName = "id_company")
    @ManyToOne(optional = false)
    private Company idCompany;
    @JoinColumn(name = "id_comm_type", referencedColumnName = "id_comm_type")
    @ManyToOne
    private CommType idCommType;
    @JoinColumn(name = "id_comm_protocol", referencedColumnName = "id_comm_protocol")
    @ManyToOne
    private CommProtocol idCommProtocol;
    @JoinColumn(name = "id_comm_device_type", referencedColumnName = "id_comm_device_type")
    @ManyToOne
    private CommDeviceType idCommDeviceType;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idCommDeviceCatalog")
    private Collection<CommDeviceCatalogLog> commDeviceCatalogLogCollection;
    @OneToMany(mappedBy = "idCommDeviceCatalog")
    private Collection<CommDeviceTags> commDeviceTagsCollection;

    public CommDeviceCatalog() {
    }

    public CommDeviceCatalog(Integer idCommDeviceCatalog) {
        this.idCommDeviceCatalog = idCommDeviceCatalog;
    }

    public CommDeviceCatalog(Integer idCommDeviceCatalog, String reference, boolean active, Date lastUpdateDate) {
        this.idCommDeviceCatalog = idCommDeviceCatalog;
        this.reference = reference;
        this.active = active;
        this.lastUpdateDate = lastUpdateDate;
    }

    public Integer getIdCommDeviceCatalog() {
        return idCommDeviceCatalog;
    }

    public void setIdCommDeviceCatalog(Integer idCommDeviceCatalog) {
        this.idCommDeviceCatalog = idCommDeviceCatalog;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
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

    public OutputType getIdOutputType() {
        return idOutputType;
    }

    public void setIdOutputType(OutputType idOutputType) {
        this.idOutputType = idOutputType;
    }

    public Company getIdCompany() {
        return idCompany;
    }

    public void setIdCompany(Company idCompany) {
        this.idCompany = idCompany;
    }

    public CommType getIdCommType() {
        return idCommType;
    }

    public void setIdCommType(CommType idCommType) {
        this.idCommType = idCommType;
    }

    public CommProtocol getIdCommProtocol() {
        return idCommProtocol;
    }

    public void setIdCommProtocol(CommProtocol idCommProtocol) {
        this.idCommProtocol = idCommProtocol;
    }

    public CommDeviceType getIdCommDeviceType() {
        return idCommDeviceType;
    }

    public void setIdCommDeviceType(CommDeviceType idCommDeviceType) {
        this.idCommDeviceType = idCommDeviceType;
    }

    @XmlTransient
    public Collection<CommDeviceCatalogLog> getCommDeviceCatalogLogCollection() {
        return commDeviceCatalogLogCollection;
    }

    public void setCommDeviceCatalogLogCollection(Collection<CommDeviceCatalogLog> commDeviceCatalogLogCollection) {
        this.commDeviceCatalogLogCollection = commDeviceCatalogLogCollection;
    }

    @XmlTransient
    public Collection<CommDeviceTags> getCommDeviceTagsCollection() {
        return commDeviceTagsCollection;
    }

    public void setCommDeviceTagsCollection(Collection<CommDeviceTags> commDeviceTagsCollection) {
        this.commDeviceTagsCollection = commDeviceTagsCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCommDeviceCatalog != null ? idCommDeviceCatalog.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CommDeviceCatalog)) {
            return false;
        }
        CommDeviceCatalog other = (CommDeviceCatalog) object;
        if ((this.idCommDeviceCatalog == null && other.idCommDeviceCatalog != null) || (this.idCommDeviceCatalog != null && !this.idCommDeviceCatalog.equals(other.idCommDeviceCatalog))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.CommDeviceCatalog[ idCommDeviceCatalog=" + idCommDeviceCatalog + " ]";
    }
    
}
