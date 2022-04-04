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
		String query2 = "insert into smambers (num,name,id,pw,email) values(3,'�̼���','white','11112','white@naver.com')";
		
		ResultSet ret = null;
		Connection conn = null; // DB���� ��ü����
		Statement stmt = null; // SQL ���� ��ü ����
		
		
		
		try {
			Class.forName(drivername); //mysql jdbc ����̹� ȣ��
			
			conn = DriverManager.getConnection(url,username,password);
			
			System.out.println("DB ���� �Ϸ�!");
			
			stmt = conn.createStatement(); // SQL ����� statment ��ü ����
			
			ret = stmt.executeQuery(query); // SQL ���� - ��ȯ�Ǵ� ������� ResultSet���� ����
 			
			while(ret.next()) {
				
				String pid = ret.getString("id");
				String ppw = ret.getString("pw");
				System.out.println(pid);
				System.out.println(ppw);
			}
			
			int rnum = stmt.executeUpdate(query2); // �������� ��ȯ int 1�̸� ����
			
			if (rnum == 1) {
		//		System.out.println("ȸ��Ż�𼺰�");
				System.out.println("ȸ�����Լ���");
			}
			else{
		//		System.out.println("ȸ��Ż�����");
				System.out.println("ȸ�����Խ���");
			}
			
			
		} catch (ClassNotFoundException e) {
			System.out.println("JDBC ����̹� �ε� ����!");
		} catch (SQLException e) {
			System.out.println("DB ���� ����!");
		}
		
		
		
		
		
	}

}
