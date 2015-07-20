package listener;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class EntityManagerFactoryLifecycle implements ServletContextListener{

	private EntityManagerFactory factory;
	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		// TODO Auto-generated method stub
		if(factory != null){
			factory.close();
		}
	}

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		// TODO Auto-generated method stub
		factory = Persistence.createEntityManagerFactory("fitness");
		ServletContext sc = arg0.getServletContext();
		sc.setAttribute(EntityManagerFactory.class.getName(), factory);
	}

}
