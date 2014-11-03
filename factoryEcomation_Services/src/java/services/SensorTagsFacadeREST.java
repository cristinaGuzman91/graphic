/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package services;

import entities.SensorTags;
import entities.SensorTagForm;
import dataBaseManagers.SensorTagFormBl;
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
 * @author cguzman
 */
@Stateless
@Path("entities.sensortags")
public class SensorTagsFacadeREST extends AbstractFacade<SensorTags> {
    
    @PersistenceContext(unitName = "factoryEcomation_ServicesPU")
    private EntityManager em;
    private @EJB SensorTagFormBl sensor;
    

    public SensorTagsFacadeREST() {
        super(SensorTags.class);
    }
    
    /**
     *
     * @param entity
     * @return 
     */
    @POST
    @Path("/create")
    @Consumes({"application/json"})
    @Produces({"application/json"})
    public Object create(SensorTagForm entity) {
        return sensor.save(entity);
        
    }

    /**
     *
     * @param id
     * @param entity
     * @return 
     */
    @PUT
    @Path("{id}")
    @Consumes({"application/json"})
    public Object edit(@PathParam("id") String id, SensorTagForm entity) {
        return sensor.edit(entity, id);
    }
/*
    @PUT
    @Path("{id}")
    @Consumes({"application/json"})
    public Object edit(@PathParam("id") String id, SensorTagForm entity) {
        return sensor.edit(entity, id);
    }

    @POST
    @Override
    @Consumes({"application/xml", "application/json"})
    public void create(SensorTags entity) {
        super.create(entity);
    }*/

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") String id) {
        super.remove(super.find(id));
    }

    @GET
    @Path("{id}")
    @Produces({"application/xml", "application/json"})
    public SensorTags find(@PathParam("id") String id) {
        return super.find(id);
    }
    
    @GET
    @Override
    @Produces({"application/xml", "application/json"})
    public List<SensorTags> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({"application/xml", "application/json"})
    public List<SensorTags> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
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
    
    /*@PUT
    @Path(value = "{id}")
    @Consumes(value = {"application/xml", "application/json"})
    @Asynchronous
    public void edit(@Suspended final AsyncResponse asyncResponse, @PathParam(value = "id") final String id, final SensorTagForm entity) {
        asyncResponse.resume(doEdit(id, entity));
    }*/

    private Object doEdit(@PathParam("id") String id, SensorTagForm entity) {
        return sensor.edit(entity, id);
    }
    
}
