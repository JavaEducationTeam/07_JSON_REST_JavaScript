package com.sport.services;


/**
 * @author krisztian
 */
public interface SportFactoryService {
    public SportTypeService getSportTypeDAO();
    public SeasonService getSeasonDAO();
    public ChampionshipService getChampionshipDAO();
    public CompetitionService getCompetitionDAO();
    public CompetitorService getCompetitorDAO();
    public RaceService getRaceDAO();
    public SeriesService getSeriesDAO();
    
    public void loadCache();
    
}
