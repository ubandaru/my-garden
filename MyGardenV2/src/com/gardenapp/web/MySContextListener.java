package com.gardenapp.web;

import java.net.UnknownHostException;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import com.mongodb.MongoClient;


public class MySContextListener implements ServletContextListener{

	@Override
	public void contextInitialized(ServletContextEvent scevent) {
		ServletContext sc = scevent.getServletContext();
		String dbhost = sc.getInitParameter("MONGODB_HOST");
		int dbport = Integer.parseInt(sc.getInitParameter("MONGODB_PORT"));
		try {
			MongoClient mongo = new MongoClient(dbhost, dbport);
			sc.setAttribute("mongoclient", mongo);
			System.out.println("Inside Listener");
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Override
	public void contextDestroyed(ServletContextEvent scevent) {
		MongoClient mongo = (MongoClient) scevent.getServletContext().getAttribute("mongoclient");
		mongo.close();
		scevent.getServletContext().setAttribute("mongoclient", null);
	}

	
}
