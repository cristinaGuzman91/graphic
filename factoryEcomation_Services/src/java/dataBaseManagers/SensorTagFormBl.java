/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dataBaseManagers;
import entities.SensorTags;
import entities.SensorTagForm;
import java.util.Date;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


/**
 *
 * @author usuario
 */
@Stateless
public class SensorTagFormBl {
    @PersistenceContext
    private EntityManager em;
    private SensorTagForm sensor;
    private SensorTags s;
    
    public SensorTagFormBl(){
    
    }
    
    public Object save(SensorTagForm sensor){
        this.s = new SensorTags();
        this.s = getSensor(sensor);
         try {
            em.persist(this.s);
         } catch (Exception e) {
            e.printStackTrace();
         }        
        return this.s;
    }
    public Object delete(String SlId){
        String query="SELECT s.sensor_tag,s.id_sensor_catalog,s.comm_device_tag,s.max_value,s.min_value,s.id_measurement_unit,s.slId,s.active,s.insert_date,s.last_update_date" +
        "FROM sensor_tags s,sensorlist l where l.slId = "+ SlId;
        List resultList = em.createNativeQuery(query, entities.SensorTags.class).getResultList();
        return resultList.get(0);
    }
    public Object edit(SensorTagForm sensor,String id){
        this.s = getSensor(sensor);
        SensorTags oldSensor = em.find(entities.SensorTags.class, id);
        oldSensor.fillAll(this.s);
         try {
            em.persist(oldSensor);
         } catch (Exception e) {
            e.printStackTrace();
         }    
        return oldSensor;
    }
    
    public SensorTags getSensor(SensorTagForm sensor){
        this.s = new SensorTags();
        s.setActive(true);
        s.setCommDeviceTag(em.find(entities.CommDeviceTags.class, sensor.getCommDeviceTag()));
        s.setIdMeasurementUnit(em.find(entities.MeasurementUnits.class, sensor.getIdMeasurementUnit()));
        s.setIdSensorCatalog(em.find(entities.SensorCatalog.class, sensor.getIdSensorCatalog()));
        s.setInsertDate(new Date());
        s.setLastUpdateDate(new Date());
        s.setMaxValue(sensor.getMaxValue());
        s.setMinValue(sensor.getMinValue());
        s.setSlId(em.find(entities.Sensorlist.class, sensor.getSlId()));
        s.setSensorTag(sensor.getSensorTag());
        s.setSensorTagsLogCollection(null);
        return s;
    }

  
    
    
}
