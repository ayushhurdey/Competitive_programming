/*

Max and min element in Binary Tree
Easy Accuracy: 50.16% Submissions: 12596 Points: 2

Given a Binary Tree, find maximum and minimum elements in it.

Input:
The first line of input contains an integer T denoting the 
number of test cases. Then T test cases follow. Each test 
case contains an integer n denoting the number of edges. 
The following line contains the edges as shown in the example.

Output:
Print two space-separated integers maximum and minimum
element in the binary tree.

Constraints:
1<=T<=10^5
1<=n<=10^5
1<=data of the node<=10^5

Example:
Input:
1
7
2 7 L 2 5 R 7 6 R 6 1 L 6 11 R 5 9 R 9 4 L

Output:
11 1

Explanation:
                           2
                        /     \
                       7        5
                       \         \
                        6         9
                      /   \       /
                     1     11    4
The above tree is constructed through the example in the
input. The maximum and minimum element in this binary 
tree is 11 and 1 respectively.
*/


/*class Node
{
    int data;
    Node left,right;
    Node(int d)
    {
        data=d;
        left=right=null;
    }
}*/

//Complete the findMax and findMin functions.
class GFG
{
  static int min = Integer.MAX_VALUE;
  static int max = Integer.MIN_VALUE;
  
	public static int findMax(Node root)
	{
	    //Add your code here.
	    if(root == null)
	        return Integer.MIN_VALUE;
	        
	    if(root.data > max)
	        max = root.data;
	    
	    int left = findMax(root.left);
	    int right = findMax(root.right);
	    int maxValue = Math.max(Math.max(left, right), max);
	    max = Integer.MIN_VALUE;   // to handle multiple cases
	    return maxValue;
	}
	
	public static int findMin(Node root)
	{
	    //Add your code here.
	    if(root == null)
	        return Integer.MAX_VALUE;
	        
	    if(root.data < min)
	        min = root.data;
	    
	    int left = findMin(root.left);
	    int right = findMin(root.right);
	    int minValue = Math.min(Math.min(left, right), min);
	    min = Integer.MAX_VALUE;  // to handle multiple cases
	    return minValue;
	}
}

/*
--> can also be done in this way if there is only one case.

public static int findMin(Node root){
	    //Add your code here.
	    if(root == null)
	        return Integer.MAX_VALUE;
	        
	    if(root.data < min)
	        min = root.data;
	    
	    int left = findMin(root.left);
	    int right = findMin(root.right);
	    return Math.min(Math.min(left, right), min);
}
*/
