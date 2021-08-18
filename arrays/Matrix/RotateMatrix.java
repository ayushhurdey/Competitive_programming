/*
48. Rotate Image
Medium

You are given an n x n 2D matrix representing an image, rotate the image by 90 degrees (clockwise).

You have to rotate the image in-place, which means you have to modify the input 2D matrix directly.
DO NOT allocate another 2D matrix and do the rotation.

 

Example 1:
         1  2  3      7  4  1
         4  5  6  =>  8  5  2
         7  8  9      9  6  3

Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
Output: [[7,4,1],[8,5,2],[9,6,3]]

Example 2:

Input: matrix = [[5,1,9,11],[2,4,8,10],[13,3,6,7],[15,14,12,16]]
Output: [[15,13,2,5],[14,3,4,1],[12,6,8,9],[16,7,10,11]]

Example 3:

Input: matrix = [[1]]
Output: [[1]]

Example 4:

Input: matrix = [[1,2],[3,4]]
Output: [[3,1],[4,2]]

 

Constraints:

    matrix.length == n
    matrix[i].length == n
    1 <= n <= 20
    -1000 <= matrix[i][j] <= 1000


*/




class Solution {
    public void rotate(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        
        // transpose a matrix
        for(int i = 0; i < rows; i++){
            for(int j = i; j < cols; j++){
                swap(matrix, i , j);
            }
        }
        
        //swap each values horizontally from left & right of each row
        for(int i = 0; i < rows; i++){
            int j = 0;
            int k = cols - 1;
            while(j < k){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][k];
                matrix[i][k] = temp;
                j++; k--;
            }
        }
    }
    
    
    private void swap(int[][] matrix, int i, int j){
        int temp = matrix[i][j];
        matrix[i][j] = matrix[j][i];
        matrix[j][i] = temp;
    }
}

/*  
    APPROACH:

        1  2  3      1  4  7       7  4  1
        4  5  6  =>  2  5  8   =>  8  5  2
        7  8  9      3  6  9       9  6  3

*/

