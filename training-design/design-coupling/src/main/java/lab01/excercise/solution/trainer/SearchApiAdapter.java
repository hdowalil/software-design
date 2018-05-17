package lab01.excercise.solution.trainer;

import java.time.ZoneId;
import java.util.Collection;
import java.util.Date;
import java.util.Optional;
import java.util.stream.Collectors;

import lab01.excercise.challenge.cots.SearchApi;
import lab01.excercise.challenge.legacy.Person;
import lab01.excercise.challenge.legacy.PersonSearchProviderInterface;

public class SearchApiAdapter implements PersonSearchProviderInterface {

	@Override
	public Optional<Person> readById(long id) {
		
		return SearchApi.getPerson(id).map(SearchApiAdapter::convertCotsPersonToLegacyPerson);
	}

	@Override
	public Collection<Person> searchByName(String nameInput) {

		Collection<lab01.excercise.challenge.cots.Person> result = SearchApi.findByName(nameInput);
		return result.stream().map(SearchApiAdapter::convertCotsPersonToLegacyPerson).collect(Collectors.toList());
	}

	@Override
	public Collection<Person> searchByZipCode(Integer zipInput) {
		
		Collection<lab01.excercise.challenge.cots.Person> result = SearchApi.findByZipCode(zipInput);
		return result.stream().map(SearchApiAdapter::convertCotsPersonToLegacyPerson).collect(Collectors.toList());
	}
	
	public static Person convertCotsPersonToLegacyPerson(lab01.excercise.challenge.cots.Person input) {
		
		Person result = new Person();
		result.setId(input.getId());
		result.setGivenName(input.getFirstName());
		result.setSurName(input.getFamilyName());
		result.setBirthDay(Date.from(input.getBirthDay().atStartOfDay(ZoneId.systemDefault()).toInstant()));
		result.setStreet(input.getStreet());
		result.setHouseNumber(input.getAdressLine2());
		result.setZipCode(input.getZipCode().toString());
		result.setCity(input.getTown());
		
		return result;
	}

}
