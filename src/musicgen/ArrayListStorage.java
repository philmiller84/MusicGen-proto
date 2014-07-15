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
    public void InsertRelative(Event insertEvent, Event relativeEvent, 
            PositionType positionType){
        
        EventNode relativeEventNode = null;   
        int relativeEventIndex = -1;
        
        boolean relativeEventExists = (relativeEvent != null);
        
        if(relativeEventExists){
            relativeEventNode = relativeEvent.GetContainingNode();
            relativeEventIndex = eventNodeList.indexOf(relativeEventNode);
        }
        
        EventNode insertEventNode = new EventNode(insertEvent);
        insertEvent.SetContainingNode(insertEventNode);

        int insertEventIndex = -1;
        
        if (relativeEventIndex != -1)
        {
            EventNode newPrevEventNode = null;
            EventNode newNextEventNode = null;
            
            switch(positionType)
            {
                case BEFORE:
                    insertEventIndex = relativeEventIndex;
                    newNextEventNode = relativeEventNode;
                    newPrevEventNode = relativeEventNode.GetPrevNode();                    
                    break;
                case AFTER:
                    insertEventIndex = relativeEventIndex + 1;
                    newPrevEventNode = relativeEventNode;
                    newNextEventNode = relativeEventNode.GetNextNode();
                    break;
            }
            
            if(newNextEventNode != null)
            {
                insertEventNode.SetNextNode(newNextEventNode);
                newNextEventNode.SetPrevNode(insertEventNode);
            }
            if(newPrevEventNode != null)
            {
                insertEventNode.SetPrevNode(newPrevEventNode);
                newPrevEventNode.SetNextNode(insertEventNode);
            }
        }

        eventNodeList.add(insertEventIndex, insertEventNode);
    }
        
    @Override
    public void InsertIrrelative(Event insertEvent, PositionType positionType){

        EventNode newPrevEventNode = null;
        EventNode newNextEventNode = null;

        if(positionType == PositionType.BEGINNING)
        {
            if(eventNodeList.size() > 0)
            {
                newNextEventNode = eventNodeList.get(0);
           }
        }

        if(positionType == PositionType.END)
        {
            if(eventNodeList.size() > 0)
             {
                newPrevEventNode = eventNodeList.get(eventNodeList.size() - 1);
            }
        }

        boolean newPrevEventNodeExists = (newPrevEventNode != null);
        boolean newNextEventNodeExists = (newNextEventNode != null);

        int insertEventIndex = -1;
        EventNode insertEventNode = new EventNode(insertEvent);
        insertEvent.SetContainingNode(insertEventNode);

        switch(positionType)
        {
            case BEGINNING:
                insertEventIndex = 0;
                break;
            case END:
                 insertEventIndex = eventNodeList.size();
                break;
        }

        if(newPrevEventNodeExists)
        {
            insertEventNode.SetPrevNode(newPrevEventNode);
            newPrevEventNode.SetNextNode(insertEventNode);
        }
        if(newNextEventNodeExists)
        {
            newNextEventNode.SetPrevNode(insertEventNode);
            insertEventNode.SetNextNode(newNextEventNode);
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
    
    public Event GetFirst(){
    
        Event firstEvent = null;
        
        if(eventNodeList.size() > 0 )
        {
            firstEvent = eventNodeList.get(0).GetEvent();
        }
        
        return firstEvent;
    }
    
    public Event GetLast(){
    
        Event lastEvent = null;
        
        if(eventNodeList.size() > 0 )
        {
            lastEvent = eventNodeList.get(eventNodeList.size() - 1).GetEvent();
        }
        
        return lastEvent;
    }
}