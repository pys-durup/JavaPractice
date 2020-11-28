package practice.stream;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class EX01_Stream {
	
	public static void main(String[] args) {
		
		// 스트림 객체 얻어오기
		
		// 1. 배열
		int[] nums1 = {10, 20, 30, 40, 50};
		Arrays.stream(nums1).forEach(n -> System.out.println(n));
		System.out.println();
		
		// 2. 컬렉션
		List<String> list = Arrays.asList( "하나", "둘", "셋", "넷", "다섯");
		list.stream().forEach(n -> System.out.println(n));
		System.out.println();
		
		// 3. 숫자 범위
		IntStream.range(1, 11).forEach(n -> System.out.println(n));
		System.out.println();
		
		
		// 4. 파일로 부터
		
		try {
			Path path = Paths.get(".\\data.txt");
			System.out.println(path.toAbsolutePath());
			
			// 한줄한줄 읽어오면서 출력
			Files.lines(path).forEach(line -> System.out.println(line));
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("primaryEx86_Stream.enm2()");
			e.printStackTrace();
		}
		
		
		// 5. 디렉토리로 부터
		try {
			Path path = Paths.get(".");//현재 폴더
			System.out.println(path.toAbsolutePath());
			
			// 자식 목록 가져오기
			Files.list(path).forEach(p ->System.out.println(p));
			System.out.println();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
