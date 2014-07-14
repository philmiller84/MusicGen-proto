/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package musicgen;

import java.util.ArrayList;

/**
 *
 * @author Phil
 */
public class ArrayListStorage  implements StorageInterface{
    
    private ArrayList <Event> eventList;
    
    public ArrayListStorage () {
        eventList = new ArrayList <>();
    }
            
    @Override
    public void Insert(Event insertEvent, Event relativeEvent, 
            PositionType positionType){
        
        boolean relativeEventExists = relativeEvent != null;
        int relativeEventIndex = -1;
        if(relativeEventExists){
            relativeEventIndex = eventList.indexOf(relativeEvent);
        }
        
        switch(positionType)
        {
            case BEFORE:
                if( relativeEventIndex != -1){
                    eventList.add(relativeEventIndex, insertEvent);
                }
                break;
            case AFTER:
                if( relativeEventIndex != -1){
                    eventList.add(relativeEventIndex + 1, insertEvent);
                }
                break;
            case BEGINNING:
                eventList.add(0, insertEvent);
                break;
            case END:
                eventList.add(insertEvent);
                break;
        }
    }
    
    @Override
    public void Delete(Event e){
        eventList.remove(e);
    }
    
    @Override
    public Event GetNext(Event e){
        
        int currentEventIndex = eventList.indexOf(e);
        boolean eventExists = (currentEventIndex != -1);
        
        if (eventExists &&(eventList.size() > currentEventIndex + 1))
        {
            return eventList.get(currentEventIndex + 1);
        }
  
        return null;    
    }

    @Override
    public Event GetPrevious(Event e){
        
        int currentEventIndex = eventList.indexOf(e);
        boolean eventExists = (currentEventIndex != -1);
        
        if (eventExists && (currentEventIndex > 0))
        {
            return eventList.get(currentEventIndex - 1);
        }
  
        return null;   
    }
}