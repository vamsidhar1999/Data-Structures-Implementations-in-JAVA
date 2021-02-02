package Sorting;

public class InsertionSort {
	
	static int[] insertionSort(int[] arr) {
		
		for(int i=1;i<arr.length;i++) {
			int key = arr[i];
			int j = i-1;
			
			while(j>=0 && key<arr[j]) {
				arr[j+1] = arr[j];
				j--;
			}
			
			arr[j+1] = key;
		}
		
		return arr;
	}
	
	public static void main(String args[]) {
		int[] arr = new int[] {7,2,1,8,10,6,4};
		int result[] = insertionSort(arr);
		for(int i=0;i<arr.length;i++) {
			System.out.print(result[i]+",");
		}
	}
}