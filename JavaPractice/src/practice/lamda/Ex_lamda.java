package practice.lamda;


public class Ex_lamda {
	
	public static void main(String[] args) {
		
		
		MyClass m1 = new MyClass();
		m1.test();
		
		// 인터페이스를 구현한 클래스의 객체는 되도록 인터페이스 변수를 만들어 저장
		MyInterface m2 = new MyClass();
		m2.test();
		
		// 익명 객체
		MyInterface m3 = new MyInterface () {
			@Override
			public void test() {
				System.out.println("익명 객체에서 구현한 메서드");
			}
		};
		m3.test();
		
		// 람다식
		MyInterface m4 = () -> {
			System.out.println("람다식에서 구현한 메서드");
		};
		m4.test();
	}

}

//람다식 전용 인터페이스
@FunctionalInterface
interface MyInterface {
	void test();
	
}

class MyClass implements MyInterface {
	@Override
	public void test() {
		System.out.println("MyCalss 객체에서 구현한 메서드");
	}
}