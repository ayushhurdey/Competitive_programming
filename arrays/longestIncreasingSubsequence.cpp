/*
Longest Increasing Subsequence 
Given a sequence A of size N, find the length of the longest increasing subsequence from a given sequence .
The longest increasing subsequence means to find a subsequence of a given sequence in which the subsequence's
elements are in sorted order, lowest to highest, and in which the subsequence is as long as possible.
This subsequence is not necessarily contiguous, or unique.
Note: Duplicate numbers are not counted as increasing subsequence.
Input:
The first line contains an integer T, depicting total number of test cases. Then following T lines contains an integer N depicting the size of array and next line followed by the value of array.
Output:
For each testcase, in a new line, print the Max length of the subsequence in a separate line.
Constraints:
1 ≤ T ≤ 100
1 ≤ N ≤ 1000
0 ≤ A[i] ≤ 300
Example:
Input:
2
16
0 8 4 12 2 10 6 14 1 9 5 13 3 11 7 15
6
5 8 3 7 9 1
Output:
6
3
Explanation:
Testcase 2: Longest increasing subsequence is of size 3 with elements (there are many subsequence, but listing one of them): 5 7 9.
*/



//Solution :

#include <iostream>
#include <algorithm>
using namespace std;

/*
 for each iteration check in the countArr, what is the max value of the elements in
 the corresponding countArr array which are less than the current element; or for each element check from which possible elements in the array the jump can come to current.(smaller->larger)
*/
int longestIncSubsequence(int *arr, int n){
    int countArr[n];
    int k,longestCount = 1;
    for(int i=0;i<n;i++)
        countArr[i] = 1;
        
    for(int i = 1; i < n; i++){
        k = i-1;
        longestCount = 0;
        while(k >= 0){
            if(arr[i] > arr[k]){
               longestCount = max(longestCount, countArr[k]);
            }
            k--;
        }
        countArr[i] = longestCount+1;
    }
    longestCount = countArr[0];
    
    // finding the maximum length in the CountArr.
    for(int i = 1; i < n; i++)
        longestCount = max(longestCount, countArr[i]);
    
    return longestCount;
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
	    cout << longestIncSubsequence(arr,sizeArr) << endl;
	}
	return 0;
}
