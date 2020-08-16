/*Given a binary tree, find its height.
Eg.         1
          /  \
         2    3     diameter = 2
         
Eg.          1
           /  \
          2    3
        /  \   
       4    5       diameter = 4


Expected Time Complexity: O(N).
Expected Auxiliary Space: O(1).
*/


class Tree
{
    // return the Height of the given Binary Tree
    
    int max(int left, int right){
        return (left > right) ? left : right;
    }
    
    int height(Node root) 
    {
         // Your code here
         if(root == null)
            return 0;
         int leftHeight = height(root.left);
         int rightHeight = height(root.right);
         return max(leftHeight, rightHeight)+1;
    }   
}
