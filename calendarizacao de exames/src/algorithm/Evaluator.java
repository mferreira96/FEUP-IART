package algorithm;

import java.util.ArrayList;

import logic.Problem;
import logic.Utils;

public class Evaluator {

	
	public static double calculateFitness(Individual ind, Problem problem){
		
		double fitness = 0;
		
		ArrayList<Integer[]> exame_list = Utils.splitChromossome(ind.getChromossome(), problem.getNumberOfExames());//problem.getNumberOfExames() 
		ArrayList<Integer> exame_days = new ArrayList<Integer>();
	
		// tranform all Byte infomration into concrete info
		for(int i = 0; i < exame_list.size(); i++){
			exame_days.add(Utils.byteToInt(exame_list.get(i)));
		}
		
		exame_days.sort(null); // order arraylist
		
		
		ArrayList<Integer> difference = new ArrayList<Integer>();
		
		for(int i = 0; i < exame_days.size() - 1 ; i++){
			difference.add(exame_days.get(i + 1) - exame_days.get(i));
		}
		
		
		// try to arrange something bettes
		difference.sort(null);

		fitness += 2 * difference.get(0); 
		
		fitness += difference.get(difference.size() - 1);
		
		
		return fitness;
	
		
	}
	
}
