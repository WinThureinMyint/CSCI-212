package lab5bMyintW;

import cs212lib.Queue;
import cs212lib.QueueEmptyException;

public class ConsumerThread extends Thread {

	private Queue<String> queue;
	private ProducerThread producer;
	private int count;
	private PictPanel panel;
	private boolean running;
	
	// TODO: constructor
	//		initialize the queue, producer thread, and the panel 
	//		using the 3 parameters
	ConsumerThread(Queue<String> q, ProducerThread pr, PictPanel pi) {
		this.queue = q;
		this.producer = pr;
		this.panel = pi;
	}
	
	public void run() {	
		// TODO loop while the producer thread isAlive or the queue is not empty
		//	Note:	possible exceptions that can occur are 
		//		QueueEmptyException and InterruptedException
		while(producer.isAlive() || !queue.isEmpty()){
				// TODO loop while the queue is empty
				while(queue.isEmpty()) {
					
				};

				// TODO if the queue is not empty
				try {
					int i = 0;
					//	take an item from the queue
					String item = queue.dequeue();
					//	call the panel's drawPict method and pass the item
					panel.drawPict(item);
					//	Use Thread.currentThread().getName() to output
					System.out.println(this.currentThread().getName());
					//		the name of this thread and the item it processed	
					//	add 1 to the count
					count++;
					//	sleep for 1000 to 5000 milliseconds (random)
					sleep((int)(Math.random()*4000+1000));
				}catch (QueueEmptyException qe) {
					qe.getMessage();
				} catch (InterruptedException ie) {
					ie.getMessage();
				}
		}
		// TODO When the thread stop's running, 
		//		display its name and the number of items processed
		System.out.println("Consumer thread has stopped.");
	}

}
