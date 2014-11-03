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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author cguzman
 */
@Entity
@Table(name = "sensorlist")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Sensorlist.findAll", query = "SELECT s FROM Sensorlist s"),
    @NamedQuery(name = "Sensorlist.findBySlId", query = "SELECT s FROM Sensorlist s WHERE s.slId = :slId"),
    @NamedQuery(name = "Sensorlist.findBySlName1", query = "SELECT s FROM Sensorlist s WHERE s.slName1 = :slName1"),
    @NamedQuery(name = "Sensorlist.findBySlName2", query = "SELECT s FROM Sensorlist s WHERE s.slName2 = :slName2"),
    @NamedQuery(name = "Sensorlist.findBySlName3", query = "SELECT s FROM Sensorlist s WHERE s.slName3 = :slName3"),
    @NamedQuery(name = "Sensorlist.findBySlInsertTimestamp", query = "SELECT s FROM Sensorlist s WHERE s.slInsertTimestamp = :slInsertTimestamp"),
    @NamedQuery(name = "Sensorlist.findBySlActualTimestamp", query = "SELECT s FROM Sensorlist s WHERE s.slActualTimestamp = :slActualTimestamp"),
    @NamedQuery(name = "Sensorlist.findBySlGMTOffset", query = "SELECT s FROM Sensorlist s WHERE s.slGMTOffset = :slGMTOffset"),
    @NamedQuery(name = "Sensorlist.findBySlActualValue", query = "SELECT s FROM Sensorlist s WHERE s.slActualValue = :slActualValue")})
public class Sensorlist implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "slId")
    private Integer slId;
    @Size(max = 255)
    @Column(name = "slName1")
    private String slName1;
    @Size(max = 255)
    @Column(name = "slName2")
    private String slName2;
    @Size(max = 255)
    @Column(name = "slName3")
    private String slName3;
    @Column(name = "slInsertTimestamp")
    @Temporal(TemporalType.TIMESTAMP)
    private Date slInsertTimestamp;
    @Column(name = "slActualTimestamp")
    private Long slActualTimestamp;
    @Column(name = "slGMTOffset")
    private Integer slGMTOffset;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "slActualValue")
    private Double slActualValue;
    @JoinColumn(name = "stId", referencedColumnName = "stId")
    @ManyToOne
    private Status stId;

    public Sensorlist() {
    }

    public Sensorlist(Integer slId) {
        this.slId = slId;
    }

    public Integer getSlId() {
        return slId;
    }

    public void setSlId(Integer slId) {
        this.slId = slId;
    }

    public String getSlName1() {
        return slName1;
    }

    public void setSlName1(String slName1) {
        this.slName1 = slName1;
    }

    public String getSlName2() {
        return slName2;
    }

    public void setSlName2(String slName2) {
        this.slName2 = slName2;
    }

    public String getSlName3() {
        return slName3;
    }

    public void setSlName3(String slName3) {
        this.slName3 = slName3;
    }

    public Date getSlInsertTimestamp() {
        return slInsertTimestamp;
    }

    public void setSlInsertTimestamp(Date slInsertTimestamp) {
        this.slInsertTimestamp = slInsertTimestamp;
    }

    public Long getSlActualTimestamp() {
        return slActualTimestamp;
    }

    public void setSlActualTimestamp(Long slActualTimestamp) {
        this.slActualTimestamp = slActualTimestamp;
    }

    public Integer getSlGMTOffset() {
        return slGMTOffset;
    }

    public void setSlGMTOffset(Integer slGMTOffset) {
        this.slGMTOffset = slGMTOffset;
    }

    public Double getSlActualValue() {
        return slActualValue;
    }

    public void setSlActualValue(Double slActualValue) {
        this.slActualValue = slActualValue;
    }

    public Status getStId() {
        return stId;
    }

    public void setStId(Status stId) {
        this.stId = stId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (slId != null ? slId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Sensorlist)) {
            return false;
        }
        Sensorlist other = (Sensorlist) object;
        if ((this.slId == null && other.slId != null) || (this.slId != null && !this.slId.equals(other.slId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Sensorlist[ slId=" + slId + " ]";
    }
    
}
