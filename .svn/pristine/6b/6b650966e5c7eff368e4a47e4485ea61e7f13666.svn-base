package com.graction.lumi.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import com.graction.lumi.data.DataStorage;
import com.graction.lumi.data.InitializeManager;


/**
 * Application Lifecycle Listener implementation class InitListener
 *
 */
public class InitListener implements ServletContextListener {
	/*
	@Autowired
	private SqlSession sqlSession;
	*/
	
	/**
	 * Default constructor.
	 */
	public InitListener() {
		// TODO Auto-generated constructor stub
		System.out.println("InitListener");
		
		/*DataTableManager.getInstance().setSqlSession(sqlSession);
		DataTableManager.getInstance().initDBWeatherRegionTable(sqlSession);
		DataTableManager.getInstance().initDBWeatherTable(sqlSession);*/
	}

	/**
	 * @see ServletContextListener#contextDestroyed(ServletContextEvent)
	 */
	public void contextDestroyed(ServletContextEvent arg0) {
		// TODO Auto-generated method stub
		System.out.println("contextDestroyed");
	}

	/**
	 * @see ServletContextListener#contextInitialized(ServletContextEvent)
	 */
	public void contextInitialized(ServletContextEvent arg0) {
		// TODO Auto-generated method stub
		System.out.println("contextInitialized");
		DataStorage.Path_Directory = arg0.getServletContext().getRealPath("/").replaceAll("\\\\", "/");
		InitializeManager.getInstance().initParseData();
//		System.setProperty("javax.xml.bind.JAXBContextFactory", "org.eclipse.persistence.jaxb.JAXBContextFactory");
	}

}
