/*
994. Rotting Oranges
Medium

You are given an m x n grid where each cell can have
one of three values:

    0 representing an empty cell,
    1 representing a fresh orange, or
    2 representing a rotten orange.

Every minute, any fresh orange that is 4-directionally
adjacent to a rotten orange becomes rotten.

Return the minimum number of minutes that must elapse 
until no cell has a fresh orange. If this is impossible, 
return -1.

 

Example 1:

Minute 0:     Minute 1:     Minute 2:     Minute 3:    Minute 4:

[[2,1,1],    [[2,2,1],   [[2,2,2],       [[2,2,2],     [[2,2,2], 
 [1,1,0],     [2,1,0],    [2,2,0],        [2,2,-],      [2,2,0],
 [0,1,1]]     [0,1,1]]    [0,1,1]]        [0,2,0]]      [0,2,2]]

Input: grid = [[2,1,1],[1,1,0],[0,1,1]]
Output: 4

Example 2:

Input: grid = [[2,1,1],[0,1,1],[1,0,1]]
Output: -1
Explanation: The orange in the bottom left corner (row 2, column 0)
is never rotten, because rotting only happens 4-directionally.

Example 3:

Input: grid = [[0,2]]
Output: 0
Explanation: Since there are already no fresh oranges at minute 0,
the answer is just 0.

 

Constraints:

    m == grid.length
    n == grid[i].length
    1 <= m, n <= 10
    grid[i][j] is 0, 1, or 2
*/



class Solution {
    private int di[] = {-1, 0, 1, 0};
    private int dj[] = {0, 1, 0, -1};
    
    class Pair{
        int first;
        int second;
        Pair(int first, int second){
            this.first = first;
            this.second = second;
        }
    }
    
    public int orangesRotting(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int totalTime = Integer.MAX_VALUE;
        Queue<Pair> queue = new LinkedList<>();
        int countFresh = 0;
        
        for(int i = 0; i < rows; i++){
            for(int j =0; j < cols; j++){
                if(grid[i][j] == 2){
                       queue.add(new Pair(i, j));
                }
                else if( grid[i][j] == 1){
                    countFresh += 1;
                }
               
            }
        }
        
        if(countFresh == 0) return 0;
        int count = 0;
        
        while(!queue.isEmpty()){
            count++;
            
            int size = queue.size();
            for(int i = 0; i < size; i++){
                Pair top = queue.poll();

                for(int k = 0; k < 4; k++){
                    int dirOne = top.first + di[k];
                    int dirTwo = top.second + dj[k];
                    if(isSafe(grid, dirOne, dirTwo, rows, cols)){
                        queue.add(new Pair(dirOne, dirTwo));
                        grid[dirOne][dirTwo] = 2;
                        countFresh--;
                    }
                }
            }
        }
        return countFresh == 0 ? count - 1 : -1;
        
    }
    
    
    private boolean isSafe(int[][] grid, int i, int j, int m, int n){
        return (i >= 0 && i < m) && (j >= 0 && j < n) && (grid[i][j] == 1);
    }   
}
