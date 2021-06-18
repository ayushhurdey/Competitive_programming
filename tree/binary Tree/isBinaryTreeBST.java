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





////////////// Smaller Version of same solution above ////////////////////

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    TreeNode prev = null;
    public boolean isValidBST(TreeNode root) {
        if( root == null)
            return true;
        boolean left = isValidBST(root.left);
        
        if(!left)
            return false;
        if(prev != null && prev.val >= root.val)
            return false;
        
        prev = root;
        boolean right = isValidBST(root.right);
        
        return left && right;
    }
}




//                   ✔✔✔✔ 👍👍
//////////////// Even smaller Version  ///////////////

public class Solution {
    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
    
    public boolean isValidBST(TreeNode root, long minVal, long maxVal) {
        if (root == null) return true;
        if (root.val >= maxVal || root.val <= minVal) return false;
        return isValidBST(root.left, minVal, root.val) && isValidBST(root.right, root.val, maxVal);
    }
}

/* Basically what it is doing is recursively iterating over the tree while 
   defining interval <minVal, maxVal> for each node which value must fit in.
   
   For each node in BST on left subtree -> min value is INTEGER_MIN
                                         & max value is root of that node
   Similarly for each node on the right -> min value is root of that node.
                                         & max value is INTEGER_MAX
   And obviously, for the tree root node, min -> INTEGER_MIN & max -> INTEGER_MAX
   
   if any node violates these two properties is violates BST properties also.
*/




////////////////// Iterative inorder Solution ///////////////

public boolean isValidBST(TreeNode root) {
   if (root == null) return true;
   Stack<TreeNode> stack = new Stack<>();
   TreeNode pre = null;
   while (root != null || !stack.isEmpty()) {
      while (root != null) {
         stack.push(root);
         root = root.left;
      }
      root = stack.pop();
      if(pre != null && root.val <= pre.val) return false;
      pre = root;
      root = root.right;
   }
   return true;
}
