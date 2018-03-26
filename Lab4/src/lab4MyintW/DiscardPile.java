package lab4MyintW;

/**
 * <p>
 * Title: Discard Pile Class
 * </p>
 * 
 * <p>
 * Description: implement the operations that can be performed on a discard
 * pile. A discard pile contains 0 or more cards. A player in a card game can
 * either choose to place a new card onto the discard pile or pick up 1 or more
 * cards from the pile.
 * </p>
 * 
 * <p>
 * Copyright: Copyright (c) 2018
 * </p>
 * 
 * @author harrychan
 *
 */
public class DiscardPile extends Stack<Card> {
	// Maximum size of Discard Pile should be 100
	// 0 cards should be in the discard pile initially
	DiscardPile() {
		super();
	}

	public Card[] removeTopCards(Card theCard) {
		int index = 0;
		boolean done = false;
		while (!done && index < getSize() - 1)
			try {

				done = getData(index).equals(theCard);
				index++;
			} catch (StackEmptyException se) {
				se.getMessage();
			}
		index--;
		Card[] card = new Card[index];

		for (int i = 0; i < index; i++)
			try {
				card[i] = pop();
			} catch (StackEmptyException se) {
				System.out.println("Stack is empty");
			}
		

		return card;
	}

}
