/*
200. Number of Islands
Medium

Given an m x n 2D binary grid grid which represents a map of '1's (land)
and '0's (water), return the number of islands.

An island is surrounded by water and is formed by connecting adjacent lands
horizontally or vertically. You may assume all four edges of the grid are all
surrounded by water.

 

Example 1:

Input: grid = [
  ["1","1","1","1","0"],
  ["1","1","0","1","0"],
  ["1","1","0","0","0"],
  ["0","0","0","0","0"]
]
Output: 1

Example 2:

Input: grid = [
  ["1","1","0","0","0"],
  ["1","1","0","0","0"],
  ["0","0","1","0","0"],
  ["0","0","0","1","1"]
]
Output: 3

 

Constraints:

    m == grid.length
    n == grid[i].length
    1 <= m, n <= 300
    grid[i][j] is '0' or '1'.


*/


class Solution {
    private final int[] di = {-1,0,1,0};
    private final int[] dj = {0,1,0,-1};
    
    private boolean isSafe(char [][] grid, int i, int j, int m, int n){
        return (i < m && i >= 0) && (j < n && j >=0 ) && (grid[i][j] == '1');
        
    }
    
    private void dfs(char[][] grid, int m ,int n, int i, int j){
        grid[i][j] = 0;   // marking a grid with 0 that is visited so that it is not visited again.
        
        for(int k = 0; k < 4; k++){
            if(isSafe(grid, i + di[k], j + dj[k], m, n)){
                dfs(grid, m, n, i + di[k], j + dj[k]);
            }
        }
    }
    
    
    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int count = 0;
        
        for(int i =0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == '1'){
                    count++;
                    dfs(grid,m,n, i, j);
                }
            }
        }
        return count;
    }
}


/*
APPROACH: Simply count the no of disconnected components in the given graph using dfs. 
*/
