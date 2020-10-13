/*
Squares of a Sorted Array

Given an array of integers A sorted in non-decreasing order, return an array of the squares of each number, also in sorted non-decreasing order.

Example 1:
Input: [-4,-1,0,3,10]
Output: [0,1,9,16,100]

Example 2:
Input: [-7,-3,2,3,11]
Output: [4,9,9,49,121]

Note:
1. 1 <= A.length <= 10000
2. -10000 <= A[i] <= 10000
3. A is sorted in non-decreasing order.

*/

class Solution {
    public int[] sortedSquares(int[] A) {
        int front = 0;
        int end = A.length-1;
        int [] newArr = new int[A.length];
        int i = A.length -1;
        while(front <= end){
            if(Math.abs(A[front]) > Math.abs(A[end])){
                newArr[i--] = A[front] * A[front];
                front++;
            }
            else{
                newArr[i--] = A[end] * A[end];
                end--;
            }    
        }
        return newArr;
    }
}
