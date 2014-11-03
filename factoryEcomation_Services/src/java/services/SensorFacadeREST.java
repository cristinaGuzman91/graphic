/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package services;

import Factories.SensorsFactory;
import entities.Sensor;
import entities.SensorType;
import entities.Sensorlist;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

/**
 *
 * @author ccastillo
 */
@Stateless
@Path("sensors")
public class SensorFacadeREST extends AbstractFacade<Sensor> {
    @PersistenceContext(unitName = "factoryEcomation_ServicesPU")
    @EJB SensorsFactory sensor;
    private EntityManager em;

    public SensorFacadeREST() {
        super(Sensor.class);
    }

    @POST
    @Override
    @Consumes({"application/xml", "application/json"})
    public void create(Sensor entity) {
        super.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes({"application/xml", "application/json"})
    public void edit(@PathParam("id") Long id, Sensor entity) {
        super.edit(entity);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") Long id) {
        super.remove(super.find(id));
    }

    @GET
    @Path("{id}")
    @Produces({"application/xml", "application/json"})
    public Sensor find(@PathParam("id") Long id) {
        return super.find(id);
    }
    
  
    
    
    @GET
    @Produces({"application/xml", "application/json"})
    public List<Sensor> listaSensores() {
        return  sensor.createSensors();
    }


    @GET
    @Path("{from}/{to}")
    @Produces({"application/xml", "application/json"})
    public List<Sensor> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
        return super.findRange(new int[]{from, to});
    }

    @GET
    @Path("count")
    @Produces("text/plain")
    public String countREST() {
        return String.valueOf(super.count());
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
}
