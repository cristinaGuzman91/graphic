/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entities;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author cguzman
 */
@Entity
@Table(name = "sensorarchive")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Sensorarchive.findAll", query = "SELECT s FROM Sensorarchive s"),
    @NamedQuery(name = "Sensorarchive.findBySlId", query = "SELECT s FROM Sensorarchive s WHERE s.sensorarchivePK.slId = :slId"),
    @NamedQuery(name = "Sensorarchive.findBySaTimestamp", query = "SELECT s FROM Sensorarchive s WHERE s.sensorarchivePK.saTimestamp = :saTimestamp"),
    @NamedQuery(name = "Sensorarchive.findBySaGMTOffset", query = "SELECT s FROM Sensorarchive s WHERE s.saGMTOffset = :saGMTOffset"),
    @NamedQuery(name = "Sensorarchive.findBySaValue", query = "SELECT s FROM Sensorarchive s WHERE s.saValue = :saValue")})
public class Sensorarchive implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected SensorarchivePK sensorarchivePK;
    @Column(name = "saGMTOffset")
    private Integer saGMTOffset;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "saValue")
    private Double saValue;
    @JoinColumn(name = "stId", referencedColumnName = "stId")
    @ManyToOne
    private Status stId;
    @JoinColumn(name = "slId", referencedColumnName = "slId", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Sensorlist sensorlist;

    public Sensorarchive() {
    }

    public Sensorarchive(SensorarchivePK sensorarchivePK) {
        this.sensorarchivePK = sensorarchivePK;
    }

    public Sensorarchive(int slId, long saTimestamp) {
        this.sensorarchivePK = new SensorarchivePK(slId, saTimestamp);
    }

    public SensorarchivePK getSensorarchivePK() {
        return sensorarchivePK;
    }

    public void setSensorarchivePK(SensorarchivePK sensorarchivePK) {
        this.sensorarchivePK = sensorarchivePK;
    }

    public Integer getSaGMTOffset() {
        return saGMTOffset;
    }

    public void setSaGMTOffset(Integer saGMTOffset) {
        this.saGMTOffset = saGMTOffset;
    }

    public Double getSaValue() {
        return saValue;
    }

    public void setSaValue(Double saValue) {
        this.saValue = saValue;
    }

    public Status getStId() {
        return stId;
    }

    public void setStId(Status stId) {
        this.stId = stId;
    }

    public Sensorlist getSensorlist() {
        return sensorlist;
    }

    public void setSensorlist(Sensorlist sensorlist) {
        this.sensorlist = sensorlist;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (sensorarchivePK != null ? sensorarchivePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Sensorarchive)) {
            return false;
        }
        Sensorarchive other = (Sensorarchive) object;
        if ((this.sensorarchivePK == null && other.sensorarchivePK != null) || (this.sensorarchivePK != null && !this.sensorarchivePK.equals(other.sensorarchivePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Sensorarchive[ sensorarchivePK=" + sensorarchivePK + " ]";
    }
    
}
