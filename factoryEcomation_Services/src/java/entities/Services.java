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
@Table(name = "services")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Services.findAll", query = "SELECT s FROM Services s"),
    @NamedQuery(name = "Services.findByIdService", query = "SELECT s FROM Services s WHERE s.idService = :idService"),
    @NamedQuery(name = "Services.findByResource", query = "SELECT s FROM Services s WHERE s.resource = :resource"),
    @NamedQuery(name = "Services.findByServiceName", query = "SELECT s FROM Services s WHERE s.serviceName = :serviceName"),
    @NamedQuery(name = "Services.findByDescription", query = "SELECT s FROM Services s WHERE s.description = :description"),
    @NamedQuery(name = "Services.findByUrl", query = "SELECT s FROM Services s WHERE s.url = :url"),
    @NamedQuery(name = "Services.findByRestMethod", query = "SELECT s FROM Services s WHERE s.restMethod = :restMethod"),
    @NamedQuery(name = "Services.findByInputParam", query = "SELECT s FROM Services s WHERE s.inputParam = :inputParam"),
    @NamedQuery(name = "Services.findByOutput", query = "SELECT s FROM Services s WHERE s.output = :output"),
    @NamedQuery(name = "Services.findByOutputFormat", query = "SELECT s FROM Services s WHERE s.outputFormat = :outputFormat"),
    @NamedQuery(name = "Services.findByExample", query = "SELECT s FROM Services s WHERE s.example = :example"),
    @NamedQuery(name = "Services.findByIdServiceNameEntity", query = "SELECT s FROM Services s WHERE s.idService = :idService OR " + "s.serviceName LIKE :term OR s.resource LIKE :term"),
    @NamedQuery(name = "Services.findByLastUpdDate", query = "SELECT s FROM Services s WHERE s.lastUpdDate = :lastUpdDate")})
public class Services implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_service")
    private Integer idService;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "resource")
    private String resource;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "service_name")
    private String serviceName;
    @Size(max = 200)
    @Column(name = "description")
    private String description;
    @Size(max = 200)
    @Column(name = "url")
    private String url;
    @Size(max = 10)
    @Column(name = "rest_method")
    private String restMethod;
    @Size(max = 150)
    @Column(name = "input_param")
    private String inputParam;
    @Size(max = 150)
    @Column(name = "output")
    private String output;
    @Size(max = 45)
    @Column(name = "output_format")
    private String outputFormat;
    @Size(max = 200)
    @Column(name = "example")
    private String example;
    @Column(name = "last_upd_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastUpdDate;

    public Services() {
    }

    public Services(Integer idService) {
        this.idService = idService;
    }

    public Services(Integer idService, String resource, String serviceName) {
        this.idService = idService;
        this.resource = resource;
        this.serviceName = serviceName;
    }

    public Integer getIdService() {
        return idService;
    }

    public void setIdService(Integer idService) {
        this.idService = idService;
    }

    public String getResource() {
        return resource;
    }

    public void setResource(String resource) {
        this.resource = resource;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getRestMethod() {
        return restMethod;
    }

    public void setRestMethod(String restMethod) {
        this.restMethod = restMethod;
    }

    public String getInputParam() {
        return inputParam;
    }

    public void setInputParam(String inputParam) {
        this.inputParam = inputParam;
    }

    public String getOutput() {
        return output;
    }

    public void setOutput(String output) {
        this.output = output;
    }

    public String getOutputFormat() {
        return outputFormat;
    }

    public void setOutputFormat(String outputFormat) {
        this.outputFormat = outputFormat;
    }

    public String getExample() {
        return example;
    }

    public void setExample(String example) {
        this.example = example;
    }

    public Date getLastUpdDate() {
        return lastUpdDate;
    }

    public void setLastUpdDate(Date lastUpdDate) {
        this.lastUpdDate = lastUpdDate;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idService != null ? idService.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Services)) {
            return false;
        }
        Services other = (Services) object;
        if ((this.idService == null && other.idService != null) || (this.idService != null && !this.idService.equals(other.idService))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Services[ idService=" + idService + " ]";
    }
    
}
