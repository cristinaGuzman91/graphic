/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package services;

import entities.CommDeviceTags;
import entities.Company;
import entities.Location;
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
@Path("entities.commdevicetags")
public class CommDeviceTagsFacadeREST extends AbstractFacade<CommDeviceTags> {
    @PersistenceContext(unitName = "factoryEcomation_ServicesPU")
    private EntityManager em;

    public CommDeviceTagsFacadeREST() {
        super(CommDeviceTags.class);
    }

    @POST
    @Override
    @Consumes({"application/xml", "application/json"})
    public void create(CommDeviceTags entity) {
        super.create(entity);
    }

    @PUT
    @Override
    @Consumes({"application/xml", "application/json"})
    public void edit(CommDeviceTags entity) {
        super.edit(entity);
    }
    
   /* @PUT
    @Path("{id}")
    @Consumes({"application/xml", "application/json"})
    public void edit(@PathParam("id") String id, CommDeviceTags entity) {
        super.edit(entity);
    }*/

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") String id) {
        super.remove(super.find(id));
    }

    @GET
    @Path("{id}")
    @Produces({"application/xml", "application/json"})
    public CommDeviceTags find(@PathParam("id") String id) {
        return super.find(id);
    }

    @GET
    @Override
    @Produces({"application/xml", "application/json"})
    public List<CommDeviceTags> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({"application/xml", "application/json"})
    public List<CommDeviceTags> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
        return super.findRange(new int[]{from, to});
    }

    @GET
    @Path("count")
    @Produces("text/plain")
    public String countREST() {
        return String.valueOf(super.count());
    }
    
    @GET
    @Path("/location/{id}")
    @Produces({"application/xml", "application/json"})
    public List<CommDeviceTags> findRange(@PathParam("id") Integer id) {
    Location location = getEntityManager().find(Location.class, id);    
    return super.getData( "CommDeviceTags.findByLocation", "idLocation", location);
        
    }


    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
}
