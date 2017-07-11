package kdata.studentmanage_jdbc; //  ( /** + 엔터 ) : /** */은 javadoc

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * <pre>
 * DB서버 연결 관리하는 클래스
 * Connection 생성, 종료
 * </pre>
 * 
 * @author Jo_TaeSang
 */

// JDBC 드라이버는 한번만 해주어도 된다 -> Static사용! 클래스 로드할때 한번만 쓰인다!
public class DBUtil {
	// static 초기화 방법 2가지 - 선언과 동시에 초기화 , static영역을 만들어서 한번에 초기화
	// 방법1 :private static int a = 1;
	// 방법2 : static {
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

	// getConnection() 메소드를 위한 상수 선언
	private static final String CON_URL = "jdbc:oracle:thin:@localhost:1521";
	private static final String USER_ID = "test";
	private static final String USER_PWD = "1234";

	/**
	 * <pre>
	 * 데이터베이스 서버 연결하는 메소드
	 * </pre>
	 * 
	 * @return Connection 데이터 베이스 연결정보 객체 변환
	 * @throws SQLException
	 *             static 메소드 는 클래스이름.메소드 불러오기 가능
	 */
	public static Connection getConnection() throws SQLException {
		return DriverManager.getConnection(CON_URL, USER_ID, USER_PWD);
	}

	// 인스턴스 변수가 없을 경우 static 메소드 선언
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

	// 인스턴스 변수가 없을 경우 static 메소드 선언
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
