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
			System.out.println("1. 학생 정보 추가");
			System.out.println("2. 학생 정보 출력");
			System.out.println("3. 학생 검색");
			System.out.println("4. 수강 신청");
			System.out.println("5. 수강 삭제");
			System.out.println("6. 수강 목록 출력");
			System.out.println("7. 성적 입력");
			System.out.println("8. 과목별 평균 출력");

			// 8.과목별 평균, 반환형Map(key과목, value점수평균)
			// 방법1. 과목코드 String, Integer
			// Map<String, Integer> a= new Map<String, Integer>();

			System.out.println("9. 종료");
			choice = sc.nextLine();

			if (choice.equals("9")) {
				System.out.println("9선택. 종료");
				break;
			}

			switch (choice) {
			case "1": {
				System.out.println("1선택. 학생 정보 추가");
				System.out.println("학생의 학번,이름,성별을 쓰세요.");
				String sNum = sc.nextLine();
				String sName = sc.nextLine();
				String gender = sc.nextLine();
				if (sNum == null || sName == null || gender == null)
					System.out.println("입력이 안되었습니다.");
				else if (sNum.length() <= 10) {
					student = new Student(sNum, sName, gender);
					int a = 0;
					try {
						a = studentManager.insert(student);
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					System.out.println(a + " 개의 행이 입력되었습니다.");
				} else
					System.out.println("학번을 다시 입력해주세요.");
				break;
			}

			case "2": {
				System.out.println("2선택. 학생 정보 출력");
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
				System.out.println("3선택. 학생 검색");
				System.out.println("검색하실 이름을 입력하세요");
				String insertname = sc.nextLine();
				try {
					student = studentManager.selectBysName(insertname);
					System.out.println("학번 : " + student.getsNum() + ",이름 : " + student.getsName() + ",성별 : "
							+ student.getGender());
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			}
			case "4": {
				System.out.println("4선택. 수강 신청");
				System.out.println("수강하시는 학생의 학번,수강코드를 쓰세요");
				String snum = sc.nextLine();
				String subjectcode = sc.nextLine();
				if (snum == null || subjectcode == null)
					System.out.println("입력이 안되었습니다.");
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
						System.out.println(result + " 개의 행이 입력되었습니다.");
					} else
						System.out.println("학번을 다시 입력해주세요.");
				}
				break;
			}
			case "5": {
				System.out.println("5선택. 수강 삭제");
				System.out.println("수강삭제하시는 학생의 학번,수강코드를 입력하세요.");
				String snum = sc.nextLine();
				String subjectcode = sc.nextLine();
				if (snum == null || subjectcode == null)
					System.out.println("입력이 안되었습니다.");
				else {
					if (snum.length() <= 10) {
						int result = 0;
						try {
							lecture = new Lecture(snum, subjectcode);
							result = lectureManager.delete(lecture);
						} catch (SQLException e) {
							e.printStackTrace();
						}
						System.out.println(result + " 개의 행이 제거되었습니다.");
					} else
						System.out.println("학번을 다시 입력해주세요.");
				}
				break;
			}
			case "6": {
				System.out.println("6선택. 수강 목록 출력");
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
				System.out.println("7선택. 성적 입력");
				System.out.println("성적 수정하시는 학생의 학번,수강코드 그리고 성적을 입력하세요.");
				String snum = sc.nextLine();
				String subjectcode = sc.nextLine();
				int score = Integer.parseInt(sc.nextLine());
				if (snum == null || subjectcode == null || score == 0)
					System.out.println("입력이 안되었습니다.");
				else {
					if (snum.length() <= 10) {
						int a = 0;
						try {
							lecture = new Lecture(snum, subjectcode, score);
							a = lectureManager.update(lecture);
						} catch (SQLException e) {
							e.printStackTrace();
						}
						System.out.println(a + " 개의 행이 업뎃되었습니다.");
					} else
						System.out.println("학번을 다시 입력해주세요.");
				}
				break;
			}

			case "8": {
				System.out.println("8. 과목별 평균 출력");
				Map<String, Integer> printMap = null;
				printMap = null;
				break;
			}

			}// switch

		} while (true); // while

	}// main

}// class
