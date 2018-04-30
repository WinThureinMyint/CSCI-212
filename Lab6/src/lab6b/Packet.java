package lab6b;


public class Packet implements Comparable<Packet> {
	private int position;
	private String message;
	
	public Packet(int p, String m) {
		position = p;
		message = m;
	}
	
	public int getPosition() {
		return position;
	}
	
	public String getMessage() {
		return message;
	}
	
	public void setPosition(int p) {
		position = p;
	}
	
	public void setMessage(String m) {
		message = m;
	}

	@Override
	public int compareTo(Packet otherProduct) {
		int result = -1;
		if(otherProduct instanceof Packet) {
			if(this.getPosition() > otherProduct.getPosition()) result = 1;
			else if(this.getPosition() < otherProduct.getPosition()) result = -1;
			else result = 0;
		}
		return result;
	}
	/**
     * toString method -- creates and returns a String which represents the state of the object
     * @return a String containing the current values of prodId, quantity, and price
     */
	@Override
    public String toString()
    {
        return "Positon: " + position + " Message: " + message ;
    }
}
