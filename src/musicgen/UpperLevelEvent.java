package musicgen;

import static musicgen.PitchType.*;
import static musicgen.StorageType.*;

/**
 *  These are stored in an entirely relative order and generate events on
 *         the lower level. As I intend it, musical lines will consist of two
 *         levels, an upper level that contains relatively ordered generative
 *         events, and a lower level that contains the events spit out by these
 *         generators.
 * 
 *       
 * @author Dakota
 *
 *        
 */

public class UpperLevelEvent extends Event {


	
	// you should have this refer to the StorageType of the
			// UpperLevelEventLine that
			// owns this UpperLevelEvent, instead of hardcoding it 	
	
	EventLine generatedEvents = new EventLine(ARRAYLIST);
	EventIterator generatedIter = generatedEvents.GetEventIterator();
	
	public UpperLevelEvent() {

		
		
		
		generatedEvents = new EventLine(ARRAYLIST);
		generatedIter = generatedEvents.GetEventIterator();
		
		
	
	}
	
	
	

}
