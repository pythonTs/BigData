package kdata.studentmanage_jdbc;

public class Subject {
	/**
	 * subject���̺� �ʵ� �� ���� ���ͼ���
	 */
	private String subjectcode;
	private String subjectname;

	public String getSubjectcode() {
		return subjectcode;
	}

	public void setSubjectcode(String subjectcode) {
		this.subjectcode = subjectcode;
	}

	public String getSubjectname() {
		return subjectname;
	}

	public void setSubjectname(String subjectname) {
		this.subjectname = subjectname;
	}

	@Override
	public String toString() {
		return "Subject [subjectcode=" + subjectcode + ", subjectname=" + subjectname + "]";
	}

}
