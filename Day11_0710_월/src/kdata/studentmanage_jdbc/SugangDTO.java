package kdata.studentmanage_jdbc;

import java.sql.Date;

public class SugangDTO {
	
	
	//private String snum;
	//private String subjectcode;
	//lecture 필드
	private int score;
	private String grade;
	private Date joindate;

	//Student 필드
	private String sNum;
	private String sName;
	private String gender;
	
	//Subject 필드
	private String subjectcode;
	private String subjectname;
	
	public SugangDTO(Lecture lecture, Student student, Subject subject){
		this.score = lecture.getScore();
		this.grade = lecture.getGrade();
		this.joindate = lecture.getDate();
		
	}
	@Override
	public String toString() {
		return "SugangDTO [score=" + score + ", grade=" + grade + ", joindate=" + joindate + ", sNum=" + sNum
				+ ", sName=" + sName + ", gender=" + gender + ", subjectcode=" + subjectcode + ", subjectname="
				+ subjectname + "]";
	}
	
}
