package lab4MyintW;


/**
 * <p>
 * Title: Discard Pile Main 
 * </p>
 * 
 * <p>
 * Description: Create discard pile object and Populate the discard pile by pushing cards. 
 * Remove the top cards of 20 and 50 integer number. Display the cards whose references have been stored in the array. 
 * </p>
 * 
 * <p>
 * Copyright: Copyright (c) 2018
 * </p>
 * 
 * @author harrychan
 *
 */
public class Lab4App {
	/**
	 * Main Method
	 * @param args
	 */
	public static void main(String[] args) {
		//created discardPile object
		DiscardPile discardPile = new DiscardPile();
		discardPile.push(new	Card(8));	
		discardPile.push(new	Card(32));	
		discardPile.push(new	Card(48));	
		discardPile.push(new	Card(2));	
		discardPile.push(new	Card(17));	
		discardPile.push(new	Card(20));	
		discardPile.push(new	Card(25));	
		discardPile.push(new	Card(50));	
		discardPile.push(new	Card(19));	
		discardPile.push(new	Card(41));
		System.out.print(discardPile);
		//remove a card	whose integer value	is 20
		Card[] revCard20=discardPile.removeTopCards(new Card(20));
		DiscardPile cardArray = new DiscardPile();
		for(int i=0;i<revCard20.length;i++) cardArray.push(revCard20[i]);
		System.out.print("Card Reference Array "+cardArray);
		
		//clear the discardPile object's data
		discardPile.clearData();
		cardArray.clearData();
		System.out.print(discardPile);
		
		discardPile.push(new	Card(8));	
		discardPile.push(new	Card(32));	
		discardPile.push(new	Card(48));	
		discardPile.push(new	Card(2));	
		discardPile.push(new	Card(17));	
		discardPile.push(new	Card(20));	
		discardPile.push(new	Card(25));	
		discardPile.push(new	Card(50));	
		discardPile.push(new	Card(19));	
		discardPile.push(new	Card(41));
		System.out.print("Card Reference Array "+cardArray);
		System.out.print(discardPile);
		//remove a card	whose integer value	is 50
		Card[] revCard50=discardPile.removeTopCards(new Card(50));
		System.out.print(discardPile);
		for(int i=0;i<revCard50.length;i++) cardArray.push(revCard50[i]);
		System.out.print("Card Reference Array "+cardArray);
		try {
			System.out.print("Peek :"+discardPile.peek());
		} catch (StackEmptyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
