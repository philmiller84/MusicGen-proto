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
        
        
        
        EventLine line = new EventLine(StorageType.ARRAYLIST);
        EventIterator iter = new EventIterator(line);
        NoteEvent note1 = null;
        
        note1 = new NoteEvent(new Pitch(61, PitchType.MIDINOTE));
        iter.AddEventAtPosition(note1, PositionType.BEGINNING);
        
        note1 = new NoteEvent(new Pitch(59, PitchType.MIDINOTE));
        iter.AddEventAtPosition(note1, PositionType.BEGINNING);
        
        NoteEvent note2 = new NoteEvent(new Pitch(62, PitchType.MIDINOTE));
        iter.SetCurrentEvent(note1);
        iter.AddEventAtPosition(note2, PositionType.AFTER);
        
        note1 = new NoteEvent(new Pitch(63, PitchType.MIDINOTE));
        iter.AddEventAtPosition(note1, PositionType.END);
        
        NoteEvent note3 = new NoteEvent(new Pitch(73, PitchType.MIDINOTE));
        iter.SetCurrentEvent(note2);
        iter.AddEventAtPosition(note3, PositionType.BEFORE);
        
        System.out.printf("%s\n", note1.GetPitch().GetFrequencyValue());

        
        NoteEvent iterNote = null;
        
        iter.FirstEvent();
        iterNote = (NoteEvent) iter.GetCurrentEvent();
        System.out.printf("%s\n", iterNote.GetPitch().GetFrequencyValue());
        
        iter.PrevEvent();
        iterNote = (NoteEvent) iter.GetCurrentEvent();
        System.out.printf("%s\n", iterNote.GetPitch().GetFrequencyValue());

        iter.PrevEvent();
        iterNote = (NoteEvent) iter.GetCurrentEvent();
        System.out.printf("%s\n", iterNote.GetPitch().GetFrequencyValue());

        iter.NextEvent();
        iterNote = (NoteEvent) iter.GetCurrentEvent();
        System.out.printf("%s\n", iterNote.GetPitch().GetFrequencyValue());

        iter.PrevEvent();
        iterNote = (NoteEvent) iter.GetCurrentEvent();
        System.out.printf("%s\n", iterNote.GetPitch().GetFrequencyValue());

        
        
        
        
        
        EventCollection  collection = new EventCollection(StorageType.ARRAYLIST);
        Pitch pitch = new Pitch(60, PitchType.MIDINOTE);
        NoteEvent noteEvent = new NoteEvent(pitch);

        System.out.printf("%s\n", pitch.toString());
        
//        collection.Insert(noteEvent, null, PositionType.BEGINNING);       
    }
}

