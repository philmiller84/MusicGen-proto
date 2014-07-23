package musicgen;

import static musicgen.PositionType.*;
import static musicgen.PitchType.*;


/**
 * Test class for Upper Level Event
 * excellent
 * @author Dakota
 *
 */
public class ArpeggioByMidiNumber extends TypedUpperLevelEvent implements Generator {

	private int baseMidiNumber;
	
	public ArpeggioByMidiNumber(int baseMidiNumber){
		super();
		this.baseMidiNumber = baseMidiNumber;
		GenerateEvents();
	}
	
	@Override
	public void GenerateEvents() {

		// make a note n, add to the end of the iterator that contains the temp
		// notes before adding to real iterator
		
		int[] offsets = {0,4,7,12,7,4,0};
		
		for (int i = 0; i < offsets.length; i++){
		
			//generatedIter is the iterator created in the constructor of UpperLevelEvent
			generatedIter.CreateEventAtPosition(new NoteEvent(new Pitch(baseMidiNumber + offsets[i] , MIDINOTE)), BEGINNING);
		}
		
		
	}
	
	@Override
	public String toString()
	{
		return "Arpeggio centered on MIDI number " + this.baseMidiNumber;
	}

}
  