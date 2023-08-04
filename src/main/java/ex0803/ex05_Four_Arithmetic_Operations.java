package ex0803;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ex05_Four_Arithmetic_Operations
 */
@WebServlet("/FourOperations")
public class ex05_Four_Arithmetic_Operations extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ex05_Four_Arithmetic_Operations() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.print("<html><meta charset=\"UTF-8\" /><head><title>Query 문자열 테스트</title></head>");
		out.print("<body>");
		out.print("<h1>GET 방식으로 요청되었습니다.</h1>");

		request.setCharacterEncoding("UTF-8");
		int first = Integer.parseInt(request.getParameter("first"));
		int second = Integer.parseInt(request.getParameter("second"));
		String op = request.getParameter("op");

		switch (op) {
		case "+":
			out.printf("답: %d %s %d = %d <br/>", first, op, second, (first + second));
			break;
		case "-":
			out.printf("답: %d %s %d = %d <br/>", first, op, second, (first - second));
			break;
		case "*":
			out.printf("답: %d %s %d = %d <br/>", first, op, second, (first * second));
			break;
		case "/":
			out.printf("답: %d %s %d = %d <br/>", first, op, second, (first / second));
			break;
		case "%":
			out.printf("답: %d %s %d = %d <br/>", first, op, second, (first / second));
			break;
		default:
			break;
		}
		
		out.println("</body></html>");
		out.close();
	}

}
