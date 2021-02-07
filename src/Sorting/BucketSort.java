package Sorting;

import java.util.ArrayList;
import java.util.Collections;

public class BucketSort {
	
	public void bucketSort(float[] arr) {
		int n=arr.length;
	    ArrayList<Float>[] bucket = new ArrayList[n];
	    
	    for (int i = 0; i < n; i++) {
	        bucket[i] = new ArrayList<Float>();
	    }
	        
	    for(int i=0;i<arr.length;i++) {
	    	int bucketIndex = (int)arr[i]*n;
	    	bucket[bucketIndex].add(arr[i]);
	    }
	    
	    for(int i=0;i<bucket.length;i++) {
	    	Collections.sort(bucket[i]);
	    }
	    
	    int index=0;
	    for(int i=0;i<bucket.length;i++) {
	    	for(int j=0;j<bucket[i].size();j++) {
	    		arr[index++] = bucket[i].get(j);
	    	}
	    }
	  }
	
	public static void main(String args[]) {
		BucketSort bs = new BucketSort();
		float[] arr = new float[] {(float) 0.2,(float) 0.34,(float) 0.25,(float) 0.86,(float) 0.12,(float) 0.45,(float) 0.64,(float) 0.66,(float) 0.73};
		bs.bucketSort(arr);
		
		for(int i=0;i<arr.length;i++) {
			System.out.print(arr[i]+",");
		}
	}
}