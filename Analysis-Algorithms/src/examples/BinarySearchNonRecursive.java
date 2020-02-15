package examples;

import java.util.Arrays;

public class BinarySearchNonRecursive {
	
	
	public static int rank(int[] array, int key) {
		Arrays.sort(array);
		int low = 0;
		int high = array.length - 1;


		while (low <= high) {
			int mid = low+(high-low)/2;
			if (key == array[mid]) {
				return mid;
			} else if (key < array[mid]) {
				high = mid - 1;
			} else if (key > array[mid]) {
				low = mid + 1;
			}

		}
		return -1;

	}
	public static void main (String[] args) {
		int[] array = {1,2,3,4,5,6,7,8};
		System.out.println(rank(array,2));
	}
}
