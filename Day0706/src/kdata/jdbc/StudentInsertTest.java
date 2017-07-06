package kdata.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class StudentInsertTest {

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
//		3. statement ��ü ����
		//statement ���� ���� callable statement�� �ִµ� �̴� db �Լ��� ȣ���� �ö� ���.
		Statement st = null;
		try {
			st = con.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		4. SQL�� ����
		Scanner sc = new Scanner(System.in);
		
		int result=0;
		try {
			System.out.println("�й� �Է��ϼ���");
			String snum = sc.nextLine();
			System.out.println("�̸��Է��ϼ���");
			String sname = sc.nextLine();
			System.out.println("�����Է�");
			String gender = sc.nextLine();
//			String sql = "insert into stuinfo values ('20157562','���缮','��')";
			String sql = "insert into stuinfo values ('"+snum+"','"+sname+
					"','"+gender+"')";
			System.out.println("�Է��ϽǷ���? �� 1 �ƴ� 2");
			switch(sc.nextInt()){
			case 1:
				result = st.executeUpdate(sql);//�ڵ�Ŀ��
				break;
			default : System.out.println("bye");
			}
			//��ŷ�� �ʹ� ���̴��ؼ� PreparedStatement�� �ٲ� �ϱ�
			
//			st.executeQuery(sql);
			System.out.println(result);
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
			st.close();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
