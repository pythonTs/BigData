package kdata.studentmanage_jdbc;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class StudentManagerTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StudentManagerDAO studentManager = new StudentManagerDAO();
		LectureManagerDAO lectureManager = new LectureManagerDAO();
		Scanner sc = new Scanner(System.in);
		Student student;
		Lecture lecture;
		String choice = null;
		do {
			System.out.println("1. �л� ���� �߰�");
			System.out.println("2. �л� ���� ���");
			System.out.println("3. �л� �˻�");
			System.out.println("4. ���� ��û");
			System.out.println("5. ���� ����");
			System.out.println("6. ���� ��� ���");
			System.out.println("7. ���� �Է�");
			System.out.println("8. ���� ��� ���");

			// 8.���� ���, ��ȯ��Map(key����, value�������)
			// ���1. �����ڵ� String, Integer
			// Map<String, Integer> a= new Map<String, Integer>();

			System.out.println("9. ����");
			choice = sc.nextLine();

			if (choice.equals("9")) {
				System.out.println("9����. ����");
				break;
			}

			switch (choice) {
			case "1": {
				System.out.println("1����. �л� ���� �߰�");
				System.out.println("�л��� �й�,�̸�,������ ������.");
				String sNum = sc.nextLine();
				String sName = sc.nextLine();
				String gender = sc.nextLine();
				if (sNum == null || sName == null || gender == null)
					System.out.println("�Է��� �ȵǾ����ϴ�.");
				else if (sNum.length() <= 10) {
					student = new Student(sNum, sName, gender);
					int a = 0;
					try {
						a = studentManager.insert(student);
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					System.out.println(a + " ���� ���� �ԷµǾ����ϴ�.");
				} else
					System.out.println("�й��� �ٽ� �Է����ּ���.");
				break;
			}

			case "2": {
				System.out.println("2����. �л� ���� ���");
				try {
					List<Student> studentList = studentManager.selectAll();
					for (int i = 0; i < studentList.size(); i++) {
						student = studentList.get(i);
						System.out.println(student);
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			}

			case "3": {
				System.out.println("3����. �л� �˻�");
				System.out.println("�˻��Ͻ� �̸��� �Է��ϼ���");
				String insertname = sc.nextLine();
				try {
					student = studentManager.selectBysName(insertname);
					System.out.println("�й� : " + student.getsNum() + ",�̸� : " + student.getsName() + ",���� : "
							+ student.getGender());
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			}
			case "4": {
				System.out.println("4����. ���� ��û");
				System.out.println("�����Ͻô� �л��� �й�,�����ڵ带 ������");
				String snum = sc.nextLine();
				String subjectcode = sc.nextLine();
				if (snum == null || subjectcode == null)
					System.out.println("�Է��� �ȵǾ����ϴ�.");
				else {
					if (snum.length() <= 10) {
						int result = 0;
						try {
							lecture = new Lecture(snum, subjectcode);
							result = lectureManager.insert(lecture);
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						System.out.println(result + " ���� ���� �ԷµǾ����ϴ�.");
					} else
						System.out.println("�й��� �ٽ� �Է����ּ���.");
				}
				break;
			}
			case "5": {
				System.out.println("5����. ���� ����");
				System.out.println("���������Ͻô� �л��� �й�,�����ڵ带 �Է��ϼ���.");
				String snum = sc.nextLine();
				String subjectcode = sc.nextLine();
				if (snum == null || subjectcode == null)
					System.out.println("�Է��� �ȵǾ����ϴ�.");
				else {
					if (snum.length() <= 10) {
						int result = 0;
						try {
							lecture = new Lecture(snum, subjectcode);
							result = lectureManager.delete(lecture);
						} catch (SQLException e) {
							e.printStackTrace();
						}
						System.out.println(result + " ���� ���� ���ŵǾ����ϴ�.");
					} else
						System.out.println("�й��� �ٽ� �Է����ּ���.");
				}
				break;
			}
			case "6": {
				System.out.println("6����. ���� ��� ���");
				List<Lecture> lectureList = null;
				try {
					lectureList = lectureManager.selectAll();
					for (int i = 0; i < lectureList.size(); i++) {
						lecture = lectureList.get(i);
						System.out.println(lecture);
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			}

			case "7": {
				System.out.println("7����. ���� �Է�");
				System.out.println("���� �����Ͻô� �л��� �й�,�����ڵ� �׸��� ������ �Է��ϼ���.");
				String snum = sc.nextLine();
				String subjectcode = sc.nextLine();
				int score = Integer.parseInt(sc.nextLine());
				if (snum == null || subjectcode == null || score == 0)
					System.out.println("�Է��� �ȵǾ����ϴ�.");
				else {
					if (snum.length() <= 10) {
						int a = 0;
						try {
							lecture = new Lecture(snum, subjectcode, score);
							a = lectureManager.update(lecture);
						} catch (SQLException e) {
							e.printStackTrace();
						}
						System.out.println(a + " ���� ���� �����Ǿ����ϴ�.");
					} else
						System.out.println("�й��� �ٽ� �Է����ּ���.");
				}
				break;
			}

			case "8": {
				System.out.println("8. ���� ��� ���");
				Map<String, Integer> printMap = null;
				printMap = null;
				break;
			}

			}// switch

		} while (true); // while

	}// main

}// class
