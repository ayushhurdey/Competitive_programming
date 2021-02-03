/*

Count ways to reach the n'th stair
Medium Accuracy: 42.67% Submissions: 12504 Points: 4

There are N stairs, a person standing at the bottom wants to 
reach the top. The person can climb either 1 stair or 2 stairs 
at a time. Count the number of ways, the person can reach the
top (order does matter).

Example 1:

Input:
N = 4
Output: 5
Explanation:
You can reach 4th stair in 5 ways. 
Way 1: Climb 2 stairs at a time. 
Way 2: Climb 1 stair at a time.
Way 3: Climb 2 stairs, then 1 stair and then 1 stair.
Way 4: Climb 1 stair, then 2 stairs then 1 stair.
Way 5: Climb 1 stair, then 1 stair and then 2 stairs.

Example 2:

Input:
N = 10
Output: 89 
Explanation: 
There are 89 ways to reach the 10th stair.

Your Task:
Complete the function countWays() which takes the top stair number
m as input parameters and returns the answer % 10^9+7.

Expected Time Complexity : O(N)
Expected Auxiliary Space: O(1)

Constraints:
1 <= N <= 105
*/



class DynamicProgramming{
    
    // function to count ways to reach mth stair
    Long countWays(int m){
        
        // your code here
        long[] dp = new long[m+1];
        dp[0] = 1;
        dp[1] = 1;
        
        for(int i = 2; i <= m; i++)
            dp[i] = (dp[i-1] % (1000000007) + dp[i-2] % (1000000007)) % (1000000007);
        return dp[m];
    }
    
}
