package musicgen;

/**
 * 
 * @author Dakota
 * 
 *         Takes reference to a lower-level EventIterator, one that contains
 *         JUST the events that the Event that implements Generator spits out
 * 
 *         The events in that iterator will then be added to the single
 *         lower-level EventIterator contained in the EventLine corresponding to
 *         the entire lower-level.
 */
public interface Generator {

	/**
	 * this abstract method is implemented by all specific kinds of typed events
	 * this is where the specific event-making code goes
	 */
	abstract void GenerateEvents();
}
