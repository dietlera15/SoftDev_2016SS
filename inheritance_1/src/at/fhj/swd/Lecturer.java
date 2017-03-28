package at.fhj.swd;

public class Lecturer extends Person{
	private float salary;
	
	public Lecturer(String firstName, String lastName, float salary){
		// In der ersten Zeile immer das Konstruktorchaining ausführen
		// super() ruft den Konstruktor der Vererbten Klasse auf
		// in unserem Fall Person
		super(firstName, lastName);
		setSalary(salary);
	}
	
	@Override
	public String toHtml(){	
		return String.format("<li>%s %s - <em>%.2f â‚¬</em></li>",
				getFirstName(),getLastName(),getSalary());
	}

	public float getSalary() {
		return salary;
	}
	private void setSalary(float salary) {
		this.salary = salary;
	}
}
