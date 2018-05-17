package lab01.excercise.challenge.cots;

import java.time.LocalDate;
import java.time.Month;

public class Person {

	private long id;
	private String firstName;
	private String familyName;
	private LocalDate birthDay;
	private String street;
	private String adressLine2;
	private Integer zipCode;
	private String town;
	
	public Person(long id,String firstName, String familyName, int birthYear, Month birthMonth, int birthDayOfMonth, String street, String adressLine2,
			Integer zipCode, String town) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.familyName = familyName;
		this.birthDay = LocalDate.of(birthYear, birthMonth, birthDayOfMonth);
		this.street = street;
		this.adressLine2 = adressLine2;
		this.zipCode = zipCode;
		this.town = town;
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getFamilyName() {
		return familyName;
	}
	public void setFamilyName(String familyName) {
		this.familyName = familyName;
	}
	public LocalDate getBirthDay() {
		return birthDay;
	}
	public void setBirthDay(LocalDate birthDay) {
		this.birthDay = birthDay;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getAdressLine2() {
		return adressLine2;
	}
	public void setAdressLine2(String adressLine2) {
		this.adressLine2 = adressLine2;
	}
	public Integer getZipCode() {
		return zipCode;
	}
	public void setZipCode(Integer zipCode) {
		this.zipCode = zipCode;
	}
	public String getTown() {
		return town;
	}
	public void setTown(String town) {
		this.town = town;
	}
	
	
}
