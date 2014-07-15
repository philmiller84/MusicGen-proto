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
public class MusicGen {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        
        AggregateLine aggrLine = new AggregateLine(StorageType.ARRAYLIST);
        
//        AggregateEvent aggrEvent = new AggregateEvent();
        
        EventLine line = new EventLine(StorageType.ARRAYLIST);
              
        NoteEvent note1 = new NoteEvent(new Pitch(70, PitchType.MIDINOTE));

        EventIterator iter = line.GetEventIterator();
        iter.AddEventAtPosition(note1, PositionType.BEGINNING);
      
        iter.SetCurrent(note1);
        
        NoteEvent note2 = new NoteEvent(new Pitch(61, PitchType.MIDINOTE));
        NoteEvent note3 = new NoteEvent(new Pitch(62, PitchType.MIDINOTE));
        NoteEvent note4 = new NoteEvent(new Pitch(64, PitchType.MIDINOTE));
        NoteEvent note5 = new NoteEvent(new Pitch(67, PitchType.MIDINOTE));
  
        iter.AddEventAtPosition(note2, PositionType.BEGINNING);
        iter.AddEventAtPosition(note3, PositionType.BEGINNING);
        iter.AddEventAtPosition(note4, PositionType.BEGINNING);
        iter.AddEventAtPosition(note5, PositionType.BEGINNING);
        
        
        System.out.printf("%s\n", ((NoteEvent)iter.GetCurrent()).GetPitch().toString());

        
        iter.FindEvent(note3);

               
        System.out.printf("%s\n", ((NoteEvent)iter.GetCurrent()).GetPitch().toString());

        
        
        
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

