/*
Count total set bits in a range.
        
Problems
You are given a number N. Find the total count of set bits for all numbers from 1 to N(both inclusive).

Input:
The first line of input contains an integer T denoting the number of test cases. T testcases follow. The first line of each test case is N.

Output:
For each testcase, in a new line, print the total count of all bits.

Constraints:
1 ≤ T ≤ 100
1 ≤ N ≤ 103

Example:
Input:
2
4
17
Output:
5
35

Explanation:
Testcase1:
An easy way to look at it is to consider the number, n = 4:
0 0 0 = 0
0 0 1 = 1
0 1 0 = 1
0 1 1 = 2
1 0 0 = 1
Therefore , the total number of bits is 5.

*/

#include <iostream>
using namespace std;

int countTotalSetBits(int n){
    int dp[n+1],count = 1;
    dp[0] = 0;
    dp[1] = 1;
    for(int i = 2; i <= n; i++){
        dp[i] = dp[i/2] + (i % 2);
        count += dp[i];
    }
    return count;
}

int main() {
	//code
	int tests,range;
	cin >> tests;
	while(tests--){
	    cin >> range;
	    cout << countTotalSetBits(range) << endl;
	}
	return 0;
}
