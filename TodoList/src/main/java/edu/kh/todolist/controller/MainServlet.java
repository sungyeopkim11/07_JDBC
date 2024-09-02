package edu.kh.todolist.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import edu.kh.todolist.dto.Todo;
import edu.kh.todolist.service.TodoService;
import edu.kh.todolist.service.TodoServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

// "/main" 요청을 매핑하여 처리하는 서블릿
// "/main" == localhost/main == 메인 페이지
@WebServlet("/main")
public class MainServlet extends HttpServlet {

	
	/* 왜 "/" 메인페이지 요청을 처리하는 서블릿 만들었는가?
	 * - Servlet(back-end)에서 추가한 데이터를
	 *   메인 페이지에서 사용할 수 있게 하려고
	 * 
	 */
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
			String path = "/WEB-INF/views/main.jsp";
			req.getRequestDispatcher(path).forward(req, resp);
	}
	
}
