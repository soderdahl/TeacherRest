package services;

import databaslagring.TeacherDao;
import entity.Teacher;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Stateless
@Path("s")
public class DaoRest {

    @Inject
    TeacherDao td;

    public DaoRest() {
    }

    @POST
    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public void createTeacher(Teacher t) {

        td.add(t);

    }

    @GET
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Teacher> getAllTeachers() {

        return td.findAll();

    }

    @DELETE
    @Path("/{id}")
    public void removeTeacher(@PathParam("id") Integer id) {
        td.delete(id);

    }

    @PUT
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Path("/{id}")
    public void edit(@PathParam("id") Integer id, Teacher t) {

        td.editTeacher(t);

    }

    @GET
    @Path("/{id}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Teacher findById(@PathParam("id") int id) {

        return td.findById(id);
    }
}
