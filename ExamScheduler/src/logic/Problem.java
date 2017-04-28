package logic;

import java.util.ArrayList;

import utils.Utils;

public class Problem {

	private ArrayList<Exam> exames;
	private int numberOfDays;
	private int byteDays;
	
	public Problem(ArrayList<Exam> exames,int numberOfDays){		
		this.exames = exames;
		this.numberOfDays = numberOfDays;
		this.byteDays = Utils.getNumberOfbitsNedded(numberOfDays);
	}
	
	public Problem(int numberOfDays){		
		this.exames = new ArrayList<Exam>();
		this.numberOfDays = numberOfDays;
		this.byteDays = Utils.getNumberOfbitsNedded(numberOfDays);		
	}
	
	public int getByteDays() {
		return byteDays;
	}	
	
	public int getNumberOfDays() {
		return numberOfDays;
	}
	
	public ArrayList<Exam> getExames() {
		return exames;
	}
	
	public Exam getExame(int id){		
		return exames.get(id);
	}	
	
	public void addExame(Exam e){
		this.exames.add(e);
	}	
	
	public int getNumberOfExames(){
		return exames.size();
	}	
}
