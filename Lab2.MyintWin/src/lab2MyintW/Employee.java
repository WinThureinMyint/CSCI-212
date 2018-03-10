package lab2MyintW;

abstract class Employee extends Person {
	protected String office;

	public Employee(String n, String i, String o) {
		super(n, i);
		office = o;
	}

	public String getOffice() {
		return office;
	}

	public void setOffice(String office) {
		this.office = office;
	}

	public abstract double pay();

	public String toString() {
		String str = super.toString();
		str += "\nWeekly Salary: " + pay();
		return str;
	}

	public int compareTo(Object o) {
		int result = -1;
		if (o instanceof Faculty)
			result = Double.compare(pay(), ((Faculty) o).pay());
		else if (o instanceof Staff)
			result = Double.compare(pay(), ((Staff) o).pay());
		return result;
	}
	
}