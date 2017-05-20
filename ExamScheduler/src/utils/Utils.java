package utils;

import java.io.BufferedOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;
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
		
	public static ArrayList<Integer[]> splitChromossome(Integer[] bits, int numExams){
	
		ArrayList<Integer[]> exameDates = new ArrayList<Integer[]>();
		
		int size = bits.length/numExams;
		
		
		for (int i = 0; i < numExams; i++) {
		
			Integer[] date = new Integer[size];
			
			System.arraycopy(bits, i * size, date, 0, size);
		
			exameDates.add(date);
		}
			
		return exameDates;
		
	}
	
	public static int getNumberOfbitsNeeded(int numberOfDays){
		return (int) Math.ceil(Math.log10(numberOfDays)/Math.log10(2));
	}	

	/**
	 * Returns the map sorted by value
	 * 
	 * @param map to be sorted
	 * @return map sorted bye value
	 */
    public static HashMap<Integer, Integer> sortByValue(HashMap<Integer, Integer> map) { 
    	
    	HashMap<Integer, Integer> sortedMap =
                map.entrySet().stream()
                   .sorted(Map.Entry.comparingByValue())
                   .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                                (e1, e2) -> e1, LinkedHashMap::new));    		
    	
    	return sortedMap;	    	
    }
    
}

