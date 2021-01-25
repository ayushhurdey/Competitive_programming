/*
Kadane's Algorithm
                                                     
Problems
Given an array arr of N integers. Find the contiguous sub-array with maximum sum.

Input:
The first line of input contains an integer T denoting the number of test cases. 
The description of T test cases follows. The first line of each test case contains
a single integer N denoting the size of array. The second line contains N 
space-separated integers A1, A2, ..., AN denoting the elements of the array.

Output:
Print the maximum sum of the contiguous sub-array in a separate line for each 
test case.

Constraints:
1 ≤ T ≤ 110
1 ≤ N ≤ 106
-107 ≤ A[i] <= 107

Example:
Input
2
5
1 2 3 -2 5
4
-1 -2 -3 -4
Output
9
-1

Explanation:
Testcase 1: Max subarray sum is 9 of elements (1, 2, 3, -2, 5) which is a 
contiguous subarray.
*/



#include<iostream>
#include<algorithm>
#include<climits> 
using namespace std;

/*
maintaining two pointers 'currSum' & 'maxSum' in which currSum is updated at each 
iteration while maxSum is updated whenever currSum > maxSum. if currSum becomes 0 
or -ve then currSum is updated as 0 again so that it does not influence the further sum.
*/

int maxSumOfSubarray(int *arr, int n){
    int maxSum = INT_MIN;  // INT_MIN -> to take the -ve numbers as maxSum also ,just in case.
    int currSum = 0;
    for(int i=0; i<n;i++){
        currSum += arr[i];
        maxSum = max(currSum, maxSum);
        if(currSum < 0)
            currSum = 0;
    }
    return maxSum;
}

// code for printing the max sum subarray.
void maxSumSubarray(int *arr, int n,int &maxStart,int &maxEnd){
    int maxSum = INT_MIN;
    int currSum = 0;
    int start = 0, end = 0;
    for(int i=0;i<n;i++){
        currSum +=arr[i];
        if(currSum > maxSum){
            maxStart = start;
            maxEnd = i;
        }
        maxSum = max(currSum, maxSum);
        if(currSum <= 0){
            currSum = 0;
            start = i+1;
        }
    }
}

//counting the number of subarrays with maxmum sum -->incomplete
int getMaxSumSubarrayCount(int *arr,int n){
    int count=0;
    int maxSum = INT_MIN;
    int currSum = 0;
    for(int i = 0 ; i < n; i++){
        currSum += arr[i];
        
        if(currSum == maxSum)
            count += 1;
            
        maxSum = max(currSum, maxSum);
        if(currSum < 0)
            currSum =0;
            
        if(currSum > maxSum)
            count = 1;   
    }
    return count;
} // testcase : 0 0 0 4 5 -1 -> Out : 1

int main() {
	//code
	int tests,sizeArr;
	int maxStart = 0, maxEnd = 0;
	cin >> tests;
	while(tests-- > 0){
	    cin >> sizeArr;
	    int *arr =  new int[sizeArr];
	    for(int i=0; i< sizeArr; i++)
	        cin >> arr[i];
	    int maxSum = maxSumOfSubarray(arr,sizeArr);
	    cout << maxSum << endl;
	    
	    /*
	    // for printing the max sum subarray.
	    maxSumSubarray(arr,sizeArr,maxStart,maxEnd);
	    for(int i=maxStart;i<= maxEnd;i++){
	        cout << arr[i] << " ";
	    }
    	cout << endl;
    	*/
    	
    	cout <<"Count =" << getMaxSumSubarrayCount(arr,sizeArr) << endl;
	}
	
	return 0;
}
