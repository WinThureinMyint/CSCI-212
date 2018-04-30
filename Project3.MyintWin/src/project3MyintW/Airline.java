package project3MyintW;

public class Airline {
	private String flightID;
	private long entered;
	private long exited;
	/**
	 * Constructor requires the id & time entered
	 * @param flightID
	 * @param entered
	 */
	public Airline(String flightID, long entered) {
		this.flightID = flightID;
		this.entered = entered;
	}
	/**
	 * Accessor for the id
	 * @return
	 */
	public String getID() {
		return flightID;
	}

	/**
	 * Mutator for the time entered
	 * @return
	 */
	public long getEntered() {
		return entered;
	}
	/**
	 * Mutator for the time exited
	 * @param entered
	 */
	public void setEntered(long entered) {
		this.entered = entered;
	}
	/**
	 * Mutator for the time exited
	 * @param exited
	 */
	public void setExited(long exited) {
		this.exited = exited;
	}
	/**
	 * A string representation of the Airline
	 */
	public String toString() {
		//return " - Entered Queue at " + Simulation.timeInMinutes(entered - Program3.getStartTime()) + " - waited " + (Simulation.timeInMinutes(exited - entered)) + " mins";
		return getID();
	}
}
