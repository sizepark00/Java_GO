package com.newlecture.web.poly;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import com.newlecture.web.entity.gNList2;

public class Program {
	
	public static void main(String[] args) {
		//람다식 사용 예시
		List list = new ArrayList();
//		list.add("6");
//		list.add("3");
//		list.add("15");
//		list.add("2");

		list.add(new Exam(1,2,3));
		list.add(new Exam(10,20,30));
		list.add(new Exam(6,22,33));
		list.add(new Exam(1000,223,3333));
		
		//정렬기준을 넘겨줘야 한다. (-1,  0 , 1 음수냐 0이냐 양수냐만 알려주면 된다.)
		//오름차순으로 정렬이 된다.
		list.sort((o1, o2) -> ((Exam)o2).getKor() - ((Exam)o1).getKor());
		
		list.sort(new Comparator<Exam>() {

			public int compare(Exam o1, Exam o2) {
				return o2.getKor()- o1.getKor();
			}
		});
		System.out.println(list);
		//Banner banner = new ICTBanner();
		
		//함수 내부 클래스
		class A implements Banner {
			public void print() {
				System.out.println("   내부 클래스 A  교육센터  ");
			}
		}
		
		//익명 클래스 
		Banner b = new Banner() {
			public void print() {
				System.out.println("  즉각적으로 만든 교육센터 , 익명 클래스 ");
			}
		};
		
		ExamConsole.printIntro (() -> {
			System.out.println("람다 익명 클래스 ICT 교육센터");
		});
		ExamConsole.printIntro(new A());
		ExamConsole.printIntro(b);
		
	}
}
