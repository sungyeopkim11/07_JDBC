package edu.kh.todolist.dto;


import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Todo {
                             
	private int    todoNo;
	private String title;
	private String detail;
	private String complete;
	private String regDate;
}
