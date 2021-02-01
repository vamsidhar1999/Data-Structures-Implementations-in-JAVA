package Sorting;

public class BubbleSort {
	
	static int[] bubbleSort(int[] arr) {
		
		for(int i=0;i<arr.length-1;i++) {
			boolean swapped = true;
			for(int j=0;j<arr.length-i-1;j++) {
				if(arr[j]>arr[j+1]) {
					int temp = arr[j+1];
					arr[j+1] = arr[j];
					arr[j] = temp;
					
					swapped = false;
				}
			}
			if(swapped==true) {
				break;
			}
		}
		
		return arr;
	}
	
	public static void main(String args[]) {
		int arr[] = new int[] {7,5,2,10,8,6,3,9,23,18,20};
		int result[] = bubbleSort(arr);
		for(int i=0;i<result.length;i++) {
			System.out.print(result[i]+",");
		}
	}
}
