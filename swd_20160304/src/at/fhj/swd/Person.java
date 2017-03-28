package at.fhj.swd;

public class Person {
	private String firstName;
	private String lastName;

	public Person(String firstName, String lastName) {
		if (firstName == null  || lastName == null) {
			this.firstName = firstName;
			this.lastName = lastName;
		} else {
			System.out.println("Nix gibts!");
			throw new IllegalArgumentException();
		}
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String toHtml() {
		return String.format("<tr> <td> %s </td> " + "<td>%s</td> </tr>", firstName, lastName);
	}
}