package algorithm;

import java.util.ArrayList;

import org.jgrapht.Graph;
import org.jgrapht.alg.util.Pair;

import logic.Exam;
import logic.Problem;
import logic.Student;

import utils.Utils;

public class Evaluator {


	private static Graph<Pair<Integer,Integer>, Pair<Integer, Integer>> graph;
	
	
	public static void createGraph(ArrayList<Exam> exams, ArrayList<Integer> days){
		

		for(int i= 0; i < exams.size() ; i++){
			Pair<Integer, Integer> pair = new Pair<Integer, Integer>(i , days.get(i));
			graph.addVertex(pair);
			
		}
		
	}
	
	
	public static double calculateFitness(Individual ind, Problem problem){
		
		
		//HashMap<Integer, Integer> exams = new HashMap<Integer,Integer>();
		
		double fitness = 0;
		
		ArrayList<Integer[]> exame_list = Utils.splitChromossome(ind.getChromossome(), problem.getNumberOfExames());//problem.getNumberOfExames() 
		ArrayList<Integer> exame_days = new ArrayList<Integer>();
			
		// tranform all Byte infomration into concrete info
		for(int i = 0; i < exame_list.size(); i++){
			//exams.put(i, Utils.byteToInt(exame_list.get(i)));
			exame_days.add(Utils.byteToInt(exame_list.get(i)));
		}
		
		exame_days.sort(null); // order arraylist
		
		
		// --------------------------------------
		
		
		ArrayList<Integer> difference = new ArrayList<Integer>();
		
		for(int i = 0; i < exame_days.size() - 1 ; i++){
			int diff = exame_days.get(i + 1) - exame_days.get(i);
	
			// in case of two exams on same day
			if(diff == 0){
				return -1;
			}
			
			difference.add(diff);
		}
		
		
		// try to arrange something bettes
		difference.sort(null);

		fitness += 2 * difference.get(0); 
		
		fitness += difference.get(difference.size() - 1);
		
		
		return fitness;		
	}
	
	/*
	 * 
	 *  - Evitar que haja exames consecutivos
	 *  - maximizar a distancia quando ha alunos em comum
	 *  - dar primazia a estudantes com exame no mesmo ano
	 * 
	 * */
	
	public static Pair<Integer,Integer> verifyExams(Exam e1, Exam e2){
		
		ArrayList<Student> students1 = e1.getStudents();
		ArrayList<Student> students2 = e2.getStudents();
		
		int same_year = 0;
		int diff_year = 0;
		
		for(int i = 0; i < students1.size(); i++){
			
			if(students2.contains(students1.get(i))){
				if(e1.getYear() == e2.getYear()){
					if(e1.getYear() == students1.get(i).getCurrentYear()){
						same_year++;
					}else{
						diff_year++;
					}
				}else{
					diff_year++;
				}
			}
		
		}		
		
		
		return new Pair<Integer, Integer>(same_year, diff_year);
	}
}
