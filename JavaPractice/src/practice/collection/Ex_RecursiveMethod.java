package practice.collection;

import java.io.File;

public class Ex_RecursiveMethod {
	
	public static void main(String[] args) {
		
		String path = "C:\\eclipse";
		
		File dir = new File(path);
		int count = 0; // 파일의 개수
		
		count = fileCount(dir, count); // 파일의 개수를 구하는 재귀함수 메서드
		
		System.out.println("eclipse 폴더 안의 모든 파일의 개수 : " + count);
		
	}

	private static int fileCount(File dir, int count) {
		
		// 폴더 안에있는 객체들을 list 배열에 넣는다
		File[] list = dir.listFiles();
		
		// 파일이면? count ++
		for (File file : list) {
			if(file.isFile()) {
				count++;
			}
		}
		
		// 디렉토리면? 다시 탐색을 한다
		for (File subdir : list) {
			if(subdir.isDirectory()) {
				count = fileCount(subdir, count);
			}
		}
		
		return count;
		
	}

}
