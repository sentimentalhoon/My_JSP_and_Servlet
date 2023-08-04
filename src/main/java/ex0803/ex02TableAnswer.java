package ex0803;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Table")
public class ex02TableAnswer extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		
		out.print(
				"<table style='border:1px solid #000'>"+
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
