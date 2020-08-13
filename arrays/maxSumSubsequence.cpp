/*
Maximum sum subsequence 
Given an array A of N positive integers. Find the sum of maximum sum in subsequence of the given array in which two consecutive elements cannot be taken.
Input:
The first line of input contains an integer T denoting the number of test cases. The first line of each test case is N (the size of array). The second line of each test case contains array elements.
Output:
For each test case print the required answer in new line.
Constraints:
1 ≤ T ≤ 100
1 ≤ N ≤ 106
1 ≤ Ai ≤ 106
Example:
Input:
2
6
5 3 -2 11 16 12
6
5 3 -5 4 7 8
Output:
28
17
Explanation:
Testcase 1:
Array :        5      3      -2       11       16      12
Including:     5      3       3       16       21      28           } : max of two in excluding
Excluding:     0      5       5       5        16      21        
maxSum of subarray = 28

*/


//Solution :

#include <iostream>
#include <algorithm>
using namespace std;

int maxSumSubsequence(int *arr, int n){
    int temp;
    int incCurrent = 0;
    int excCurrent = 0;
    for(int i=0; i < n; i++){
        temp = incCurrent;
        incCurrent = arr[i] + excCurrent;
        excCurrent = max(temp, excCurrent);
    }
    return max(incCurrent, excCurrent);
}
 
int main() {
	//code
	int sizeArr,tests;
	cin >> tests;
	while(tests--){
	    cin >> sizeArr;
	    int *arr = new int[sizeArr];
	    for(int i = 0; i < sizeArr; i++)
	        cin >> arr[i];
	    cout << maxSumSubsequence(arr,sizeArr) << endl;
	}
	return 0;
}
