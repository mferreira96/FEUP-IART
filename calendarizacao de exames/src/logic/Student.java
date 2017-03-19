package logic;

import java.util.ArrayList;

public class Student {

	private String name;
	private ArrayList<Subject> subejcts;
	
	public Student(String name){
		this.name = name;
		this.subejcts = new ArrayList<Subject>();
	}
	
	public String getName() {
		return name;
	}
	
	public ArrayList<Subject> getSubejcts() {
		return subejcts;
	}
	
	public void addSubject(Subject s){
		this.subejcts.add(s);
	}
	
	public void removeSubject(Subject s){
		
		if(!this.subejcts.contains(s)){
			System.out.println("The subject does not exist");
			return;
		}
		else{
			this.subejcts.remove(s);
		}
	}
}
