package logic;

import java.util.ArrayList;

public class Student {

	private String name;
	private ArrayList<Exame> examesEpocaNormal;
	private ArrayList<Exame> examesEpocaRecurso;
	
	public Student(String name){
		this.name = name;
		this.examesEpocaNormal = new ArrayList<Exame>();
		this.examesEpocaRecurso = new ArrayList<Exame>();
	}
	
	public String getName() {
		return name;
	}
	
	public ArrayList<Exame> getExamesEpocaNormal() {
		return examesEpocaNormal;
	}
	
	public ArrayList<Exame> getExamesEpocaRecurso() {
		return examesEpocaRecurso;
	}
	
	public void addExameRecurso(Exame e){
		examesEpocaNormal.add(e);
	}
	
	public void addExameNormal(Exame e){
		examesEpocaRecurso.add(e);
	}
}
