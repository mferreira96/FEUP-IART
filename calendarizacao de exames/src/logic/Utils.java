package logic;

import java.util.ArrayList;

import algorithm.Population;

public class Utils {
	
	public static int byteToInt(Integer[] bits){
		int sum = 0;
		
		int mult = 1;
		
		for(int i = bits.length - 1; i > -1; i--){
			
			sum += mult * bits[i];
			mult *= 2;            //1 2 4 8 16 32 64 .... ou seja multiplicar sempre or 2 a começar em 1
		}

		return sum;	
	}
	
	
	public static ArrayList<Integer[]> splitChromossome(Integer[] bits, int days){
	
		ArrayList<Integer[]> exameDates = new ArrayList<Integer[]>();
		
		int size = bits.length/days;
		
		
		for (int i = 0; i < days; i++) {
		
			Integer[] date = new Integer[size];
			
			System.arraycopy(bits, i * size, date, 0, size);
		
			exameDates.add(date);
		}
			
		return exameDates;
		
	}
	
	public static int getNumberOfbitsNedded(int numberOfDays){
		return (int) Math.ceil(Math.log10(numberOfDays)/Math.log10(2));
	}
	


}

