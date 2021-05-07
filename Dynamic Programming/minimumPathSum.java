/*
Given a m x n grid filled with non-negative numbers, 
find a path from top left to bottom right, which minimizes 
the sum of all numbers along its path.

Note: You can only move either down or right at any point in time.

 

Example 1:

Input: grid = [[1,3,1],
               [1,5,1],
               [4,2,1]]
Output: 7
Explanation: Because the path 1 → 3 → 1 → 1 → 1 minimizes the sum.

Example 2:

Input: grid = [[1,2,3],
               [4,5,6]]
Output: 12

 

Constraints:

    m == grid.length
    n == grid[i].length
    1 <= m, n <= 200
    0 <= grid[i][j] <= 100


*/

// O(2^n) recursive solution.
class Solution {
    public int minPathSum(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        return findMin(grid, rows-1, cols-1);
    }

    int findMin(int[][] arr, int m, int n){
        if(m == 0 && n == 0)
            return arr[0][0];
        else if(m == 0)
            return findMin(arr, m, n-1) + arr[m][n];
        else if(n == 0)
            return findMin(arr, m - 1, n) + arr[m][n];
        else{
            return Math.min(
                         findMin(arr, m-1, n),
                         findMin(arr, m, n-1)
                        ) + arr[m][n];
        }
    }
}


// O(n^2)  DP solution .

class Solution {
    public int minPathSum(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        return findMin(grid, rows, cols);
    }
    
    int findMin(int[][] arr, int m, int n){
        if(m-1 == 0 && n-1 == 0)
            return arr[0][0];
        int dp[][] = new int[m][n];
        dp[0][0] = arr[0][0];
        
        for(int i = 1; i < m; i++)
            dp[i][0] = dp[i-1][0] + arr[i][0];
      
        for(int j = 1; j < n; j++)
            dp[0][j] = dp[0][j-1] + arr[0][j];
      
        for(int i = 1; i < m; i++){
            for(int j = 1; j < n; j++){
                dp[i][j] = Math.min(dp[i-1][j], dp[i][j-1]) + arr[i][j];
            }
        }
        return dp[m-1][n-1];
    }
}
