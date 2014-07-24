/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



package musicgen;
import static musicgen.PositionType.*;
import static musicgen.StorageType.*;
import static musicgen.PitchType.*;
import musicgen.ArpeggioByMidiNumber;
import musicgen.EventIterator;
import musicgen.UpperLevelEventLine;

/**
 *
 * @author Phil
 */
public class MusicGen {

    public static void main(String[] args) {
        
        
        AggregateLine aggrLine = new AggregateLine(ARRAYLIST);
        EventLine line = new EventLine(ARRAYLIST);
        line.SetAggregateLine(aggrLine);
        
        AggregateLine aggrRef = line.GetAggregateLine();
        
        System.out.print(aggrRef.GetLineName() + "\n");
        
        NoteEvent note1 = new NoteEvent(new Pitch(70, MIDINOTE));

        EventIterator iter = line.GetEventIterator();
        iter.CreateEventAtPosition(note1, BEGINNING);
      
        iter.SetCurrent(note1); //-----------------------------------------------
        
        NoteEvent note2 = new NoteEvent(new Pitch(61, MIDINOTE));
        NoteEvent note3 = new NoteEvent(new Pitch(62, MIDINOTE));
        NoteEvent note4 = new NoteEvent(new Pitch(64, MIDINOTE));
        NoteEvent note5 = new NoteEvent(new Pitch(67, MIDINOTE));
  
        iter.SetCurrent(note1);
        iter.CreateEventAtPosition(note2, BEFORE);
        iter.SetCurrent(note2);
        iter.CreateEventAtPosition(note3, BEFORE);
        iter.SetCurrent(note3);
        iter.CreateEventAtPosition(note4, BEGINNING);
        iter.CreateEventAtPosition(note5, BEGINNING);
        
        NoteEvent currentNote = (NoteEvent)iter.GetCurrent();        
        String lineName = currentNote.GetContainingNode().GetEventLine().GetLineName();
        
        System.out.printf("%s\n", lineName);
        System.out.printf("%s\n", ((NoteEvent)iter.GetCurrent()).GetPitch().GetFrequencyValue());

        
        iter.FindEvent(note3);//-----------------------------------------------

        currentNote = (NoteEvent)iter.GetCurrent();
        lineName = currentNote.GetContainingNode().GetEventLine().GetLineName();
        System.out.printf("%s\n", lineName);
        System.out.printf("%s\n", ((NoteEvent)iter.GetCurrent()).GetPitch().GetFrequencyValue());
        
    	
		UpperLevelEventLine upperEventLine = new UpperLevelEventLine(ARRAYLIST);
		LowerLevelEventLine lowerEventLine = new LowerLevelEventLine(ARRAYLIST);

		// create an upper line full of arpeggiobymidinumber objects
		// and a lower line to hold their outputs
		
		EventIterator upperIter = upperEventLine.GetEventIterator();
		EventIterator lowerIter = lowerEventLine.GetEventIterator();
		
		
		upperIter.CreateEventAtPosition(new ArpeggioByMidiNumber(60), BEGINNING);
		upperIter.CreateEventAtPosition(new ArpeggioByMidiNumber(55), END);
		
		// this iterates over the arpeggiobymidinumber objects
		// and tells them to iterate over themselves and insert their notes into the
		// lower level iterator
		// this gets stuck in an infinite loop
		// this ends up calling dispenseEvents for each item in upperIter
		// which calls the Next method in EventIterator,
		// which keeps, i believe, returning the first and then last and then first and then last
		// events in that iterator, ad infinitum, instead of iterating properly
	
		upperIter.dispenseEventsInIterators(lowerIter, END);
		
		System.out.println(lowerIter.First());
        
        
        //create event, then add to aggregate
        //create on aggregate, then add to event.
        
        // Differences? Any? 



//        EventLine line = new EventLine(StorageType.ARRAYLIST);
//        EventIterator iter = new EventIterator(line);
//        NoteEvent note1 = null;
//        
//        note1 = new NoteEvent(new Pitch(61, PitchType.MIDINOTE));
//        iter.AddEventAtPosition(note1, PositionType.BEGINNING);
//        
//        note1 = new NoteEvent(new Pitch(59, PitchType.MIDINOTE));
//        iter.AddEventAtPosition(note1, PositionType.BEGINNING);
//        
//        NoteEvent note2 = new NoteEvent(new Pitch(62, PitchType.MIDINOTE));
//        iter.SetCurrent(note1);
//        iter.AddEventAtPosition(note2, PositionType.AFTER);
//        
//        note1 = new NoteEvent(new Pitch(63, PitchType.MIDINOTE));
//        iter.AddEventAtPosition(note1, PositionType.END);
//        
//        NoteEvent note3 = new NoteEvent(new Pitch(73, PitchType.MIDINOTE));
//        iter.SetCurrent(note2);
//        iter.AddEventAtPosition(note3, PositionType.BEFORE);
//        
//        System.out.printf("%s\n", note1.GetPitch().GetFrequencyValue());
//
//        
//        NoteEvent iterNote = null;
//        
//        iter.First();
//        iterNote = (NoteEvent) iter.GetCurrent();
//        if(iterNote!=null)
//            System.out.printf("%s\n", iterNote.GetPitch().GetFrequencyValue());
//        
//        iter.Next();
//        iterNote = (NoteEvent) iter.GetCurrent();
//        if(iterNote!=null)
//            System.out.printf("%s\n", iterNote.GetPitch().GetFrequencyValue());
//
//        iter.Prev();
//        iterNote = (NoteEvent) iter.GetCurrent();
//        if(iterNote!=null)
//            System.out.printf("%s\n", iterNote.GetPitch().GetFrequencyValue());
//
//        iter.Next();
//        iterNote = (NoteEvent) iter.GetCurrent();
//        if(iterNote!=null)
//            System.out.printf("%s\n", iterNote.GetPitch().GetFrequencyValue());
//
//        iter.Prev();
//        iterNote = (NoteEvent) iter.GetCurrent();
//        if(iterNote!=null)
//            System.out.printf("%s\n", iterNote.GetPitch().GetFrequencyValue());
//
//        
//        
//        
//        
//        
//        EventCollection  collection = new EventCollection(StorageType.ARRAYLIST);
//        Pitch pitch = new Pitch(60, PitchType.MIDINOTE);
//        NoteEvent noteEvent = new NoteEvent(pitch);
//
//        System.out.printf("%s\n", pitch.toString());
        
//        collection.Insert(noteEvent, null, PositionType.BEGINNING);       
    }
}

