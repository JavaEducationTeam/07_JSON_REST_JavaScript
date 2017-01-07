package com.sport.util;

import com.sport.services.SportFactoryService;
import hu.sport.util.MemoryFactory;




/**
 * @author krisztian
 */
public class FactoryProducer {
    
    private static SportFactoryService instance = null;
    
    public static SportFactoryService createFactory(DataHandlerTypes type){
        switch(type){
            case STATIC_MEMORY :
                try{
                instance = new MemoryFactory();
                instance.loadCache();
                System.out.println(".......cache loaded..................");
                }
                catch(Exception e){e.printStackTrace();}
                break;
        }
        return instance;
    }

    public static SportFactoryService getInstance() {
        return instance;
    }
    
    
}
