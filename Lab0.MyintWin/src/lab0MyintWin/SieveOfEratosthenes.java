
package lab0MyintWin;


import java.util.Scanner;


/**
*   <b>Title:</b> Lab 0<br>
*   <b>Filename:</b> SieveOfEratosthenes.java<br>
*   <b>Date Written:</b> January 31, 2018<br>
*   <b>Due Date:</b> February 5, 2018<br>
*   <p>
*   <b>Description:</b><br>
*   Displays prime numbers using The Sieve of Eratosthenes.
*   </p>
*   <p>
*   The user is permitted to enter a value for n, and then all prime numbers
*   in the range 2 to n are displayed.
*   </p>
*   <p><b>Algorithm:</b></p>
*   <p>
*   We start  with a table of numbers  (e.g., 2, 3, 4, 5, ..., n) and progressively
*   cross off numbers in the table until the only numbers left are primes.</p>
*   <p> Specifically, we  begin with the first number, p, in the table , and<br>
*   1.   Declare p to be prime, then display it<br>
*   2.   Cross off all the multiples of that number in the table, starting from  p^2 <br> 
*   3.   Find  the  next  number in  the table after p that  is  not yet crossed off and
*   set  p to that number; and then  repeat steps 1 to 3.
*	</p>
* 	@author Win Thurein Myint
*/
public class SieveOfEratosthenes {
	public static void main (String [] args) {
		System.out.print("Type the number range(2-n) : ");
		int range=new Scanner(System.in).nextInt();
		int[] numbers = new int[range];
		for(int i=1;i<numbers.length;i++) {
			numbers[i]=i+1;
		}
		System.out.print("The numbers are : ");
		arrayPrint(numbers);
		System.out.println();
		System.out.print("The Prime in the range 2 to "+range+" : ");
		arrayPrint(primeNumber(numbers,range));
		System.out.println();
		System.out.print("End of Program");
	}
	private static int[] primeNumber(int[] numbers,int range) {
		for(int i=2;i<=Math.sqrt(range);i++) {	 
			for(int j=i*i;j<=range;j+=i) {
				for(int a=0;a<numbers.length;a++) {
					if(numbers[a] == j) {
						numbers[a]=0;
					}
				}
			}
		}
		return numbers;
	}
	static void arrayPrint(int[] numbers) {
		for(int i=1;i<numbers.length;i++) {	
			if(numbers[i] != 0) {
				System.out.print(numbers[i]+" ");	
			}
		}
	}
}
