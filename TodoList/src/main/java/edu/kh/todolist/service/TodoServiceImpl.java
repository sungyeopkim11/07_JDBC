package edu.kh.todolist.service;

import static deu.kh.todolist.common.JDBCTemplate.*;

import java.sql.Connection;

import deu.kh.todolist.common.JDBCTemplate;
import edu.kh.todolist.dao.TodoDao;
import edu.kh.todolist.dao.TodoDaoImpl;
import edu.kh.todolist.dto.Todo;

public class TodoServiceImpl implements TodoService {

	// 필드
	private TodoDao dao = new TodoDaoImpl(); 
	
	@Override
	public int todoAdd(String title, String detail) throws Exception {
		
		// 1. 커넥션 생성
		Connection conn = getConnection();
		
		int result = dao.todoAdd(conn,title,detail);
		
		if(result > 0) commit(conn);
		else           rollback(conn);
		
		close(conn);
		
		return result;
	}

	@Override
	public Todo todoDetailView(int index) throws Exception {
		
		
		
		return null;
	}

	
}
