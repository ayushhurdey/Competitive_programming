/*

Search in a row-column sorted Matrix

Given a matrix of size n x m, where every row and column
is sorted in increasing order, and a number x. Find whether
element x is present in the matrix or not.

Example 1:

Input:
n = 3, m = 3, x = 62
matrix[][] = {{ 3, 30, 38},
              {36, 43, 60},
              {40, 51, 69}}
Output: 0
Explanation:
62 is not present in the matrix, 
so output is 0.

Example 2:

Input:
n = 1, m = 6, x = 55
matrix[][] = {{18, 21, 27, 38, 55, 67}}
Output: 1
Explanation: 55 is present in the matrix.


Your Task:
You don't need to read input or print anything. Complete the
function search() that takes n, m, x, and matrix[][] as input
parameters and returns a boolean value. True if x is present 
in the matrix and false if it is not present.

Expected Time Complexity: O(N + M)
Expected Auxiliary Space: O(1)

Constraints:
1 <= N, M <= 1000
1 <= mat[][] <= 105
1 <= X <= 1000
*/



class Solution 
{ 
	static boolean search(int matrix[][], int n, int m, int x) 
	{  
	    // code here 
	    int i = 0, j = m-1;     // starting from top right corner
	    while(i < n && j >= 0){
	        if(matrix[i][j] == x)
	            return true;
	        if(matrix[i][j] > x)
	            j--;
	        else
	            i++;
	    }
	    return false;
	    
	} 
} 



// HINT: starting from top left corner won't work
// so it's better to start either from top right
// corner or bottom-left corner.

// For remembering the concept of movements take a
// 1-D array and apply the movements of i & j.
// e.g. {{18, 21, 27, 38, 55, 67}}
// starting from right corner j has to be decremented
// if matrix[i][j] > Key, since i has no chance of 
// increament or deceament beacuse of 1 row only.
