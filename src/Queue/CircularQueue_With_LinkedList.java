package Queue;

import java.io.*;
class Node{
    int data;
    Node next;
    public Node(){
        data = 0;
        next = null;
    }
    public Node(int d){
        data = d;
        next = null;
    }
}
public class CircularQueue_With_LinkedList{
    Node front;
    Node rear;
    public CircularQueue_With_LinkedList(){
        front = null;
        rear = null;
    }
    public void push(int d){
        Node n = new Node(d);
        if(front == null)
            front = n;
        else
            rear.next = n;
        rear = n;
        rear.next = front;
        System.out.println(d + " pushed.");
    }
    public void pop(){
        if(front == null){
            System.out.println("Queue underflow!");
            return;
        }
        int d = 0;
        d = front.data;
        if(front == rear){
            front = null;
            rear = null;
        }
        else{
            front = front.next;
            rear.next = front;
        }
        System.out.println(d + " popped.");
    }
    public void display(){
        if(front == null){
            System.out.println("Queue is empty!");
            return;
        }
        Node n = front;
        System.out.println("Circular queue contents:");
        while(n.next != front){
            System.out.print(n.data + "\t");
            n = n.next;
        }
        System.out.println(n.data);
    }
    public static void main(String args[])throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        CircularQueue_With_LinkedList queue = new CircularQueue_With_LinkedList();
        while(true){
            System.out.println("1. Push");
            System.out.println("2. Pop");
            System.out.println("3. Display");
            System.out.print("Enter your choice: ");
            int choice = Integer.parseInt(br.readLine());
            switch(choice){
                case 1:
                System.out.print("Element to be pushed: ");
                int d = Integer.parseInt(br.readLine());
                queue.push(d);
                break;
                case 2:
                queue.pop();
                break;
                case 3:
                queue.display();
                break;
                default:
                System.out.println("Bye...");
                return;
            }
        }
    }
}