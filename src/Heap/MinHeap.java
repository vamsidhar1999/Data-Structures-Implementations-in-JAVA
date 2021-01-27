package Heap;

//Max-Heap data structure in Java

import java.io.*;
import java.util.*;

public class MinHeap {
    
    ArrayList<Integer> heap = new ArrayList<Integer>();
    
    private int getLeftChildIndex(int parentIndex) {
    return 2 * parentIndex + 1;
  }

  private int getRightChildIndex(int parentIndex) {
    return 2 * parentIndex + 2;
  }

  private int getParentIndex(int childIndex) {
    return (childIndex - 1) / 2;
  }

  private boolean hasLeftChild(int index) {
    return getLeftChildIndex(index) < heap.size();
  }

  private boolean hasRightChild(int index) {
    return getRightChildIndex(index) < heap.size();
  }

  private boolean hasParent(int index) {
    return getParentIndex(index) >= 0;
  }

  private int leftChild(int parentIndex) {
    return heap.get(getLeftChildIndex(parentIndex));
  }

  private int rightChild(int parentIndex) {
    return heap.get(getRightChildIndex(parentIndex));
  }

  private int parent(int childIndex) {
    return heap.get(getParentIndex(childIndex));
  }

  private void swap(int index1, int index2) {
    int element = heap.get(index1);
    heap.set(index1, heap.get(index2));
    heap.set(index2, element);
  }
    
    private void heapifyDown(int i) {
    int index = i;

    while (hasLeftChild(index)) {
      int smallestChildIndex = getLeftChildIndex(index);

      if (hasRightChild(index) && rightChild(index) < leftChild(index)) {
        smallestChildIndex = getRightChildIndex(index);
      }

      if (heap.get(index) > heap.get(smallestChildIndex)) {
        swap(index, smallestChildIndex);
      } else {
        break;
      }
      index = smallestChildIndex;
    }
  }
    
    private void heapifyUp() {
    int index = heap.size() - 1;

    while (hasParent(index) && parent(index) > heap.get(index)) {
      swap(getParentIndex(index), index);
      index = getParentIndex(index);
    }
  }
    
    void add(int num){
        if(heap.size()==0){
            heap.add(num);
        }else{
            heap.add(num);
            heapifyUp();
        }
    }
    
    void delete(int num){
        int i;
        for(i=0;i<heap.size();i++){
            if(num==heap.get(i)){
                break;
            }
        }
        swap(i, heap.size()-1);
        heap.remove(heap.size()-1);
        
        heapifyDown(i);
    }
    
    int getMin(){
        return heap.get(0);
    }
    
    
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        MinHeap h = new MinHeap();
        for(int i=0;i<n;i++){
            int q = scan.nextInt();
            if(q==1){
                int num = scan.nextInt();
                h.add(num);
            }else if(q==2){
                int num = scan.nextInt();
                h.delete(num);
            }else if(q==3){
                System.out.println(h.getMin());
            }
        }
    }
}
