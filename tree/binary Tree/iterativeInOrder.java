/*
Inorder Traversal 
          
Problems
Given a Binary Tree, find the In-Order Traversal of it.

Example 1:

Input:
       1
     /  \
    3    2
Output: 3 1 2

Example 2:

Input:
        10
     /      \ 
    20       30 
  /    \    /
 40    60  50
Output: 40 20 60 10 50 30

Your Task:
You don't need to read input or print anything. Your task is to complete the function inOrder() that takes root node of the tree as input and returns a list containing the In-Order Traversal of the given Binary Tree.

Expected Time Complexity: O(N).
Expected Auxiliary Space: O(N).

Constraints:
1 <= Number of nodes <= 105
1 <= Data of a node <= 105
 
*/


class Tree
{
    // Return a list containing the inorder traversal of the given tree
    
    ArrayList<Integer> inOrder(Node root)
    {
        // Code
        ArrayList<Integer> list = new ArrayList<Integer>();
        Stack<Node> s = new Stack<Node>();
        Node curr = root;
        if(root == null)
            return list;
        while(curr != null || !s.empty()){
              while(curr != null){
                  s.push(curr);
                  curr = curr.left;
              }
              
              curr = s.pop();
              list.add(curr.data);
              curr = curr.right;
        }
        return list;
    }
}
