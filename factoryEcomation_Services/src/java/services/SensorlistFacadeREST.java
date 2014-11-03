/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package services;


import entities.Sensorlist;


import Factories.SensorListFactory;
import Factories.SensorsFactory;
import entities.Company;
import entities.Sensor;
import entities.SensorCatalog;
import entities.SensorTags;
import java.util.List;
import java.util.ArrayList;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
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
 * @author cguzman
 */
@Stateless
@Path("entities.sensorlist")
public class SensorlistFacadeREST extends AbstractFacade<Sensorlist> {
    @PersistenceContext(unitName = "factoryEcomation_ServicesPU")
    @EJB SensorListFactory listSensor;
    private EntityManager em;
     private String nameQuery;

    public SensorlistFacadeREST() {
        super(Sensorlist.class);
    }

    @POST
    @Override
    @Consumes({"application/xml", "application/json"})
    public void create(Sensorlist entity) {
        super.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes({"application/xml", "application/json"})
    public void edit(@PathParam("id") Integer id, Sensorlist entity) {
        super.edit(entity);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") Integer id) {
        super.remove(super.find(id));
    }

    @GET
    @Path("{id}")
    @Produces({"application/xml", "application/json"})
    public Sensorlist find(@PathParam("id") Integer id) {
        return super.find(id);
    }

    @GET
    @Override
    @Produces({"application/xml", "application/json"})
    public List<Sensorlist> findAll() {
        return super.findAll();
    }
    
   /* Chavos*/
   @GET   
    @Path("/noreference")
    @Produces({"application/xml", "application/json"})
    public List<Sensorlist> getData() {
      List<Sensorlist> sensorList= listSensor.createSensorList();
     // console.log("return servicio == " + sensorList);
     return sensorList;
     }
    
    @GET
    @Path("{from}/{to}")
    @Produces({"application/xml", "application/json"})
    public List<Sensorlist> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
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
