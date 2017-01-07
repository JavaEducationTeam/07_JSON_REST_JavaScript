/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.ulyssys.restfull.jaxrs;

import com.sport.data.SportType;
import com.sport.util.FactoryProducer;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author krisztian
 */
@Path("/sports")
public class SportTypeResource {

    @Context
    private UriInfo uriContext;
    @Context
    private ServletContext servletContext;

    @Context 
    private HttpServletRequest requestContext;
    
    public SportTypeResource() {}

    /**
     * Retrieves representation of an instance of hu.ulyssys.tld.SportsResource
     * @return an instance of java.lang.String
     */
    @GET
    @Path("all")
    @Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
    public List<SportType> getAll() {
        return FactoryProducer.getInstance().getSportTypeDAO().getAll();
    }

    @GET 
    @Path("/{id}") 
    @Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
    public SportType getCountryById(@PathParam("id") int id) { 
        return FactoryProducer.getInstance().getSportTypeDAO().getAll().get(id); 
    }

/*    
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public SportType addCountry(SportType country) {}

    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    public SportType updateCountry(SportType country) {}

    @DELETE
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public void deleteCountry(@PathParam("id") int id) {}
 */   
}
