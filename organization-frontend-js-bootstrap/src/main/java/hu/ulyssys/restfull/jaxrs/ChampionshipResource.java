package hu.ulyssys.restfull.jaxrs;

import com.sport.data.Championship;
import com.sport.data.Season;
import com.sport.data.Series;
import com.sport.data.SportType;
import com.sport.exceptions.InstanceExistException;
import com.sport.exceptions.InstanceNotExistException;
import com.sport.services.ChampionshipService;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * @author krisztian
 */

@Path("/championship")
public class ChampionshipResource {

   @Inject
    private ChampionshipService service;
    
    @GET
    @Path("getall")
    @Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
    public List<Championship> getAll() {
        return service.getAll();
    }
/*
    public Championship createIfNotExist(String name, String description, SportType sportype, Season season, Series series) throws InstanceExistException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Championship createIfNotExist(String description, SportType sportype, Season season, Series series) throws InstanceExistException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
*/
    public Championship getByName(String name) throws NullPointerException, InstanceNotExistException {
        return service.getByName(name);
    }
    
}
