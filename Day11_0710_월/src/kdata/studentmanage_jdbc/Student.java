package kdata.studentmanage_jdbc;

public class Student {
	/**
	 * student ���̺�
	 */
	private String sNum;
	private String sName;
	private String gender;

	/**
	 * <pre>
	 * �����ڸ� �̿��� �ʱ�ȭ���
	 * </pre>
	 * @param sNum : �й�
	 * @param sName : �̸�
	 * @param genger : ����
	 * @return Student
	 */
	public Student(String sNum, String sName, String gender) {
		super();
		this.sNum = sNum;
		this.sName = sName;
		this.gender = gender;
	}

	public String getsNum() {
		return sNum;
	}

	public void setsNum(String sNum) {
		this.sNum = sNum;
	}

	public String getsName() {
		return sName;
	}

	public void setsName(String sName) {
		this.sName = sName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	@Override
	public String toString() {
		return "Student [sNum=" + sNum + ", sName=" + sName + ", gender=" + gender + "]";
	}
	

}
