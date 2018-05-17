package lab01.sample.challenge;

public class Employee {
	
	private String name;

	public Employee(String name) {
		super();
		this.name = name;
	}
	
	public String getName() {
		return name;
	}

	public Employee changeName(String newName) {
		return new Employee(newName);
	}

	public static void main(String[] args) {
		
		Employee mye = new Employee("Charlie");
		
		// clean compile, but makes no sense:
		mye.changeName("Alan");
	}

}
