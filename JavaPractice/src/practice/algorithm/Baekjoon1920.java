package practice.algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon1920 {

	/*
	
	5
	4 1 5 2 3
	5
	1 3 7 9 5
	
	1
	1
	0
	0
	1
	
	*/
	
	public static void main(String[] args) throws NumberFormatException, IOException {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int high = Integer.parseInt(br.readLine());
		
		String setNumbers = br.readLine();
		
		int numberCount = Integer.parseInt(br.readLine()); // 반복 횟수.
		
		String getNumbers = br.readLine();
		
		String[] setArray = setNumbers.split(" ");
		//System.out.println(setArray.toString());
		//System.out.println(setArray[0]);
		
		String[] numArray = getNumbers.split(" ");
		
		for (int i=0; i<setArray.length-1; i++) {
			for (int j=i+1; j<setArray.length; j++) {
				if (Integer.parseInt(setArray[j]) < Integer.parseInt(setArray[i])) {
					String temp = setArray[j];
					setArray[j] = setArray[i];
					setArray[i] = temp;
				}
			}
		}
		
//		for (int i=0; i<setArray.length; i++) {
//			System.out.println(setArray[i]);
//		}
		
		
		for (int i=0; i<numArray.length; i++) {
			System.out.println(binarySearch(setArray, numArray[i]));
		}
		
		
		
		
		
	}

	private static int binarySearch(String[] setArray, String getNum) {
		int high = setArray.length - 1;
		int low = 0;
		
		while (low <= high) {
			int middle = (low + high)/2;
			
			if(setArray[middle].equals(getNum)) {
				return 1;
			}
			
			if(Integer.parseInt(setArray[middle]) < Integer.parseInt(getNum)) {
				low = middle + 1;
			} else {
				high = middle - 1;
			}
		}
		
		return 0;
	}
	
}
