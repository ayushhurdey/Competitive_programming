/*
Change Bits 

Given a number N, complete the following tasks,
Task 1. Generate a new number from N by changing the zeroes in the binary representation of N to 1.
Task  2. Find the difference between N and the newly generated number.

 

Example 1:

Input: N = 8 
Output: 7 15
Explanation:
There are 3 zeroes in binary representation
of 8. Changing them to 1 will give 15.
Difference between these two is 7.

Example 2:

Input: N = 6 
Output: 1 7
Explanation:
There is 1 zero in binary representation
of 6. Changing it to 1 will give 7.
Difference between these two is 1.
 

Your Task:
You don't need to read input or print anything. Your task is to complete the function 
changeBits() which takes an integer N as input parameter and returns a list of two integers
containing the difference and the generated number respectively.

 

Expected Time Complexity: O(log(N))
Expected Auxiliary Space: O(1)
*/

class Solution {
    static int[] changeBits(int N) {
        // code here
        int [] arr = new int[2];
        int totalBits = (int)(Math.log(N)/Math.log(2)) + 1;
        int newNum = N | ((1 << totalBits) - 1);
        arr[0] = newNum - N;
        arr[1] = newNum;
        return arr;
    }
}


/*
N = 8  ->  1 0 0 0 
           1 1 1 1   -> genetated using ((1 << totalBits) - 1) Eg if totalBits = 4 then 1<<4 = 10000  then 10000-1 = 1111
          ---------
   OR  ->  1 1 1 1   -> 15
          ---------

*/
