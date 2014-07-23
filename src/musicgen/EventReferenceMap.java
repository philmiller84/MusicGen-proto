package musicgen;

//

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

//
//  Generated by StarUML(tm) Java Add-In
//
//  @ Project : MusicGen
//  @ File Name : EventReferenceMap.java
//  @ Date : 6/24/2014
//  @ Author : Phil
//
//

public class EventReferenceMap {
    
    private Map <ReferenceKey, Event> map;
    
    public EventReferenceMap()
    {
        map = new HashMap();
    }
    
    public void AddReference(Event e) {
        EventLine eventLine = e.containingNode.GetEventLine();
      
        ReferenceKey newKey = new ReferenceKey(e, eventLine );
        
        map.put(newKey, e);      
    }
    
//    public void AddReferenceByType(Event e) {
    public boolean ContainsEvent(Event e){
        
        boolean containsEvent = false;
        
        for (Iterator<Event> it = map.values().iterator(); 
                it.hasNext() && containsEvent == false;) {
            Event searchEvent = it.next();
            
            if(searchEvent == e)
            {
                containsEvent = true;
            }
        }
         
        return containsEvent;
    }

    public Event GetEventByLineName(String lineName){
        
        Event searchEvent = null;
        Set <ReferenceKey> keySet = map.keySet();
        
        for (Iterator<ReferenceKey> it = keySet.iterator(); 
                it.hasNext() && searchEvent == null;) {
            
            ReferenceKey key = it.next();
            
            if(key.HasEventLineByName(lineName)){
                searchEvent = key.event;
            }
        }
        
        return searchEvent;
    }
    
    public void HashValue() {

    }
}
