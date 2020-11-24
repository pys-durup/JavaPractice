package practice.collection;

import java.util.ArrayList;
import java.util.Collections;

public class Ex_Comparable {
	
	public static void main(String[] args) {
		
		// 컬랙션 객체의 정렬
		ArrayList<Book> bookList = new ArrayList<Book>();
		
		bookList.add(new Book("컴퓨터 구조론", 345, 20000));
		bookList.add(new Book("네트워크 교실", 221, 35000));
		bookList.add(new Book("알고리즘", 552, 12000));
		bookList.add(new Book("완벽한 공부법", 124, 23000));
		bookList.add(new Book("컴퓨터 사이언스", 234, 19000));
		bookList.add(new Book("데이터베이스", 211, 26000));
		
		// 객체는 어떤 기준으로 정렬할지 모르는 상태
		Collections.sort(bookList);
		System.out.println(bookList);
		
		
	}

}

// Book 클래스에 Comparable 인터페이스 구현
class Book implements Comparable<Book>{
	
	public String title;
	public int pages;
	public int price;
	
	public Book(String title, int pages, int price) {
		super();
		this.title = title;
		this.pages = pages;
		this.price = price;
	}
	
	// compareTo 메서드 재정의
	@Override
	public int compareTo(Book o) {
		
//		return this.pages - o.pages; // 페이지 수 순서로 오름차순
//		return o.pages - this.pages; // 페이지 수 순서로 내림차순
//		return this.price - o.price; // 가격 순서로 오름차순
//		return o.price - this.price; // 가격 순서로 내림차순
//		return title.compareTo(o.title); // 이름순으로 오름차순
		return o.title.compareTo(this.title);
	}


	@Override
	public String toString() {
		return "{title=" + title + ", pages=" + pages + ", price=" + price
				+ "}\n";
	}
	
}