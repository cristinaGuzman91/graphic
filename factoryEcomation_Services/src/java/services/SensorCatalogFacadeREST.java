/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package services;

import entities.Company;
import entities.SensorType;
import entities.SensorCatalog;
import java.util.List;
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
 * @author cguzman
 */
@Stateless
@Path("entities.sensorcatalog")
public class SensorCatalogFacadeREST extends AbstractFacade<SensorCatalog> {
    @PersistenceContext(unitName = "factoryEcomation_ServicesPU")
    private EntityManager em;

    public SensorCatalogFacadeREST() {
        super(SensorCatalog.class);
    }

    @POST
    @Override
    @Consumes({"application/xml", "application/json"})
    public void create(SensorCatalog entity) {
        super.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes({"application/xml", "application/json"})
    public void edit(@PathParam("id") Integer id, SensorCatalog entity) {
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
    public SensorCatalog find(@PathParam("id") Integer id) {
        return super.find(id);
    }

    @GET
    @Override
    @Produces({"application/xml", "application/json"})
    public List<SensorCatalog> findAll() {
        return super.findAll();
    }
    
    @GET
    @Path("/company/{id}")
    @Produces({"application/xml", "application/json"})
    public List<SensorCatalog> getData(@PathParam("id") Integer id) {
    Company company = getEntityManager().find(Company.class, id);    
     return super.getData( "SensorCatalog.findByCompany", "idCompany", company);
        
    }
    
    @GET
    @Path("/company/{idCompany}/sensorType/{idSensor}")
    @Produces({"application/xml", "application/json"})
    public List<SensorCatalog> getData(@PathParam("idCompany") Integer idCompany, @PathParam("idSensor") Integer idSensor) {
    Company company = getEntityManager().find(Company.class, idCompany);    
    SensorType sensorType = getEntityManager().find(SensorType.class, idSensor);
    return super.getData( "SensorCatalog.findByCompanySensorType", "idCompany", company, "idSensorType", sensorType);
        
    }
    
    @GET
    @Path("{from}/{to}")
    @Produces({"application/xml", "application/json"})
    public List<SensorCatalog> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
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
