package lab01.excercise.challenge.legacy;

import java.io.PrintStream;
import java.util.Collection;
import java.util.Optional;
import java.util.Scanner;

public class LegacyUserInterface {
	
	private PrintStream out;
	private Scanner in;
	private PersonSearchProviderInterface searchApi;
	
	public LegacyUserInterface(PrintStream out, Scanner in, PersonSearchProviderInterface searchApi) {
		super();
		this.out = out;
		this.in = in;
		this.searchApi = searchApi;
	}

	public void runConsole() {
		
		String entry = null;
		
		while (!"1".equals(entry)) {
			
			out.println("1 ... Quit");
			out.println("2 ... Search for People by Name");
			out.println("3 ... Search for People by ZipCode");
			
			entry = in.next();

			if ("2".equals(entry)) {
				searchByNameConsole();
			} else if ("3".equals(entry)) {
				searchByNameZipCode();
			} 
			
		}
		
	}
	
	private void searchByNameConsole() {
		
		out.print("Please enter name, that you want to search for: ");
		String entry = in.next();
		
		Collection<Person> result = searchApi.searchByName(entry);

		if (result == null || result.isEmpty()) {
			out.println("Nothing found!");
		} else {
			displayList(result);
		}
	}
	
	private void searchByNameZipCode() {

		out.print("Please enter the zip-code, that you want to search for: ");
		String entry = in.next();
		
		if (isNumeric(entry)) {
			
			Integer zip = Integer.valueOf(entry);
			
			Collection<Person> result = searchApi.searchByZipCode(zip);
	
			if (result == null || result.isEmpty()) {
				out.println("Nothing found!");
			} else {
				displayList(result);
			}
		}
		
	}
	
	private void displayList(Collection<Person> result) {
		
		long choice = -1;
		
		while (choice != 0) {
		
			result.stream().forEach(p -> System.out.println(p.toString()));
			out.print("Type 0 to get back to main console, or the id of the person you want to display: ");
			
			String entry = in.next();
			
			if (isNumeric(entry)) {
				choice = Long.parseLong(entry);
				if (choice != 0) {
					Optional<Person> pers = searchApi.readById(choice);
					if (pers.isPresent()) {
						out.println(pers.get().toString());
					}
				}
			}
		}
	}
	
	private boolean isNumeric(String s) {  
	    return s != null && s.matches("[-+]?\\d*\\.?\\d+");  
	}  

}
