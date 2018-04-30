package project3MyintW;

import java.util.Scanner;

public class Program3 {
	private static long startTime;
	private static long simulationTime;
	Runway runway;
	Arrival arrival;
	Departure departure;

	public Program3(int min) {
		arrival = new Arrival(min);
		departure = new Departure(min);
		runway = new Runway(arrival, departure);
	}

	public static long getStartTime() {
		return startTime;
	}

	public static long getSimulationTime() {
		return simulationTime;
	}

	public void startSimulation(long time) {
		// TODO: Start each thread
		startTime = System.currentTimeMillis();
		simulationTime = time;
		arrival.start();
		departure.start();
		runway.start();
		// Loop - run simulation for specified time
		while (System.currentTimeMillis() < startTime + simulationTime) {

		}

		// TODO: stop the loop in each thread - call the stopRunning method
		arrival.stopRunning();
		departure.stopRunning();

		// TODO: interrupt each thread - method from Thread class
		arrival.interrupt();
		departure.interrupt();

		try {

			// TODO: wait for each thread to die - method from Thread class
			arrival.join();
			departure.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

	public static void main(String[] args) {
		/*
		 * TODO:
		 * 
		 * Input the length of time to run the simulation (in minutes) Create an
		 * instance of Program3 Call the startSimulation method and pass the time to it
		 * Loop while the Arrival or Departure threads are alive Stop the Runway thread
		 * from running
		 * 
		 */

		System.out.println("Enter minute: ");
		Scanner temp = new Scanner(System.in);
		int time = temp.nextInt();
		Program3 p3 = new Program3(time);
		long miliSec = Simulation.timeInMilisecs(time);
		p3.startSimulation(miliSec);
		while (p3.arrival.isAlive() || p3.departure.isAlive())
			;
		p3.runway.stopRunning();

	}

}
