/*

Smallest Positive Integer that can not be represented as Sum
Hard Accuracy: 49.71% Submissions: 14080 Points: 8

Given an array of size N, find the smallest positive integer 
value that cannot be represented as sum of some elements from
the array.


Example 1:

Input: 
N = 6
array[] = {1, 10, 3, 11, 6, 15}
Output: 
2
Explanation:
2 is the smallest integer value that cannot 
be represented as sum of elements from the array.

Example 2:

Input: 
N = 3
array[] = {1, 1, 1}
Output: 
4
Explanation: 
1 is present in the array. 
2 can be created by combining two 1s.
3 can be created by combining three 1s.
4 is the smallest integer value that cannot be 
represented as sum of elements from the array.


Your Task:  
You dont need to read input or print anything. Complete 
the function smallestpositive() which takes the array and
N as input parameters and returns the smallest positive 
integer value that cannot be represented as sum of some 
elements from the array.


Expected Time Complexity: O(N * Log(N))
Expected Auxiliary Space: O(1)


Constraints:
1 ≤ N ≤ 106
1 ≤ array[i] ≤ 109
Array may contain duplicates
*/


class Solution { 
    long smallestpositive(long[] array, int n){ 
        // Your code goes here 
      
        Arrays.sort(array);
        long sum = 1;
        if(array[0] > sum)
            return sum;
        
        for(int i = 0; i < n && array[i] <= sum; i++){
            sum += array[i];
        }
        return sum;
    }
} 


/*
HINTS:
    1). If after sorting of array, if first element is > 1,
        then answer is 1 itself.
    2). else, take initial sum = 1
              keep adding sum with arr[i] (current element)
              until arr[i] < sum,
              then finallly return sum.
*/
