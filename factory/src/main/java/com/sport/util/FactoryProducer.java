package com.sport.util;

import hu.sport.util.MemoryFactory;



/**
 * @author krisztian
 */
public class FactoryProducer {
    
    private static AbstractFactory instance = null;
    
    public static AbstractFactory createFactory(DataHandlerTypes type){
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

    public static AbstractFactory getInstance() {
        return instance;
    }
    
    
}
