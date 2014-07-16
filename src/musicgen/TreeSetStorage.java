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

public class TreeSetStorage implements StorageInterface{
    
    
    private EventCollection eventCollection;
    
    public TreeSetStorage(EventCollection eventCollection){
        
        this.eventCollection = eventCollection;
    }
    
    
    @Override
    public void InsertRelative(Event insertEvent, Event relativeEvent, 
            PositionType positionType){
        
    }

    @Override
    public void InsertIrrelative(Event insertEvent, PositionType positionType){
        
    }
    
    @Override
    public void Delete(Event e){
        
    }
    
    @Override
    public Event GetNext(Event e){
        return null;
    }

    @Override
    public Event GetPrevious(Event e){
        return null;
    }
       
    @Override
    public Event GetFirst(){
        return null;
    }
    
        
    @Override
    public Event GetLast(){
        return null;
    }

    @Override
    public EventCollection GetContainingCollection(){
        return this.eventCollection;
    }
    
}
