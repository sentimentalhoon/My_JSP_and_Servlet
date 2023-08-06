package ex0803;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

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
		response.setContentType("application/json;charset=UTF-8");

		FAO fao = new FAO();

		try (PrintWriter out = response.getWriter()) {
			request.setCharacterEncoding("UTF-8");
			Gson gson = new Gson();
			int first = Integer.parseInt(request.getParameter("first"));
			int second = Integer.parseInt(request.getParameter("second"));
			String op = request.getParameter("op");

			fao = new FAO(200, first, second, op);

			String json = gson.toJson(fao);

			out.println(json);
		}
	}
}

class FAO {
	private int code;
	private int firstNumber;
	private int secondNumber;
	private String op;
	private int numPlus;

	public FAO() {
	}

	public FAO(int code, int firstNumber, int secondNumber, String op) {
		super();
		this.code = code;
		this.firstNumber = firstNumber;
		this.secondNumber = secondNumber;
		this.op = op;
		this.numPlus = getFourOp(this.firstNumber, this.secondNumber, this.op);
	}

	private int getFourOp(int n1, int n2, String op) {
		switch (op) {
		case "+":
			return n1 + n2;
		case "-":
			return n1 - n2;
		case "*":
			return n1 * n2;
		case "/":
			return n1 / n2;
		case "%":
			return n1 % n2;
		default:
			return 0;
		}
	}

	public int getFirstNumber() {
		return firstNumber;
	}

	public void setFirstNumber(int firstNumber) {
		this.firstNumber = firstNumber;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public int getSecondNumber() {
		return secondNumber;
	}

	public void setSecondNumber(int secondNumber) {
		this.secondNumber = secondNumber;
	}

	public String getOp() {
		return op;
	}

	public void setOp(String op) {
		this.op = op;
	}

	public int getPlusN() {
		return numPlus;
	}

	public void setPlusN(int numPlus) {
		this.numPlus = numPlus;
	}

}
