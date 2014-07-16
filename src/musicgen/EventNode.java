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
public class EventNode {
    
    private Event event;
    private EventNode nextNode;
    private EventNode prevNode;
    private EventNode parentNode;
    private StorageInterface storageReference;
    
    public EventNode(Event event){

        this.event = event;        
    }
    
    public void SetStorageReference(StorageInterface storageReference){
        
        this.storageReference = storageReference;
    }
  
    public EventLine GetEventLine(){
        
        EventLine searchEventLine = null;
        EventCollection searchEventCollection = null;
        
        searchEventCollection = this.storageReference.GetContainingCollection();
        searchEventLine = searchEventCollection.GetEventLine();
        
        return searchEventLine;
    }
    
    
    public void SetNextNode(EventNode nextNode){
        
        this.nextNode = nextNode;        
    }
    public void SetPrevNode(EventNode prevNode){
        
        this.prevNode = prevNode;        
    }
    
    public void SetParentNode(EventNode parentNode){
        
        this.parentNode = parentNode;
    }
    
    public EventNode GetByPositionType(PositionType positionType){
        
        EventNode searchNode = null;
        switch(positionType)
        {
            case NEXT:
            case AFTER:
                searchNode = GetNextNode();
                break;
            case PREV:
            case BEFORE:
                searchNode = GetPrevNode();
                break;
            case AT:
                searchNode = this;
                break;
        }
        
        return searchNode;
    }
       
    public EventNode GetNextNode(){
        
        return this.nextNode;      
    }
    public EventNode GetPrevNode(){
        
        return this.prevNode;    
    }
    
    public EventNode GetParentNode(){
        
        return this.parentNode;
    }
    
    public void SetEvent(Event event){
        
        this.event = event;
    }
    public Event GetEvent(){
        
        return this.event;
    }
    
}
