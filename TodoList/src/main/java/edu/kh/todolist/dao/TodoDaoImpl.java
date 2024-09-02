package edu.kh.todolist.dao;

import static deu.kh.todolist.common.JDBCTemplate.*;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

import edu.kh.todolist.dto.Todo;



public class TodoDaoImpl implements TodoDao {

	// 필드
	
		// JDBC 객체 참조 변수 + Propertice 참조 변수 선언
		private Statement stmt;
		private PreparedStatement pstmt;
		private ResultSet rs;
		
		private Properties prop; 
		// -> K, V가 모두 String인 Map, 파일 입출력이 쉬움
		
		// 기본 생성자
		public TodoDaoImpl() {
			
			// 객체 생성 시 
			// 외부에 존재하는 sql.xml 파일을 읽어와
			// prop에 저장
			
			try {
				
				String filePath = 
						TodoDaoImpl.class.getResource("/edu/kh/todolist/sql/sql.xml").getPath();
				
				// 지정된 경로의 XML 파일 내용을 읽어와
				// ProPerties 객체에 K:V 세팅
				prop = new Properties();
				prop.loadFromXML(new FileInputStream(filePath));
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			
		}

		@Override
		public int todoAdd(Connection conn, String title, String detail) throws Exception {
			
			int result = 0;
			
			try {
				
				String sql = prop.getProperty("todoAdd");
				
				pstmt = conn.prepareStatement(sql);
				
				pstmt.setString(1, title);
				pstmt.setString(2, detail);
				
				
				result = pstmt.executeUpdate();
				
			} finally {
				close(pstmt);
			}
			
			return result;
		}
	

























}
