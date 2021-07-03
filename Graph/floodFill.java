/*
733. Flood Fill
Easy

An image is represented by an m x n integer grid image where image[i][j] 
represents the pixel value of the image.

You are also given three integers sr, sc, and newColor. You should 
perform a flood fill on the image starting from the pixel image[sr][sc].

To perform a flood fill, consider the starting pixel, plus any pixels 
connected 4-directionally to the starting pixel of the same color as 
the starting pixel, plus any pixels connected 4-directionally to those 
pixels (also with the same color), and so on. Replace the color of all
of the aforementioned pixels with newColor.

Return the modified image after performing the flood fill.

 1 1 1          2 2 2
 1 1 0    =>    2 2 0
 1 0 1          2 0 1
 
Example 1:

Input: image = [[1,1,1],[1,1,0],[1,0,1]], sr = 1, sc = 1, newColor = 2
Output: [[2,2,2],[2,2,0],[2,0,1]]
Explanation: From the center of the image with position (sr, sc) = (1, 1) 
(i.e., the red pixel), all pixels connected by a path of the same color as 
the starting pixel (i.e., the blue pixels) are colored with the new color.
Note the bottom corner is not colored 2, because it is not 4-directionally
connected to the starting pixel.

Example 2:

Input: image = [[0,0,0],[0,0,0]], sr = 0, sc = 0, newColor = 2
Output: [[2,2,2],[2,2,2]]

 

Constraints:

    m == image.length
    n == image[i].length
    1 <= m, n <= 50
    0 <= image[i][j], newColor < 216
    0 <= sr < m
    0 <= sc < n


*/



// BFS Approach: Time complexity: O(m*n); space complexity: O(m*n) 
class Solution {
    class Pair{
        int x;
        int y;
        Pair(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    
    private static final int[] row = {-1, 0, 1, 0};
    private static final int[] col = {0, 1, 0, -1};
    
    private boolean isSafe(int[][] image, int x, int y, int n, int m, int oldColor){
        return (x < n && x >= 0) && (y < m && y >= 0) && (image[x][y] == oldColor);
    }
    
    private void bfs(int[][] image, int i, int j, int newColor, boolean[][] visited, int oldColor){
        int n = image.length;
        int m = image[0].length;
        Queue<Pair> queue = new LinkedList<>();
        visited[i][j] = true;
        queue.add(new Pair(i, j));
        
        while(!queue.isEmpty()){
            Pair top = queue.poll();
            int x = top.x;
            int y = top.y;
            image[x][y] = newColor;
            
            for(int k = 0; k < 4; k++){
                if(isSafe(image, row[k] + x, col[k] + y, n, m, oldColor) && !visited[row[k] + x][col[k] + y]){
                    queue.add(new Pair(row[k] + x, col[k] + y));
                    visited[row[k] + x][col[k] + y] = true;
                }
            }
        }
    }
    
    
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int m = image.length;
        int n = image[0].length;
        boolean visited[][] = new boolean[m][n];
        int oldColor = image[sr][sc];
        
        bfs(image, sr, sc, newColor, visited, oldColor);
        return image;
    }
}



// DFS Appraoch : TC: O(n*m); SC: O(1)
// Simpler and clean code
class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if (image[sr][sc] != newColor)
            dfs(image, sr, sc, image[sr][sc], newColor);
        return image;
    }

    private void dfs(int[][] image, int i, int j, int c0, int c1) {
        if (i < 0 || j < 0 || i >= image.length || j >= image[0].length || image[i][j] != c0) return;
        image[i][j] = c1;
        dfs(image, i, j - 1, c0, c1);
        dfs(image, i, j + 1, c0, c1);
        dfs(image, i - 1, j, c0, c1);
        dfs(image, i + 1, j, c0, c1);
    }
}



/*
Flood fill (also known as seed fill) is an algorithm that determines the area
connected to a given node in a multi-dimensional array.

It is used in the “bucket” fill tool of a paint program to fill connected, 
similarly colored areas with a different color and in games such as Go and 
Minesweeper for determining which pieces are cleared. When applied on an 
image to fill a particular bounded area with color, it is also known as
boundary fill.
*/
