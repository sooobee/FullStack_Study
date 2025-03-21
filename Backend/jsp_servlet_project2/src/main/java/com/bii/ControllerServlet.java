package com.bii;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ControllerServlet")
public class ControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// post되면,해당 정보를 받아옴
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		// 콘솔에 로그 찍어서 확인 
		System.out.println(username);
		System.out.println(password);
		
		// 객체를 담음
		request.setAttribute("username", username);
		request.setAttribute("password", password);
		
		// 페이지 이동(포워딩): index.jsp에서 받아온 데이터와 함께 result.jsp 페이지로 이동
		request.getRequestDispatcher("result.jsp").forward(request, response);
	}

}
