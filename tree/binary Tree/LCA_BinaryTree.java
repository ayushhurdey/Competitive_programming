/*

Lowest Common Ancestor in a Binary Tree

Given a Binary Tree with all unique values and two nodes value 
n1 and n2. The task is to find the lowest common ancestor of the
given two nodes. We may assume that either both n1 and n2 are 
present in the tree or none of them is present. 

Example 1:

Input:
n1 = 2 , n2 =  3
     1
   /  \
  2    3
Output: 1
Explanation:
LCA of 2 and 3 is 1.

Example 2:

Input:
n1 = 3 , n2 = 4
         5
        /
       2
     /  \
    3    4
Output: 2
Explanation: 
LCA of 3 and 4 is 2. 

Your Task:
You don't have to read input or print anything. Your task is to 
complete the function lca() that takes nodes, n1, and n2 as 
parameters and returns LCA node as output.

Expected Time Complexity: O(N).
Expected Auxiliary Space: O(H).
Note: H is the height of the tree.

Constraints:
1 <= Number of nodes <= 100
1 <= Data of a node <= 1000
 
*/

/* A Binary Tree node
class Node
{
    int data;
    Node left, right;

    Node(int item)
    {
        data = item;
        left = right = null;
    }
}*/



class Tree
{

/* If n1 and n2 are present, return reference
   to LCA. If both are not present, return 
   null,. Else if left subtree contains any 
   of them return pointer to left.*/
   
  static boolean nodeOneExists = false, nodeTwoExists = false;
    
	Node lca(Node root, int n1,int n2){
		// Your code here
		nodeOneExists = false;
		nodeTwoExists = false;
		
		Node node = LCAUtil(root, n1, n2);
		if(nodeOneExists && nodeTwoExists){
		    return node;
		}
		return null;
	}
	
	Node LCAUtil(Node root, int n1, int n2){
	    if(root == null)
	        return root;
	    
	    Node temp = null;
	    
	    if(root.data == n1){
	        nodeOneExists = true;
	        temp = root;
	    }
	    
	    if(root.data == n2){
	        nodeTwoExists = true;
	        temp = root;
	    }
	    
	    Node leftLCA = LCAUtil(root.left, n1, n2);
	    Node rightLCA = LCAUtil(root.right, n1, n2);
	    
	    if(temp != null)
	        return temp;
	    
	    if(leftLCA != null && rightLCA != null)
	        return root;
	        
	    return leftLCA != null ? leftLCA : rightLCA;
	}
}


/*
  temp node works when one of the node to be found is the 
  lowest common ancestor itself then it return null(if we don't use temp),
  and hence a null pointer exception,
  which is wrong for sure.
*/
