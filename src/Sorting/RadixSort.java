package Sorting;

public class RadixSort {
	
	void countingSort(int[] arr, int max, int place) {
		int[] count = new int[max+1];
		for(int i=0;i<arr.length;i++) {
			count[(arr[i]/place)%10]++;
		}
		for(int i=1;i<count.length;i++) {
			count[i]+=count[i-1];
		}
		
		int sorted[] = new int[arr.length];
		for(int i=sorted.length-1;i>=0;i--) {
			sorted[count[(arr[i]/place)%10]-1] = arr[i];
			count[(arr[i]/place)%10]--;
		}
		
		for(int i=0;i<arr.length;i++) {
			arr[i] = sorted[i];
		}
	}
	
	void radixSort(int[] arr) {
		int max=0;
		for(int i=0;i<arr.length;i++) {
			if(arr[i]>max) {
				max = arr[i];
			}
		}
		for(int place=1;max/place>0;place*=10) {
			countingSort(arr, max, place);
		}
	}
	
	public static void main(String args[]) {
		RadixSort rs = new RadixSort();
		int[] arr = new int[] {62,333,856,40,22,223,1,0,100,1111};
		rs.radixSort(arr);
		for(int i=0;i<arr.length;i++) {
			System.out.print(arr[i]+",");
		}
	}
}