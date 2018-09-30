package list;

public class Car implements Comparable<Car> {

	    int year;
	    String make, model;


		@Override
		public int compareTo(Car other) {
			if (!this.make.equalsIgnoreCase(other.make))
	            return this.make.compareTo(other.make);
	        if (!this.model.equalsIgnoreCase(other.model))
	            return this.model.compareTo(other.model);
	        return this.year - other.year;
		}
	
}
