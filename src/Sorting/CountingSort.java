package Sorting;

public class CountingSort {

	void countingSort(int[] arr) {
		int max=0;
		for(int i=0;i<arr.length;i++) {
			if(arr[i]>max) {
				max=arr[i];
			}
		}
		int[] count = new int[max+1];
		
		for(int i=0;i<arr.length;i++) {
			++count[arr[i]];
		}
		for(int i=1;i<count.length;i++) {
			count[i] += count[i-1];
		}
		int[] sorted = new int[arr.length];
		
		for(int i=sorted.length-1;i>=0;i--) {
			sorted[count[arr[i]]-1] = arr[i];
			--count[arr[i]];
		}
		
		for(int i=0;i<arr.length;i++) {
			arr[i] = sorted[i];
		}
	}
	
	public static void main(String[] args) {
		CountingSort cs = new CountingSort();
		int[] arr = new int[] {8,3,5,6,4,0,9,1,5,6,4};
		cs.countingSort(arr);
		for(int i=0;i<arr.length;i++) {
			System.out.print(arr[i]+",");
		}
	}
}
