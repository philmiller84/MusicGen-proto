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
    
    private ArrayList <EventNode> eventNodeList;
    
    public ArrayListStorage () {
        eventNodeList = new ArrayList <>();
    }
            
    @Override
    public void Insert(Event insertEvent, Event relativeEvent, 
            PositionType positionType){
        
        
        EventNode relativeEventNode = null;   
        int relativeEventIndex = -1;
        
        if(positionType == PositionType.BEGINNING)
        {
            if(eventNodeList.size() > 0)
            {
                relativeEventNode = eventNodeList.get(0);
                relativeEvent = relativeEventNode.GetEvent();
            }
        }
          
        if(positionType == PositionType.END)
        {
            if(eventNodeList.size() > 0)
            {
                relativeEventNode = eventNodeList.get(eventNodeList.size() - 1);
                relativeEvent = relativeEventNode.GetEvent();
            }
        }
                
        boolean relativeEventExists = (relativeEventNode != null);
        
        if(relativeEventExists){
            relativeEventNode = relativeEvent.GetContainingNode();
            relativeEventIndex = eventNodeList.indexOf(relativeEventNode);
        }
        
        EventNode insertEventNode = new EventNode(insertEvent);
        
        insertEvent.SetContainingNode(insertEventNode);
        int insertEventIndex = -1;
        
        switch(positionType)
        {
            case BEFORE:
                if( relativeEventIndex != -1){
                    insertEventIndex = relativeEventIndex;
                }
                break;
            case AFTER:
                if( relativeEventIndex != -1){
                    insertEventIndex = relativeEventIndex + 1;
                }
                break;
            case BEGINNING:
                insertEventIndex = 0;
                break;
            case END:
                insertEventIndex = eventNodeList.size();
                break;
        }
         
        if(relativeEventIndex != -1)
        {
            EventNode temp = relativeEventNode.GetPrevNode();
            if(temp != null)
            {
                temp.SetNextNode(insertEventNode);
                insertEventNode.SetPrevNode(temp);
            }
            relativeEventNode.SetPrevNode(insertEventNode);            
        }

        eventNodeList.add(insertEventIndex, insertEventNode);
    }
    
    @Override
    public void Delete(Event e){
        
        EventNode currentEventNode = e.GetContainingNode();
        
        EventNode nextEventNode = currentEventNode.GetNextNode();
        EventNode prevEventNode = currentEventNode.GetPrevNode();
                
        if(prevEventNode != null)
        {
            prevEventNode.SetNextNode(nextEventNode);
        }
             
        if(nextEventNode != null)
        {
            nextEventNode.SetPrevNode(prevEventNode);
        }
        
        eventNodeList.remove(e);
    }
    
    @Override
    public Event GetNext(Event e){
        
        EventNode currentEventNode = e.GetContainingNode();
        int currentEventIndex = eventNodeList.indexOf(currentEventNode);
        
        boolean eventExists = (currentEventIndex != -1);
        
        if (eventExists &&(eventNodeList.size() > currentEventIndex + 1))
        {
            return eventNodeList.get(currentEventIndex + 1).GetEvent();
        }
  
        return null;    
    }

    @Override
    public Event GetPrevious(Event e){
        
        EventNode currentEventNode = e.GetContainingNode();        
        int currentEventIndex = eventNodeList.indexOf(currentEventNode);
        boolean eventExists = (currentEventIndex != -1);
        
        if (eventExists && (currentEventIndex > 0))
        {
            return eventNodeList.get(currentEventIndex - 1).GetEvent();
        }
  
        return null;   
    }
}