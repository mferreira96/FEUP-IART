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
		this.hour = hour;
	}
	
	public int getDay() {
		return day;
	}
	
	
	public int getHour() {
		return hour;
	}
	
	public int getMonth() {
		return month;
	}
	
	public int getYear() {
		return year;
	}
}
