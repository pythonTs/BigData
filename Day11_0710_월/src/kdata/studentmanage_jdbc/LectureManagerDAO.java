package kdata.studentmanage_jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LectureManagerDAO {
	/**
	 * 필드선언 및 게터세터선언
	 */

	/**
	 * 수강신청 메소드
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
	 * 수강삭제 메소드
	 * 
	 * @return int result trim : sql문을 위해 잘라주는 것 만약에 char(10)라고 선언되었다면 이름을 5글자
	 *         썻을경우 나머지 5자리도 쓰레기값으로 채워지는데 그 쓰레기값을 제거해주는 메소드
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
	 * 수강 목록 출력
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
			while (rsSet.next()) { // 행 갯수만큼 진행! //rs.next()의 반환형은 boolean
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
	 * 성적입력 메소드(업데이트)
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
