/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.ulyssys.rest;

import com.sport.data.Season;
import com.sport.util.AbstractFactory;
import hu.ulyssys.webui.Constants;
import java.util.List;
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
public class SeasonService {

    @Context
    private UriInfo context;
    
    @Context
    private ServletContext servletContext;
    
    /**
     * Creates a new instance of SeasonResource
     */
    public SeasonService() {}

    /**
     * Retrieves representation of an instance of hu.ulyssys.rest.SeasonResource
     * @return an instance of java.lang.String
     */
    @GET
    @Path("all")
    @Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
    public List<Season> getAll() {
        AbstractFactory dataModellHandler = (AbstractFactory) servletContext.getAttribute(Constants.APPLICATION_DATA_MODELL);
        return dataModellHandler.getSeasonDAO().getAll();
    }

    @GET 
    @Path("/{id}") 
    @Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
    public Season getCountryById(@PathParam("id") int id) { 
        AbstractFactory dataModellHandler = (AbstractFactory) servletContext.getAttribute(Constants.APPLICATION_DATA_MODELL);
        return dataModellHandler.getSeasonDAO().getAll().get(id);
    }

}
