package at.fhj.swd;

public class Student extends Person{
	private float pointAverage;
	
	public Student(String firstName, String lastName, float pointAverage){
		super(firstName, lastName);
		setPointAverage(pointAverage);
	}
	
	@Override
	public String toHtml(){	
		return String.format("<li> %s %s - point average: <em>%f </em></li>",
				getFirstName(),getLastName(),getPointAverage());
	}
	
	public float getPointAverage() {
		return pointAverage;
	}
	private void setPointAverage(float pointAverage) {
		this.pointAverage = pointAverage;
	}
}
