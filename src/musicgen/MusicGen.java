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
        // TODO code application logic here
        
        EventCollection  a = new EventCollection();
        Pitch p = new Pitch(60, PitchType.MIDINOTE);
        NoteEvent e = new NoteEvent(p);
        a.Insert(e);       
    }
    
}
