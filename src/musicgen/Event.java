package musicgen;

//

import java.util.HashMap;

//
//  Generated by StarUML(tm) Java Add-In
//
//  @ Project : MusicGen
//  @ File Name : Event.java
//  @ Date : 6/24/2014
//  @ Author : Phil
//
//


public class Event {
    
    protected EventNode containingNode;
    protected String eventTypeName;        
    private EventReferenceMap referenceMap;
    
    public Event(){
        this.referenceMap = new EventReferenceMap();
    }
        
    public void AddReferenceToEvent(Event e) {
          
        referenceMap.AddReference(e);
    }       
    
    public Event GetCorrespondingEventFromEventLine(EventLine eventLine){
        Event correspondingEvent = null;
        
        if(referenceMap.ContainsEventLine(eventLine)){
            correspondingEvent = 
                    referenceMap.GetEventByLineName(eventLine.GetLineName());
        }
        
        return correspondingEvent;
    }
    public boolean HasReferenceToEvent(Event e){
        
        boolean foundReference = false;
        foundReference = referenceMap.ContainsEvent(e);        
        return foundReference;
    }
	
        
    public boolean HasReferenceToEventLine(EventLine eventLine){
    
        boolean foundReference = false;
        foundReference = referenceMap.ContainsEventLine(eventLine);
        return foundReference;
    }
    
    public static EventIterator GetIteratorAtEvent(Event e){
        
        EventLine eventLine = e.GetContainingNode().GetEventLine();

        EventIterator eventIterator = null;
        eventIterator = eventLine.GetEventIterator();
        eventIterator.SetCurrent(e);
        
        return eventIterator;
    }
    
    public void Create() {
	
    }	

    public void Set() {

    }
	
    public void Get() {
	
    }
    
    public EventNode GetContainingNode(){

        return this.containingNode;
    }
    
    public void SetContainingNode(EventNode containingNode){

        this.containingNode = containingNode;
    }
    public String GetEventType() {
       
        return eventTypeName;	
    }
}
