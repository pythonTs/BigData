package kdata.manager;

import java.util.Scanner;


public class StudentManagerTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//1.�л� ���� �߰�
		//��ĳ�����ؼ� �Է��� ������ �Ű������� �л���ü? ����?
		//2.�л� ����Ʈ ���
		//3.�л� �̸� �˻�
		StudentManager m1 = new StudentManager();
		
		Scanner sc = new Scanner(System.in);
		while(true) {
			System.out.println("1: �߰�, 2: ���, 3: �˻�");
			switch(sc.nextInt()) {
			case 1:
				sc.nextLine(); 
				System.out.println("�л��� �й��� �Է��ϼ���");
				String snum = sc.nextLine(); 
				System.out.println("�л��� �̸��� �Է��ϼ���");
				String sname = sc.nextLine();
				System.out.println("�л��� ������ �Է��ϼ���");
				String gender = sc.nextLine();
				if(m1.insert(new Student(snum, sname, gender))==1) {
					System.out.println("�̴�");
				}else System.out.println("�ȵ̴�");
				
				break;
			
			default : System.out.println("�ٽ� �Է�"); break;
			}
		}
		
	}
}
