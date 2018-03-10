package lab2MyintW;

class Staff extends Employee {
	private double rate, hours;

	public Staff(String n, String i, String o, double r, double h) {
		super(n, i, o);
		rate = r;
		hours = h;
	}

	public double getRate() {
		return rate;
	}

	public void setRate(double rate) {
		this.rate = rate;
	}

	public double getHours() {
		return hours;
	}

	public void setHours(double hours) {
		this.hours = hours;
	}

	public double pay() {
		return hours * rate;
	}
}