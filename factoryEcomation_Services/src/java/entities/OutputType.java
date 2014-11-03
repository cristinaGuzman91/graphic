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
@Table(name = "output_type")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "OutputType.findAll", query = "SELECT o FROM OutputType o"),
    @NamedQuery(name = "OutputType.findByIdOutputType", query = "SELECT o FROM OutputType o WHERE o.idOutputType = :idOutputType"),
    @NamedQuery(name = "OutputType.findByOutputType", query = "SELECT o FROM OutputType o WHERE o.outputType = :outputType"),
    @NamedQuery(name = "OutputType.findByActive", query = "SELECT o FROM OutputType o WHERE o.active = :active"),
    @NamedQuery(name = "OutputType.findByLastUpdateDate", query = "SELECT o FROM OutputType o WHERE o.lastUpdateDate = :lastUpdateDate")})
public class OutputType implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_output_type")
    private Integer idOutputType;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "output_type")
    private String outputType;
    @Basic(optional = false)
    @NotNull
    @Column(name = "active")
    private boolean active;
    @Basic(optional = false)
    @NotNull
    @Column(name = "last_update_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastUpdateDate;
    @OneToMany(mappedBy = "idOutputType")
    private Collection<CommDeviceCatalog> commDeviceCatalogCollection;
    @OneToMany(mappedBy = "idOutputType")
    private Collection<SensorCatalog> sensorCatalogCollection;

    public OutputType() {
    }

    public OutputType(Integer idOutputType) {
        this.idOutputType = idOutputType;
    }

    public OutputType(Integer idOutputType, String outputType, boolean active, Date lastUpdateDate) {
        this.idOutputType = idOutputType;
        this.outputType = outputType;
        this.active = active;
        this.lastUpdateDate = lastUpdateDate;
    }

    public Integer getIdOutputType() {
        return idOutputType;
    }

    public void setIdOutputType(Integer idOutputType) {
        this.idOutputType = idOutputType;
    }

    public String getOutputType() {
        return outputType;
    }

    public void setOutputType(String outputType) {
        this.outputType = outputType;
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

    @XmlTransient
    public Collection<SensorCatalog> getSensorCatalogCollection() {
        return sensorCatalogCollection;
    }

    public void setSensorCatalogCollection(Collection<SensorCatalog> sensorCatalogCollection) {
        this.sensorCatalogCollection = sensorCatalogCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idOutputType != null ? idOutputType.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OutputType)) {
            return false;
        }
        OutputType other = (OutputType) object;
        if ((this.idOutputType == null && other.idOutputType != null) || (this.idOutputType != null && !this.idOutputType.equals(other.idOutputType))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.OutputType[ idOutputType=" + idOutputType + " ]";
    }
    
}
