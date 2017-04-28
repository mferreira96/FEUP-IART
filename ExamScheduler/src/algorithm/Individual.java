package algorithm;

public class Individual implements Comparable<Individual>{
	
	private Integer[] chromossome;
	private double fitness;

	
	public Individual(int size){
		this.chromossome = new Integer[size];
		this.fitness = -1;
	
		randomInitiator();
	}
	
	
	public void randomInitiator(){
	
		for (int i = 0; i < chromossome.length; i++) {
			if(Math.random() < 0.5){
				this.setGene(i, 1);
			}else{
				this.setGene(i, 0);
			}			
		}
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
	
	public double getFitness(){
		return fitness;
	}
	
	public void setFitness(double fit){
		fitness = fit;
	}
	
	public void mutation(int index){			
		this.setGene(index , 1 - this.getGene(index));
		
	}	

	@Override
	public int compareTo(Individual individual) {
		
		if(this.getFitness() > individual.getFitness()){
			return -1;
		}else if(this.getFitness() < individual.getFitness()){
			return 1;
		}else 
			return 0;
	}	
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		
		sb.append("[");
		for(int i = 0; i < chromossome.length - 1; i++){
			sb.append(chromossome[i]);
			sb.append(",");
		}
		sb.append(chromossome[chromossome.length - 1]);
		sb.append("] -------------------------------- Fitness = ");
		sb.append(this.getFitness()).append("\n");
		
		return sb.toString();
	}	
}