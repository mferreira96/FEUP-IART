package algorithm;

import java.util.ArrayList;

import org.jgrapht.alg.util.Pair;

import graph.EdgeScheduler;
import graph.GraphScheuler;
import graph.VertexScheduler;
import logic.Exam;
import logic.Problem;
import logic.Student;

import utils.Utils;

public class Evaluator {


	private  GraphScheuler graph;
	
	private static Evaluator evaluator = new Evaluator(); 
	private final Integer P_SAME_YEAR = 9;
	private final Integer P_DIFF_YEAR = 3;
	private final Integer P_DAY = 9;
	
	public Evaluator(){
		this.graph = new GraphScheuler();
	}
	
	public static Evaluator getInstance(){
		
		if(evaluator == null){
			return new Evaluator();
		}else {
			return evaluator;
		}
	}
	
	// should not be ordered, this way the positions will match
	public void createGraph(ArrayList<Exam> exams, ArrayList<Integer> days){
		
		addAllVertexs(exams, days);
		addAllNodes(this.graph.getNodes());

	}
	
	private void addAllVertexs(ArrayList<Exam> exams, ArrayList<Integer> days){
		
		for(int i = 0 ; i < exams.size(); i++){
			this.graph.addVertex(new VertexScheduler(exams.get(i), days.get(i)));
		}
		
	}
	
	private void addAllNodes(ArrayList<VertexScheduler> vertexs){
		
		
		for(int i = 0 ; i < vertexs.size(); i++){
			
			for(int  j = i + 1 ; j < vertexs.size(); j++){
				
				Pair<Integer, Integer> p = verifyExams(vertexs.get(i).getExam(), vertexs.get(j).getExam());
				
				EdgeScheduler edge = new EdgeScheduler(vertexs.get(j), vertexs.get(i), p.getFirst(), p.getSecond()); 
				
				vertexs.get(i).addAdjs(edge);
				vertexs.get(j).addAdjs(edge);
				
				this.graph.addEdge(edge);
			}
		}
		
	}

	
	private Pair<Integer,Integer> verifyExams(Exam e1, Exam e2){
		
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
		
		
		return new Pair<Integer, Integer>(diff_year, same_year);
	}
	
	
	public void updateDays(ArrayList<Integer> days){
		this.graph.updateAllNodes(days);
	}
	
	
	public double calculateFitness(Individual ind, Problem problem){
		
		
		double fitness = 0;
		
		ArrayList<Integer[]> exame_list = Utils.splitChromossome(ind.getChromossome(), problem.getNumberOfExames()); 
		ArrayList<Integer> exame_days = new ArrayList<Integer>();
			
		for(int i = 0; i < exame_list.size(); i++){
			exame_days.add(Utils.byteToInt(exame_list.get(i)));
		}
		
		this.updateDays(exame_days);
		
		for(int j = 0 ; j < exame_list.size(); j++){
		
		// TODO arranjar uma forma de eu nao ter os exames ordenados, porque eu preciso de fazer a diferencça dos dias...		
			// - Possivel solução por o peso todo no edge, desta forma seria apenas somar
			
		}
		
		
		return fitness;		
	}
	


}
