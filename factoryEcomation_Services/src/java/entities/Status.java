/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entities;

import java.io.Serializable;
import java.util.Collection;
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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author cguzman
 */
@Entity
@Table(name = "status")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Status.findAll", query = "SELECT s FROM Status s"),
    @NamedQuery(name = "Status.findByStId", query = "SELECT s FROM Status s WHERE s.stId = :stId"),
    @NamedQuery(name = "Status.findByStText", query = "SELECT s FROM Status s WHERE s.stText = :stText")})
public class Status implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "stId")
    private Integer stId;
    @Size(max = 255)
    @Column(name = "stText")
    private String stText;
    @OneToMany(mappedBy = "stId")
    private Collection<Sensorlist> sensorlistCollection;
    @OneToMany(mappedBy = "stId")
    private Collection<Sensorarchive> sensorarchiveCollection;

    public Status() {
    }

    public Status(Integer stId) {
        this.stId = stId;
    }

    public Integer getStId() {
        return stId;
    }

    public void setStId(Integer stId) {
        this.stId = stId;
    }

    public String getStText() {
        return stText;
    }

    public void setStText(String stText) {
        this.stText = stText;
    }

    @XmlTransient
    public Collection<Sensorlist> getSensorlistCollection() {
        return sensorlistCollection;
    }

    public void setSensorlistCollection(Collection<Sensorlist> sensorlistCollection) {
        this.sensorlistCollection = sensorlistCollection;
    }

    @XmlTransient
    public Collection<Sensorarchive> getSensorarchiveCollection() {
        return sensorarchiveCollection;
    }

    public void setSensorarchiveCollection(Collection<Sensorarchive> sensorarchiveCollection) {
        this.sensorarchiveCollection = sensorarchiveCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (stId != null ? stId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Status)) {
            return false;
        }
        Status other = (Status) object;
        if ((this.stId == null && other.stId != null) || (this.stId != null && !this.stId.equals(other.stId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Status[ stId=" + stId + " ]";
    }
    
}
