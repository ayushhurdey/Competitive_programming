/*

Steps by Knight 👍👍
Medium Accuracy: 50.11% Submissions: 21469 Points: 4

Given a square chessboard, the initial position of Knight and position of a target.
Find out the minimum steps a Knight will take to reach the target position.

Note:
The initial and the target position co-ordinates of Knight have been given accoring
to 1-base indexing.

 

Example 1:

Input:
N=6
knightPos[ ] = {4, 5}
targetPos[ ] = {1, 1}
Output:
3
Explanation:

Knight takes 3 step to reach from 
(4, 5) to (1, 1):
(4, 5) -> (5, 3) -> (3, 2) -> (1, 1).

 

 

Your Task:
You don't need to read input or print anything. Your task is to complete the function
minStepToReachTarget() which takes the inital position of Knight (KnightPos), the target
position of Knight (TargetPos) and the size of the chess board (N) as an input parameters
and returns the minimum number of steps required by the knight to reach from its current 
position to the given target position.

 

Expected Time Complexity: O(N^2).
Expected Auxiliary Space: O(N^2).

 

Constraints:
1 <= N <= 1000
1 <= Knight_pos(X, Y), Targer_pos(X, Y) <= N
*/




class Solution
{
    class Pair{
        int first;
        int second;
        Pair(int first, int second){
            this.first = first;
            this.second = second;
        }
    }
    
  
    // possible positions from the given row & col index to reach
    // by the Knignt keeping in mind that it makes 2.5 moves only 
    // in all directions.
    private int[] di = {-2 ,-1, 1, 2, 2, 1, -1, -2}; 
    private int[] dj = {1, 2, 2, 1, -1, -2, -2, -1};
    
    private boolean isSafe(boolean[][] visited, int i, int j, int N){
        return (i >= 0 && i < N) && (j >= 0 && j < N) && (!visited[i][j]);
    }
    
    //Function to find out minimum steps Knight needs to reach target position.
    public int minStepToReachTarget(int KnightPos[], int target[], int N)
    {
        // Code here
   
        if(KnightPos[0] == target[0] && KnightPos[1] == target[1])
            return 0;
        Queue<Pair> queue = new LinkedList<>();
        boolean [][] visited = new boolean[N][N];
        queue.add(new Pair(KnightPos[0]-1, KnightPos[1]-1));
        visited[KnightPos[0]-1][KnightPos[1]-1] = true;    // -1 since 1-based indexing
        int size = queue.size();
        int count = 0;
        boolean flag = false;
        
        while(!queue.isEmpty()){
            Pair top = queue.poll();
            int rowInx = top.first;
            int colInx = top.second;
            size--;
            
            for(int k = 0; k < 8; k++){
                int i = di[k] + rowInx;
                int j = dj[k] + colInx;
                if(isSafe(visited, i, j, N)){
                    queue.add(new Pair(i, j));
                    visited[i][j] = true;
                    if(i == (target[0]-1) && j == (target[1]-1)){
                        queue.clear();
                        flag = true;    // so that count doesn't run when target is found.
                        break;          // and I simulate the break from while loop also.      
                    }                   // the below condition also doesn't run.
                }
            }
            if(size == 0 && !flag){
                size = queue.size();
                count++;
            }
        }
        
        return count+1;
    }
}

/*
APPROACH: Using BFS count the levels of bfs algorithm
          to get minimum steps to reach the target from
          the given starting position.
*/
