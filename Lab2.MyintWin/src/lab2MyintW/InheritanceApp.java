package lab2MyintW;

public class InheritanceApp {
	public static void main(String[] args) {
		Faculty faculty = new Faculty("Dave Watson", "N00543210", "B3038", 2000);
		Staff staff = new Staff("Mary Smith", "N00975310", "C3078", 49, 35);
		Student student = new Student("John Doe", "N00123456", 2.54);
		System.out.println(faculty);
		System.out.println(student);
		System.out.println(staff);
		System.out.println("The employee with the higher pay");

		// A polymorphic reference
		Person[] person = new Person[] { faculty, staff, student };
		// Late or dynamic binding
		for (int i = 0; i < person.length; i++)
			System.out.println(person[i]);
		
		switch (staff.compareTo(faculty)) {
		case -1:
			System.out.println(faculty.getName()+" get pay higher than "+staff.getName());
			break;
		case 0:
			System.out.println(faculty.getName()+"'s pay is equal with "+staff.getName());
			break;
		case 1:
			System.out.println(staff.getName()+" is pay higher than "+faculty.getName());
			break;
		}
	}
}
