package lab7MyintW;

import list.ListEmptyException;
import list.OrderedList;
import list.UnorderedList;
import sort.Sort;

import java.util.Iterator;
/**
 * <p>
 * Title: List Test
 * </p>
 * 
 * <p>
 * Description: add about 10 items to each of the lists, prior to testing each
 * of the other methods
 * </p>
 * 
 * <p>
 * Copyright: Copyright (c) 2018
 * </p>
 * 
 * @author Win Thurein Myint
 *
 */
public class ListApp {
	public static void main(String[] args) {
		String[] str = { "hello", "this", "is", "the", "test", "of", "the", "Iterator", "in", "java" };
		UnorderedList<String> ulist = new UnorderedList<String>();
		OrderedList<String> olist = new OrderedList<String>();
		for (String s : str) {
			ulist.add(s);
			olist.add(s);

		}
		System.out.println("---Print Out Inserted Array---");

		System.out.println("Unorder list \n"+ulist);
		System.out.println("order list \n"+olist);
		System.out.println("--------------------");
		try {
			System.out.println("----------First and last list----------");

			System.out.println(ulist.first());
			System.out.println(ulist.last());
			
			System.out.println(olist.first());
			System.out.println(olist.last());

			System.out.println("--------------------");
		} catch (ListEmptyException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		try {
			System.out.println("----------Remove first----------");
			System.out.println("Unorder list \n"+ulist);
			ulist.removeFirst();
			System.out.println(ulist);

			System.out.println("order list \n"+olist);
			olist.removeFirst();
			System.out.println(olist);
			System.out.println("--------------------");
			
			System.out.println("----------Remove Last----------");
			System.out.println("Unorder list \n"+ulist);
			ulist.removeLast();
			System.out.println(ulist);

			System.out.println("order list \n"+olist);
			olist.removeLast();
			System.out.println(olist);
			System.out.println("--------------------");
			
			System.out.println("----------Remove At Positon----------");
			System.out.println("Unorder list \n"+ulist);
			ulist.removeAtPosition(0);
			System.out.println(ulist);

			System.out.println("order list \n"+olist);
			olist.removeAtPosition(2);
			System.out.println(olist);
			System.out.println("--------------------");
			
			System.out.println("----------Set----------");
			System.out.println("order list \n"+olist);
			ulist.set("Iterator", "Test Set");
			System.out.println(ulist);

			System.out.println("order list \n"+olist);
			olist.set("java", "Test Set");
			System.out.println(olist);
			System.out.println("--------------------");
			Iterator<String> it = ulist.iterator();
			while (it.hasNext())
				System.out.println("->" + it.next());
			
			System.out.println("--------------------");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("ulist.search(str[4]) \t: "+ulist.search(str[4]));
		System.out.println("olist.search(str[4]) \t: "+olist.search(str[4]));
		System.out.println("ulist.search(\"hello\") \t: "+ulist.search("hello"));
		System.out.println("olist.search(\"hello\") \t: "+olist.search("hello"));
		System.out.println("----------Remove----------");
		System.out.println("order list \n"+olist);
		olist.remove("hello");
		System.out.println("order list Removed 'hello' \n"+olist);
		
		System.out.println("ulist list \n"+ulist);
		ulist.remove("test");
		System.out.println("ulist list Removed 'test' \n"+ulist);
		System.out.println("--------------------");
		
		System.out.println(olist);
		System.out.println(ulist);
		System.out.println("--------------------");
		
		Integer[] x = { 5, 4, 2, 6, 1, 7, 3, 33, 44, 55, 22 };
		
		Sort.insertionSort(x);
		System.out.println("--------------------");
		for (int n : x)
			System.out.println(n);
		System.out.println("--------------------");
		Sort.insertionSort(str);
		System.out.println("--------------------");
		for (String s : str)
			System.out.println(s);
	}
}
