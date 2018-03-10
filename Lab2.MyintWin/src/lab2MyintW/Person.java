package lab2MyintW;

class Person {
	protected String name, id;

	public Person(String n, String i) {
		name = n;
		id = i;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String toString() {
		String str = "******************************";
		str += "\nName: " + name + "\nID: " + id;
		str += "\nEmail Address: " + email();
		return str;
	}

	public String email() {
		String[] nameArray = name.split(" ");
		return nameArray[0].charAt(0) + nameArray[1] + "@qc.cuny.edu";
	}
}