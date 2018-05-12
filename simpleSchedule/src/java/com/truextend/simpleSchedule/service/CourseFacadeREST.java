package com.truextend.simpleSchedule.service;

import com.truextend.simpleSchedule.entity.Course;
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
import javax.ws.rs.core.MediaType;

/**
 *
 * @author jplc
 */
@Stateless
@Path("/course")
public class CourseFacadeREST extends AbstractFacade<Course> {

  @PersistenceContext(unitName = "simpleSchedulePU")
  private EntityManager em;

  public CourseFacadeREST() {
    super(Course.class);
  }

  @POST
  @Override
  @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
  public void create(Course entity) {
    super.create(entity);
  }

  @PUT
  @Path("{code}")
  @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
  public void edit(@PathParam("code") Long code, Course entity) {
    super.edit(entity);
  }

  @DELETE
  @Path("{code}")
  public void remove(@PathParam("code") Long code) {
    super.remove(super.find(code));
  }

  @GET
  @Path("{code}")
  @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
  public Course find(@PathParam("code") Long code) {
    return super.find(code);
  }

  @GET
  @Override
  @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
  public List<Course> findAll() {
    return super.findAll();
  }

  @GET
  @Path("{from}/{to}")
  @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
  public List<Course> findRange(@PathParam("from") Integer from, 
      @PathParam("to") Integer to) {
    return super.findRange(new int[]{from, to});
  }

  @GET
  @Path("count")
  @Produces(MediaType.TEXT_PLAIN)
  public String countREST() {
    return String.valueOf(super.count());
  }

  @Override
  protected EntityManager getEntityManager() {
    return em;
  }
  
}
