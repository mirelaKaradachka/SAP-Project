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
//1.2 		Desk job with little exercise
//1.375 	1-3 hrs/wk of light exercise
//1.55 		3-5 hrs/wk of moderate exercise
//1.725 	5-6 hrs/wk of strenuous exercise
//1.9 		7-21 hrs/wk of strenuous exercise/work 	Very heavy exercise (twice per day, extra heavy workouts)
private double activityLevel;
//String koito se zima ot padashtoto menu na stranica User Info.
private String activityLevelStirng;
private int achievementPoints;
private String workOutPlan;
private String aim;
private double callories;
private double protein;
private double fats;
private double carbohydrates;


@ManyToMany(cascade={CascadeType.ALL})
private Set<Day> days;

public User() {
	super();
}
public User(String username,String password,String email,String firstName,String lastName,int age,boolean isMale) {
	this();
	setUsername(username);
	setPassword(password);
	setEmail(email);
	setFirstName(firstName);
	setLastName(lastName);
	setAge(age);
	setMale(isMale);
	
}

public void update(double weight,double height,String activityLevelStirng,String aim){
	setWeight(weight);
	setHeight(height);
	setActivityLevelStirng(activityLevelStirng);
	setActivityLevel(this.activityLevelStirng);
	setAchievementPoints(0);
	setAim(aim);
	setMacros();
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

public void setActivityLevel(String activityLevelStirng) {
	switch(activityLevelStirng){
	case "Rarely exercise":  activityLevel=1.2;
    break;
	case "Light exercise (1-3 hours)":  activityLevel=1.375;
    break;
	case "Moderate exercise (3-5 hours)" :  activityLevel=1.55;
	break;
	case "Strenuous esercise  (5-6 hours)" :  activityLevel=1.725;
	break;
	case "Strenuous esercise  (7-21 hours)" :  activityLevel=1.9;
	break;
	default: activityLevel=1.2;break;
	}
	
}

public int getAchievementPoints() {
	return achievementPoints;
}

public void setAchievementPoints(int achievementPoints) {
	if(achievementPoints>=0 && achievementPoints<= MAX_ACHIEVEMENT_POINTS)
	this.achievementPoints = achievementPoints;
}

public String getWorkOutPlan() {
	return workOutPlan;
}

public void setWorkOutPlan(String workOutPlan) {
	if(workOutPlan != null && !workOutPlan.isEmpty())
	this.workOutPlan = workOutPlan;
}

public String getAim() {
	return aim;
}
public void setAim(String aim) {
	this.aim = aim;
}
public String getActivityLevelStirng() {
	return activityLevelStirng;
}
public void setActivityLevelStirng(String activityLevelStirng) {
	this.activityLevelStirng = activityLevelStirng;
}

public double getCallories() {
	return callories;
}
public void setCallories() {
	if(isMale){
		this.callories = (66 + 13.7*weight + 5*height - 6.8*age)*activityLevel;
	}else{
		this.callories =(655 + 9.6*weight + 1.8*height - 4.7*age)*activityLevel;
	}
	
}
public double getProtein() {
	return protein;
}
public void setProtein(double protein) {
	this.protein = protein;
}
public double getFats() {
	return fats;
}
public void setFats(double fats) {
	this.fats = fats;
}
public double getCarbohydrates() {
	return carbohydrates;
}
public void setCarbohydrates(double carbohydrates) {
	this.carbohydrates = carbohydrates;
}

public void setMacros(){
	 setCallories();
	 setProtein(weight*2.2);
	 if(aim=="Clean bulk"){
		 callories+=250;
	 }else if(aim=="Lose fat - 5%"){
		 callories*=0.95;
	 }else if(aim=="Lose fat - 10%"){
		 callories*=0.90;
	 }else if(aim=="Lose fat - 15%"){
		 callories*=0.85;
	 }else if(aim=="Lose fat - 20%"){
		 callories*=0.80;
	 }else if(aim=="Lose fat - 25%"){
		 callories*=0.75;
	 }
	 setCarbohydrates(Math.round(((callories - protein*4)/3)/2));
	 setFats(Math.round(((callories - protein*4)/3)/9));
}
@Override
public String toString() {
	return "User [id=" + id + ", username=" + username + ", password=" + password + ", email=" + email + ", firstName="
			+ firstName + ", lastName=" + lastName + ", age=" + age + ", isMale=" + isMale + ", weight=" + weight
			+ ", height=" + height + ", activityLevel=" + activityLevel + ", activityLevelStirng=" + activityLevelStirng
			+ ", achievementPoints=" + achievementPoints + ", workOutPlan=" + workOutPlan + ", aim=" + aim
			+ ", callories=" + callories + ", protein=" + protein + ", fats=" + fats + ", carbohydrates="
			+ carbohydrates + ", days=" + days + "]";
}

}
