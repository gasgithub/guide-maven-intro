package io.openliberty.guides.session;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class SessionServlet
 */
@WebServlet("/SessionServlet")
public class SessionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String localAddr = request.getLocalAddr();
		int localPort = request.getLocalPort();
		String localName = request.getLocalName();
		String serverName = request.getServerName();
		int serverPort = request.getServerPort();
		
		
		out.append("Served at: ").append(request.getContextPath());
		out.println("<BR>");
		out.println("Local: " + localAddr + " | " + localName + " | " + localPort);
		out.println("<BR>");
		out.println("Server: " + serverName + " | " + serverPort);
		out.println("<BR>");
		
		HttpSession httpSession = request.getSession();
		
		Integer counter = (Integer) httpSession.getAttribute("counter");
		if(counter == null) {
			out.println("Session is empty");
			counter = new Integer(0);
		}
		else {
			out.println("Counter = " + counter);
		}
		counter++;
		out.println("<BR>");
		System.out.println("counter= " + counter);
		httpSession.setAttribute("counter", counter);
		
		out.println("<a href='SessionServlet'>Increment counter</a>");
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
