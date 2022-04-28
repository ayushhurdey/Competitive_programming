/**
LEETCODE:

108. Convert Sorted Array to Binary Search Tree
Easy

Given an integer array nums where the elements 
are sorted in ascending order, convert it to a
 height-balanced binary search tree.

A height-balanced binary tree is a binary tree in 
which the depth of the two subtrees of every node
 never differs by more than one.

 
             0
            / \
         -3    9
        /     /
     -10     5
Example 1:

Input: nums = [-10,-3,0,5,9]
Output: [0,-3,9,-10,null,5]
Explanation: [0,-10,5,null,-3,null,9] is also accepted:
             
                 0
                /  \
              -10   5
                \    \
                 3    9

Example 2:

     3      1
    /        \
   1          3


Input: nums = [1,3]
Output: [3,1]
Explanation: [1,null,3] and [3,1] are both height-balanced BSTs.

 

Constraints:

    1 <= nums.length <= 10^4
    -10^4 <= nums[i] <= 10^4
    nums is sorted in a strictly increasing order.


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


// TC: O(n)

class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        int len = nums.length;
        if(len == 0) return null;
        return treeMaker(nums, 0, len - 1);
    }
    
    private TreeNode treeMaker(int[] nums, int low, int high){
        if(low > high)
            return  null;
        
        int mid = (low + high)/2;
        TreeNode node = new TreeNode(nums[mid]);
        node.left = treeMaker(nums, low, mid-1);
        node.right = treeMaker(nums, mid+1, high);
        
        return node;
    }
}


/**
APPROACH:
     Start from the mid, add it as a root node.
     then repeat the same for left subtree & right subtree recursively.
 */