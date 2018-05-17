package lab01.sample.solution;

import java.util.Objects;

import javax.annotation.CheckReturnValue;
import javax.annotation.Nonnull;
import javax.annotation.concurrent.Immutable;

@Immutable
public class Employee {
	
	private String name;

	public Employee(@Nonnull CharSequence name) {
		
		super();
		
		Objects.requireNonNull(name);
		
		this.name = name.toString();
	}
	
	public String getName() {
		return name;
	}

	@CheckReturnValue
	public Employee changeName(@Nonnull CharSequence newName) {
		
		Objects.requireNonNull(newName);
		
		Employee result = new Employee(newName);
		
		assert result != null && result.name != null;
		
		return result;
	}
	
	public static void main(String[] args) {
		
		Employee mye = new Employee("Charlie");
		
		// should now make findbugs create a warning
		mye.changeName("Alan");
	}

}

