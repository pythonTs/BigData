package kdata.studentmanage_jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LectureManagerDAO {
	/**
	 * �ʵ弱�� �� ���ͼ��ͼ���
	 */

	/**
	 * ������û �޼ҵ�
	 * 
	 * @return int result
	 */
	public int insert(Lecture s) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		int result = 0;
		try {
			con = DBUtil.getConnection();
			String sql = "insert into lecture (snum, subjectcode) values(?,?)";
			pstmt = con.prepareStatement(sql);

			pstmt.setString(1, s.getSnum());
			pstmt.setString(2, s.getSubjectcode());
			result = pstmt.executeUpdate();
		} finally {
			DBUtil.close(con, pstmt);
		}
		return result;
	}

	/**
	 * �������� �޼ҵ�
	 * 
	 * @return int result trim : sql���� ���� �߶��ִ� �� ���࿡ char(10)��� ����Ǿ��ٸ� �̸��� 5����
	 *         ������� ������ 5�ڸ��� �����Ⱚ���� ä�����µ� �� �����Ⱚ�� �������ִ� �޼ҵ�
	 */
	public int delete(Lecture s) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		int result = -1;
		try {
			con = DBUtil.getConnection();
			String sql = "delete from lecture where trim(snum) = ? and trim(subjectcode) = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, s.getSnum());
			pstmt.setString(2, s.getSubjectcode());
			result = pstmt.executeUpdate();
		} finally {
			DBUtil.close(con, pstmt);
		}
		return result;
	}

	/**
	 * ���� ��� ���
	 * 
	 * @return List list
	 */
	public List<Lecture> selectAll() throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rsSet = null;
		List<Lecture> list = new ArrayList<>();
		try {
			con = DBUtil.getConnection();
			String sql = "select * from lecture";
			pstmt = con.prepareStatement(sql);
			rsSet = pstmt.executeQuery();
			while (rsSet.next()) { // �� ������ŭ ����! //rs.next()�� ��ȯ���� boolean
				Lecture tc = new Lecture(rsSet.getString("snum"), rsSet.getString("subjectcode"),
						rsSet.getInt("score"),rsSet.getString("grade"),rsSet.getDate("joindate"));
				list.add(tc);
			}
		} finally {
			DBUtil.close(con, pstmt, rsSet);
		}
		return list;
	}

	/**
	 * �����Է� �޼ҵ�(������Ʈ)
	 */
	public int update(Lecture s) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		int result = 0;
		try {
			con = DBUtil.getConnection();
			String sql = "update lecture set score = ? where trim(snum) = ? and trim(subjectcode) = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, s.getScore());
			pstmt.setString(2, s.getSnum());
			pstmt.setString(3, s.getSubjectcode());
			System.out.println(s);
			result = pstmt.executeUpdate();
		} finally {
			DBUtil.close(con, pstmt);
		}
		return result;
	}

}
