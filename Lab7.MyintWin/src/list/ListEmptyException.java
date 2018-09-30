package list;

public class ListEmptyException extends Exception {

	public ListEmptyException() {
		super("List Empty Exception...");
	}

	public ListEmptyException(String message) {
		super(message);
	}
}