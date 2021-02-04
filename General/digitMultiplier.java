/*

Digit multiplier
Medium Accuracy: 21.55% Submissions: 358 Points: 4

Given a positive integer N, find the smallest number S 
such that the product of all the digits of S is equal
to the number N. If there's no such number, Print "-1".

 

Example 1:

Input:
N = 100
Output:
455
Explanation:
4*5*5 = 100. There are no numbers
less than 455 with the product of
it's digit as 100.

Example 2:

Input:
N = 26
Output:
-1
Explanation:
There are no numbers which can form
a product of 26 with its digits.

 

Your Task:
You don't need to read input or print anything. Your 
task is to complete the function getSmallest() which 
takes an Integer N as input and returns the answer 
as a String.

 

Expected Time Complexity: O(log(N))
Expected Auxiliary Space: O(1)

 

Constraints:
1 <= N <= 109
*/


class Solution {
    static String getSmallest(Long N) {
          // code here
        if(N >= 0 && N < 10)
            return "" + N;
            
        String result = "";
        for(int i = 9; i > 1 && N > 1; i--){
            
            while(N % i == 0){
                result += ("" + i);
                N = N / i;
            }
        }
        if(N != 1)
            return "-1";
            
        return new StringBuilder(result).reverse().toString();
    }
}
