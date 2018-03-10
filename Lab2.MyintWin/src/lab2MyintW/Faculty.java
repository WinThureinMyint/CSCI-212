package lab2MyintW;

class Faculty extends Employee {
	private double salary = 1500;

	public Faculty(String n, String i, String o, double s) {
		super(n, i, o);
		salary = s;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public double pay() {
		return salary;
	}
}