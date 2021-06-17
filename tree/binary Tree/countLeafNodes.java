/*
Count Leaves in Binary Tree 
        
Problems
Given a Binary Tree of size N , You have to count leaves in it. For example, there are two leaves in following tree

        1
     /      \
   10      39
  /
5

Input:
First line of input contains the number of test cases T. For each test case, there will be only a single line of input which is a string representing the tree as described below: 

The values in the string are in the order of level order traversal of the tree where, numbers denote node values, and a character “N” denotes NULL child.

For example:

For the above tree, the string will be: 1 2 3 N N 4 6 N 5 N N 7 N

Output:
For each test case print the count of leaves.
Your Task:
You don't have to take input. Complete the function countLeaves() that takes root node of given tree as parameter and returns the count of leaves in tree . The printing is done by the driver code.
Constraints:
1<= T <= 30
1<= N <= 104
Example:
Input:
2
3 4 2 
4 8 10 7 N 5 1 3 
Output:
2
3
Explanation:
Test Case 2:  Given Tree is 
                                 4
                               /     \
                              8       10
                            /       /    \
                           7       5      1
                          /
                         3
Three leaves are 3 , 5 and 1.


*/


class Tree
{
    int count = 0;
    void preorder(Node node){
         if(node == null)
            return;
         if(node.left == null && node.right == null)
             count +=1;  
         countLeaves(node.left);
         countLeaves(node.right);
    }
    
    int countLeaves(Node node) 
    {
         // Your code
         preorder(node);
         return count;
    }
}



/*-----------------------Simple and Crisp solution----------------*/

class Tree
{   
    int countLeaves(Node node) 
    {
         // Your code
         if(node == null)
            return 0;
         if(node.left == null && node.right == null)
            return 1;
         return countLeaves(node.left) + countLeaves(node.right);
    }
}
