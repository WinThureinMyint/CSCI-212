package list;

public class UnorderedList<T extends Comparable<T>> extends List<T> {

	@Override
	public void add(T item) {		
		Node<T> trav = front;
		while(trav.getNext() != null)
			trav = trav.getNext();
		trav.setNext(new Node<T>(item));
		size++;
	}

	@Override
	public void remove(T item) {		
		boolean found = false;
		Node<T> trav = front;
		while(trav.getNext() != null && !found){
			if(trav.getNext().getData().compareTo(item) == 0){
				found = true;
				trav.setNext(trav.getNext().getNext());
				size--;
			}
			else{
				trav = trav.getNext();
			}
		}
	}

	@Override
	public int search(T item) {
		int index = 0;
		boolean found = false;
		Node<T> trav = front.getNext();
		while(trav != null && !found){
			if(trav.getData().compareTo(item) == 0){
				found = true;
			}
			else{
				index++;
				trav = trav.getNext();
			}
		}
		return (found) ? index : -1;
	}

}
