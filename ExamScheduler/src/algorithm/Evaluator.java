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
	private final Integer P_SAME_YEAR = 12;
	private final Integer P_DIFF_YEAR = 3;
	private final Integer P_DAY = 15;
	private final Integer P_ZERO_CHILDS = 12;
	
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
	public void createGraph(ArrayList<Exam> exams){
		this.graph = new GraphScheuler();
		addAllVertexs(exams);
		addAllNodes(this.graph.getNodes());

	}
	
	

	private void addAllVertexs(ArrayList<Exam> exams){
		
		for(int i = 0 ; i < exams.size(); i++){
			this.graph.addVertex(new VertexScheduler(exams.get(i), 0));
		}
		
	}
	

	private void addAllNodes(ArrayList<VertexScheduler> vertexs){
		
		
		for(int i = 0 ; i < vertexs.size(); i++){
			
			for(int  j = i + 1 ; j < vertexs.size(); j++){
				
				Pair<Integer, Integer> p = verifyExams(vertexs.get(i).getExam(), vertexs.get(j).getExam());
				
				// only create an edge if there is students in common between exams
				
				if(p.getFirst() > 0 || p.getSecond() > 0){
					EdgeScheduler edge1 = new EdgeScheduler(vertexs.get(j), vertexs.get(i), p.getFirst(), p.getSecond()); 
					
				
					int id = this.graph.addEdge(edge1);
					
					vertexs.get(i).addAdjs(id);
					vertexs.get(j).addAdjs(id);
					
					
				}
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
	
	private void updateUnColored() {
		this.graph.updateUnColored();
		
	}
	
	

	public double calculateFitness(Individual ind, Problem problem){
		
		
		double fitness = 0;
		
		ArrayList<Integer[]> exame_list = Utils.splitChromossome(ind.getChromossome(), problem.getNumberOfExames()); 
		ArrayList<Integer> exame_days = new ArrayList<Integer>();
			
		for(int i = 0; i < exame_list.size(); i++){
			exame_days.add(Utils.byteToInt(exame_list.get(i)));
		}
		
		this.updateDays(exame_days);
		this.updateUnColored();
		
		System.out.println("............... HELLO ............");

		
		for(int j = 0 ; j < this.graph.getNodes().size(); j++){
		
			VertexScheduler node = this.graph.getNodes().get(j);
			int childs = node.numberOfConnections();  
			
			System.out.println("taking care of");
			System.out.println(node.toString());
			
			if(childs > 0){
				
				int edgeID = -1;
				int diffDay = 365;
				
				for(int k = 0 ; k < childs ; k++){
					int index = node.getAdjs().get(k);

					VertexScheduler v = this.graph.getEdge(index).getOtherVertex(node);
					
					System.out.println("son ...");
					System.out.println(v.toString());
						
					int tempDiff = v.getDay() - node.getDay();
		
					if(tempDiff < diffDay && tempDiff >  0){
						edgeID = index;
						diffDay = tempDiff;
					}
				
				}
				
				System.out.println("diff_day = " + diffDay); 
				System.out.println("k = " + edgeID);

				
				// revision on how to calc fitness.....
				if(edgeID != -1){
					fitness += diffDay * P_DAY;	
					
					fitness += this.graph.getEdge(edgeID).getDiff_year() * P_DIFF_YEAR;
					fitness += this.graph.getEdge(edgeID).getSame_year() * P_SAME_YEAR;
				}
				
				this.graph.getNodes().get(j).setColored(true);
			
			}else{
				
				fitness += P_ZERO_CHILDS;
				this.graph.getNodes().get(j).setColored(true);
			}
			
		}
		
		
		
		System.out.println("............... BYE ............");

		
		return fitness;		
	}


}
