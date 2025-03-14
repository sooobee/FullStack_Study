package jsp_servlet_project1;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ProjectServelet")
// MVC 패턴에서 Model(데이터 베이스에 저장된 데이터를 담는 그릇,클래스 -> JavaBeans)
// MVC패턴에서 View(JSP -> 화면을 구성하는데, 형태는 HTML+JAVA)
// MVC패턴에서 Controller(servlet)

public class ProjectServelet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
