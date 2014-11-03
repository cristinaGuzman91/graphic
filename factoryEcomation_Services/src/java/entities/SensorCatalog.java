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
@Table(name = "sensor_catalog")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SensorCatalog.findAll", query = "SELECT s FROM SensorCatalog s"),
    @NamedQuery(name = "SensorCatalog.findByIdSensorCatalog", query = "SELECT s FROM SensorCatalog s WHERE s.idSensorCatalog = :idSensorCatalog"),
    @NamedQuery(name = "SensorCatalog.findByModel", query = "SELECT s FROM SensorCatalog s WHERE s.model = :model"),
    @NamedQuery(name = "SensorCatalog.findByReference", query = "SELECT s FROM SensorCatalog s WHERE s.reference = :reference"),
    @NamedQuery(name = "SensorCatalog.findByActive", query = "SELECT s FROM SensorCatalog s WHERE s.active = :active"),
    @NamedQuery(name = "SensorCatalog.findByLastUpdateDate", query = "SELECT s FROM SensorCatalog s WHERE s.lastUpdateDate = :lastUpdateDate"),
    @NamedQuery(name = "SensorCatalog.findByCompany", query = "SELECT s FROM SensorCatalog s WHERE s.idCompany = :idCompany"), 
    @NamedQuery(name = "SensorCatalog.findByCompanySensorType", query = "SELECT s FROM SensorCatalog s WHERE s.idCompany = :idCompany AND  s.idSensorType = :idSensorType")})

public class SensorCatalog implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_sensor_catalog")
    private Integer idSensorCatalog;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "model")
    private String model;
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idSensorCatalog")
    private Collection<SensorCatalogLog> sensorCatalogLogCollection;
    @OneToMany(mappedBy = "idSensorCatalog")
    private Collection<SensorTags> sensorTagsCollection;
    @JoinColumn(name = "id_sensor_type", referencedColumnName = "id_sensor_type")
    @ManyToOne
    private SensorType idSensorType;
    @JoinColumn(name = "id_output_type", referencedColumnName = "id_output_type")
    @ManyToOne
    private OutputType idOutputType;
    @JoinColumn(name = "id_output_format", referencedColumnName = "id_output_format")
    @ManyToOne
    private OutputFormat idOutputFormat;
    @JoinColumn(name = "id_company", referencedColumnName = "id_company")
    @ManyToOne(optional = false)
    private Company idCompany;

    public SensorCatalog() {
    }

    public SensorCatalog(Integer idSensorCatalog) {
        this.idSensorCatalog = idSensorCatalog;
    }

    public SensorCatalog(Integer idSensorCatalog, String model, String reference, boolean active, Date lastUpdateDate) {
        this.idSensorCatalog = idSensorCatalog;
        this.model = model;
        this.reference = reference;
        this.active = active;
        this.lastUpdateDate = lastUpdateDate;
    }

    public Integer getIdSensorCatalog() {
        return idSensorCatalog;
    }

    public void setIdSensorCatalog(Integer idSensorCatalog) {
        this.idSensorCatalog = idSensorCatalog;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
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

    @XmlTransient
    public Collection<SensorCatalogLog> getSensorCatalogLogCollection() {
        return sensorCatalogLogCollection;
    }

    public void setSensorCatalogLogCollection(Collection<SensorCatalogLog> sensorCatalogLogCollection) {
        this.sensorCatalogLogCollection = sensorCatalogLogCollection;
    }

    @XmlTransient
    public Collection<SensorTags> getSensorTagsCollection() {
        return sensorTagsCollection;
    }

    public void setSensorTagsCollection(Collection<SensorTags> sensorTagsCollection) {
        this.sensorTagsCollection = sensorTagsCollection;
    }

    public SensorType getIdSensorType() {
        return idSensorType;
    }

    public void setIdSensorType(SensorType idSensorType) {
        this.idSensorType = idSensorType;
    }

    public OutputType getIdOutputType() {
        return idOutputType;
    }

    public void setIdOutputType(OutputType idOutputType) {
        this.idOutputType = idOutputType;
    }

    public OutputFormat getIdOutputFormat() {
        return idOutputFormat;
    }

    public void setIdOutputFormat(OutputFormat idOutputFormat) {
        this.idOutputFormat = idOutputFormat;
    }

    public Company getIdCompany() {
        return idCompany;
    }

    public void setIdCompany(Company idCompany) {
        this.idCompany = idCompany;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idSensorCatalog != null ? idSensorCatalog.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SensorCatalog)) {
            return false;
        }
        SensorCatalog other = (SensorCatalog) object;
        if ((this.idSensorCatalog == null && other.idSensorCatalog != null) || (this.idSensorCatalog != null && !this.idSensorCatalog.equals(other.idSensorCatalog))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.SensorCatalog[ idSensorCatalog=" + idSensorCatalog + " ]";
    }
    
}
