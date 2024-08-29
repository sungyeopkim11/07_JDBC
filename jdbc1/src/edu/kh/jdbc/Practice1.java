package edu.kh.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class Practice1 {
	public static void main(String[] args) {
		
		
		// EMPLOYEE 테이블에서
		// 사번, 이름, 성별, 급여, 직급명, 부서명을 조회
		// 단, 입력 받은 조건에 맞는 결과만 조회하고 정렬할 것
				
		// - 조건 1 : 성별 (M, F)
		// - 조건 2 : 급여 범위
		// - 조건 3 : 급여 오름차순/내림차순
				
		// [실행화면]
		// 조회할 성별(M/F) : F
		// 급여 범위(최소, 최대 순서로 작성) : 3000000 4000000
		// 급여 정렬(1.ASC, 2.DESC) : 2

		
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet  rs   = null;
		
		
		
		try {
			// Connection 생성
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			String url = "jdbc:oracle:thin:@localhost:1521:XE"; // 드라이버의 종류
			String userName ="KH_KSY"; // 사용자 계정명
			String password = "KH1234"; // 계정 비밀번호
			
			conn = DriverManager.getConnection(url, userName, password);
			
			
			
			// SQL 작성
			Scanner sc = new Scanner(System.in);
			
			System.out.print("조회할 성별(M/F) : ");
			String gender = sc.nextLine().toUpperCase();
			
			System.out.print("급여 범위(최소, 최대) : ");
			int min = sc.nextInt();
			int max = sc.nextInt();

			
			
			System.out.print("급여 정렬(1.ASC,2.DESC) : ");
			int sorting = sc.nextInt();
			
			
			
			
			String sql = """
					SELECT 
						EMP_ID 사번,
						EMP_NAME 이름,
						DECODE(SUBSTR(EMP_NO, 8, 1), '1', 'M', '2', 'F') 성별,
						SALARY 급여,
						JOB_NAME 직급명,
						NVL(DEPT_TITLE, '없음') 부서명
					FROM EMPLOYEE
					JOIN JOB USING (JOB_CODE)
					JOIN DEPARTMENT ON (DEPT_CODE = DEPT_ID)
					WHERE DECODE(SUBSTR(EMP_NO, 8, 1), '1', 'M', '2', 'F') = ?
					AND SALARY BETWEEN ? AND ?
					ORDER BY SALARY """;
			
			// 정렬 방식 설정
			if(sorting == 1) sql += " ASC";
			else             sql += " DESC";
			
			
			pstmt = conn.prepareStatement(sql);
			
			// ?에 값 세팅
			pstmt.setString(1, gender);
			pstmt.setInt(2, min);
			pstmt.setInt(3, max);
			
			rs = pstmt.executeQuery();
			
			boolean flag = true;
			// true : 조회 결과가 없음 / false : 조회 결과 존재함
			
			while(rs.next()) {
				
				flag = false;
				// while :
				
				String empId = rs.getString("사번");
				String empName = rs.getString("이름");
				String gen   = rs.getString("성별");
				int    salary = rs.getInt("급여");
				String jobName = rs.getString("직급명");
				String deptTitle = rs.getString("부서명");
				
				
				System.out.printf(
						"%-4s | %3s | %-4s | %7d | %-3s  | %s \n",
						empId, empName, gen, salary, jobName, deptTitle);
			}
			
			
			if(flag) { // flag == true인 경우 -> 조회결과 없음
				System.out.println("조회 결과 없음");
			}
			
			
			
			
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			
			try {
				
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
}
