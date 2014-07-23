/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package musicgen;
import static musicgen.PositionType.*;
import static musicgen.StorageType.*;
import static musicgen.PitchType.*;

/**
 *
 * @author Phil
 */
public class MusicGen {

    public static void main(String[] args) {
        
        
        AggregateLine aggrLine = new AggregateLine(ARRAYLIST);
        EventLine line1 = new EventLine(ARRAYLIST);
        EventLine line2 = new EventLine(ARRAYLIST);
        
        line1.SetAggregateLine(aggrLine);
        line2.SetAggregateLine(aggrLine);
        
        AggregateLine aggrRef = line1.GetAggregateLine();
        
        System.out.print(aggrRef.GetLineName() + "\n");
        
        NoteEvent note1 = new NoteEvent(new Pitch(60, MIDINOTE));

        EventIterator iter = line1.GetEventIterator();
        iter.CreateEventAtPosition(note1, END);
      
        iter.SetCurrent(note1); //-----------------------------------------------
        
        NoteEvent note2 = new NoteEvent(new Pitch(61, MIDINOTE));
        NoteEvent note3 = new NoteEvent(new Pitch(62, MIDINOTE));
        NoteEvent note4 = new NoteEvent(new Pitch(64, MIDINOTE));
        NoteEvent note5 = new NoteEvent(new Pitch(67, MIDINOTE));
  
        iter.CreateEventAtPosition(note2, END);
        iter.CreateEventAtPosition(note3, END);
        iter.CreateEventAtPosition(note4, END);
//        iter.CreateEventAtPosition(note5, END);
        
        line2.GetEventIterator().CreateEventRelativeToEvent(note5, note2, AFTER);
        
        NoteEvent currentNote = (NoteEvent)iter.GetCurrent();        
        String lineName = currentNote.GetContainingNode().GetEventLine().GetLineName();
        
        System.out.printf("%s ", lineName);
        System.out.printf("%s\n", ((NoteEvent)iter.GetCurrent()).GetPitch().GetMIDIValue());

        
        iter.FindEvent(note3);//-----------------------------------------------

        currentNote = (NoteEvent)iter.GetByPositionType(AFTER);
        lineName = currentNote.GetContainingNode().GetEventLine().GetLineName();
        System.out.printf("%s ", lineName);
        System.out.printf("%s\n", ((NoteEvent)iter.GetCurrent()).GetPitch().GetMIDIValue());
        
        
        //create event, then add to aggregate
        //create on aggregate, then add to event.
        
        // Differences? Any? 
    }
}

