package logic;

public class Student {

	private String name;
	private int id;
	private int currentYear;
	
	public Student(String name, int id, int currentYear){
		this.name = name;
		this.id = id;
		this.currentYear = currentYear;
	}
	
	public String getName() {
		return name;
	}
	
	public int getId() {
		return id;
	}

	public int getCurrentYear() {
		return currentYear;
	}
	
	@Override
	public String toString() {		
		StringBuilder sb = new StringBuilder().append("Student: ").append("Id: ").append(getId()).append(" Name: ").append(getName());
		
		sb.append(" Current year: ").append(getCurrentYear()).append("\n");
		
		return sb.toString();
	}
}
