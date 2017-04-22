package logic;

import java.util.ArrayList;

public class Problem {

	private ArrayList<Exame> exames;
	private int numberOfDays;
	private int byteDays;
	
	public Problem(ArrayList<Exame> exames,int numberOfDays){
		
		this.exames = exames;
		this.numberOfDays = numberOfDays;
		this.byteDays = Utils.getNumberOfbitsNedded(numberOfDays);
	}
	
	public Problem(int numberOfDays){
		
		this.exames = new ArrayList<Exame>();
		this.numberOfDays = numberOfDays;
		this.byteDays = Utils.getNumberOfbitsNedded(numberOfDays);
		
	}
	
	public int getByteDays() {
		return byteDays;
	}
	
	
	public int getNumberOfDays() {
		return numberOfDays;
	}
	
	public ArrayList<Exame> getExames() {
		return exames;
	}
	
	public Exame getExame(int id){
		
		return exames.get(id);
	}
	
	
	public void addExame(Exame e){
		this.exames.add(e);
	}
	
	
	public int getNumberOfExames(){
		return exames.size();
	}
	
}
