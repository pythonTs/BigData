package kdata.studentmanage;

import java.util.Scanner;

public class StudentManegeTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		ListMake list = new ListMake();

		while (true) {
			System.out.println("1. �л� ���� �߰�");
			System.out.println("2. �л� ���� ���");
			System.out.println("3. ����");
			System.out.println("4. �л��˻�");
			System.out.println("5. �л� ���� ����");
			System.out.println("6. ��ü ����");
			System.out.println("7. �ְ� ����");
			System.out.println("8. ���� ����");
			System.out.println("���ڸ� �Է����ּ���");
			String message = sc.nextLine();

			if (message.equals("1")) {

				System.out.println("�й�,�̸�,����,����,���� ������ �Է��ϼ���");
				StudentData data = new StudentData(Integer.parseInt(sc.nextLine()), sc.nextLine(),
						Integer.parseInt(sc.nextLine()), Integer.parseInt(sc.nextLine()),
						Integer.parseInt(sc.nextLine()));
				// System.out.println(data);
				list.add(data);
				System.out.println("list�� : " + list);
			} else if (message.equals("2")) {
				ListMake.sortUp();
				System.out.println("sort : " + list);
			} else if (message.equals("3")) {
				System.out.println("��!!");
				System.exit(0);
			} else if (message.equals("4")) {
				System.out.println("ã�����ϴ� �̸��� �Է��ϼ���");
				String serchname = sc.nextLine();
				int num = ListMake.getData(serchname);
				if (num == 0)
					System.out.println("�Է��Ͻ� �̸��� �й��� �����ϴ�");
				else
					System.out.println("�Է��Ͻ� �̸��� �й� : " + num);
			}

			else if (message.equals("5")) {
				System.out.println("������� �ϴ� �̸��� �Է��ϼ���");
				String delname = sc.nextLine();
				StudentData data = ListMake.delete(delname);
				if (data == null)
					System.out.println("�ش��ϴ� �̸��� �������� �ʾ� ������ϴ�.");
				else
					System.out.println("���ŵǴ� �й��� �̸� : " + data.getNum() + ", " + data.getName());
			} else if (message.equals("6")) { // ��ü ����
				System.out.println("��ü �л��� ������ ��ü ������");
				System.out.println(ListMake.everysum());// ��ü �л��� ����
			}

			else if (message.equals("7")) { // �ְ�����
				String nametop = ListMake.sum_top();
				System.out.println("������ ������ ���� ���� ��� : " + nametop);
			}

			else if (message.equals("8")) { // ��������
				String namebot = ListMake.sum_bot();
				System.out.println("������ ������ ���� ���� ��� : " + namebot);
			} else
				System.out.println("�߸��Է�!!");
		}
	}
}

/*
 * List<Student> list = new ArrayList<>();
 * 
 * for(int i=0;i<4;i++) { Student a= new
 * Student(Integer.parseInt(sc.nextLine()),sc.nextLine()); list.add(a);
 * System.out.println("list��3 : "+list); //System.out.println(list.hashCode());
 * }
 */