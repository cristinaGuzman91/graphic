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
@Table(name = "output_format")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "OutputFormat.findAll", query = "SELECT o FROM OutputFormat o"),
    @NamedQuery(name = "OutputFormat.findByIdOutputFormat", query = "SELECT o FROM OutputFormat o WHERE o.idOutputFormat = :idOutputFormat"),
    @NamedQuery(name = "OutputFormat.findByOutputFormat", query = "SELECT o FROM OutputFormat o WHERE o.outputFormat = :outputFormat"),
    @NamedQuery(name = "OutputFormat.findByActive", query = "SELECT o FROM OutputFormat o WHERE o.active = :active"),
    @NamedQuery(name = "OutputFormat.findByLastUpdateDate", query = "SELECT o FROM OutputFormat o WHERE o.lastUpdateDate = :lastUpdateDate")})
public class OutputFormat implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_output_format")
    private Integer idOutputFormat;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "output_format")
    private String outputFormat;
    @Basic(optional = false)
    @NotNull
    @Column(name = "active")
    private boolean active;
    @Basic(optional = false)
    @NotNull
    @Column(name = "last_update_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastUpdateDate;
    @OneToMany(mappedBy = "idOutputFormat")
    private Collection<SensorCatalog> sensorCatalogCollection;

    public OutputFormat() {
    }

    public OutputFormat(Integer idOutputFormat) {
        this.idOutputFormat = idOutputFormat;
    }

    public OutputFormat(Integer idOutputFormat, String outputFormat, boolean active, Date lastUpdateDate) {
        this.idOutputFormat = idOutputFormat;
        this.outputFormat = outputFormat;
        this.active = active;
        this.lastUpdateDate = lastUpdateDate;
    }

    public Integer getIdOutputFormat() {
        return idOutputFormat;
    }

    public void setIdOutputFormat(Integer idOutputFormat) {
        this.idOutputFormat = idOutputFormat;
    }

    public String getOutputFormat() {
        return outputFormat;
    }

    public void setOutputFormat(String outputFormat) {
        this.outputFormat = outputFormat;
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
    public Collection<SensorCatalog> getSensorCatalogCollection() {
        return sensorCatalogCollection;
    }

    public void setSensorCatalogCollection(Collection<SensorCatalog> sensorCatalogCollection) {
        this.sensorCatalogCollection = sensorCatalogCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idOutputFormat != null ? idOutputFormat.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OutputFormat)) {
            return false;
        }
        OutputFormat other = (OutputFormat) object;
        if ((this.idOutputFormat == null && other.idOutputFormat != null) || (this.idOutputFormat != null && !this.idOutputFormat.equals(other.idOutputFormat))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.OutputFormat[ idOutputFormat=" + idOutputFormat + " ]";
    }
    
}
