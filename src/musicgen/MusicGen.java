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

        EventCollection  collection = new EventCollection(StorageType.ARRAYLIST);
        Pitch pitch = new Pitch(60, PitchType.MIDINOTE);
        NoteEvent noteEvent = new NoteEvent(pitch);

        System.out.printf("%s\n", pitch.toString());
        
        collection.Insert(noteEvent);       
    }
}
