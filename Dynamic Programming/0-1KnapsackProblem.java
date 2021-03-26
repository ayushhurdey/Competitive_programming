/*

0 - 1 Knapsack Problem
Medium Accuracy: 47.21% Submissions: 26451 Points: 4

You are given weights and values of N items, put these items
in a knapsack of capacity W to get the maximum total value in
the knapsack. Note that we have only one quantity of each item.
In other words, given two integer arrays val[0..N-1] and wt[0..N-1]
which represent values and weights associated with N items 
respectively. Also given an integer W which represents knapsack 
capacity, find out the maximum value subset of val[] such that 
sum of the weights of this subset is smaller than or equal to W.
You cannot break an item, either pick the complete item, or 
don’t pick it (0-1 property).

Example 1:

Input:
N = 3
W = 4
values[] = {1,2,3}
weight[] = {4,5,1}
Output: 3

Example 2:

Input:
N = 3
W = 3
values[] = {1,2,3}
weight[] = {4,5,6}
Output: 0

Your Task:
Complete the function knapSack() which takes maximum capacity W,
weight array wt[], value array val[] and number of items n as a
parameter and returns the maximum possible value you can get.

Expected Time Complexity: O(N*W).
Expected Auxiliary Space: O(N*W)

Constraints:
1 ≤ N ≤ 1000
1 ≤ W ≤ 1000
1 ≤ wt[i] ≤ 1000
1 ≤ v[i] ≤ 1000
*/


class Solution 
{ 
    // Returns the maximum value that can be put in a knapsack of capacity W 
    static int knapSack(int W, int wt[], int val[], int n) 
    { 
         // your code here 
         int[][] dp = new int[n+1][W+1];
         int i;
         for(i = 1; i <= n; i++){
             for(int w = 1; w <= W; w++){
                 if(w >= wt[i-1]){
                     int remainingCapacity = w - wt[i-1];                                       // if current is taken then find for remaining(if it is) from previuos row.
                     dp[i][w] = Math.max(dp[i-1][remainingCapacity] + val[i-1], dp[i-1][w]);    // else take the previous one(previous row) itself completely.
                 }
                 else{
                     dp[i][w] = dp[i-1][w];       // when i isn't taken
                 }
             }
         }
         return dp[n][W];
    } 
}


// This problem can be applied in many other optimization problems like
// how to choose batsman(item) who can give maximum scores(value to be optimized)
// in given balls(equivalent to Capacity of Knapsack, W).
// weight => Balls
// values => Runs
