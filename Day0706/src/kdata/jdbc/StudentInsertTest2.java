package kdata.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class StudentInsertTest2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		1.JDBC ����̹� �ε� 
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//�������� �ٲ�°��̱⶧���� import ��Ű�� �ʰ� ��ü��θ� �Է�.
			System.out.println("JDBC ����̹� �ε� ����");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("JDBC ����̹� �ε� ����");
		}
//		2.�����ͺ��̽� ���� ����
		//����̹� �ε��ϸ� �Ŵ����� ���� ����. �ű⿡ getConnection���� ����.
		Connection con = null;//���� ��ġ�� ���� try�� �ȿ� ���� �ؿ��� ���� ����.
		try {
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521", "zook3280", "1234");
			System.out.println("�����ͺ��̽� ���� ���� ����");
			//����Ǹ� sql developer �����ѰͰ� ����.
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("�����ͺ��̽� ���� ���� ����");
		}
		
		//3.statement ��ü ����
		Scanner sc = new Scanner(System.in);
		System.out.println("Please input student's number");
		String snum = sc.nextLine();
		System.out.println("Please input student's name");
		String sname = sc.nextLine();
		System.out.println("Please input student's gender");
		String gender = sc.nextLine();
		System.out.println("Is it right?" + snum +"  " +sname +"  " +gender);
		String sql = "insert into stuinfo values(?,?,?)";
		PreparedStatement pstmt = null;
		try {
			pstmt = con.prepareStatement(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//4. sql�� ����
		int result =0;
		try {
			pstmt.setString(1, snum);
			pstmt.setString(2, sname);
			pstmt.setString(3, gender);
			
			result = pstmt.executeUpdate();
		//	pstmt.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
//		5. ��� ó��
		if(result ==0) {
			System.out.println("mission fail");
		}
		else {
			System.out.println("mission success");
		}
		
//		6. �����ͺ��̽� ���� ���� ����
		try {
			pstmt.close();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
