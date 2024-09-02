package edu.kh.todolist.dao;

import java.sql.Connection;

import edu.kh.todolist.dto.Todo;

public interface TodoDao {

	int todoAdd(Connection conn,String title, String detail) throws Exception ;

}
