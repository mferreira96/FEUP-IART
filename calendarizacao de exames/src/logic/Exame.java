package logic;

public class Exame {

	private int day;
	private int month;
	private int year;
	private int hour;
	
	public Exame(int day, int month, int year, int hour){
		this.day = day;
		this.month = month;
		this.year = year;
	}
	
	public int getDay() {
		return day;
	}
	
	public int getMonth() {
		return month;
	}
	
	public int getYear() {
		return year;
	}
	
	// cada exame e representado por um array de bits (tamanho 5)
}
