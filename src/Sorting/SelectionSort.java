package Sorting;

public class SelectionSort {
	
	static int[] selectionSort(int[] arr) {
		
		int min = 0;
		for(int i=0;i<arr.length-1;i++) {
			min=i;
			for(int j=i+1;j<arr.length;j++) {
				if(arr[j]<arr[min]) {
					min=j;
				}
			}
			int temp = arr[min];
			arr[min] = arr[i];
			arr[i] = temp;
		}
		
		return arr;
	}
	
	public static void main(String args[]) {
		int arr[] = new int[] {7,5,2,10,8,6,3,9,23,18,20};
		int result[] = selectionSort(arr);
		for(int i=0;i<result.length;i++) {
			System.out.print(result[i]+",");
		}
	}
}