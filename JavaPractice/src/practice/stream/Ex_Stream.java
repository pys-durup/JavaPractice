package practice.stream;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.stream.Stream;

public class Ex_Stream {
	
	public static void main(String[] args) {
		
		ArrayList<Integer> nums = new ArrayList<Integer>();
		
		nums.add(10);
		nums.add(5);
		nums.add(50);
		nums.add(20);
		nums.add(3);
		nums.add(2);
		nums.add(30);
		nums.add(1);
		nums.add(4);
		nums.add(40);
		
		
		// 배열(컬렉션) 탐색
		
		
		// 1. for문
		for (int i=0; i<nums.size() ; i++) {
			System.out.printf("%3d", nums.get(1));
		}
		System.out.println();
		
		
		// 2. 향상된 for문
		for (int i : nums) {
			System.out.printf("%3d", i);
		}
		System.out.println();
		
		// 3. Iterator
		Iterator<Integer> it = nums.iterator();
		
		while(it.hasNext()) {
			System.out.printf("%3d", it.next());
		}
		System.out.println();
		
		
		// 4. Stream
		Stream<Integer> stream = nums.stream();
		stream.forEach(n -> System.out.printf("%3d", n));
		
		
	}

}
