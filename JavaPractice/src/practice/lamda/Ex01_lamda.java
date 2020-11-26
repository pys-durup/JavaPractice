package practice.lamda;

public class Ex01_lamda {
	
	public static void main(String[] args) {
		
		
		
		// 람다식의 패턴은 메서드의 패턴과 같다
	
		
		
		// 매개변수 없고 반환값도 없을때
		NoParameterNoReturn f1 = () -> { System.out.println("f1"); };
		f1.call();
		
		// 매개변수 있고 반환값 없을때
		ParameterNoReturn f2 = (int num) -> {System.out.println(num);};
		f2.call(10);
		
		ParameterNoReturn f3 = num -> { System.out.println(num); }; // 매개변수의 자료형 생략
		f3.call(20);
		
		// 매개변수 없고 반환값 있을때
		NoParameterReturn f4 = () -> { return 10;};
		System.out.println(f4.call());
		
		NoParameterReturn f5 = () -> 20; // 한줄로 표현할때 return 키워드 생략 가능 / return문만 존재할때
		System.out.println(f5.call());
		
		
		// 매개변수 있고 반환값 있을때
		ParameterReturn f6 = (int a, int b) -> { return a+b; };
		System.out.println(f6.call(5, 10));
		
		ParameterReturn f7 = (a, b) -> a + b;
		System.out.println(f7.call(10, 20));
		
		
	}

}

@FunctionalInterface
interface NoParameterNoReturn {
	void call();
}

@FunctionalInterface
interface ParameterNoReturn {
	void call(int num);
}


@FunctionalInterface
interface NoParameterReturn {
	int call();
}

@FunctionalInterface
interface ParameterReturn {
	int call(int a, int b);
}