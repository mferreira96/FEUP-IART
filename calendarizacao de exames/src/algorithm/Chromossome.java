package algorithm;

import java.util.ArrayList;

public class Chromossome {
	
	public static void main(String[] args) {
		
		Chromossome c = new Chromossome();
		
		ArrayList<Integer> c1 = new ArrayList<Integer>();
		c1.add(1);
		c1.add(0);
		c1.add(0);
		c1.add(1);
		
		ArrayList<Integer> c2 = new ArrayList<Integer>();
		c2.add(1);
		c2.add(1);
		c2.add(1);
		c2.add(1);
		
		System.out.println(c.crossover(c1,c2,1));
		
		c.mutation(c1, 3);
		
		System.out.println(c1);
	}

	// mudar para um array de bits
	
	public ArrayList<ArrayList<Integer>> crossover(ArrayList<Integer> c1, ArrayList<Integer> c2, int split_index){
		
		//considering split_index, the index before the split
		
		ArrayList<ArrayList<Integer>> out = new ArrayList<ArrayList<Integer>>();
		
		ArrayList<Integer> newC1 = crossAux(c1, c2, split_index);
		
		ArrayList<Integer> newC2 = crossAux(c2, c1, split_index);
				
		
		out.add(newC1);
		out.add(newC2);
		
		return out;
		
	}
	
	private ArrayList<Integer> crossAux(ArrayList<Integer> c1, ArrayList<Integer> c2, int split_index){
		
		ArrayList<Integer> modChromossome= new ArrayList<Integer>();
		
		for (int i = 0; i < c1.size(); i++) {
			
			if(i <= split_index){
				modChromossome.add(c1.get(i));
			}else{
				modChromossome.add(c2.get(i));
			}
		}
		
		return modChromossome;
	}
	
	
	public void mutation(ArrayList<Integer> c1, int index){
		
		if(c1.get(index) == 1)
			c1.set(index,0);
		else
			c1.set(index,1);
		
	}
}
