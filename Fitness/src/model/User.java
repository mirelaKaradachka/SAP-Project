package model;


import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class User {
@Id
private int id;
private String username;
private String password;
private String email;
private String firstName;
private String lastName;

public User(int id, String username, String password, String email, String firstName, String lastName) {
	super();
	this.id = id;
	this.username = username;
	this.password = password;
	this.email = email;
	this.firstName = firstName;
	this.lastName = lastName;
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



}
