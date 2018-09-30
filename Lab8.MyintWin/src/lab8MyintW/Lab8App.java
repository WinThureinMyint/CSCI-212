package lab8MyintW;

import java.io.File;

/**
 * <p>
 * Title: Debugging and Recursive
 * </p>
 * 
 * <p>
 * Description: Use the debugger to trace through the programs. Show the value
 * of each variable and the returned value in each program.
 * </p>
 * 
 * <p>
 * Copyright: Copyright (c) 2018
 * </p>
 * 
 * @author Win Thurein Myint, Kei Nemoto
 *
 */
public class Lab8App {

	public static void main(String[] args) {
		Lab8App recursion = new Lab8App();
		

		System.out.println(recursion.strToNum("12341"));
		System.out.println(recursion.findMin(new int[] { 3, 2, 1, 4, 5 }, 5, 0));
		System.out.println(recursion.isPalindrome("racecar", 0, 6));
		System.out.println(recursion.reverseString("pots&pans"));
		recursion.traverse(new File("J:/"));
		

		LinkedList<String> ulist = new LinkedList<String>();
		String[] str = { "hello", "this", "is", "a", "test" };
		for (String s : str)
			ulist.insert(s);
		System.out.println(ulist);
		Node<String> node = ulist.getfront();
		System.out.println(recursion.countNodes(node));
		
		System.out.println("----1. sum()----");
		System.out.println(recursion.sum(1, 7));
		
		System.out.println("----2. hanoi()----");
		int[] numberOfDiscs= {2,	3,	4,	5,	6,	7,	8,	9,	10,	15,	20,	30,31};
		for(int i=0;i<numberOfDiscs.length;i++) {
			System.out.println("The number of move for " + numberOfDiscs[i] + " discs is " + hanoi(numberOfDiscs[i],'A','B','C'));
		}
		System.out.println("----3. power()----");
		System.out.println(recursion.power(2,7));
		System.out.println("----4. showReverse()----");
		recursion.showReverse(ulist.getfront());
		System.out.println("\n----5. convert()----");
		System.out.println(recursion.convert(1, 7));

	}

	public int strToNum(String str) {
		if (str.length() < 1)
			return 0;
		else
			return ((str.charAt(str.length() - 1) - '0') + (10 * strToNum(str.substring(0, str.length() - 1))));
	}

	private <T> int countNodes(Node<T> trav) {
		if (trav == null)
			return 0;
		return 1 + countNodes(trav.getNext());
	}

	public int findMin(int array[], int size, int index) {
		if (index == size - 1)
			return array[index];
		int result = findMin(array, size, index + 1);
		if (array[index] < result)
			return array[index];
		else
			return result;
	}

	public boolean isPalindrome(String str, int low, int high) {
		if (high <= low)
			return true;
		else if (str.charAt(low) != str.charAt(high))
			return false;
		else
			return isPalindrome(str, low + 1, high - 1);
	}

	public String reverseString(String s) {
		if (s.length() == 0)
			return s;
		return reverseString(s.substring(1)) + s.charAt(0);
	}

	public static void traverse(File file) {
		if (file.isDirectory()) {
			System.out.println(file);
			String dirContents[] = file.list();
			if (dirContents != null)
				for (String directory : dirContents)
					traverse(new File(file, directory));
		}
	}

//	public static void hanoi(int discs) {
//		for (int x = 1; x < (1 << discs); x++) {
//			int from = (x & x - 1) % 3;
//			int to = ((x | x - 1) + 1) % 3;
//			System.out.println("Move " + from + " to " + to);
//		}
//	} no recursion method

	
	/*
	 * 1. Modify the method that calculates the sum of the integers between 1 and N
	 * shown above. Have the new version match the following recursive definition:
	 * The sum of 1 to N is the sum of 1 to (N/2) plus the sum of (N/2 + 1) to N.
	 * Trace your solution using an N of 7.
	 */
	public static int sum(int start, int n) {
		if (start == n) {
			return n;
		}
		return sum(start, (start + n) / 2) + sum((start + n) / 2 + 1, n);
	}
	/*
	 * 2. Modify	the	method,	hanoi,	above into	a	recursive	one,	and	produce	an	Excel	
	 * chart	showing	the	number	of	moves	required	to	solve	the	Towers	of	Hanoi	
	 * puzzle	using	the	 following	
	 * number	of	discs: 2,	3,	4,	5,	6,	7,	8,	9,	10,	15,	20,	30	and	31.
	 */
	private static int [] memoDisc = new int [100];
	public static int hanoi(int discs, char from, char to, char rest){ 	
		if(discs==1) {
			return memoDisc[discs-1] = 1;
		}
		if(memoDisc[discs-1]>0) return memoDisc[discs-1];
		memoDisc[discs-1] = 1 + hanoi(discs-1,from, rest, to);
		memoDisc[discs-1] = memoDisc[discs-1] + hanoi(discs-1,rest,to,from);
		return memoDisc[discs-1];
	}
	/*
	 * 3. Write a recursive definition of x^y, where x and y are integers and y >=
	 * 0. In addition, write the recursive method.
	 */
	public static int power(int x, int y) {
		if (y <= 0)
			return 1;
		int temp;
		if (y % 2 == 0) {
			temp = power(x, (y / 2));
			return temp * temp;
		} else {
			temp = power(x, (y - 1) / 2);
			return x * temp * temp;
		}
	}
	/*
	 * 4. Write a recursive method to display the contents of a linked-list in
	 * reverse order.
	 */
	public static <T> void showReverse(Node<T> trav) {
		if(trav==null) return;
		showReverse(trav.getNext());
		System.out.print(trav.getData() + " ");
	}
	/*
	 * 5. Write a recursive method to convert a number, n, to a base, b, and return
	 * result as a String.
	 */
	private static final char[] table = 
		{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
	
	public static String convert(int target, int base) {
		String ans = "";
		if(target/base == 0) return String.valueOf(table[target]);
		char temp = table[target%base];
		ans = convert(target/base, base) + temp;
		return ans;
	}
}

class Node<E> {
	private E data;
	private Node<E> next;

	public Node() {
		data = null;
		next = null;
	}

	public Node(E d) {
		data = d;
		next = null;
	}

	public Node(E d, Node<E> n) {
		data = d;
		next = n;
	}

	public Node<E> getNext() {
		return next;
	}

	public void setNext(Node<E> n) {
		next = n;
	}

	public E getData() {
		return data;
	}

	public void setData(E data) {
		this.data = data;
	}
}

class LinkedList<T extends Comparable<T>> {

	protected Node<T> head = new Node<T>(); // dummy Node
	protected int numItems;

	public Node<T> getfront() {
		return head.getNext();
	}

	public int getSize() {
		return numItems;
	}

	public boolean isEmpty() {
		return numItems == 0;
	}

	public void insert(T insertItem) {
		if (insertItem == null)
			throw new NullPointerException();
		Node<T> trav = head;
		while (trav.getNext() != null)
			trav = trav.getNext();
		trav.setNext(new Node<T>(insertItem));
		++numItems;
	}

	public String toString() {
		String str = "\n==================================\n" + "The list contains " + numItems + " items.\n"
				+ "==================================\n[";
		Node<T> trav = head.getNext();
		while (trav != null) {
			// str += trav.data + "\n";
			str += trav.getData() + ((trav.getNext() == null) ? "" : "->");
			trav = trav.getNext();
		}
		return str + "]";
	}
}