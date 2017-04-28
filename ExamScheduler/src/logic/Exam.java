package logic;

import java.util.ArrayList;

public class Exam {
	
	private String name;
	private int id;
	private int year;
	private ArrayList<Student> students;
	private int date;
	
	public Exam(int id ,String name, int year){
		this.name = name;
		this.id = id;
		this.year = year;
		this.students = new ArrayList<Student>();
	}
		
	public int getDate() {
		return date;
	}
	
	public void setDate(int date){
		this.date = date;
	}
	
	public String getName(){
		return name;
	}
	
	public int getId() {
		return id;
	}
	
	public int getYear() {
		return year;
	}
	
	public  ArrayList<Student> getStudents() {
		return students;
	}
	
	public void addStudent(Student student){	
		
		if(students.contains(student)){
			System.out.println("The student " + student.getName() + " is already assigned to this exame");
		}else{
			this.students.add(student);
			System.out.println("Student " + student.getName() + " added to exame " + getName());
		}		
	}

	
	@Override
	public String toString() {	
		StringBuilder sb = new StringBuilder();
		
		sb.append("Exam -> ").append("Id: ").append(getId()).append(" Name: ").append(getName()).append(" Year: ").append(getYear()).append("\n");		
		sb.append("Data : ").append(this.date).append("\n");		
		sb.append("Students: ");	
		
		for(int i = 0; i  < students.size(); i++)			
			sb.append("    ").append(students.get(i));	
		
		return sb.toString();
	}
}
