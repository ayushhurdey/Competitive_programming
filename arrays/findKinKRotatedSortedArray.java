/*
Rotation
Easy Accuracy: 30.08% Submissions: 4513 Points: 8

Given an ascending sorted rotated array Arr of distinct integers 
of size N. The array is right rotated K times. Find the value of K.

Example 1:

Input:
N = 5
Arr[] = {5, 1, 2, 3, 4}
Output: 1
Explanation: The given array is 5 1 2 3 4. 
The original sorted array is 1 2 3 4 5. 
We can see that the array was rotated 
1 times to the right.

Example 2:

Input:
N = 5
Arr[] = {1, 2, 3, 4, 5}
Output: 0
Explanation: The given array is not rotated.

Your Task:
Complete the function findKRotation() which takes array arr and size n,
as input parameters and returns an integer representing the answer. You
don't to print answer or take inputs.

Expected Time Complexity: O(log(N))
Expected Auxiliary Space: O(1)

Constraints:
1 <= N <=105
1 <= Arri <= 107
*/



class Solution {
    int modifiedBinarySearch(int[] arr, int low, int high){
        if(low > high)
            return 0;
            
        if(low == high)
            return low;
        
        int mid = low + (high - low)/2;
        
        if(mid < high && arr[mid] > arr[mid+1])
            return mid+1;
        if(mid > low && arr[mid] < arr[mid-1])
            return mid;
        if(arr[mid] < arr[high])
            return modifiedBinarySearch(arr, low, mid -1);
        return modifiedBinarySearch(arr, mid+1, high);
    }
    
    int findKRotation(int arr[], int n) {
        // code here
        return modifiedBinarySearch(arr,0,n-1);
    }
}
