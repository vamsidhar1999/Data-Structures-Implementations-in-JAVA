package Sorting;

public class ShellSort {
	
	void shellSort(int arr[]) {
		int n=arr.length;
		for(int interval = n/2;interval>0;interval/=2) {
			for(int i=interval;i<n;i++) {
				int temp = arr[i];
				int j;
				for(j=i;j>=interval && arr[j-interval]>temp; j-=interval) {
					arr[j] = arr[j-interval];
				}
				arr[j] = temp;
			}
		}
	}
	
	public static void main(String args[]) {
		ShellSort ss = new ShellSort();
		int[] arr = new int[] {9, 8, 3, 7, 5, 6, 4, 1};
		ss.shellSort(arr);
		for(int i=0;i<arr.length;i++) {
			System.out.print(arr[i]+",");
		}
	}
}