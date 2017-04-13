package app;

import java.util.ArrayList;


import algorithm.Individual;
import logic.Utils;

public class ExameSheduler {

	
	public static void main(String[] args) {
		
		int a = Utils.getNumberOfbitsNedded(32);
		
		System.out.println(a);
		
		
		// ---------
		
		Integer[] b  = new Integer[20];
		int n_iterations = 5;
		
		
		Individual ind = new Individual(20);
		
		ArrayList<Integer[]> c = Utils.splitChromossome(ind.getChromossome(), n_iterations);
		
		System.out.println("arrays ....");		
		
		for(int  i = 0 ; i < c.size() ; i++){
			System.out.print("[");
			for (int j = 0; j < c.get(i).length; j++) {
				System.out.print(c.get(i)[j]);
			}
			System.out.print("] \n");
		}
		
		System.out.println("bits to int .....");
		
		int d = Utils.byteToInt(c.get(0));
		
		System.out.println(d);
	}
	
}
