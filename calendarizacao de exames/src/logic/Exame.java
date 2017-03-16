package logic;

public class Exame {

	private int day;
	private int month;
	private int year;
	private int hour;
	private int duration;
	
	public Exame(int day, int month, int year, int hour, int duration){
		this.day = day;
		this.month = month;
		this.year = year;
		this.hour = hour;
		this.duration = duration;
	}
	
	public int getDay() {
		return day;
	}
	
	public int getDuration() {
		return duration;
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
