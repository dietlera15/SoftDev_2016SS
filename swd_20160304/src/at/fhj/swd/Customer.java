package at.fhj.swd;

public class Customer {

	private String firstName;
	private String lastName;
	private String address;
	private String city;
	private String zipCode;
	private String country;

	public Customer(String firstName, String lastName, String address, String city, String zipCode, String country) {
		setFirstName(firstName);
		setLastName(lastName);
		setAddress(address);
		setCity(city);
		setZipCode(zipCode);
		setCountry(country);
	}

	public String getLastName() {
		return lastName;
	}

	private void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	private void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getAddress() {
		return address;
	}

	private void setAddress(String address) {
		if (address == null || address.length() == 0) {
			throw new IllegalArgumentException("Address must not be null or empty");
		}
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	private void setCity(String city) {
		this.city = city;
	}

	public String getZipCode() {
		return zipCode;
	}

	private void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public String getCountry() {
		return country;
	}

	private void setCountry(String country) {
		this.country = country;
	}

}