package algorithm;

import java.util.ArrayList;

import logic.Exame;

public class GeneticAlgorithm {
	
	private final int MAX_ITERATIONS;	
	private double MUTATION_RATE;
	private double CROSSOVER_RATE;
	private final int POPULATION_SIZE;
	private Population population;
	


	
	public GeneticAlgorithm(int iterations, double mutation_rate, double crossover_rate, int cromossomeLength){
		this.MAX_ITERATIONS = iterations;
		this.MUTATION_RATE = mutation_rate;
		this.CROSSOVER_RATE = crossover_rate;
		this.POPULATION_SIZE = 20;
		
		this.population = new Population(this.POPULATION_SIZE,cromossomeLength);
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
			fitness += calcFitness(population.getIndividuals().get(i));
		}
		
		population.setPopulationFitness(fitness);
	}
	
	public double calcFitness(Individual ind){
		
		
		// TODO Fitness function
		return 0;
	}
	
}
