package practice.algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

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
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int[] setArray = new int[high];
		for(int i=0; i<high; i++) {
			setArray[i] = Integer.parseInt(st.nextToken());
		}
		
		
		int numberCount = Integer.parseInt(br.readLine()); // 반복 횟수.
		st = new StringTokenizer(br.readLine());
		int[] numArray = new int[numberCount];
		for(int i=0; i<numberCount; i++) {
			numArray[i] = Integer.parseInt(st.nextToken());
		}
		
	
		Arrays.sort(setArray);
//		for (int i=0; i<setArray.length-1; i++) {
//			for (int j=i+1; j<setArray.length; j++) {
//				if (setArray[j] < setArray[i]) {
//					int temp = setArray[j];
//					setArray[j] = setArray[i];
//					setArray[i] = temp;
//				}
//			}
//		}
		
		
		for (int i=0; i<numberCount; i++) {
			System.out.println(binarySearch(setArray, numArray[i]));
		}
		
		
		
		
		
	}

	private static int binarySearch(int[] setArray, int getNum) {
		int high = setArray.length - 1;
		int low = 0;
		
		while (low <= high) {
			int middle = (low + high)/2;
			
			if(setArray[middle] == getNum) {
				return 1;
			}
			
			if(setArray[middle] < getNum) {
				low = middle + 1;
			} else {
				high = middle - 1;
			}
		}
		
		return 0;
	}
	
}
