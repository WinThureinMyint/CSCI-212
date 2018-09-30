package list;

public class OrderedList<T extends Comparable<T>> extends List<T> {

	@Override
	public void add(T item) {
		Node<T> trav = front;
		while(trav.getNext() != null 
				&& trav.getNext().getData().compareTo(item) < 0)
			trav = trav.getNext();
		trav.setNext(new Node<T>(item, trav.getNext()));
		size++;
	}

	@Override
	public void remove(T item) {
		boolean found = false, okay = true;
		Node<T> trav = front;
		while(trav.getNext() != null && !found && okay){
			if(trav.getNext().getData().compareTo(item) == 0){
				found = true;
				trav.setNext(trav.getNext().getNext());
				size--;
			}
			else if(trav.getNext().getData().compareTo(item) > 0)
				okay = false;
			else{
				trav = trav.getNext();
			}
		}
	}
	@Override
	public int search(T item) {
		int pos = -1, index = 0;
		boolean found = false, okay = true;
		Node<T> trav = front.getNext();
		while(trav != null && !found && okay){
			if(trav.getData().compareTo(item) == 0){
				found = true;
				pos = index;
			}
			else if(trav.getData().compareTo(item) > 0)
				okay = false;
			else{
				index++;
				trav = trav.getNext();
			}
		}
		return pos;
	}
}
