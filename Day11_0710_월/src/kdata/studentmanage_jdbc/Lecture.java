package kdata.studentmanage_jdbc;

import java.sql.Date;

public class Lecture {
	/**
	 * takeclass Å×ÀÌºí
	 */
	private String snum;
	private String subjectcode;
	private int score;
	private String grade;
	private Date joindate;

	public Lecture(String snum, String subjectcode, int score) {
		super();
		this.snum = snum;
		this.subjectcode = subjectcode;
		this.score = score;
	}

	public Lecture(String snum, String subjectcode) {
		// TODO Auto-generated constructor stub
		super();
		this.snum = snum;
		this.subjectcode = subjectcode;
	}

	public Lecture(String snum, String subjectcode, int score, String grade, Date joindate) {
		super();
		this.snum = snum;
		this.subjectcode = subjectcode;
		this.score = score;
		this.grade = grade;
		this.joindate = joindate;
	}

	public String getSnum() {
		return snum;
	}

	public void setSnum(String snum) {
		this.snum = snum;
	}

	public String getSubjectcode() {
		return subjectcode;
	}

	public void setSubjectcode(String subjectcode) {
		this.subjectcode = subjectcode;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int grade) {
		this.score = grade;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public Date getDate() {
		return joindate;
	}

	public void setDate(Date date) {
		this.joindate = date;
	}

	@Override
	public String toString() {
		return "Lecture [snum=" + snum + ", subjectcode=" + subjectcode + ", score=" + score + ", grade=" + grade
				+ ", date=" + joindate + "]";
	}

}
