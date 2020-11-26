package practice.lamda;

import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class Ex02_lamda {
	
	public static void main(String[] args) {
		
//		useConsumer();
//		useSupplier();
//		useFunction();
//		useOperator();
		usePredicate();
	
		
	}

	private static void usePredicate() {
		
		// Predicate
		// Function의 서브셋
		// 주로 매개변수값을 조사해서 논리값을 반환하는 역할
		
		Function<Integer, Boolean> f1 = n -> n > 0 ;
		
		if (f1.apply(10)) {
			System.out.println("양수");
		} else {
			System.out.println("음수");
		}
		
		Predicate<Integer> p1 = n -> n > 0;
		
		if (p1.test(-10)) {
			System.out.println("양수");
		} else {
			System.out.println("음수");
		}
		
	}

	private static void useOperator() {
		
		// Operaor
		// Function의 서브셋
		// 주로 매개변수 값을 연산 처리후 반환
		// 매개변수의 타입과 반환값 타입이 동일
		// biFunction, BinaryOperator
		BiFunction<Integer, Integer, Integer> bf1 = (a,b) -> a + b;
		System.out.println(bf1.apply(10, 20));
		
		BinaryOperator<Integer> bo1 = (a,b) -> a - b;
		System.out.println(bo1.apply(50, 100));
		
		
	}

	private static void useFunction() {
		
		// Function
		// 함수 역할의 메서드 제공
		// apply() 추상 메서드
		// Function<T, R> T : 매개변수, R : 반환값
		
		Function<String, Integer> f1 = name -> name.length();
		System.out.println(f1.apply("YSPARK"));
		System.out.println(f1.apply("java practice"));
		
		Function<Integer, String> f2 = num -> num > 0 ? "양수" : "음수";
		System.out.println(f2.apply(100));
		System.out.println(f2.apply(-100));
		
	}

	private static void useSupplier() {
		
		// Supplier
		// 반환값만 제공하는 역할
		// get() 추상 메서드
	
		Supplier<String> s1 = () -> { return "YSPARK"; };
		System.out.println(s1.get());
		
		Supplier<Integer> s2 = () -> { return 12345; };
		System.out.println(s2.get());
		
	}

	private static void useConsumer() {
		
		// Consumer
		// 매개변수를 받아서 소비하는 일을 구현
		// accept() 추상 메서드 
		
		Consumer<String> c1 = name -> System.out.println(name);
		c1.accept("YSPARK");
		
		Consumer<Integer> c2 = n -> {
			for (int i=0 ; i<n ; i++) {
				System.out.println(i);
			}
		};
		
		c2.accept(5);
		
		Consumer<Integer> c3 = new Consumer<Integer>() {
			@Override
			public void accept(Integer t) { 
				// TODO Auto-generated method stub
				
			}
		};
		
		BiConsumer<String, Integer> c4 = (name, age) -> {
			System.out.println("이름 : " + name);
			System.out.println("나이 : " + age);
		};
		c4.accept("YSPARK", 28);
	}
	
}
