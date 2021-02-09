/*

Missing number in array

Given an array of size N-1 such that it can only 
contain distinct integers in the range of 1 to N. 
Find the missing element.

Example 1:

Input:
N = 5
A[] = {1,2,3,5}
Output: 4

Example 2:

Input:
N = 10
A[] = {1,2,3,4,5,6,7,8,10}
Output: 9

Your Task :
Complete the function MissingNumber() that takes 
array and N as input and returns the value of the
missing number.

Expected Time Complexity: O(N).
Expected Auxiliary Space: O(1).

Constraints:
1 ≤ N ≤ 106
1 ≤ A[i] ≤ 106
*/



class Solution {
    int MissingNumber(int array[], int n) {
        // Your Code Here
        int x = 1, y = 1;
        for(int i = 0; i < n-1; i++)
            x = x ^ array[i];
            
        for(int i = 1; i <= n; i++)
            y = y ^ i;
        
        return x ^ y; 
    }
}


/*Given: Array has only distinct elements*/
