package edu.kh.todolist.service;

import edu.kh.todolist.dto.Todo;

public interface TodoService {

	int todoAdd(String title, String detail) throws Exception ;

	Todo todoDetailView(int index) throws Exception ;

}
