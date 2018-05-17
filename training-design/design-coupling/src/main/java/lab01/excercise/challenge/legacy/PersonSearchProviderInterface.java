package lab01.excercise.challenge.legacy;

import java.util.Collection;
import java.util.Optional;

public interface PersonSearchProviderInterface {

	public Optional<Person> readById(long id);
	
	public Collection<Person> searchByName(String nameInput);

	public Collection<Person> searchByZipCode(Integer zipInput);

}
