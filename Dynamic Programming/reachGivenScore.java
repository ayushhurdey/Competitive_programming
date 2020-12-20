/*
Reach a given score

Consider a game where a player can score 3 or 5 or 10 points 
in a move. Given a total score n, find number of distinct 
combinations to reach the given score.

Input:
The first line of input contains an integer T denoting the 
number of test cases. T testcases follow.The first line of 
each test case is n.

Output:
For each testcase, in a new line, print number of 
ways/combinations to reach the given score.

Constraints:
1 ≤ T ≤ 100
1 ≤ n ≤ 1000

Example:
Input
3
8
20
13
Output
1
4
2
Explanation
For 1st example when n = 8
{ 3, 5 } and {5, 3} are the two possible permutations but
these represent the same cobmination. Hence output is 1.
*/



class Geeks {
    public long count(int n) {
        long[] dp = new long[(int)n+1];
        Arrays.fill(dp, 0);
        dp[0] = 1;
        
        // Add your code here.
        for(int i = 3; i <= n; i++)
            dp[i] += dp[i - 3];
        
        for(int i = 5; i <= n; i++)
            dp[i] += dp[i - 5];
            
        for(int i = 10; i <= n; i++)
            dp[i] += dp[i - 10];
            
        return dp[n];
    }
}


// Similar to coin change problem.
