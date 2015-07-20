package model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

//annotation
//many to many with User
@Entity
public class Day {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String name;
	private double comparison;
	
	@ManyToMany(cascade={CascadeType.ALL})
	private Set<Meal> meals;
	
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
