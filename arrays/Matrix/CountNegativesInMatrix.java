/*
1351. Count Negative Numbers in a Sorted Matrix
Easy

Given a m x n matrix grid which is sorted in non-increasing
order both row-wise and column-wise, return the number of 
negative numbers in grid.

 

Example 1:

Input: grid = [[4,3,2,-1],[3,2,1,-1],[1,1,-1,-2],[-1,-1,-2,-3]]
Output: 8
Explanation: There are 8 negatives number in the matrix.

Example 2:

Input: grid = [[3,2],[1,0]]
Output: 0

Example 3:

Input: grid = [[1,-1],[-1,-1]]
Output: 3

Example 4:

Input: grid = [[-1]]
Output: 1

 

Constraints:

    m == grid.length
    n == grid[i].length
    1 <= m, n <= 100
    -100 <= grid[i][j] <= 100

 
Follow up: Could you find an O(n + m) solution?

*/


class Solution {
    public int countNegatives(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int r = rows - 1;
        int c = 0;
        int count = 0;
        
        while(r >= 0 && c < cols){
            if(grid[r][c] < 0){
                r--;
                count += cols - c;
            }
            else
                c++;
        }
        return count;
    }
}


/* TIP: In such question start moving from
         down left side in most cases.
         When get negatives, count negatives in a row(#columns - current column) and 
           decrease the row count.
         otherwise move in the colums until you get negative.
         
         It is more like a staircase.
*/
