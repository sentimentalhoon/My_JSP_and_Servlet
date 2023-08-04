package ex0803;


import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ex02Table
 */
public class ex02Table extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		
		out.print(
				"<table border=1>"+
						"<tr>"
							+ "<td>" +1+"</td>"
							+ "<td>"+2+"</td>"
							+ "<td>"+3+"</td>"
							+ "<td>"+4+"</td>"
							+ "<td>"+5+"</td>"
							+ "<td>"+6+"</td>"
						+ "</tr>"
				+ "</table>"
					
				 );
	}

}
