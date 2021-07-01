/*

Rat in a Maze Problem - I
Medium Accuracy: 37.73% Submissions: 63799 Points: 4

Consider a rat placed at (0, 0) in a square matrix of order N * N.
It has to reach the destination at (N - 1, N - 1). Find all possible
paths that the rat can take to reach from source to destination. 
The directions in which the rat can move are 'U'(up), 'D'(down),
'L' (left), 'R' (right). Value 0 at a cell in the matrix represents
that it is blocked and rat cannot move to it while value 1 at a cell
in the matrix represents that rat can be travel through it.
Note: In a path, no cell can be visited more than one time.

Example 1:

Input:
N = 4
m[][] = {{1, 0, 0, 0},
         {1, 1, 0, 1}, 
         {1, 1, 0, 0},
         {0, 1, 1, 1}}
Output:
DDRDRR DRDDRR
Explanation:
The rat can reach the destination at 
(3, 3) from (0, 0) by two paths - DRDDRR 
and DDRDRR, when printed in sorted order 
we get DDRDRR DRDDRR.

Example 2:

Input:
N = 2
m[][] = {{1, 0},
         {1, 0}}
Output:
-1
Explanation:
No path exists and destination cell is 
blocked.

Your Task:  
You don't need to read input or print anything. Complete the function
printPath() which takes N and 2D array m[ ][ ] as input parameters and
returns the list of paths in lexicographically increasing order. 
Note: In case of no path, return an empty list. The driver will 
output "-1" automatically.

Expected Time Complexity: O((N^2)^4).
Expected Auxiliary Space: O(L * X), L = length of the path, X = number of paths.

Constraints:
2 ≤ N ≤ 5
0 ≤ m[i][j] ≤ 1
*/

// Naive Approach:
class Solution {
    private static void solve(int i, int j, int a[][], int n, ArrayList<String> ans, String move, 
    int vis[][]) {
        if(i==n-1 && j==n-1) {
            ans.add(move);
            return; 
        }
        // downward
        if(i+1<n && vis[i+1][j] == 0 && a[i+1][j] == 1) {
            vis[i][j] = 1; 
            solve(i+1, j, a, n, ans, move + 'D', vis);
            vis[i][j] = 0; 
        }
        
        // left
        if(j-1>=0 && vis[i][j-1] == 0 && a[i][j-1] == 1) {
            vis[i][j] = 1; 
            solve(i, j-1, a, n, ans, move + 'L', vis);
            vis[i][j] = 0; 
        }
        
        // right 
        if(j+1<n && vis[i][j+1] == 0 && a[i][j+1] == 1) {
            vis[i][j] = 1; 
            solve(i, j+1, a, n, ans, move + 'R', vis);
            vis[i][j] = 0; 
        }
        
        // upward
        if(i-1>=0 && vis[i-1][j] ==0 && a[i-1][j] == 1) {
            vis[i][j] = 1; 
            solve(i-1, j, a, n, ans, move + 'U', vis);
            vis[i][j] = 0; 
        }
    }
  
  
    public static ArrayList<String> findPath(int[][] m, int n) {
        // Your code here
        int vis[][] = new int[n][n];
        for(int i = 0;i<n;i++) {
            for(int j = 0;j<n;j++) {
                vis[i][j] = 0; 
            }
        }
         
        ArrayList<String> ans = new ArrayList<>(); 
        if(m[0][0] == 1) solve(0, 0, m, n, ans, "", vis); 
        return ans; 
    }
}





// Better Approach by reducing No. of if's with same time & space complexity.
// Solution: Time Complexity: O(N^(n*m))  n: rows, m: columns
//           Space Complexity: O(n*m)
class Solution {
    static ArrayList<String> ans = new ArrayList<String>();

    private static void trackPath(int i, int j, int[][] paths, int n, String move,
                                    boolean[][] visited, int[] di, int[] dj){
        if(i == n-1 && j == n-1){
            ans.add(move);
            return;
        }

        String path = "DLRU";        
        for(int k = 0; k < 4; k++){
            int nexti = i + di[k];
            int nextj = j + dj[k];
            if(0 <= nexti && nexti < n && 0 <= nextj && nextj < n && !visited[nexti][nextj] && paths[nexti][nextj] == 1){
                visited[i][j] = true;
                trackPath(nexti, nextj, paths, n, move + path.charAt(k), visited, di, dj);
                visited[i][j] = false;
            }
        }
    }
    
    // m is the given matrix and n is the order of matrix
    public static ArrayList<String> findPath(int[][] m, int n) {
        // Your code here
        ans.clear();
        boolean[][] visited = new boolean[n][n];
        int di[] = {1, 0, 0, -1};
        int dj[] = {0, -1, 1, 0};
        
        if(m[0][0] == 1)
            trackPath(0,0,m,n, "", visited, di, dj);
        return ans;
    }
}
