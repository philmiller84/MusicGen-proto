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
        NoteEvent note1 = null;
        
        note1 = new NoteEvent(new Pitch(60, PitchType.MIDINOTE));
        line.AddEventAtPosition(note1, PositionType.BEGINNING);
        
        note1 = new NoteEvent(new Pitch(62, PitchType.MIDINOTE));
        line.AddEventAtPosition(note1, PositionType.BEGINNING);
        
        NoteEvent note2 = new NoteEvent(new Pitch(61, PitchType.MIDINOTE));
        line.AddEventAtPosition(note1, PositionType.AFTER);
        
         
        
        System.out.printf("%s\n", note1.GetPitch().GetFrequencyValue());
        
        

        EventCollection  collection = new EventCollection(StorageType.ARRAYLIST);
        Pitch pitch = new Pitch(60, PitchType.MIDINOTE);
        NoteEvent noteEvent = new NoteEvent(pitch);

        System.out.printf("%s\n", pitch.toString());
        
        collection.Insert(noteEvent, null, PositionType.BEGINNING);       
    }
}

