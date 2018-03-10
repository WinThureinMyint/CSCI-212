package lab2MyintW;

class Student extends Person {
	protected double gpa;

	public Student(String n, String i, double g) {
		super(n, i);
		gpa = g;
	}
}
