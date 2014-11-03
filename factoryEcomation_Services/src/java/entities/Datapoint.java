/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entities;

/*
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;*/


import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;


/**
 *
 * @author cguzman
 */
@Entity
public class Datapoint implements InterfaceDataPoint{
/*@Table(name = "DATAPOINT")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Datapoint.findAll", query = "SELECT d FROM Datapoint d"),
    @NamedQuery(name = "Datapoint.findByDatapointId", query = "SELECT d FROM Datapoint d WHERE d.datapointId = :datapointId"),
    @NamedQuery(name = "Datapoint.findByOutputId", query = "SELECT d FROM Datapoint d WHERE d.outputId = :outputId"),
    @NamedQuery(name = "Datapoint.findByTime", query = "SELECT d FROM Datapoint d WHERE d.time = :time"),
    @NamedQuery(name = "Datapoint.findByValue", query = "SELECT d FROM Datapoint d WHERE d.value = :value")})
public class Datapoint implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "DATAPOINT_ID")
    private Integer datapointId;
    @Column(name = "OUTPUT_ID")
    private Integer outputId;
    @Column(name = "TIME")
    @Temporal(TemporalType.DATE)
    private Date time;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "VALUE")
    private Double value;
    @JoinColumn(name = "sensorList_id_slid", referencedColumnName = "slid")
    @ManyToOne
    private Sensorlist sensorIdSlid;

    public Datapoint() {
    }

    public Datapoint(Integer datapointId) {
        this.datapointId = datapointId;
    }

    public Integer getDatapointId() {
        return datapointId;
    }

    public void setDatapointId(Integer datapointId) {
        this.datapointId = datapointId;
    }

    public Integer getOutputId() {
        return outputId;
    }

    public void setOutputId(Integer outputId) {
        this.outputId = outputId;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public Sensorlist getSensorIdSlid() {
        return sensorIdSlid;
    }

    public void setSensorIdSlid(Sensorlist sensorIdSlid) {
        this.sensorIdSlid = sensorIdSlid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (datapointId != null ? datapointId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Datapoint)) {
            return false;
        }
        Datapoint other = (Datapoint) object;
        if ((this.datapointId == null && other.datapointId != null) || (this.datapointId != null && !this.datapointId.equals(other.datapointId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Datapoint[ datapointId=" + datapointId + " ]";
    }*/
    @Id 
    private int dataPoint_id;
    
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date time;
    private Double value;
    @ManyToOne
    private Sensor slId;
    private int output_id;

    
    public void setId(int id){
        this.dataPoint_id=id;
    }

    
    public int get(){
        return this.dataPoint_id;
    }

    @Override
    public void setDate(Date date) {
        this.time=date;
    }

  
    @Override
    public Date getDate() {
        return this.time;
    }

    @Override
    public void setValue(double value) {
        this.value=value;
    }

    @Override
    public double getValue() {
        return this.value;
    }
    
    
    public void setOutputId(int output_id) {
        this.output_id=output_id;
    }

   
    public int getOutputId() {
        return this.output_id;
    }
    
    
}
