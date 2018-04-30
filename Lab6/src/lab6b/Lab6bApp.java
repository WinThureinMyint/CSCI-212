package lab6b;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

public class Lab6bApp {
	public static void main(String args[]) {
		OrderedArrayList<Packet> orderArrayList = new OrderedArrayList<>();
		// try {
		URL oracle;
		BufferedReader in;
		try {
			oracle = new URL("http://venus.cs.qc.cuny.edu/~ksong/cs212/Lab/packet.dat");
			in = new BufferedReader(new InputStreamReader(oracle.openStream()));
			String inputLine;
			while ((inputLine = in.readLine()) != null) {
				// System.out.println(inputLine);
				String splitArray[] = inputLine.split("\t", 2);
				int postion = Integer.parseInt(splitArray[0]);
				String message = splitArray[1];
				Packet packet = new Packet(postion, message);

				orderArrayList.add(packet);

			}
			// System.out.print(orderArrayList.toString());
			in.close();
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		String str = "";
		orderArrayList = bubbleSort(orderArrayList);
		for (int i = 0; i < orderArrayList.size; i++) {
			str += orderArrayList.get(i).getMessage();
		}
		orderArrayList.clear();
		
		System.out.print(str);
		
	}

	public static OrderedArrayList<Packet> bubbleSort(OrderedArrayList<Packet> array) {
		int n = array.getSize();
        Packet temp;  
         for(int i=0; i < n-1; i++){  
                 for(int j=0; j < (n-i)-1; j++){  
                          if(array.get(j).compareTo(array.get(j+1))==1){       
                                 temp = array.get(j);  
                                 array.set(j,array.get(j+1)); 
                                 array.set(j+1,temp);  
                         }  
                          
                 }  
         }
		return array;  
	}
}
