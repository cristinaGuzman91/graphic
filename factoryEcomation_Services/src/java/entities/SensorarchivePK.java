/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author cguzman
 */
@Embeddable
public class SensorarchivePK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "slId")
    private int slId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "saTimestamp")
    private long saTimestamp;

    public SensorarchivePK() {
    }

    public SensorarchivePK(int slId, long saTimestamp) {
        this.slId = slId;
        this.saTimestamp = saTimestamp;
    }

    public int getSlId() {
        return slId;
    }

    public void setSlId(int slId) {
        this.slId = slId;
    }

    public long getSaTimestamp() {
        return saTimestamp;
    }

    public void setSaTimestamp(long saTimestamp) {
        this.saTimestamp = saTimestamp;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) slId;
        hash += (int) saTimestamp;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SensorarchivePK)) {
            return false;
        }
        SensorarchivePK other = (SensorarchivePK) object;
        if (this.slId != other.slId) {
            return false;
        }
        if (this.saTimestamp != other.saTimestamp) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.SensorarchivePK[ slId=" + slId + ", saTimestamp=" + saTimestamp + " ]";
    }
    
}
