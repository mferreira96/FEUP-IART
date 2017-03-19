package logic;

public class Subject {

	private Exame normalExame;
	private Exame appealExame;
	private String name;
	private int year;
	
	public Subject(String name, int year){
		this.name = name;
		this.year = year;
	}
	
	
	public String getName() {
		return name;
	}
	
	
	public Exame getAppealExame() {
		return appealExame;
	}
	
	
	public Exame getNormalExame() {
		return normalExame;
	}
	
	
	public int getYear() {
		return year;
	}
	
	
	public void setNormalExame(Exame e){
		this.normalExame = e;
	}
	
	public void setAppealExame(Exame e){
		this.appealExame = e;
	}
}
