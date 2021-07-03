/*
A celebrity is a person who is known to all but does not know
anyone at a party. If you go to a party of N people, find if 
there is a celebrity in the party or not.
A square NxN matrix M[][] is used to represent people at the
party such that if an element of row i and column j  is set
to 1 it means ith person knows jth person. Here M[i][i] will
always be 0.
Note: Follow 0 based indexing.
 

Example 1:

Input:
N = 3
M[][] = {{0 1 0},
         {0 0 0}, 
         {0 1 0}}
Output: 1
Explanation: 0th and 2nd person both
know 1. Therefore, 1 is the celebrity. 


Example 2:

Input:
N = 2
M[][] = {{0 1},
         {1 0}}
Output: -1
Explanation: The two people at the party both
know each other. None of them is a celebrity.


Your Task:
You don't need to read input or print anything. Complete the 
function celebrity() which takes the matrix M and its size N
as input parameters and returns the index of the celebrity. 
If no such celebrity is present, return -1.


Expected Time Complexity: O(N)
Expected Auxiliary Space: O(1)


Constraints:
2 <= N <= 3000
0 <= M[][] <= 1
*/


class Solution
{ 
    //Function to find if there is a celebrity in the party or not.
    int celebrity(int M[][], int n){
    	// code here 
    	Stack<Integer> stack = new Stack<>();
    	
      // push all people in the stack
    	for(int i = 0; i < n; i++)
    	    stack.push(i);
    	
    	while(stack.size() >= 2){
        	int topOne = stack.pop();
        	int topTwo = stack.pop();
        	
        	if(M[topOne][topTwo] == 1)  // if topOne knows topTwo -> topOne is not a celebrity.
        	    stack.push(topTwo);
        	else                        // if topOne doesn't knows topTwo -> topTwo is not a celebrity.
        	    stack.push(topOne);
    	}
    	
    	// only one element is left in stack now.
    	int potentialCelebrity = stack.pop();
    	
    	for(int someone = 0; someone < n; someone++){
    	    if(someone != potentialCelebrity){     // leaving the diagonal elements because someone knows himself doesn't matter.
    	        if(M[potentialCelebrity][someone] == 1 || M[someone][potentialCelebrity] == 0)
    	            return -1;
    	    }
    	}
    	
    	return potentialCelebrity;   
    }
}


/*
APPROACH:  This is a elimination based approach. We eliminate 
           people who cannot be celebrity and the last one left
           in elimination round is a potential celebrity.
           Now we only have to check for this on only if this 
           is a celebrity or not.
           
            ALGORITHM:

          - Push all people in the stack 
          - while stack does not have only one person left
              - pop top two people
              - then if first knows second (ie. M[first][second] = 1)=> first is not a celebrity.
              - else => first doesn't know second => second cannot be celebrity
          - pop the potential celebrity out
          - for each person check
               if either potential celebrity knows someone or someone does not know potential celebrity
               then even potential celebrity is not a celebrity
                  return -1
          - return potential celebrity
*/
    	
