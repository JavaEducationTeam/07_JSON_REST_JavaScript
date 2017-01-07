/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.ulyssys.restfull.jaxrs;

import com.sport.data.Season;
import com.sport.services.SportFactoryService;
import hu.ulyssys.webui.Constants;
import java.util.ArrayList;
import javax.servlet.ServletContext;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author krisztian
 */
@Path("/season")
public class SeasonResource {

    @Context
    private UriInfo context;
    
    @Context
    private ServletContext servletContext;
    
    /**
     * Creates a new instance of SeasonResource
     */
    public SeasonResource() {}

    /**
     * Retrieves representation of an instance of hu.ulyssys.rest.SeasonResource
     * @return an instance of java.lang.String
     */
    @GET
    @Path("all")
    @Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
    public ArrayList<Season> getAll() {
        SportFactoryService dataModellHandler = (SportFactoryService) servletContext.getAttribute(Constants.APPLICATION_DATA_MODELL);
        return (ArrayList<Season>)dataModellHandler.getSeasonDAO().getAll();
    }

    @GET 
    @Path("/{id}") 
    @Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
    public Season getCountryById(@PathParam("id") int id) { 
        SportFactoryService dataModellHandler = (SportFactoryService) servletContext.getAttribute(Constants.APPLICATION_DATA_MODELL);
        return dataModellHandler.getSeasonDAO().getAll().get(id);
    }

}
