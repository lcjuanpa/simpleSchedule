package com.truextend.simpleSchedule.service;

import com.truextend.simpleSchedule.entity.Student;
import java.util.List;
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
import javax.ws.rs.core.MediaType;

/**
 *
 * @author jplc
 */
@Stateless
@Path("/student")
public class StudentFacadeREST extends AbstractFacade<Student> {

  @PersistenceContext(unitName = "simpleSchedulePU")
  private EntityManager em;

  public StudentFacadeREST() {
    super(Student.class);
  }

  @POST
  @Override
  @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
  public void create(Student entity) {
    super.create(entity);
  }

  @PUT
  @Path("{id}")
  @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
  public void edit(@PathParam("id") Long id, Student entity) {
    super.edit(entity);
  }

  @DELETE
  @Path("{id}")
  public void remove(@PathParam("id") Long id) {
    super.remove(super.find(id));
  }

  @GET
  @Path("{id}")
  @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
  public Student find(@PathParam("id") Long id) {
    return super.find(id);
  }

  @GET
  @Override
  @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
  public List<Student> findAll() {
    return super.findAll();
  }
  
  @GET
  @Path("/lastname/{lastname}")
  @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
  public Student findByLastname(@PathParam("lastname") String lastname) {
    return super.findBy("Student.findByLastname", "lastname", lastname);
//    return (Student) getEntityManager()
//        .createNamedQuery("Student.findByLastname")
//        .setParameter("lastname", lastname)
//        .getSingleResult();
  }

  @GET
  @Path("{from}/{to}")
  @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
  public List<Student> findRange(@PathParam("from") Integer from, 
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
