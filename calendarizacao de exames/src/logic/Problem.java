package logic;

import java.util.ArrayList;

public class Problem {

	private ArrayList<Exame> exames;
	
	
	public Problem(ArrayList<Exame> exames){
		
		this.exames = exames;
		
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
