package lab5aMyintW;

public class Lab5aApp {

	public static void main(String[] args) {
		// Question 4
		Queue queueDef = new Queue();
		System.out.println(queueDef);
		// Question 5
		Queue queuePar3 = new Queue(3);
		System.out.println(queuePar3);
		// Question 6
		Queue<Integer> queuePar5 = new Queue<Integer>(5);
		try {
			queuePar5.enqueue(new Integer(4));
			// Question 7
			System.out.println(queuePar5);

			// Question 8
			queuePar5.enqueue(new Integer(8));
			queuePar5.enqueue(new Integer(11));
			System.out.println(queuePar5);

			// Question 9
			queuePar5.enqueue(new Integer(9));
			queuePar5.enqueue(new Integer(10));
			queuePar5.enqueue(new Integer(101)); // Exception thrown for queue is Full
		} catch (QueueException qe) {
			System.out.println(qe.getMessage() + "\n");
		}

		// Question 10
		if (queueDef.isEmpty())
			System.out.println("queueDef Queue is Empty");
		else
			System.out.println("queueDef is Not empty");
		if (queuePar5.isEmpty())
			System.out.println("queuePar5 Queue is Empty");
		else
			System.out.println("queuePar5 is Not empty" + "\n");

		// Question 11
		try {
			System.out.println("The element in the front is: " + queueDef.front());
		} catch (QueueException qe) {
			System.out.println("queueDef : " + qe.getMessage());
		}
		try {
			System.out.println("The element in the rear is: " + queueDef.rear());
		} catch (QueueException qe) {
			System.out.println("queueDef : " + qe.getMessage());
		}
		try {
			System.out.println("The element in the front is: " + queuePar5.front());
		} catch (QueueException qe) {
			System.out.println("queuePar5 : " + qe.getMessage());
		}
		try {
			System.out.println("The element in the rear is: " + queuePar5.rear() + "\n");
		} catch (QueueException qe) {
			System.out.println("queuePar5 : " + qe.getMessage());
		}

		// Question 12
		try {
			//empty queue
			queueDef.dequeue();
		} catch (QueueException qe) {
			System.out.println("queueDef : " + qe.getMessage());
		}
		try {
			
			System.out.println(queuePar5);
			while(!queuePar5.isEmpty()) {
				queuePar5.dequeue();
			}
			System.out.println(queuePar5 + "\n");
			queuePar5.enqueue(new Integer(9));
			queuePar5.enqueue(new Integer(10));
		} catch (QueueException qe) {
			System.out.println("queuePar5 : " + qe.getMessage() + "\n");
		}

		//Question 13
		
		if (queueDef.isEmpty())
			System.out.println("queueDef Queue is Empty");
		else
			System.out.println("queueDef is Not empty");
		if (queuePar5.isEmpty())
			System.out.println("queuePar5 Queue is Empty");
		else
			System.out.println("queuePar5 is Not empty" + "\n");
		
		//Question 14
		try {
			queuePar5.makeEmpty();
			if (queuePar5.isEmpty())
				System.out.println("queuePar5 Queue is Empty");
			else
				System.out.println("queuePar5 is Not empty" + "\n");
			
		} catch (QueueException qe) {
			System.out.println("queuePar5 : " + qe.getMessage() + "\n");
		}
	}

}
