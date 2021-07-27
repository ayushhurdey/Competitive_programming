/**
Convert a given Linked List to complete Binary Tree

  Input : 1 -> 2 -> 3 -> 4 -> 5 -> 6
  Output: 

          1
        /   \
       2     3
     /  \   /  \
    4   5   6   null

    Inorder: 4 2 5 1 6 3
**/


import java.util.*;

class Main {
  static class NodeList{
    int data;
    NodeList next;
    
    NodeList(int data){
      this.data = data;
      this.next =  null;
    }
  }

  static class TreeNode{
    int data;
    TreeNode left, right;

    TreeNode(int data){
      this.data = data;
      this.left = null;
      this.right = null;
    }
  }
  
  public static void main(String[] args) {
    NodeList ll = new NodeList(1);
    ll.next = new NodeList(2);
    ll.next.next = new NodeList(2);
    ll.next.next = new NodeList(3);
    ll.next.next.next = new NodeList(4);
    ll.next.next.next.next = new NodeList(5);
    ll.next.next.next.next.next = new NodeList(6);

    TreeNode root = convertLLToBinaryTree(ll);
    inorder(root);
  }

  private static void inorder(TreeNode root){
    if(root == null) return;

    inorder(root.left);
    System.out.print(root.data + " ");
    inorder(root.right);
  }

  private static TreeNode convertLLToBinaryTree(NodeList head){
      if(head == null)
        return null;
      
      Queue<TreeNode> queue = new ArrayDeque<>();
      TreeNode root = new TreeNode(head.data);
      queue.add(root);

      head = head.next;

      while(head != null){
        TreeNode top = queue.poll();

        top.left = new TreeNode(head.data);
        queue.add(top.left);

        head = head.next;

        if(head != null){
          top.right = new TreeNode(head.data);
          queue.add(top.right);
          head = head.next;
        }
      }

      return root;
  }
}

// Refer: https://replit.com/@AyushCh/Linked-list-to-complete-binary-tree#Main.java
