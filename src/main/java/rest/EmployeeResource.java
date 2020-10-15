/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest;

import com.google.gson.Gson;
import facades.EmployeeFacade;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author jenso
 */
@Path("employee")
public class EmployeeResource {

    
    
    private static final EntityManagerFactory EMF = Persistence.createEntityManagerFactory("pu"); 
    private static final EmployeeFacade FACADE =  EmployeeFacade.getEmployeeFacade(EMF);
    /**
     * Creates a new instance of EmployeeResource
     */
    public EmployeeResource() {
    }

    /**
     * Retrieves representation of an instance of rest.EmployeeResource
     * @param id
     * @return an instance of java.lang.String
     */
    @GET
    @Path("employee/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public String getEmployeeByID(@PathParam("id") int id){
        EntityManager em = EMF.createEntityManager();
        try {
            return new Gson().toJson(FACADE.getEmployeeByID(id)); 
        } finally {
            em.close();
        }
    }

    /**
     *
     * @param name
     * @return
     */
    @GET
    @Path("employee/name/{name}")
    @Produces(MediaType.APPLICATION_JSON)
    public String getEmployeeByID(@PathParam("name") String name){
        EntityManager em = EMF.createEntityManager();
        try {
            return new Gson().toJson(FACADE.getEmployeesByName(name)); 
        } finally {
            em.close();
        }
    }
    @GET
    @Path("employee/all")
    @Produces(MediaType.APPLICATION_JSON)
    public String getEmployeeAll(){
        EntityManager em = EMF.createEntityManager();
        try {
            return new Gson().toJson(FACADE.getAllEmployees());
        } finally {
            em.close();
        }
    }
    @GET
    @Path("employee/highestpaid")
    @Produces(MediaType.APPLICATION_JSON)
    public String getHighestPaid(){
        EntityManager em = EMF.createEntityManager();
        try{
            return new Gson().toJson(FACADE.getEmployeesByHighestSalary());
        }finally{
            em.close();
        }
    }
}
