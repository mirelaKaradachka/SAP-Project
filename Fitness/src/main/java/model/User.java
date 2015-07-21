package model;


import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class User {
private static final int MAX_ACHIEVEMENT_POINTS = 1000;
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
private int id;
private String username;
private String password;
private String email;
private String firstName;
private String lastName;
private int age;
private boolean isMale;
//kg
private double weight;
//cm
private double height;
//1- 1.8
private double activityLevel;
private int achievementPoints;
private String workOutPlan;

@ManyToMany(cascade={CascadeType.ALL})
private Set<Day> days;

public User() {
	super();
}


public int getId() {
	return id;
}

//public void setId(int id) {
//	this.id = id;
//}

public String getUsername() {
	return username;
}

public void setUsername(String username) {
	if(username != null || username != "")
	this.username = username;
}

public String getPassword() {
	return password;
}

public void setPassword(String password) {
	if(password != null || password != "")
	this.password = password;
}

public String getEmail() {
	return email;
}

public void setEmail(String email) {
	if(email != null || email != "")
	this.email = email;
}

public String getFirstName() {
	return firstName;
}

public void setFirstName(String firstName) {
	if(firstName != null || firstName != "")
	this.firstName = firstName;
}

public String getLastName() {
	return lastName;
}

public void setLastName(String lastName) {
	if(lastName != null || lastName != "")
	this.lastName = lastName;
}


public int getAge() {
	return age;
}

public void setAge(int age) {
	if(age>0)
	this.age = age;
}

public boolean isMale() {
	return isMale;
}

public void setMale(boolean isMale) {
	this.isMale = isMale;
}

public double getWeight() {
	return weight;
}

public void setWeight(double weight) {
	if(weight>0)
	this.weight = weight;
}

public double getHeight() {
	return height;
}

public void setHeight(double height) {
	if(height>0)
	this.height = height;
}

public double getActivityLevel() {
	return activityLevel;
}

public void setActivityLevel(double activityLevel) {
	if(activityLevel>=1 && activityLevel<=1.8)
	this.activityLevel = activityLevel;
}

public int getAchievementPoints() {
	return achievementPoints;
}

public void setAchievementPoints(int achievementPoints) {
	if(achievementPoints>0 && achievementPoints<= MAX_ACHIEVEMENT_POINTS)
	this.achievementPoints = achievementPoints;
}

public String getWorkOutPlan() {
	return workOutPlan;
}

public void setWorkOutPlan(String workOutPlan) {
	if(workOutPlan != null && !workOutPlan.isEmpty())
	this.workOutPlan = workOutPlan;
}

}
