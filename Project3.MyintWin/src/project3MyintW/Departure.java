package project3MyintW;

import cs212lib.Queue;
import cs212lib.QueueFullException;

public class Departure extends Thread {
	private Queue<Airline> queue=new Queue<Airline>();
	private int time;
	private boolean running = true;
	/**
	 * Constructor requires the takeoff duration
	 * @param t
	 */
	public Departure(int t) {
		time = t;
	}
	/**
	 * Accessor for the arrival queue
	 * @return
	 */
	public Queue<Airline> getQueue() {
		return queue;
	}
	/**
	 * Accessor for the mean time between arrivals
	 * @return
	 */
	public int getTime() {
		return time;
	}
	/**
	 * Change the running state to false
	 */
	public void stopRunning() {
		running = false;
	}
	/**
	 * A string representation of the Departure
	 */
	public String toString() {
		return queue.toString() + "\t"+"departured\t" + getTime()+" mins";
	}
	/**
	 * Started by the start method, loop until 
	 * main program calls the stopRunning method
	 */
	public void run() {
		long next = Simulation.timeTillNext(time);/*fix!!!*/
		while(running) {
			try {
				sleep(Simulation.timeInMilisecs(next));/*fix!!!*/
			} catch(InterruptedException ie) {
				ie.getMessage();
			}
			int number = (int)(Math.random() * 20) + 10;
			String id = Simulation.AIRLINES[(int)(Math.random()*17)] + number;
			Airline d = new Airline(id,System.currentTimeMillis());
			try {
				queue.enqueue(d); 
			} catch(QueueFullException qf) {
				qf.getMessage();
			}
			System.out.println("Minute: " + (Simulation.timeInMinutes(System.currentTimeMillis() - Program3.getStartTime())) + " - " + "Added flight " + d.getID() + " to departure Queue\n"
								+ "Random wait time before next departure: " + Simulation.timeInMinutes(time)/*fix!!!*/ + " mins");
		};
	}
}