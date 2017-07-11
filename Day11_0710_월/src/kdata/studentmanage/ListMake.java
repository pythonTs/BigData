package kdata.studentmanage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ListMake {

	private static List<StudentData> list = new ArrayList<>();

	public List<StudentData> add(StudentData data) {
		list.add(data);
		return list;
	}

	public static List<StudentData> sortUp() {
		Collections.sort(list, new Comparator<StudentData>() {
			@Override
			public int compare(StudentData o1, StudentData o2) {
				return o1.getName().compareTo(o2.getName()); // 문자열 오름차순
				// 문자열 비교 메소드 compareTo : public int compareTo(String
				// anotherString)
			}
		});

		// System.out.println("sort : "+ list);
		return list;
	}

	public static int getData(String inpname) {
		for (int i = 0; i < list.size(); i++) {
			StudentData data = list.get(i);
			// System.out.println("getname : " + data.getName());
			if (data.getName().equals(inpname)) {
				return data.getNum();
			}
		}
		return 0;
	}

	public static StudentData delete(String delname) {
		for (int i = 0; i < list.size(); i++) {
			StudentData data = list.get(i);
			if (data.getName().equals(delname)) {
				// System.out.println("제거되는 학번과 이름 : "+ data.getNum() +", "
				// +data.getName() );
				int listindex = i;
				// System.out.println("제거되는 listindex : "+ listindex);
				list.remove(listindex); // remove(index) : index에 맞는 list의 객체값
										// 제거
				// System.out.println("제거되었습니다.");
				return data;
			}
		}
		return null;

	}

	public static int everysum() {
		int sum = 0;
		for (int i = 0; i < list.size(); i++) {
			StudentData data = list.get(i);
			System.out.println("학생" + i + " : " + data.getSum());
			sum += data.getSum();
		}
		return sum;
	}

	public static String sum_top() {
		int sumtop = 0;
		int indextop = 0;
		StudentData data = null;
		for (int i = 0; i < list.size(); i++) {
			data = list.get(i);
			if (sumtop < data.getSum()) {
				sumtop = data.getSum();
				indextop = i;
			}
		}
		data = list.get(indextop);

		System.out.println("국영수 총점이 제일 높은 사람의 점수 : " + sumtop);
		return data.getName();
	}

	public static String sum_bot() {
		int sumbot = 300;
		int indexbot = 0;
		StudentData data = null;
		for (int i = 1; i < list.size(); i++) {
			data = list.get(i);
			if (sumbot > data.getSum()) {
				sumbot = data.getSum();
				indexbot = i;
			}
		}
		data = list.get(indexbot);

		System.out.println("국영수 총점이 제일 낮은 사람의 점수 : " + sumbot);
		return data.getName();
	}

	@Override
	public String toString() {
		return "StudentList [list=" + list + "]";
	}
}