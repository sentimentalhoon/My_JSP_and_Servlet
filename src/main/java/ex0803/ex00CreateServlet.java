package ex0803;


import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


	//Servlet 생명주기(Life Cycle)
	// (1) 생성자 호출(1번만 호출)	--> 부모클래스 메소드 사용
	// (2) init 호출(1번만 호출)	--> 부모클래스 메소드 사용
	// (3) 요청이 들어올 때 까지 Servlet 대기상태
	// (4) service 메소드 호출(요청 들어올때마다 호출 다능하다!)
	// (5) server가 종료되면 destroy 호출

public class ex00CreateServlet extends HttpServlet {
	// 모든 Servlet은 HttpServlet을 상속받고 있다
	// -> HttpServlet 부모클래스가 가지고 있는 메소드를 가져와서 사용가능하다
	// -> 메소드 재정의(오버라이딩) 가능하다!

	// 1) 직렬화하는 과정에서 Servlet임을 알려주는 ID값
	private static final long serialVersionUID = 1L;
	// 클래스 파일 --> byte code 변환
	// 단순한 text를 byte code로 변화는 것은 어려운일 아니다!!!
	// 객체는 byte code로 변환을 배열로 만드는 복잡한 과정을 거침
	// ----> 직렬화 과정
   
	
	// 2) 생성자 : 객체 생성, 초기화
    public ex00CreateServlet() {
        super();
        System.out.println("생성자 호출");
    }

	// 3)initialize : 서블릿을 초기화 시키는 메서드
    // --> 초기값을 설정하는 메서드로, 딱 한번만 실행 되는 메소드
    // --> 초기화 시킨다는 것은 많은 자원을 필요로하기때문에, 딱 한번만 호출된다!
	public void init(ServletConfig config) throws ServletException {
		
		System.out.println("서블릿 init 호출");
	}

	
	// 4) destroy : sever가 종료되었을때, Servlet을 지워주는 메소드
	// --> server가 꺼질 때, 한번 호출 되는 메서드
	public void destroy() {

		System.out.println("서블릿 destroy  호출");
	}

	// 5) ★★★★★★★"service", doGet, doPost★★★★★★★★★
	// --> Client의 요청을 처리해주는 메소드
	// 요청방식(GET, POST, PUT, DELETE...)은 다양함
	// service 메소드 : 요청방식의 구분 없이, 어떤 요청이 들어오더라도 처리해 줄수 있는 메소드
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("서블릿 service 호출");
	}

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
