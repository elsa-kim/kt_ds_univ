

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class AsyncServlet
 */
public class AsyncServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AsyncServlet() {
        super();
       
    }

	/**
	 * GET / POST
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// AsyncServlet은 HTML 데이터를 전송하지 않는다.
		// AsyncServlet이 전송하는 데이터는 반드시 JSON 형태여야 한다
		// JSON = JavaScript Object Notation (자바 스크립트의 객체 표현식) ==> Object Literal : {key : value}
		//
		
		// AJAX API 호출한다 ==> 내 서비스에서 다른서비스의 URL을 호출한다 
		//					==> 우리 프로젝트에서 깃헙, 네이버 ,다음, ,..등의 서비스를 호출
		// 우리 프로젝트 : /sync, /async
		// gmail 프로젝트 : 메일 전송, 메일 읽기 처리, 메일 삭제 처리 
			// 우리 프로젝트: 언어 : Java, server:servlet, DB : oracle
			// gmail : 언어:Python, server:Flask, DB : Mongo (noSQL)
		//요청을 어떻게 할것인가? : URL 체계, 파라미터 전송하는 방법, 데이터 처리하는 방법
			// XML *HTML like ==> XML 분석방법 : 너무 어렵다
			// JSON :  JavaScript Object Literal : 분석이 쉽다
		
		response.getWriter().append("{\"Key\":\"Value\", \"name\":\"sohyun\"}");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
