package logic;


public class Student {

	private String name;
	private Integer id;
	
	public Student(String name, Integer id){
		this.name = name;
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public Integer getId() {
		return id;
	}

	@Override
	public String toString() {
		
		
		StringBuilder sb = new StringBuilder().append("Student: ").append("Id: ").append(getId()).append(" Name: ").append(getName()).append("\n");
		
		return sb.toString();
	}
}
