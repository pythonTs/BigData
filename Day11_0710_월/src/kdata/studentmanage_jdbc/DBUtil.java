package kdata.studentmanage_jdbc; //  ( /** + ���� ) : /** */�� javadoc

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * <pre>
 * DB���� ���� �����ϴ� Ŭ����
 * Connection ����, ����
 * </pre>
 * 
 * @author Jo_TaeSang
 */

// JDBC ����̹��� �ѹ��� ���־ �ȴ� -> Static���! Ŭ���� �ε��Ҷ� �ѹ��� ���δ�!
public class DBUtil {
	// static �ʱ�ȭ ��� 2���� - ����� ���ÿ� �ʱ�ȭ , static������ ���� �ѹ��� �ʱ�ȭ
	// ���1 :private static int a = 1;
	// ���2 : static {
	// a = 1;
	// }
	private static final String DRIVER_NAME = "oracle.jdbc.driver.OracleDriver";

	static {
		try {
			Class.forName(DRIVER_NAME);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// getConnection() �޼ҵ带 ���� ��� ����
	private static final String CON_URL = "jdbc:oracle:thin:@localhost:1521";
	private static final String USER_ID = "test";
	private static final String USER_PWD = "1234";

	/**
	 * <pre>
	 * �����ͺ��̽� ���� �����ϴ� �޼ҵ�
	 * </pre>
	 * 
	 * @return Connection ������ ���̽� �������� ��ü ��ȯ
	 * @throws SQLException
	 *             static �޼ҵ� �� Ŭ�����̸�.�޼ҵ� �ҷ����� ����
	 */
	public static Connection getConnection() throws SQLException {
		return DriverManager.getConnection(CON_URL, USER_ID, USER_PWD);
	}

	// �ν��Ͻ� ������ ���� ��� static �޼ҵ� ����
	public static void close(Connection con, PreparedStatement pstmt, ResultSet rs) {
		if (rs != null)
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		if (pstmt != null)
			try {
				pstmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		if (con != null)
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}

	// �ν��Ͻ� ������ ���� ��� static �޼ҵ� ����
	public static void close(Connection con, PreparedStatement pstmt) {
		if (pstmt != null)
			try {
				pstmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		if (con != null)
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}

}
