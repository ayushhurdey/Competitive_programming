/*
111. Minimum Depth of Binary Tree
Easy

Given a binary tree, find its minimum depth.

The minimum depth is the number of nodes along the shortest path from 
the root node down to the nearest leaf node.

Note: A leaf is a node with no children.

 

Example 1:

        3
       /  \
      9    20
          /  \
         15    7

Input: root = [3,9,20,null,null,15,7]
Output: 2

Example 2:
        
        2
         \
          3
           \
            4
             \
              5
               \
                6

Input: root = [2,null,3,null,4,null,5,null,6]
Output: 5

 

Constraints:

    The number of nodes in the tree is in the range [0, 105].
    -1000 <= Node.val <= 1000


*/


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


// Recursive Solution (Leetcode: 5ms)
class Solution {
    public int minDepth(TreeNode root) {
       if(root == null) 
            return 0;
       int leftMin = minDepth(root.left);
       int rightMin = minDepth(root.right);
       return (leftMin == 0 || rightMin == 0) ? leftMin + rightMin + 1 : 1 + Math.min(leftMin, rightMin);
   }
}



// Iterative Queue solution (Leetcode: 1ms)
class Solution {
    public int minDepth(TreeNode root) {
        if(root == null) 
            return 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int size = 1;
        int depth = 0;
        
        while(!queue.isEmpty()){
            TreeNode top = queue.poll();
            size--;
            if(top.left == null && top.right == null)
                break;
            
            if(top.left != null)
                queue.add(top.left);
            if(top.right != null)
                queue.add(top.right);
            if(size == 0){
                depth++;
                size = queue.size();
            }
        }
        return depth + 1;  
    }
}
