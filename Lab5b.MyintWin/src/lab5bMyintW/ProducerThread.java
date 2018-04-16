package lab5bMyintW;

import cs212lib.Queue;
import cs212lib.QueueFullException;

public class ProducerThread extends Thread {
	
	private Queue<String> queue;
	private String[] picture;

	//TODO: constructor
	//	initialize the queue and the array
	//	using the 2 parameters
	ProducerThread(Queue<String> q, String [] p) {
		this.queue = q;
		this.picture = p;
	}

	public void run() {
		//	TODO loop for each picture and the picture is not null
		//	Note: possible exceptions that can occur are
		//		QueueFullException and InterruptedException
		
		for(int i=0;i<this.picture.length;i++){	
			//	TODO loop while the queue is full
			while(queue.isFull()) {
			}
			
			try {
				//TODO add an item from the array to the queue
				//		display the item added to the queue
				//		sleep for 100 - 1000 milliseconds
				queue.enqueue(picture[i]);
				System.out.print(queue.rear());
				sleep((int)(100 + (int)(Math.random() * ((1000 - 100) + 1))));
				
			} catch (QueueFullException qfe) {
				qfe.getMessage();
			} catch (InterruptedException ie) {
				ie.getMessage();
			}
		}
		//	TODO When the thread stop's running,
		//	display a message indicating the thread has stopped
		System.out.println("Producer thread has stopped.");
	}
	
}
