package hu.sport.util;

import com.sport.exceptions.InstanceExistException;
import com.sport.data.Championship;
import com.sport.data.Competition;
import com.sport.data.Race;
import com.sport.data.ResultType;
import com.sport.data.Series;
import com.sport.data.SportType;
import com.sport.memory.ChampionshipServiceImpl;
import com.sport.memory.CompetitionServiceImpl;
import com.sport.memory.CompetitorServicesImpl;
import com.sport.memory.RaceServicesImpl;
import com.sport.memory.SeasonServicesImpl;
import com.sport.memory.SeriesServicesImpl;
import com.sport.memory.SportTypeServicesImpl;
import com.sport.services.ChampionshipService;
import com.sport.services.CompetitionService;
import com.sport.services.CompetitorService;
import com.sport.services.RaceService;
import com.sport.services.SeasonService;
import com.sport.services.SeriesService;
import com.sport.services.SportFactoryService;
import com.sport.services.SportTypeService;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author krisztian
 */
public class MemoryFactory implements SportFactoryService{
    
    
    private final SportTypeService sportTypeService = new SportTypeServicesImpl();
    private final SeasonService seasonService = new SeasonServicesImpl();
    private final ChampionshipService championshipService = new ChampionshipServiceImpl();
    private final CompetitionService competitionService = new CompetitionServiceImpl();
    private final CompetitorService competitorService = new CompetitorServicesImpl();
    private final RaceService raceService = new RaceServicesImpl();
    private final SeriesService seriesService = new SeriesServicesImpl();
    

    public MemoryFactory() throws InstanceExistException {
    }
    
    

    @Override
    public SportTypeService getSportTypeDAO() {
        return sportTypeService;
    }

    @Override
    public SeasonService getSeasonDAO() {
        return seasonService;
    }

    @Override
    public ChampionshipService getChampionshipDAO() {
        return championshipService;
    }

    @Override
    public CompetitionService getCompetitionDAO() {
        return competitionService;
    }

    @Override
    public CompetitorService getCompetitorDAO() {
        return competitorService;
    }

    @Override
    public RaceService getRaceDAO() {
        return raceService;
    }

    @Override
    public SeriesService getSeriesDAO() {
        return seriesService;
    }

    @Override
    public void loadCache() {
        Championship tmp;
        Series series;
        SportType sport;
        try {
            seasonService.registerIfNotExist("2016", "...");
            seasonService.registerIfNotExist("2016/17", "...");

            sport = sportTypeService.registerIfNotExist("Labdarúgás", "...", ResultType.NUMBER);
                series = seriesService.createIfNotExist("Premier League", "...", sport);
                    tmp = championshipService.createIfNotExist("..", sport, seasonService.getAll().get(1),series);
                        tmp.getCompetitions().add(new Competition("1. forduló", "bajnoki forduló"));
                        tmp.getCompetitions().add(new Competition("2. forduló", "bajnoki forduló"));     
                        tmp.getCompetitions().add(new Competition("3. forduló", "bajnoki forduló"));     
                        tmp.getCompetitions().add(new Competition("4. forduló", "bajnoki forduló"));     
                        tmp.getCompetitions().add(new Competition("5. forduló", "bajnoki forduló"));     
                
                series = seriesService.createIfNotExist("Bundesliga", "...", sportTypeService.getAll().get(0));
                    tmp = championshipService.createIfNotExist("..", sportTypeService.getAll().get(0), seasonService.getAll().get(1),series);
                series = seriesService.createIfNotExist("La Liga", "...", sportTypeService.getAll().get(0));
                    tmp = championshipService.createIfNotExist("..", sportTypeService.getAll().get(0), seasonService.getAll().get(1),series);
                        
            sport = sportTypeService.registerIfNotExist("Úszás", "...", ResultType.TIME);            
            sport = sportTypeService.registerIfNotExist("Távolugrás", "...", ResultType.NUMBER);
            

            List<SportType> ost=new ArrayList<>();
            ost.add(sportTypeService.getAll().get(0));
            ost.add(sportTypeService.getAll().get(1));
            ost.add(sportTypeService.getAll().get(2));
                series = seriesService.createIfNotExist("Olimpia", "...", ost);
                    tmp = championshipService.createIfNotExist("férfi 50m gyors", "...", sportTypeService.getAll().get(1), seasonService.getAll().get(0), series);
                        tmp.getCompetitions().add(new Competition("Döntő", "Verseny"));
                            tmp.getCompetitions().get(0).getReces().add(new Race("döntő futam", ".."));
                        tmp.getCompetitions().add(new Competition("Elődöntő", "Verseny"));
                            tmp.getCompetitions().get(1).getReces().add(new Race("1 futam", ".."));
                            tmp.getCompetitions().get(1).getReces().add(new Race("2 futam", ".."));
                    tmp = championshipService.createIfNotExist("férfi 50m gyors", "...", sportTypeService.getAll().get(0), seasonService.getAll().get(0), series);
                        tmp.getCompetitions().add(new Competition("Csoport mérkőzések", "Verseny"));
                        tmp.getCompetitions().add(new Competition("Elődöntő", "Verseny"));
                        tmp.getCompetitions().add(new Competition("Döntő", "Verseny"));
            
            sport = sportTypeService.registerIfNotExist("Auto-Motor sport", "...", ResultType.TIME);
                series = seriesService.createIfNotExist("Világbajnokság", "...", sport);
                    tmp = championshipService.createIfNotExist("Formula 1 Világbajnokság", "..", sportTypeService.getAll().get(1), seasonService.getAll().get(0),seriesService.getAll().get(4));
                        tmp.getCompetitions().add(new Competition("Hungaroring", "GP"));
                            tmp.getCompetitions().get(0).getReces().add(new Race("Szabadedzés 1", "GP"));
                            tmp.getCompetitions().get(0).getReces().add(new Race("Szabadedzés 2", "GP"));
                            tmp.getCompetitions().get(0).getReces().add(new Race("Időmérő", "GP"));
                            tmp.getCompetitions().get(0).getReces().add(new Race("Futam", "GP"));
                        tmp.getCompetitions().add(new Competition("Spa", "GP"));
                        tmp.getCompetitions().add(new Competition("Monza", "GP"));


    
            
            
        } catch (InstanceExistException ex) {
            Logger.getLogger(MemoryFactory.class.getName()).log(Level.SEVERE, null, ex);
        }
         
    }

    
}
