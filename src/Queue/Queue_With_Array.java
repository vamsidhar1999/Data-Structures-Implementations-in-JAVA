package Queue;

import java.util.*;

class Queue1{

 int front;
 int rear;
 int[] arr;
 
 Queue1()
 {
   front=rear=-1;
   arr=new int[10];
  }
  
  void enqueue(int a)
  {
    if(rear==arr.length-1)
		System.out.println("overflow");
	else
		arr[++rear]=a;
	
	if(front==-1)
		front++;
   }
   
   int dequeue()
   {
     int x=-1;
	 if(front==-1)
		System.out.println("underflow");
	 else
		x=arr[front++];
	 if(rear==0)
	     rear--;
	 return x;
    }
	
	void display()
	{
	  for(int i=front;i<=rear;i++)
		System.out.print(arr[i]+" ");

	 System.out.println();


	}
}

public class Queue_With_Array{

	public static void main(String[] args)
	{
	  Queue1 ob=new Queue1();
	  ob.enqueue(1);
	  ob.enqueue(2);
	  ob.enqueue(3);
	  ob.enqueue(4);
	  ob.enqueue(5);
	  ob.display();
	  ob.dequeue();
	  ob.display();
	 }
}