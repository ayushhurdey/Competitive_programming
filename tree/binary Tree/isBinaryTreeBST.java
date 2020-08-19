/*
Given a binary tree. Check whether it is a BST or not.
Example 1:
Input:
    2
 /    \
1      3
Output: 1
Example 2:
Input:
  2
   \
    7
     \
      6
       \
        5
         \
          9
           \
            2
             \
              6
Output: 0
Your Task:
You don't need to read input or print anything. Your task is to complete the function isBST() which takes the root of the tree
as a parameter and returns true if the given binary tree is BST, else returns false. The printing is done by the driver's code.
Expected Time Complexity: O(N).
Expected Auxiliary Space: O(Height of the BST).
Constraints:
0 <= Number of edges <= 100000
*/



/*
Structure of Node:
class Node{
    int data;
    Node left;
    Node right;
    Node(int data){
        this.data = data;
        left=null;
        right=null;
    }
}
*/

public class Tree
{
    Boolean isBst = true;
    Node prev = null;
    
    void inOrder(Node root){
        if(root == null)
            return;
        if(isBst)
            inOrder(root.left);
        
        if(prev != null && root.data <= prev.data)
            isBst = false;
            
        prev = root;   
        if(isBst)
            inOrder(root.right);
    }
     
    // return true if the given tree is a BST, else return false 
    boolean isBST(Node root){
            // code here
            isBst = true;
            prev = null;
            inOrder(root);
            return isBst;
    }
}


/*
Beware of test cases like 
                     1
                   /   \
                  1     1
                /  \     \
               1     1    1
              / \   / \    
             1   1 1   1 
 This is not a BST.
 Also in this solution it has been considered that all values will be distinct for a binary tree to be BST.
 A more optimised solution will be if we do no more recursion after we found at any point that tree is not BST.
*/
