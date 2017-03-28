package at.fhj.swd;

import java.io.PrintWriter;
import java.util.ArrayList;

public class Main {

	
	private static void printStudentsList(ArrayList<Student> students, PrintWriter writer){
		writer.println("<ul>");
		for(Student student : students){
			writer.println(student.toHtml());
		}
		writer.println("</ul>");
	}

	private static void printLecturersList(ArrayList<Lecturer> lecturers, PrintWriter writer){
		writer.println("<ul>");
		for(Lecturer lecturer : lecturers){
			writer.println(lecturer.toHtml());
		}
		writer.println("</ul>");
		
	}	

	private static void printPersonsList(ArrayList<Person> persons, PrintWriter writer){
		writer.println("<ul>");
		for(Person person : persons){
			writer.println(person.toHtml());
		}
		writer.println("</ul>");
	}
	
	
	private static void printHtml(Person person){
		System.out.println("<html><ul>" + person.toHtml() + "</ul></html>");
	}
	
	public static void main(String[] args) {
		ArrayList<Person> students = new ArrayList<>();
		students.add(new Student("Stephanie", "Student", 1.3F));
		students.add(new Student("Franz", "Faul", 3.8F));
		
		
		ArrayList<Person> lecturers = new ArrayList<>();
		lecturers.add(new Lecturer("Erwin","Ernst", 2900F));
		lecturers.add(new Lecturer("Ludwig","Lässig", 3200));

		PrintWriter writer = new PrintWriter(System.out);
		printPersonsList(students, writer);
		printPersonsList(lecturers, writer);
		writer.close();
		
		Object object = new Student ("a", "b", 1f);
		Object student = new Student ("a", "b", 1f);
		object.getClass();
		student.getClass();
		/*
		Student student = new Student("Max", "Muster", 1.9f);
		Lecturer lecturer = new Lecturer("Martina", "Muster", 2000.0f);
		Person person = new Person("Paul", "Person");
		
		printHtml(student);
		printHtml(lecturer);
		printHtml(person);
		*/
		/*
		ArrayList<Student> students = new ArrayList<>();
		students.add(new Student("Stephanie", "Student", 1.3F));
		students.add(new Student("Franz", "Faul", 3.8F));
		
		
		ArrayList<Lecturer> lecturers = new ArrayList<>();
		lecturers.add(new Lecturer("Erwin","Ernst", 2900F));
		lecturers.add(new Lecturer("Ludwig","Lässig", 3200));

		PrintWriter writer = new PrintWriter(System.out);
		printStudentsList(students, writer);
		printLecturersList(lecturers, writer);
		writer.close();
		*/
	}

	
}
