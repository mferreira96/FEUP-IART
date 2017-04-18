package logic;

import java.util.ArrayList;

public class Problem {

	private ArrayList<Exame> exames;
	private int numberOfDays;
	
	public Problem(ArrayList<Exame> exames,int numberOfDays){
		
		this.exames = exames;
		this.numberOfDays = numberOfDays;
		
	}
	
	
	public int getNumberOfDays() {
		return numberOfDays;
	}
	
	public ArrayList<Exame> getExames() {
		return exames;
	}
	
	public Exame getExame(int Id){
		for (int i = 0; i < exames.size(); i++) {
			if(exames.get(i).getId() == Id){
				return exames.get(i);
			}
		}
		
		return null;
	}
	
	public int getNumberOfExames(){
		return exames.size();
	}
	
}
