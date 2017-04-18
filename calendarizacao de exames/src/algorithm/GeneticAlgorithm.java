package algorithm;

import java.util.ArrayList;

import logic.Exame;
import logic.Problem;
import logic.Utils;

public class GeneticAlgorithm {
	
	private final int MAX_ITERATIONS;	
	private double MUTATION_RATE;
	private double CROSSOVER_RATE;
	private final int POPULATION_SIZE;
	private Population population;
	private Problem problem;


	
	public GeneticAlgorithm(int iterations, double mutation_rate, double crossover_rate, Problem problem){
		this.MAX_ITERATIONS = iterations;
		this.MUTATION_RATE = mutation_rate;
		this.CROSSOVER_RATE = crossover_rate;
		
		
		this.problem = problem;
		
		this.POPULATION_SIZE = 20;
		int size = Utils.getNumberOfbitsNedded(this.problem.getNumberOfDays()) * problem.getNumberOfExames();
		
		this.population = new Population(this.POPULATION_SIZE,size);
	}
	
	public Problem getProblem(){
		return problem;
	}
	
	
	public double getCROSSOVER_RATE() {
		return CROSSOVER_RATE;
	}
	
	public int getMAX_ITERATIONS() {
		return MAX_ITERATIONS;
	}
	
	public double getMUTATION_RATE() {
		return MUTATION_RATE;
	}
	
	public Population getPopulation(){
		return population;
	}
	
	public void evalPopulation(){
		
		double fitness = 0;
		
		for(int i = 0;  i< population.getIndividuals().size();i++){
			//fitness += calcFitness(population.getIndividuals().get(i));
		}
		
		population.setPopulationFitness(fitness);
	}
	
	public void calcFitness(Individual ind){
		
		// TODO Fitness function
		
		int fitness = 0;
		
		ArrayList<Integer[]> exame_list = Utils.splitChromossome(ind.getChromossome(), this.problem.getNumberOfExames());//problem.getNumberOfExames() 
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
		
		
		ind.setFitness(fitness);
	

	
	}
	
	public void mutatePopulation(){
		
		// TODO mutate population
		
	}
	
	
	public void crossoverPopulation(){
		
		// TODO crossover Population
	}
	
	
	public boolean isTerminated(){
		
		//TODO condition to terminate
		
		return true;
	}
	
}
