package lab5bMyintW;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import java.net.*;
import java.applet.*;
import java.io.*;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import cs212lib.Queue;

public class Lab5bApp {

	// Define an integer variable to store the number of consumer threads
	int numThreads;
	
	// TODO: define a reference to a Queue<String> (use the default constructor)
	Queue<String> queue = new Queue<>();
	

	// define a reference to a ThreadGroup
	private ThreadGroup tg = new ThreadGroup("consumers");

	// TODO: define a reference to an array of Threads (data type isThread)
	//	variable name - consumer
	Thread [] consumer;
	
	// TODO: define a reference to a ProducerThread 
	//	variable name - producer
	ProducerThread producer;

	// TODO: define a reference to an array of PictPanel objects (to display each image)
	//	variable name - panel
	PictPanel [] panel;
	
	// TODO: define a reference to an array of JFrame objects (to place each Panel)
	//	variable name - pictureFrame
	JFrame[] pictureFrame;
	
	// TODO: define a reference to an array of Strings (to store the names of the images)
	//	variable name - picture	
	String [] picture;

	public static void main(String[] args) {

		// TODO: create an instance of this class and call its constructor
		Lab5bApp lab5 = new Lab5bApp();		
		// exit the program
		System.exit(0);
	}
 
	// constructor for the class
	public Lab5bApp() {
		// TODO: permit the user to input the number of consumer threads (3 - 5)
		//	Use JOptionPane.showInputDialog
		String input = JOptionPane.showInputDialog("Enter the number of consumer threads (3-5): ");
		
		// TODO: initialize all arrays to the size of the number of consumer threads
		numThreads = Integer.parseInt(input);
		consumer = new Thread [numThreads];
		panel = new PictPanel [numThreads];
		pictureFrame = new JFrame[numThreads];
		picture = new String [numThreads];
		
		
		// TODO: call the appropriate method to load the pictures
		loadImages();
		
		// TODO: create a loop based on the number of consumer threads
		//		for each JFrame and PictPanel object
		for(int i=0;i<consumer.length;i++){
			// TODO: create an instance of JFrame with the title
			//	 Thread and the number of the thread example: (Thread 1)
			// and store it in the array
			String tName = "Thread " + i+1;
			pictureFrame[i] = new JFrame(tName);
			// TODO: use the setSize method to set the JFrame’s size to 200 by 200
			pictureFrame[i].setSize(200,200);
			// Set X,Y coordinate of upper left corner of the frame
			pictureFrame[i].setLocation(80 * i, 80 * i);
			// TODO: create an instance of PictPanel and store it in the panel
			// array
			PictPanel newPanel = new PictPanel(pictureFrame[i]); 
			panel[i] = newPanel;
			// add the panel to the frame
			pictureFrame[i].getContentPane().add(panel[i]);
			// Use the setVisible method to show the frame
			pictureFrame[i].setVisible(true);
		}

		// TODO: create an instance of ProducerThread
		// store it in the variable created
		// the ProducerThread constructor needs a Queue and an array of Strings
		producer = new ProducerThread(queue, picture);

		// TODO: call the start method of the producer thread
		producer.start();

		producer.setPriority(Thread.MAX_PRIORITY);
		// create the consumer threads and add them to the ThreadGroup
		for (int i = 0; i < numThreads; i++) {
			consumer[i] = new Thread(tg, new ConsumerThread(queue, producer,
					panel[i]), "thread " + i);
			consumer[i].start();
		}

		// TODO: loop until the producer thread is no longer alive
		// use the isAlive() method of the producer thread
		// the loop pauses the program until the producer thread ends
		while(producer.isAlive()) {
			
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			
		}

		// TODO: after the loop ends, display a message using ShowMessageDialog
		// indicating  the producer thread has finished
		JOptionPane.showMessageDialog(null, "the producer thread has finished.");



		// TODO: pause the program until the consumer threads end
		// Loop while ThreadGroup's activeCount > 0
		while(tg.activeCount()>0) {
			try {
				Thread.sleep(100);
			} catch (InterruptedException ie) {
				// TODO Auto-generated catch block
				ie.getMessage();
			}
		}

		// TODO: after the loop ends, display a message using ShowMessageDialog
		// indicating that the consumer threads have finished
		JOptionPane.showMessageDialog(null, "The consumer threads have finished.");


		// TODO: display an end of program message using ShowMessageDialog
		
	}
	
	/**
	 *  Method loads the pictures from URL
	 */	
	public void loadImages() {		
     Document doc;
     String url = "http://venus.cs.qc.cuny.edu/~aabreu/cs212/images/";
     int j = 0;
        
		try {
			System.out.println("Reading URL directory");
			doc = Jsoup.connect(url).get();
			Elements files = doc.getElementsByTag("a");
			
			// initialize the array size for the file names
			picture = new String[files.size()];
			
			for (Element file : files){
				String filename = file.attr("href");
				if(filename.indexOf(".jpg") >= 0 || filename.indexOf(".gif") >= 0){
					System.out.println(filename);
					picture[j++] = url + filename;
				}
			}
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}

	}
	
	
 
/**
	 *  Method loads the pictures from a local folder
	 */	
	public void loadPictures() {
		// create a reference to an array of Files (type is File)
		File[] pictures;

		// create a reference String for the image directory
		String directory = "images/";

		// create a reference to the directory
		File imgDirectory = new File(directory);

		// store the directory listing in the File array
		pictures = imgDirectory.listFiles();

		// initialize the array size for the file names
		picture = new String[pictures.length];

		// add each image file to the image file array
		for (int i = 0, j = 0; i < pictures.length; i++) {
			File file = pictures[i];

			// add .jpg and .gif file names to the String array
			// you can add other image types
			if (file.isFile()
					&& (file.getName().toLowerCase().endsWith(".jpg") || 
						file.getName().toLowerCase().endsWith(".gif"))) {
				// display the name of the image file
				System.out.println((j + 1) + ": " + pictures[i].getName());

				// add the name to the array
				picture[j] = pictures[i].getName();

				// increment the number of images
				j++;
			}
		}
	}
	
}
