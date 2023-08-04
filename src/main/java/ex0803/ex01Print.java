package ex0803;



import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class ex01Print extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//service == mian
	
		// 1. request(HttpServletRequest)
		// : client의 요청에 대한 정보들이 담경있는 객체
		
		// 2. response(HttpServletResponse)
		// : 응답에 대한 정보들이 담겨있는 객체
	
		// (1) Servlet에서 웹페이지 화면에 출력해보기
		// --> 웹페이지 출력 == 응답을 되돌려주겠다.
		
		// 1-0)한글 인코딩 잡아주기(반드시 도구 꺼내오기 전에 작성)
		response.setContentType("text/html; charset= UTF-8");
		
		// 1-1)웹 화면 출력을 도와주는 도구 꺼내오기
		PrintWriter out = response.getWriter();
		
		// 1-2) 출력하기
		out.print("<h1>Hello World</h1>");
		out.print("<h2>손지영</h2>");

		// 1~10까지 h3태그로 출력해주세요!
		for (int i = 1; i < 11; i++) {
			out.print("<h3>"+i+"</h3>");
			
		}
		
		
	
	
	
	
	
	
	
	}

}
