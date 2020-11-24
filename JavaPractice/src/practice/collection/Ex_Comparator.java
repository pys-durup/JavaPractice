package practice.collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Ex_Comparator {
	public static void main(String[] args) {
		
		// 컬랙션 객체의 정렬
		ArrayList<Book> bookList = new ArrayList<Book>();
		
		// Book 클래스에는 Comparable 인터페이스가 구현되어 있음
		// 오버라이드 된 CompareTo 메서드의 정렬방식은 책이름으로 내림차순
		
		bookList.add(new Book("컴퓨터 구조론", 345, 20000));
		bookList.add(new Book("하루3분 네트워크 교실", 221, 35000));
		bookList.add(new Book("알고리즘", 552, 12000));
		bookList.add(new Book("완벽한 공부법", 124, 23000));
		bookList.add(new Book("컴퓨터 사이언스 부트캠프", 234, 19000));
		bookList.add(new Book("데이터베이스 오라클", 211, 26000));
		
		Collections.sort(bookList); 
		System.out.println(bookList); // 정해진 정렬방식인 책이름으로 내림차순으로 정렬된다
		
		// 다른 방식으로의 정렬이 필요할떄
		// 필요할 때마다 Book클래스의 ComapreTo 메서드를 수정하는 방식은 좋지 않다
		// Comparator 인터페이스 익명클래스로 사용
		
		Comparator<Book> comparator = new Comparator<Book>() {
			@Override
			public int compare(Book o1, Book o2) {
				// 정렬 방식을 정의 ex) 글자수대로 정렬
//				int result = o1.title.length() - o2.title.length();
				return o1.title.length() - o2.title.length();
			}
		};
		
		Collections.sort(bookList, comparator); // comparator 이용한 정렬
		System.out.println(bookList);
		
		// ArrayList.sort() 메서드에 사용
		bookList.sort(new Comparator<Book>() {
			@Override
			public int compare(Book o1, Book o2) {
				// TODO Auto-generated method stub
				return 0;
			}
		});
	}
}


