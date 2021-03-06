package controller;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.User;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private EntityManagerFactory factory;

	@Override
	public void init(ServletConfig config) throws ServletException {
		factory = (EntityManagerFactory) config.getServletContext().getAttribute(EntityManagerFactory.class.getName());
	}

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Login() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		doPost(request, response);

		// EntityManager em = factory.createEntityManager();
		// try {
		// em.getTransaction().begin();
		// em.createQuery("select U from User U where U.naame = :name and U.pwd
		// = :pwd", User.class)
		// .setParameter("name", "").getSingleResult();
		// } finally {
		// if (null != em) {
		// em.close();
		// }
		// }

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		User u = new User();
		String username = null;
		String password = null;
		username = (String) request.getParameter("username");
		password = (String) request.getParameter("password");
		if (username != null && !username.isEmpty() && password != null && password.isEmpty()) {
			u.setUsername(username);
		} else {
			response.setStatus(400);
		}

		// tyrsim ot bazata za user s username
		// i parolata dali syvpadat s tekushtata

		EntityManager em = factory.createEntityManager();
		if (em == null) {
			System.out.println("Entity not created.");

		}
		boolean loggedIn = false;
		try {
			if (em.find(u.getClass(), username) == null
					|| em.find(u.getClass(), SettingManager.cryptMD5(password)) == null) {
				// response.sendError(0, "Wrong username or password");
				response.sendError(400, "Not input parameters");
				System.out.println("Wrong username or password");
			} else {
				// tyrsim ot bazata za user s username
				// i parolata dali syvpadat s tekushtata

				System.out.println("Logged succefully!");
				loggedIn = true;
			}
		} finally {
			if (em != null) {
				em.close();
			}
		}

		if (loggedIn) {

			// response.sendRedirect();
		}

	}

}
