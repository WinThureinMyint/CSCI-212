package project3MyintW;

import cs212lib.QueueEmptyException;

public class Runway extends Thread {
	
	private Arrival arrival;
	private Departure departure;
	private boolean running = true;
	
	/**
	 * constructor - needs arrival & departure threads
	 * @param arrival
	 * @param departure
	 */
	public Runway(Arrival arrival, Departure departure) {
		this.arrival = arrival;
		this.departure = departure;
	}

	/**
	 * Change the running state to false
	 */
	public void stopRunning() {
		running = false;
	}
	/**
	 * A string representation of the Runway
	 */
	public String toString() {
		return "Arrival \t"+arrival.getName() +"\tDeparture \t"+departure.getName();
	}
	/**
	 * Started by the start method inherited from the thread class 
	 * loop until main program calls the stopRunning method
	 */
	public void run() {
		while(running) {
			while(arrival.getQueue().getSize()>0) {
				try{
					Airline a = arrival.getQueue().dequeue();
					a.setExited(System.currentTimeMillis());
					System.out.println("Minute: " + (Simulation.timeInMinutes(System.currentTimeMillis() - Program3.getStartTime())) + " - " + a.getID() + arrival.toString() + a.toString());
					try {
						sleep(Simulation.LANDING_TIME);
					} catch(InterruptedException ie) {
						ie.getMessage();
					}
				} catch(QueueEmptyException qe) {
					qe.setStackTrace(null);
				}
			}
			
			while(departure.getQueue().getSize()>0) {
				try{
					Airline d = departure.getQueue().dequeue();
					d.setExited(System.currentTimeMillis());
					System.out.println("Minute: " + (Simulation.timeInMinutes(System.currentTimeMillis() - Program3.getStartTime())) + " - " + d.getID() + departure.toString() + d.toString());
					try {
						sleep(Simulation.TAKEOFF_TIME);
					} catch(InterruptedException ie) {
						ie.getMessage();
					}
				} catch(QueueEmptyException qe) {
					qe.setStackTrace(null);
				}
			}
		}; 
	}
}