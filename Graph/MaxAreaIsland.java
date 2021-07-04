/*
695. Max Area of Island
Medium

You are given an m x n binary matrix grid. An island 
is a group of 1's (representing land) connected 4-directionally 
(horizontal or vertical.) You may assume all four edges of the 
grid are surrounded by water.

The area of an island is the number of cells with a value 1 in the island.

Return the maximum area of an island in grid. If there is no island, return 0.

 

Example 1:

Input: grid = [[0,0,1,0,0,0,0,1,0,0,0,0,0],
               [0,0,0,0,0,0,0,1,1,1,0,0,0],
               [0,1,1,0,1,0,0,0,0,0,0,0,0],
               [0,1,0,0,1,1,0,0,1,0,1,0,0],
               [0,1,0,0,1,1,0,0,1,1,1,0,0],
               [0,0,0,0,0,0,0,0,0,0,1,0,0],
               [0,0,0,0,0,0,0,1,1,1,0,0,0],
               [0,0,0,0,0,0,0,1,1,0,0,0,0]]
Output: 6
Explanation: The answer is not 11, because the island must be connected 4-directionally.

Example 2:

Input: grid = [[0,0,0,0,0,0,0,0]]
Output: 0

 

Constraints:

    m == grid.length
    n == grid[i].length
    1 <= m, n <= 50
    grid[i][j] is either 0 or 1.


*/



// DFS Approach
class Solution {
    private final int[] di = {-1, 0, 1, 0};
    private final int[] dj = {0, 1, 0, -1};
    
    private boolean isSafe(int[][] grid, int i, int j, int m, int n){
        return (i < m && i >= 0) && (j < n && j >= 0) && (grid[i][j] == 1);
    }
    
    
    private int dfs(int[][] grid, int i, int j){
        int m = grid.length;
        int n = grid[0].length;
        grid[i][j] = 0;  // so that visited are not visited again
        int totalArea = 1;
        
        for(int k = 0; k < 4; k++){
            if(isSafe(grid, i + di[k], j + dj[k], m, n)){
                totalArea += dfs(grid, i + di[k], j + dj[k]);
            }
        }
        return totalArea;
    }
    
    
    public int maxAreaOfIsland(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int maxArea = 0;
        
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == 1){
                    int area = dfs(grid, i, j);
                    maxArea = area > maxArea ? area : maxArea;
                }
            }
        }
        return maxArea;
        
    }
}

/*
APPROACH: This question basically breaks down to finding different disconnected
          components in a graph and finding the component with maximum nodes.
*/
