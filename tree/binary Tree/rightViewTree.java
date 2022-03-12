/*
Right View of Binary Tree 

Problems
Given a Binary Tree, print Right view of it. Right view of a Binary Tree is set of nodes visible when tree is viewed from right side.

Right view of following tree is 1 3 7 8.

          1
       /     \
     2        3
   /   \      /    \
  4     5   6    7
    \
     8

Example 1:

Input:
       1
    /    \
   3      2
Output: 1 2
Example 2:

Input:
     10
    /   \
  20     30
 /   \
40  60 
Output: 10 30 60
Your Task:
Just complete the function rightView() that takes node as parameter and prints the right view. The newline is automatically appended by the driver code.
Expected Time Complexity: O(N).
Expected Auxiliary Space: O(Height of the Tree).

Constraints:
1 <= Number of nodes <= 105
1 <= Data of a node <= 105.
 
*/


class Tree{
    void rightView(Node node) {
        //add code here.
        if(node == null) return;
        LinkedList<Node> q = new LinkedList<Node>();
        q.add(node);
        int counter = q.size();
        
        while(q.size() > 0){
            Node curr = q.poll();
            counter--;
            if(curr.left != null)
                q.add(curr.left);
            if(curr.right != null)
                q.add(curr.right);
            if(counter == 0){
                System.out.print(curr.data + " ");
                counter = q.size();
            }    
        }
    }
}



// DFS way of right view of Binary Tree - Simpler to understand.

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
    List<Integer> rightViewList = new ArrayList<>();
    Map<Integer, Integer> map = new HashMap<>();
    int maxLevel = 0;
    
    public void getRightSideView(TreeNode root, int level){
        if(root == null)
            return;
        
        // updating map at each node moving left to right at a particlar level.
        map.put(level, root.val);  
        maxLevel = Math.max(maxLevel, level);  //  keeping maxLevel to use in list to add elements from map
        
        getRightSideView(root.left, level+1);   // going left first
        getRightSideView(root.right, level+1);  // then going to right so that rightmost is updated at the last.
    }
    
    public List<Integer> rightSideView(TreeNode root) {
        // Write your code here
        if(root == null)
            return new ArrayList<>();

        getRightSideView(root, 0);
        for(int i = 0; i <= maxLevel; i++){
            rightViewList.add(map.get(i));    
        }

        return rightViewList;
    }
}


/* Approach:
    While visiting each level again and again from left to right
    Keep updating the value corresponding to each level.
    Finally the map will give the rightmost nodes at each level
    in the binary tree.
*/