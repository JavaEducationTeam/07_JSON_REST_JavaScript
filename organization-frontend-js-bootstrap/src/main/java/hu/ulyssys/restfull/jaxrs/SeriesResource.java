package hu.ulyssys.restfull.jaxrs;

import com.sport.data.Season;
import com.sport.data.Series;
import com.sport.data.SportType;
import com.sport.exceptions.InstanceNotExistException;
import com.sport.services.SportFactoryService;

import hu.ulyssys.webui.Constants;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
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
@Path("series")
public class SeriesResource {

    @Context
    private UriInfo context;
    @Context
    private ServletContext servletContext;


    /**
     * Creates a new instance of SeriesResource
     */
    public SeriesResource() {}
    @GET
    @Path("all")
    @Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
    public ArrayList<Series> getAll() {
        SportFactoryService dataModellHandler = (SportFactoryService) servletContext.getAttribute(Constants.APPLICATION_DATA_MODELL);
        return (ArrayList<Series>)dataModellHandler.getSeriesDAO().getAll();
    }

    @GET 
    @Path("{id}") 
    @Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
    public Series getSeriesById(@PathParam("id") int id) { 
        SportFactoryService dataModellHandler = (SportFactoryService) servletContext.getAttribute(Constants.APPLICATION_DATA_MODELL);
        return dataModellHandler.getSeriesDAO().getAll().get(id);
    }
    
    @GET 
    @Path("{sportid}/{seasonid}") 
    @Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
    public List<Series> getSeriesOfSportAndSeason(@PathParam("sportid") int sportId, @PathParam("seasonid") int seasonId) throws InstanceNotExistException { 
        SportFactoryService dataModellHandler = (SportFactoryService) servletContext.getAttribute(Constants.APPLICATION_DATA_MODELL);
        SportType sportType = dataModellHandler.getSportTypeDAO().getAll().get(sportId);
        Season season = dataModellHandler.getSeasonDAO().getAll().get(seasonId);
        return (ArrayList<Series>)dataModellHandler.getSeriesDAO().getOfSportTypeAndSeason(sportType, season);
    }

    @GET 
    @Path("sport/{sportid}") 
    @Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
    public List<Series> getSeriesOfSport(@PathParam("sportid") int sportId) throws InstanceNotExistException { 
        SportFactoryService dataModellHandler = (SportFactoryService) servletContext.getAttribute(Constants.APPLICATION_DATA_MODELL);
        SportType sportType = dataModellHandler.getSportTypeDAO().getAll().get(sportId);
        return (ArrayList<Series>)dataModellHandler.getSeriesDAO().getOfSportType(sportType);
    }
}
