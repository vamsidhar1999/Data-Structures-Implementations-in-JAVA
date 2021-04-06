package Trees;
import java.util.*;
class Tree{
    class Node{
        int data;
        Node left;
        Node right;
        Node(int data){
            this.data = data;
        }
    }
    
    Node root;
    int size=0;
    private Node add(int val, Node root){
        if(root==null){
            root = new Node(val);
            return root;
        }
        if(val<root.data){
            root.left =  add(val, root.left);
        }else if(val>root.data){
            root.right = add(val, root.right);
        }
        
        return root;
    }
    
    public void add(int val){
        root = add(val, root);
        size++;
    }
    
    private void inorder(Node root){
        if(root==null){
            return;
        }
        System.out.print(root.data+" ");
        inorder(root.left);
        inorder(root.right);
    }
    
    public void inorder(){
        inorder(root);
    }
    private Node randomNode(Node root) {
        int r = new Random().nextInt(size);
        if (r == 0) {
            return root;
        } else if (root!=null && root.left != null && 1 <= r && r <= size) {
            return randomNode(root.left);
        } else if(root!=null){
            return randomNode(root.right);
        }
    }
    
    public void randomNode(){
        System.out.println(randomNode(root).data);
    }
}

public class Practice{
     public static void main(String []args){
         Tree tree = new Tree();
         tree.add(5);
         tree.add(3);
         tree.add(7);
         tree.add(6);
         tree.add(1);
         tree.add(2);
         tree.add(8);
         tree.add(4);
         
         tree.randomNode();
     }
}