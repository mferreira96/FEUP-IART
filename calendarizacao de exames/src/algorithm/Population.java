package algorithm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;


public class Population {

	private ArrayList<Individual> individuals;
	private double fitness;
	private int populationSize;
	
	
	public Population(int populationSize, int cromossomeLength){
		this.individuals = new ArrayList<Individual>();
		this.fitness = -1;
		this.populationSize = populationSize;

		
		initiatePopulation(this.populationSize, cromossomeLength);
	
	}
	
	public void initiatePopulation(int populationSize, int chromossomeLength){
	
		for (int i = 0; i < populationSize; i++) {
			
			addIndividual(new Individual(chromossomeLength));
		}
	
	}
	
	public ArrayList<Individual> getIndividuals() {
		return individuals;
	}
	
	public void addIndividual(Individual ind){
		individuals.add(ind);
	}
	
	
	public double getPopulationFitness(){
		return fitness;
	}
	
	
	public int getPopulationSize() {
		return populationSize;
	}
	
	
	public void setPopulationFitness(double fitness){
		this.fitness = fitness;
	}
	
	
	public Individual getFittest(){
		
		this.getIndividuals().sort(null);
		
		return individuals.get(0);
	}

}
