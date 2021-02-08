package Sorting;

public class HeapSort {
	
	void heapify(int arr[], int n, int i) {
		int largest = i;	//current node is set as a largest
		int left = 2*i+1;  //left child of node
		int right = 2*i+2;	//right child of node
		
		//setting left as largest if left child is greater than node
		if(left<n && arr[left]>arr[largest])
			largest = left;
		//setting right as largest if right child is greater than node
		if(right<n && arr[right]>arr[largest])
			largest = right;
		
		//if current node is the largest, no swapping required. but if largest changes then swapping is done and heapified as max-heap again
		if(largest!=i) {
			int temp = arr[largest];
			arr[largest] = arr[i];
			arr[i] = temp;
			
			heapify(arr, n, largest);
		}
	}
	
	void sort(int arr[]) {
		
		//Build the max-heap
		for(int i=(arr.length/2)-1;i>=0;i--) {
			heapify(arr, arr.length, i);
		}
		
		//sorting the array by deleting the root for every loop
		for(int i=arr.length-1;i>=0;i--) {
			int temp = arr[0];
			arr[0] = arr[i];
			arr[i] = temp;
			
			//send i in place of array length as array length gets decreasing by every time loop runs as this is like deleting root.
			heapify(arr, i, 0);
		}
	}
	
	public static void main(String args[]) {
		HeapSort hs = new HeapSort();
		int[] arr = new int[] {12,10,16,0,80,63,12,15,44};
		hs.sort(arr);
		
		for(int i=0;i<arr.length;i++) {
			System.out.print(arr[i]+",");
		}
	}
}