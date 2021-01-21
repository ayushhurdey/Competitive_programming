/*

Boolean Matrix
Medium Accuracy: 40.02% Submissions: 8400 Points: 4

Given a boolean matrix of size RxC where each cell contains 
either 0 or 1, modify it such that if a matrix cell matrix[i][j]
is 1 then all the cells in its ith row and jth column will become 1.

Example 1:

Input:
R = 2, C = 2
matrix[][] = {{1, 0},
              {0, 0}}
Output: 
1 1
1 0 
Explanation:
Only cell that has 1 is at (0,0) so all 
cells in row 0 are modified to 1 and all 
cells in column 0 are modified to 1.


Example 2:

Input:
R = 4, C = 3
matrix[][] = {{ 1, 0, 0},
              { 1, 0, 0},
              { 1, 0, 0},
              { 0, 0, 0}}
Output: 
1 1 1
1 1 1
1 1 1
1 0 0 
Explanation:
The position of cells that have 1 in
the original matrix are (0,0), (1,0)
and (2,0). Therefore, all cells in row
0,1,2 are and column 0 are modified to 1. 


Your Task:
You dont need to read input or print anything. Complete the function
booleanMatrix() that takes the matrix as input parameter and modifies
it in-place.
 

Expected Time Complexity: O(R * C)
Expected Auxiliary Space: O(R + C) 
 

Constraints:
1 ≤ R, C ≤ 1000
0 ≤ matrix[i][j] ≤ 1
*/


class Solution{
    void booleanMatrix(int matrix[][]){
        // code here 
        int rows = matrix.length;
        int columns = matrix[0].length;
        int[] rowFlags = new int[rows];
        int[] colFlags = new int[columns];
        
        Arrays.fill(rowFlags, 0);
        Arrays.fill(colFlags, 0);
        
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < columns; j++){
                if(matrix[i][j] ==  1){
                    rowFlags[i] = 1;
                    colFlags[j] = 1;
                }
            }
        }
        
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < columns; j++){
                if(rowFlags[i] == 1 || colFlags[j] == 1){
                    matrix[i][j] = 1;
                }
            }
        }
    }
}




/*
  Approach:
    * Take two arrays say A and B then
      whenever there is a 1 in traversing 
      the matrix for first time put 1 in
      i th of A and j th of B.
       
    * Second traversal wherever
      A[i] == 1 || B[j] == 1
      put 1 in the same matrix.
      
    * The approach is simple
      whenever there is 1 in the matrix
      that means that particular row and column
      both will convert fully to 1.
*/
