package project3MyintW;

import cs212lib.Queue;
import cs212lib.QueueFullException;

public class Arrival extends Thread {
	private Queue<Airline> queue=new Queue<Airline>(); 
	private int time; 
	private boolean running = true;

	/**
	 * Constructor requires the landing duration
	 * @param t
	 */
	public Arrival(int t) {
		time = t;
	}
	/**
	 * Accessor for the arrival queue
	 * @return Arrival queue
	 */
	public Queue<Airline> getQueue() {
		return queue;
	}
	/**
	 * Accessor for the landing duration time
	 * @return Landing duration (sleep time)
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
	 * A string representation of the Arrival
	 */
	public String toString() {
		return queue.toString() + "\t"+"arrived\t" + getTime()+" mins";
	}
	/**
	 * Started by the start method, loop until 
	 * main program calls the stopRunning method
	 */
	public void run() {
		long next = Simulation.timeTillNext(time);
		while(running) {
			try {
				sleep(Simulation.timeInMilisecs(next));
			} catch(InterruptedException ie) {
				ie.getMessage();
			}
			int number = (int)(Math.random() * 20) + 10;
			String id = Simulation.AIRLINES[(int)(Math.random())] + number;
			Airline a = new Airline(id,System.currentTimeMillis());
			try {
				queue.enqueue(a); 
			} catch(QueueFullException qf) {
				qf.getMessage();
			}
			System.out.println("Minute: " + (Simulation.timeInMinutes(System.currentTimeMillis() - Program3.getStartTime())) + " - " + "Added flight " + a.getID() + " to arrival Queue\n"
								+ "Random wait time before next arrival: " + Simulation.timeInMinutes(time)/*fix!!!*/ + " mins");
		}; 
	}
}