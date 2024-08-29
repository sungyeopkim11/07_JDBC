package edu.kh.jdbc.controller;

import java.io.IOException;
import java.util.List;

import edu.kh.jdbc.dto.User;
import edu.kh.jdbc.service.UserService;
import edu.kh.jdbc.service.UserServiceImpl;
import jakarta.security.auth.message.callback.PrivateKeyCallback.Request;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/selectAll")
public class SelectAllServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		UserService userService = new UserServiceImpl();
		try {
		List<User> userList = userService.selectAll();
		
		
		ServletRequest request = null;
		request.setAttribute("userList", userList);
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		
		
		String path = "/WEB-INF/views/selectAll.jsp";
		req.getRequestDispatcher(path).forward(req, resp);
		
		
		
	}
	
}
