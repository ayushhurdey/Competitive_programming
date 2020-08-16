/*
Given a Binary Tree, find diameter of it.
+The diameter of a tree is the number of nodes on the longest path between two leaves in the tree.
The diagram below shows two trees each with diameter nine, the leaves that form the ends of a longest
path are shaded (note that there is more than one path in each tree of length nine, but no path longer
than nine nodes).

Example 1:
Input:
       1
     /  \
    2    3
Output: 3


Example 2:
Input:
         10
        /   \
      20    30
    /   \ 
   40   60
Output: 4
*/



class Tree {
    /* Complete the function to get diameter of a binary tree */
    int maxDiam;
    
    int max(int left, int right){
        return left > right ? left : right;
    } 
    int calcDiameter(Node root){
        if(root == null)
            return 0;
        int leftHeight = calcDiameter(root.left);
        int rightHeight = calcDiameter(root.right);
        int diam = leftHeight + rightHeight +1;
        maxDiam = max(maxDiam, diam);
        return max(leftHeight , rightHeight) +1;
    }
    
    int diameter(Node root) {
        // Your code here
        calcDiameter(root);
        return maxDiam;
    }
}
