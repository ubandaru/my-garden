package com.gardenapp.web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.gardenapp.model.PlantsDao;

/**
 * Servlet implementation class ShowServlet
 */
@WebServlet("/ShowServlet")
public class ShowServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		List<String> plants = new ArrayList<String>();
		HttpSession session = request.getSession();
		
		if (request.getParameter("ask")!=null) {
			System.out.println("ask is not null");
			session.setAttribute("zipcode", request.getParameter("zipcode"));
			session.setAttribute("ask", request.getParameter("ask"));
			PlantsDao myPlants = new PlantsDao();
			plants = myPlants.getPlants(request.getServletContext());
			session.setAttribute("plants", plants);
		} 
		
		if (request.getParameter("back")!= null) {
			System.out.println("Back is not null");
			session.removeAttribute("plants");
		}
		
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("/jsp/Plants.jsp");
		requestDispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
