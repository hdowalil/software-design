package lab01.excercise.challenge.cots;

import java.util.Collection;
import java.util.Optional;
import java.util.stream.Collectors;

public class SearchApi {
	
	public static Optional<Person> getPerson(long id) {
		
		return Database.data.stream().filter(p -> p.getId()==id).findFirst();
	}

	public static Collection<Person> findByName(CharSequence searchInput) {
		
		return Database.data.stream().
				filter(p -> p.getFamilyName().contains(searchInput) || p.getFirstName().contains(searchInput)).
				collect(Collectors.toList());
	}
	
	public static Collection<Person> findByZipCode(Number input) {
		
		return Database.data.stream().
				filter(p -> p.getZipCode().equals(input)).
				collect(Collectors.toList());
	}
	
}
