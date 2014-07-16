/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package musicgen;

/**
 *
 * @author Phil
 */

public class ReferenceKey {
    
    public EventLine eventLine;
    public Event event;
    
    public ReferenceKey(Event e, EventLine el){
        this.event = e;
        this.eventLine = el;
    }
    
    public Event GetEvent(){
        return event;
    }
    
    public EventLine GetEventLine(){
        return eventLine;
    }
    
}
