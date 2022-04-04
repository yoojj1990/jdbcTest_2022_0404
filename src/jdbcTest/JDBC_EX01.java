package jdbcTest;

import java.sql.*;

public class JDBC_EX01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String drivername = "com.mysql.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/student_db";
		String username = "root";
		String password = "yoojj1990";
		String query = "select * from smambers";
	//	String query2 = "delete from smambers where id='hong'";
		String query2 = "insert into smambers (num,name,id,pw,email) values(3,'이순신','white','11112','white@naver.com')";
		
		ResultSet ret = null;
		Connection conn = null; // DB연결 객체선언
		Statement stmt = null; // SQL 실행 객체 선언
		
		
		
		try {
			Class.forName(drivername); //mysql jdbc 드라이버 호출
			
			conn = DriverManager.getConnection(url,username,password);
			
			System.out.println("DB 연결 완료!");
			
			stmt = conn.createStatement(); // SQL 실행용 statment 객체 생성
			
			ret = stmt.executeQuery(query); // SQL 실행 - 반환되는 결과값을 ResultSet으로 받음
 			
			while(ret.next()) {
				
				String pid = ret.getString("id");
				String ppw = ret.getString("pw");
				System.out.println(pid);
				System.out.println(ppw);
			}
			
			int rnum = stmt.executeUpdate(query2); // 성공여부 반환 int 1이면 성공
			
			if (rnum == 1) {
		//		System.out.println("회원탈퇴성공");
				System.out.println("회원가입성공");
			}
			else{
		//		System.out.println("회원탈퇴실패");
				System.out.println("회원가입실패");
			}
			
			
		} catch (ClassNotFoundException e) {
			System.out.println("JDBC 드라이버 로드 에러!");
		} catch (SQLException e) {
			System.out.println("DB 연결 에러!");
		}
		
		
		
		
		
	}

}
