/*

Find the number of islands
Medium Accuracy: 38.66% Submissions: 51996 Points: 4

Given a grid consisting of '0's(Water) and '1's(Land). 
Find the number of islands.
Note: An island is surrounded by water and is formed by
connecting adjacent lands horizontally or vertically or
diagonally i,e in all 8 directions.
 

Example 1:

Input:
grid = {{0,1},{1,0},{1,1},{1,0}}
Output:
1
Explanation:
The grid is-
0 1
1 0
1 1
1 0
All lands are connected.

Example 2:

Input:
grid = {{0,1,1,1,0,0,0},{0,0,1,1,0,1,0}}
Output:
2
Expanation:
The grid is-
0 1 1 1 0 0 0
0 0 1 1 0 1 0 
There are two islands one is colored in blue 
and other in orange.

 

Your Task:
You don't need to read or print anything. Your task is 
to complete the function numIslands() which takes grid
as input parameter and returns the total number of islands.
 

Expected Time Compelxity: O(n*m)
Expected Space Compelxity: O(n*m)
 

Constraints:
1 <= n, m <= 500
*/


// DFS Approach

class Solution
{
    int ROWS;
    int COLS;
    boolean[][] visited;
    
    public int numIslands(char[][] grid)
    {
        // Code here
        ROWS = grid.length;
        COLS = grid[0].length;
        //System.out.println(ROWS+ " " + COLS);
        visited = new boolean[ROWS][COLS];
        
        for(int i = 0; i < ROWS; i++)
            for(int j = 0; j < COLS; j++)
                visited[i][j] = false;
                
        int count = 0;
        
        for(int i = 0; i < ROWS; i++){
            for(int j = 0 ;j < COLS; j++){
                if(grid[i][j] == '1' && !visited[i][j]){
                    DFS(grid, i, j);
                    printVisited();
                    count++;
                }
            }
        }
        return count;
    }
    
    void DFS(char[][] M, int i, int j){
        
        int[] rowNbr = {-1,-1,0,1,1,1,0,-1};
        int[] colNbr = {0,1,1,1,0,-1,-1,-1};
        
        visited[i][j] = true;
        
        for(int k = 0; k < 8; k++){
            if(isSafe(M, i + rowNbr[k], j + colNbr[k]))
                DFS(M, i + rowNbr[k], j + colNbr[k]);
        }
    }
    
    boolean isSafe(char[][] M, int i, int j){
        return (i >= 0) && (i < ROWS) && (j >= 0) && (j < COLS) && (M[i][j] == '1' && !visited[i][j]); 
    }
    
    void printVisited(){
        System.out.println("\n::VISISTED::");
        for(int i = 0; i < ROWS; i++){
            for(int j = 0; j < COLS; j++)
                System.out.print(visited[i][j] + " ");
            System.out.println();
        }
        System.out.println("\n");
    }
}
