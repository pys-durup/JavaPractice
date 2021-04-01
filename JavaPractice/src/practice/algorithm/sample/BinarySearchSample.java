package practice.algorithm.sample;

public class BinarySearchSample {
	
	public static void main(String[] args) {
		
		int[] arrays = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		System.out.println(binarySearch(arrays, 9));
		
		
	}

	private static int binarySearch(int[] arrays, int item) {
		
		int low = 0;
		int high = arrays.length-1;
		
		while (low <= high) {
			int mid = (low + high) / 2;
			int guess = arrays[mid];
			
			if(item == guess) {
				return mid;
			}
			
			if(item < guess) {
				high = mid - 1;
			} else {
				low = mid + 1;
			}
		}
		
		return 123456;
	}


	
}
