package practice.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class Ex01_Connection {
	
	public static void main(String[] args) {
		
		// 1. DB 접속 -> Connection 클래스 사용
		Connection conn	 = null;
		
		// 2. DB서버 접족
		// 호스트명 : 서버 IP or 도메인 주소 localhost
		// 포트번호 : 1521
		// 드라이버 : "thin(oci)"
		// 사용자명 : "hr"
		// 비밀번호 : "java1234"
		
		// 연결 문자열 세팅 (Connection String)
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String id = "hr";
		String pw = "java1234";
		
		// JDBC 작업은 외부 입출력 -> 예외 처리 필수
		try {
			// 3. JDBC 관련 드라이버 로딩
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			// 4. Connection 객체 생성 + 오라클 접속
			conn = DriverManager.getConnection(url, id, pw);
			
			// 5. 필요한 업무 진행 . . .
			System.out.println(conn.isClosed());
			
			// 6. 접속 종료
			conn.close();
			System.out.println(conn.isClosed());
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
