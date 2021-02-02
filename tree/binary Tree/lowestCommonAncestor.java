/*
Lowest Common Ancestor in a Binary Tree 
Given a Binary Tree with all unique values and two nodes value n1 and n2. The task is to find the lowest common ancestor of the given two nodes. We may assume that either both n1 and n2 are present in the tree or none of them is present. 

Example 1:

Input:
n1 = 2 , n2 =  3

     1
   /  \
  2    3
Output: 1

Example 2:

Input:
n1 = 3 , n2 = 4

         5
        /
       2
     /  \
    3    4
Output: 2
Your Task:
 Just complete the function lca() that takes nodes, n1, and n2 as parameters and returns LCA node as output.

Expected Time Complexity: O(N).
Expected Auxiliary Space: O(H).
Note: H is the height of the tree.

Constraints:
1 <= Number of nodes <= 100
1 <= Data of a node <= 1000
 
*/

⚠⚠ This solution works only if it is guaranteed
that the solution to the problem exists.

class Tree
{

/* If n1 and n2 are present, return reference
   to LCA. If both are not present, return 
   null,. Else if left subtree contains any 
   of them return pointer to left.*/
	Node lca(Node root, int n1,int n2)
	{
		// Your code here
		if(root == null)
		   return null;
		if(root.data == n1 || root.data == n2)
		   return root;
		
		Node leftLca =  lca(root.left,n1,n2);
		Node rightLca = lca(root.right,n1,n2);
		
		if(leftLca != null && rightLca != null)
		     return root;
		
		return leftLca != null ? leftLca : rightLca;     
	}
}
