package logic;

import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.text.html.HTMLDocument.Iterator;

public class Exame {
	
	private String name;
	private int id;
	private int year;
	private ArrayList<Student> students;
	private int data;
	
	public Exame(int id ,String name, int year){
		this.name = name;
		this.id = id;
		this.year = year;
		this.students = new ArrayList<Student>();
	}
		
	public int getData() {
		return data;
	}
	
	public void setData(int data){
		this.data = data;
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
	
	public void addStudent(Student st){
		
		if(students.contains(st)){
			System.out.println("The student " + st.getName() + " is already assigned to this exame");
		}else{
			this.students.add(st);
			System.out.println("Student " + st.getName() + "added to exame " + getName());
		}
		
	}

	
	@Override
	public String toString() {
	
		StringBuilder sb = new StringBuilder();
		
		sb.append("Exam -> ").append("Id: ").append(getId()).append(" Name: ").append(getName()).append(" Year: ").append(getYear()).append("\n");
		
		sb.append("Data : ").append(this.data).append("\n");
		
		sb.append("Students: ");
		

		
		for(int i = 0; i  < students.size(); i++){
			
			sb.append("    ").append(students.get(i));
			
		}
		
		
		return sb.toString();
	}
}
