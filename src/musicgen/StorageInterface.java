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
public interface StorageInterface {
    
    public void InsertRelative(Event insertEvent, Event relativeEvent, 
            PositionType positionType);
    
    public void InsertIrrelative(Event insertEvent, PositionType positionType);
    
    public void Delete(Event e);
    
    public Event GetNext(Event e);

    public Event GetPrevious(Event e);

    public Event GetFirst();

    public Event GetLast();
    
    public EventCollection GetContainingCollection();
    
}
