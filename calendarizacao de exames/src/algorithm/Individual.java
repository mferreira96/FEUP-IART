package algorithm;

import java.util.Random;

public class Individual {
	
	private Integer[] chromossome;
	private double fitness;

	
	public Individual(int size){
		this.chromossome = new Integer[size];
		this.fitness = -1;
	
	}
	
	public Integer[] getChromossome() {
		return chromossome;
	}
	
	public void setGene(int index, int gene){
		this.chromossome[index] = gene; 
	}
	
	public int getGene(int index){
		return this.chromossome[index];
	}
	
	public void randGenes(){
		Random rand = new Random();
		
		for(int i = 0; i < this.chromossome.length; i++){
			this.setGene(i, rand.nextInt(2));
		}
	}

	
	public double getFitness(){
		return fitness;
	}
	
	public void setFitness(double fit){
		fitness = fit;
	}
	
	public void mutation(int index){
			
		this.setGene(index , 1 - this.getGene(index));
		
	}
	
}