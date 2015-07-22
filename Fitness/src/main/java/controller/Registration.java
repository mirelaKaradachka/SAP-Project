package controller;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.User;

/**
 * Servlet implementation class Registration
 */
@WebServlet("/Registration")
public class Registration extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private EntityManagerFactory factory;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Registration() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String username;
		String password;
		String repassword;
		String email;
		String firstName;
		String lastName;
		int age;
		String Age;
		String ismale;
		boolean isMale;
		username = (String) request.getParameter("username");
		password = (String) request.getParameter("password");
		repassword = (String) request.getParameter("repassword");
		email = (String) request.getParameter("email");
		firstName = (String) request.getParameter("firstName");
		lastName = (String) request.getParameter("lastName");
		ismale = (String) request.getParameter("isMale");
		Age = (String) request.getParameter("age");
		age = Integer.parseInt(Age);
		
		//Validacii !!!
		
		if(ismale.equalsIgnoreCase("male")){
			isMale = true;
		}
		else
			isMale = false;
		
		//trqbuva data mladej
		if (password != repassword) {
			response.sendError(400, "Passwords do not match");
		}

		if (username == null || username.isEmpty() || password == null || password.isEmpty() || email == null
				|| email.isEmpty()) {
			
			response.sendError(400, "Invalid data input");
		}

		// MD5
		String cryptPass = SettingManager.cryptMD5(password);
		password = cryptPass;

		// Email validation
		String emailreg = "^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
		Boolean validEmail = email.matches(emailreg);
		if (!validEmail) {
			response.setStatus(400);
			response.setContentType("Invalid email");
		}
		

		// checked in DB
		User u = new User();
		EntityManager em = factory.createEntityManager();
		try {
			if (em.find(u.getClass(), username) == null && em.find(u.getClass(), email) == null) {
				User user = new User(username,password,email,firstName,lastName,age,isMale);
			} 
		} finally {
			if (em != null) {
				em.close();
			}
		}

//		response.sendRedirect();
		
	}
}
