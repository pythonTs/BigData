package kdata.studentmanage_jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentManagerDAO {
	/**
	 * <pre>
	 * DB�� Student���̺� �л����� insert
	 * </pre>
	 * 
	 * @param s
	 * @return int
	 * @throws SQLException
	 */
	public int insert(Student s) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		int result = 0;
		try {
			con = DBUtil.getConnection();
			String sql = "insert into student values(?,?,?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, s.getsNum());
			pstmt.setString(2, s.getsName());
			pstmt.setString(3, s.getGender());
			// 5.
			result = pstmt.executeUpdate();
			System.out.println(result);

		} finally {
			// 6.
			DBUtil.close(con, pstmt);

		}
		return result;
	}

	/**
	 * <pre>
	 * DB�� Student ���̺��� ������� ���
	 * </pre>
	 * 
	 * @return List<Student>
	 * @throws SQLException
	 */
	public List<Student> selectAll() throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<Student> list = new ArrayList<>();
		try {
			con = DBUtil.getConnection();
			String sql = "select * from student";
			pstmt = con.prepareStatement(sql);
			// 5.
			rs = pstmt.executeQuery();

			// �� ������ŭ ����! //rs.next()�� ��ȯ���� boolean
			while (rs.next()) {
				Student stu = new Student(rs.getString("snum"), rs.getString("sname"), rs.getString("gender"));
				list.add(stu);
			}
		} finally {
			DBUtil.close(con, pstmt, rs);
		}
		return list;
	}

	/**
	 * <pre>
	 * DB�� �л��̸����� �л����� �˻��� Student��ü ����
	 * </pre>
	 * 
	 * @param s
	 * @return Student
	 * @throws SQLException
	 */
	public Student selectBysName(String s) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Student stu = null;
		try {
			con = DBUtil.getConnection();
			String sql = "select * from student where sname = ?";
			pstmt = con.prepareStatement(sql);
			// �Ű������� ?�� ������ ����
			pstmt.setString(1, s);
			// 5.
			rs = pstmt.executeQuery();
			// �� ������ŭ ����! //rs.next()�� ��ȯ���� boolean
			if (rs.next()) {
				if (rs.getString("sname").equals(s))
					stu = new Student(rs.getString("snum"), rs.getString("sname"), rs.getString("gender"));
				else
					stu = new Student("error", "error", "error");
			}
		} finally {
			DBUtil.close(con, pstmt, rs);
		}
		return stu;
	}
}
