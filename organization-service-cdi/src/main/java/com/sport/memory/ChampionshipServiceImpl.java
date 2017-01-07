/*
 */
package com.sport.memory;

import com.sport.exceptions.InstanceExistException;
import com.sport.exceptions.InstanceNotExistException;
import com.sport.data.Championship;
import com.sport.data.Season;
import com.sport.data.Series;
import com.sport.data.SportType;
import com.sport.services.ChampionshipService;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import javax.enterprise.context.Dependent;
import javax.enterprise.inject.Default;


/**
 * @author krisztian
 */

@Dependent


public class ChampionshipServiceImpl implements ChampionshipService {
    private static final Logger LOGG = Logger.getLogger(ChampionshipServiceImpl.class.getName());
    private static final List<Championship> CHAMPIONSHIP = new ArrayList<>();
    
    
    
    @Override
    public  List<Championship> getAll() {
        return CHAMPIONSHIP;
    }
   

    @Override
    public Championship createIfNotExist(String name, String description, SportType sportype,Season season,Series series) throws InstanceExistException{    
        Championship tmp = new Championship(name, description);
        tmp.setSportype(sportype);
        tmp.setSeason(season);
        CHAMPIONSHIP.add(tmp);
        if(series.getChampionships().get(season)==null)
            series.getChampionships().put(season,new ArrayList<Championship>());
        series.getChampionships().get(season).add(tmp);
        return tmp;
    }

    @Override
    public Championship createIfNotExist(String description, SportType sportype,Season season,Series series) throws InstanceExistException{    
        Championship tmp = new Championship(series.getName()+" "+season.getName() +"("+sportype.getName()+")", description);
        tmp.setSportype(sportype);
        tmp.setSeason(season);
        CHAMPIONSHIP.add(tmp);
        if(series.getChampionships().get(season)==null)
            series.getChampionships().put(season,new ArrayList<Championship>());
        series.getChampionships().get(season).add(tmp);
        return tmp;
    }
    
    
    @Override
    public Championship getByName(String name) throws NullPointerException,InstanceNotExistException{
        for(Championship tmp:CHAMPIONSHIP){
            if(tmp.getName().equals(name))
                return tmp;
        }
        throw new InstanceNotExistException(name);
    }
    
    
}
