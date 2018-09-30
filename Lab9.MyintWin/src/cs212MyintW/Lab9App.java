package cs212MyintW;

/**
 * 	Driver class to test the methods in the BinarySearchTree class.
 * 	The BinarySearchTree class uses the following packages:
 * 		- Lab5b:	cs212lib;	(Queue, QueueException)
 *		- Lab7: 	list;		(UnorderedList)
 *	Adjust the import statements in the BST class if necessary.
 */
public class Lab9App {
	
	public static void main(String[] args) {
		
		// Question 1
		
		BinarySearchTree<Integer> bst = new BinarySearchTree<>();
		bst.insert(6);
		bst.insert(11);
		bst.insert(9);
		bst.insert(7);
		bst.insert(4);
		bst.insert(5);
		bst.insert(10);
		bst.insert(2);
		bst.insert(19);
		bst.insert(28);
		bst.insert(1);
		
		System.out.println(bst.height());
		// You should not have access to the the Nodes in the Tree outside of the Tree class.
		// Create public no-param helper methods (see the public, no-param height method) that will
		// call the private level/in/post/pre-order methods.
		

		// Question 2
		int[] myArray = new int[11];
		// TODO: Insert each node in level order
		myArray[0] = 6;
		myArray[1] = 11;
		myArray[2] = 9;
		myArray[3] = 7;
		myArray[4] = 4;
		myArray[5] = 5;
		myArray[6] = 10;
		myArray[7] = 2;
		myArray[8] = 19;
		myArray[9] = 28;
		myArray[10] = 1;

		BinarySearchTree.buildHeap(myArray, 11);
		for (int i = 0; i < myArray.length; i++) {
			System.out.print(myArray[i]+" ");
		}

	}
	
}
