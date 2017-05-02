package logic;

import java.util.ArrayList;

public class Student {

	private String name;
	private int id;
	private int currentYear;
	private ArrayList<Exam> exams;
	boolean hasDisciplinesToDo = false;
	
	public Student(int id, String name, int currentYear){
		this.id = id;
		this.name = name;
		this.currentYear = currentYear;
		this.exams = new ArrayList<Exam>();
	}
	
	public String getName() {
		return name;
	}
	
	public int getId() {
		return id;
	}

	public int getCurrentYear() {
		return currentYear;
	}
	
	public void addExam(Exam exam){
		exams.add(exam);
		
		if(currentYear == exam.getYear())
			hasDisciplinesToDo = true;
	}
	
	public ArrayList<Exam> getExams(){
		return exams;
	}
	
	public boolean hasDisciplinesToDo(){
		return hasDisciplinesToDo;
	}
	
	@Override
	public String toString() {		
		StringBuilder sb = new StringBuilder().append("Student: ").append("Id: ").append(getId()).append(" Name: ").append(getName());
		
		sb.append(" Current year: ").append(getCurrentYear()).append("\n");
		
		return sb.toString();
	}
}
