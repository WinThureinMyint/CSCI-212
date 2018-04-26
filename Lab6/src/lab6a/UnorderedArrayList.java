package lab6a;

public class UnorderedArrayList<T> extends ArrayList<T>{
	
	public UnorderedArrayList() {
		super(); // with this code or not it gonna call partent constructor
	}
	
	public UnorderedArrayList(int capacity) {
		super(capacity);
	}
	
	/**
     * add method - adds an item to this list
     * @param insertItem is a reference to the item to be added
     * @return <i>true</i> if item was added, <i>false</i> otherwise
     */
	@Override
	public boolean add(T insertItem) {
		// TODO Just add the item to the array 
		if(isFull()) {
			return false;
		}
		data[size]=insertItem;
		size++;
		return true;
	}
	/**
     * Returns the index of the first occurrence of the specified item (key) in this list
     * @param searchItem is a reference to an item whose key-field has been initialized
     * @return the location of the first occurrence of the specified item in this list; 
     * if searchItem is not found, -1 is returned
     */
	@Override
	public int indexOf(T searchItem) {
		// TODO Auto-generated method stub
		// use a loop to serach for the item
		// hint: use the .equeals() method,
		// not the == operator
		// return the index # if found
		// otherwise, return -1 if item not found
		return 0;
	}
	 /**
     * Returns the index of the last occurrence of the specified item (key) in this list
     * @param searchItem is a reference to an item whose key-field has been initialized
     * @return the location of the last occurrence of the specified item in this list; 
     * if searchItem is not found, -1 is returned
     */
	@Override
	public int lastIndexOf(T searchItem) {
		// TODO Auto-generated method stub
		return 0;
	}
	/**
     * contains method - determines whether or not the searchItem (key)is in this list
     * @param searchItem is a reference to an item whose key-field has been initialized
     * @return <i>true</i> if the item is in this list, <i>false</i> otherwise 
     */
	@Override
	public boolean contains(T searchItem) {
		// TODO Find searchItem
		//return true if found
		//return false if not
		return false;
	}
    /**
     * get method - returns the item at the specified location in this list
     * @param index is the index of the item in this list
     * @return the item, if it is in this list, otherwise null is returned
     */
	@Override
	public T get(int index) {
		// TODO return item at index
		// Make sure "index" is within the correct range
		// index >=0 && index <size
		// return item at index
		// if not, return null
		return null;
	}
    /**
     * Removes the first occurrence of the specified item from this list, if it is present
     * @param removeItem is a reference to an item whose key-field has been initialized
     * @return the item, if it is in this list, otherwise null is returned
     */
	@Override
	public T remove(T removeItem) {
		// TODO
		// Find the removeItem in the array
		// return null if not found
		// First, Store the item found in a variable 
		// shift the sequence element to the blank(adjust the array)
		// decrease size by 1
		//return the stored item 
		return null;
	}
    /**
     * Removes the item at the specified location from this list, if it is present
     * @param index is the index of the item in this list
     * @return the item, if it is in this list, otherwise null is returned
     */
	@Override
	public T remove(int index) {
		// TODO check if index is withing the correct range
		// If not, return null
		// otherwise , do the same as above 
		return null;
	}

}
