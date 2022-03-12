/*
Left View of Binary Tree
                              
Problems
Given a Binary Tree, print Left view of it. Left view of a Binary Tree is set of nodes visible when tree is visited from Left side. The task is to complete the function leftView(), which accepts root of the tree as argument.

Left view of following tree is 1 2 4 8.

          1
       /     \
     2         3
   /     \    /  \
  4     5   6     7
   \
     8   

Example 1:

Input:
   1
 /  \
3    2
Output: 1 3

Example 2:

Input:
          10
         /  \
        20   30
       /  \
      40   60 

Output: 10 20 40
Your Task:
You just have to complete the function leftView() that prints the left view. The newline is automatically appended by the driver code.
Expected Time Complexity: O(N).
Expected Auxiliary Space: O(Height of the Tree).

Constraints:
1 <= Number of nodes <= 100
1 <= Data of a node <= 1000
*/

class Tree
{
    static int maxLevel= -1;
    void leftView(Node root)
    {
      // Your code here
      if(root == null) return;
      maxLevel = -1;
      leftViewUtil(root,0);
      
    }
    
    void leftViewUtil(Node root,int level){
        if(root == null) return;
        if(level > maxLevel){
            //System.out.println("\nLevel and maxLevel = " + level + " " + maxLevel);
            System.out.print(root.data + " ");
            maxLevel = level;
        }
        //System.out.print("\nbefore left Level = " + level+" ,max Level="+maxLevel);
        leftViewUtil(root.left, level+1);
        //System.out.print("\nbefore right Level = " + level+" ,max Level="+maxLevel);
        leftViewUtil(root.right, level+1);
        
    }
}

/*
Hint: Draw Horizontal levels. Starting with -1(i.e null level).
      Maintain maxLevelAchievedSoFar to track the maximum level achieved
        that will be helpful when right subtree's height > left subtree height.
        Increase level each time you traverse to left or right subtree.
*/




// DFS way of Left View of Binary Tree - Simpler to understand. - Similar to Right View

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
    List<Integer> leftViewList = new ArrayList<>();
    Map<Integer, Integer> map = new HashMap<>();
    int maxLevel = 0;
    
    public void getLeftSideView(TreeNode root, int level){
        if(root == null)
            return;
        
        // updating map at each node moving right to left at a particlar level.
        map.put(level, root.val);  
        maxLevel = Math.max(maxLevel, level);  //  keeping maxLevel to use in list to add elements from map
        
        getLeftSideView(root.right, level+1);   // going right first
        getLeftSideView(root.left, level+1);  // then going to left so that leftmost is updated at the last.
    }
    
    public List<Integer> leftSideView(TreeNode root) {
        // Write your code here
        if(root == null)
            return new ArrayList<>();

        getLeftSideView(root, 0);
        for(int i = 0; i <= maxLevel; i++){
            leftViewList.add(map.get(i));    
        }

        return leftViewList;
    }
}


/* Approach:
    While visiting each level again and again from right to left
    Keep updating the value corresponding to each level.
    Finally the map will give the leftmost nodes at each level
    in the binary tree.
*/