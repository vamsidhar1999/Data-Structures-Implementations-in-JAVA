package Sorting;

public class MergeSort {
	int n= 0;
	void merge(int arr[], int p, int q, int r) {
		System.out.println(n++);
		int n1 = q-p+1;
		int n2 = r-q;
		
		int[] L = new int[n1];
		int[] R = new int[n2];
		
		for(int i=0;i<n1;i++) {
			L[i] = arr[p+i];
		}
		for(int i=0;i<n2;i++) {
			R[i] = arr[q+1+i];
		}
		
		int i=0,j=0,k=p;
		while(i<n1 && j<n2) {
			if(L[i]<R[j]) {
				arr[k] = L[i];
				i++;
			}else {
				arr[k] = R[j];
				j++;
			}
			k++;
		}
		
		while(i<n1) {
			arr[k] = L[i];
			i++;
			k++;
		}
		while(j<n2) {
			arr[k] = R[j];
			j++;
			k++;
		}
	}

	void mergeSort(int arr[], int l, int r) {
		
		if(l<r) {
			int m = (l+r)/2;
			
			mergeSort(arr,l,m);
			mergeSort(arr,m+1,r);
			
			merge(arr, l, m, r);
		}
	}
	
	void sort(int[] arr){
		mergeSort(arr, 0, arr.length-1);
	}
	
	public static void main(String[] args) {
		int arr[] = new int[] {2,8,4,6,10,12,5,3,7};
		MergeSort ms = new MergeSort();
		ms.sort(arr);
		
		for(int i=0;i<arr.length;i++) {
			System.out.print(arr[i] + ",");
		}
	}

}
