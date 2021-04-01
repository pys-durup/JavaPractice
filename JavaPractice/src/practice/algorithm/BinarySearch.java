package practice.algorithm;

public class BinarySearch {
	
	public static void main(String[] args) {
		
		// 하나의 배열, 하나의 아이템
		int[] arrays = setArrays();
		int item = 77;
				
		int startIndex = 0;
		int endIndex = arrays.length - 1;
		int position = 0;
		
		
		// 얼마만큼의 반복횟수를 가져가야 하는가?
		double count = baseLog(arrays.length, 2);
		System.out.println("반복 횟수 : " + count);
		
		for (int i=0 ; i<count ; i++) {
			//System.out.println((startIndex+endIndex)/2);
			if(arrays[(startIndex+endIndex)/2] == item) { 
				position = (startIndex+endIndex)/2;
				break; 
			}
			
			if(arrays[(startIndex+endIndex)/2] < item) {
				startIndex = (startIndex+endIndex)/2;
			} else {
				endIndex = (startIndex+endIndex)/2;
			}
			
//			System.out.println("===");
//			System.out.println(arrays[(startIndex+endIndex)/2]);
//			System.out.println(i);
//			System.out.println("startIndex = " + startIndex);
//			System.out.println("endIndex = " + endIndex);
			
		}
		
//		System.out.println("result ====");
		
		System.out.println(position);
		System.out.println(arrays[position]);
		
		
		
		
		
		
	}
	
	static double baseLog(double x, double base) {

		return Math.log10(x) / Math.log10(base);

	}


	private static int[] setArrays() {
		int[] arrays = new int[100];
		
		for (int i=1; i<= arrays.length; i++) {
			arrays[i-1] = i;
		}
		
		System.out.println(arrays[0]);
		System.out.println(arrays[99]);
		
		return arrays;
	}
	
}
