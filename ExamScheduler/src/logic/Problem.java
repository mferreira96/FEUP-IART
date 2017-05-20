package logic;

import java.util.ArrayList;

import utils.Utils;

public class Problem {

	private ArrayList<Exam> exams;
	private ArrayList<Student> students;
	private int numberOfDays;
	private int byteDays;
	private long duration;
	
	public Problem(){
		this.exams = new ArrayList<Exam>();
		this.students = new ArrayList<Student>();
	}
	
	public Problem(ArrayList<Exam> exams,int numberOfDays){		
		this.exams = exams;
		this.numberOfDays = numberOfDays;
		this.byteDays = Utils.getNumberOfbitsNeeded(numberOfDays);
	}
	
	public Problem(int numberOfDays){		
		this.exams = new ArrayList<Exam>();
		this.students = new ArrayList<Student>();
		this.numberOfDays = numberOfDays;
		this.byteDays = Utils.getNumberOfbitsNeeded(numberOfDays);		
	}
	
	public void setNumberOfDays(int numberOfDays){
		this.numberOfDays = numberOfDays;
		this.byteDays = Utils.getNumberOfbitsNeeded(numberOfDays);
	}
	
	public int getByteDays() {
		return byteDays;
	}	
	
	public int getNumberOfDays() {
		return numberOfDays;
	}
	
	public ArrayList<Exam> getExams() {
		return exams;
	}
	
	public Exam getExam(int id){		
		return exams.get(id);
	}	
	
	public void addExam(Exam exam){
		this.exams.add(exam);
	}	
	
	public int getNumberOfExames(){
		return exams.size();
	}
	
	public void addStudent(Student student){
		this.students.add(student);
	}

	public ArrayList<Student> getStudents() {
		return students;
	}	
	
	public long getDuration(){
		return duration;
	}
	
	public void setDuration(long time){
		duration = time;
	}
	
	@Override
	public String toString(){
		String result = "";
		
		for (int i = 0; i < exams.size(); i++)
			result += exams.get(i).getDate()+" - ";			
		
		result += "duration = ";
		result += duration + " ms";
		
		return result;			
	}
}
