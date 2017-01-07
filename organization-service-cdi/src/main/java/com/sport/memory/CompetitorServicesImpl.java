package com.sport.memory;

import com.sport.data.Competitor;
import com.sport.data.CompetitorSingle;
import com.sport.data.CompetitorTeam;
import com.sport.services.CompetitorService;

/**
 * @author krisztian
 */
public class CompetitorServicesImpl implements CompetitorService {
    
    
    public Competitor competitorFactory(CompetitorEnum pType){
        Competitor res;
        switch (pType){
            case TEAM: 
                res = new CompetitorTeam();
                break;
            /*case SINGLE:
                res = new CompetitorSingle();
                break; */
            default:
                res = new CompetitorSingle();
        }
        return res;
    }
    
}
