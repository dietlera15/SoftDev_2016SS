package at.fhj.swd;

public abstract class Person {
	private String firstName;
	private String lastName;
	
	public Person (String firstName, String lastName) {
		setFirstName(firstName);
		setLastName(lastName);
	}
	
	public String toHtml(){
		return String.format("<li> %s - %s </li>",
				getFirstName(),getLastName());
	}

	public String getFirstName() {
		return firstName;
	}
	private void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName.toUpperCase();
	}
	private void setLastName(String lastName) {
		this.lastName = lastName;
	}
}
