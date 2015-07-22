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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		doPost(request, response);
		
		EntityManager em = factory.createEntityManager();
		try{
			em.getTransaction().begin();
			em.createQuery("select U from User U where U.naame = :name and U.pwd = :pwd", User.class).setParameter("name", "").getSingleResult();
		}finally{
			if(null != em){
				em.close();
			}
		}
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		User u = new User();
		String username = null ; 
		String password = null;
				username = (String)request.getAttribute("username") ;
				password = (String)request.getAttribute("password") ;
				
				if(username != null && !username.isEmpty() && password !=null && password.isEmpty()){
					u.setUsername(username); 
					response.setStatus(200);
				}else
				{
					response.setStatus(400);
				}
				
				// tyrsim ot bazata za user s username 
				//i parolata dali syvpadat s tekushtata
				
				
		
	}

}
