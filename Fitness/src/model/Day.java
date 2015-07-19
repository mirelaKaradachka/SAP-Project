package model;

//annotation
//many to many with User
public class Day {
	private int id;
	private String name;
	private double comparison;
	public Day() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getComparison() {
		return comparison;
	}
	public void setComparison(double comparison){
		this.comparison = comparison;
	}
	
}
