package kdata.studentmanage;

import java.util.Scanner;

public class StudentManegeTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		ListMake list = new ListMake();

		while (true) {
			System.out.println("1. 학생 정보 추가");
			System.out.println("2. 학생 정보 출력");
			System.out.println("3. 종료");
			System.out.println("4. 학생검색");
			System.out.println("5. 학생 정보 제거");
			System.out.println("6. 전체 총점");
			System.out.println("7. 최고 점수");
			System.out.println("8. 최저 점수");
			System.out.println("숫자를 입력해주세요");
			String message = sc.nextLine();

			if (message.equals("1")) {

				System.out.println("학번,이름,국어,영어,수학 성적을 입력하세요");
				StudentData data = new StudentData(Integer.parseInt(sc.nextLine()), sc.nextLine(),
						Integer.parseInt(sc.nextLine()), Integer.parseInt(sc.nextLine()),
						Integer.parseInt(sc.nextLine()));
				// System.out.println(data);
				list.add(data);
				System.out.println("list값 : " + list);
			} else if (message.equals("2")) {
				ListMake.sortUp();
				System.out.println("sort : " + list);
			} else if (message.equals("3")) {
				System.out.println("끝!!");
				System.exit(0);
			} else if (message.equals("4")) {
				System.out.println("찾고자하는 이름을 입력하세요");
				String serchname = sc.nextLine();
				int num = ListMake.getData(serchname);
				if (num == 0)
					System.out.println("입력하신 이름의 학번이 없습니다");
				else
					System.out.println("입력하신 이름의 학번 : " + num);
			}

			else if (message.equals("5")) {
				System.out.println("지우고자 하는 이름을 입력하세요");
				String delname = sc.nextLine();
				StudentData data = ListMake.delete(delname);
				if (data == null)
					System.out.println("해당하는 이름이 존재하지 않아 못지웁니다.");
				else
					System.out.println("제거되는 학번과 이름 : " + data.getNum() + ", " + data.getName());
			} else if (message.equals("6")) { // 전체 총점
				System.out.println("전체 학생의 국영수 전체 총점은");
				System.out.println(ListMake.everysum());// 전체 학생의 총점
			}

			else if (message.equals("7")) { // 최고점수
				String nametop = ListMake.sum_top();
				System.out.println("국영수 총점이 제일 높은 사람 : " + nametop);
			}

			else if (message.equals("8")) { // 최저점수
				String namebot = ListMake.sum_bot();
				System.out.println("국영수 총점이 제일 낮은 사람 : " + namebot);
			} else
				System.out.println("잘못입력!!");
		}
	}
}

/*
 * List<Student> list = new ArrayList<>();
 * 
 * for(int i=0;i<4;i++) { Student a= new
 * Student(Integer.parseInt(sc.nextLine()),sc.nextLine()); list.add(a);
 * System.out.println("list값3 : "+list); //System.out.println(list.hashCode());
 * }
 */