/*

Sum of two large numbers

Given two strings denoting non-negative numbers X and Y.
Calculate the sum of X and Y.


Example 1:

Input:
X = "25", Y = "23"
Output:
48
Explanation:
The sum of 25 and 23 is 48.

Example 2:

Input:
X = "2500", Y = "23"
Output:
2523
Explanation:
The sum of 2500 and 23 is 2523.


Your Task:
Your task is to complete the function findSum() which takes
two strings as inputs and returns the string without leading
zeros. You do not need to take any input or print anything.


Expected Time Complexity: O(|X| + |Y|)
Expected Auxiliary Space: O(1)


Constraints:
1 <= |X|, |Y| <= 105
*/


class Solution {
    String findSum(String X, String Y) {
        // code here
        
        X = new StringBuilder(X).reverse().toString();
        Y = new StringBuilder(Y).reverse().toString();
        
        int carry = 0;
        String output = "";
        int i = 0, j = 0;
        
        while(i < X.length() && j < Y.length()){
            int inp1 = X.charAt(i) - '0';
            int inp2 = Y.charAt(i) - '0';
            int out = inp1 + inp2 + carry;
            int fOut = out % 10;
            output += ("" + (fOut));
            carry = out / 10;
            i++;
            j++;
        } 
        
        
        while(i < X.length()){
            int inp1 = X.charAt(i) - '0';
            int out = inp1 + carry;
            int fOut = out % 10;
            output += ("" + (fOut));
            carry = out / 10;
            i++;
        }
        
        while(j < Y.length()){
            int inp2 = Y.charAt(j) - '0';
            int out = inp2 + carry;
            int fOut = out % 10;
            output += ("" + (fOut));
            carry = out / 10;
            j++;
        }
        
        if(carry != 0)
            output += ("" + carry);
        
        StringBuilder outSB = new StringBuilder(output).reverse();
         
        i = 0;
        while(i < outSB.length() - 1 && outSB.charAt(i) == '0')
            i++;
        
        output = outSB.replace(0,i,"").toString();
        
        return output;
    }
}


/*
Edge Cases:

    7693
+ 4078842
  =======
  4086535
  =======
  
  
  9999
+   99
  ====
 10098 
 =====
 
 0009
+0000
 ====
    9
 ====
 
 
   0005
+000003
 ======
      8
 ======
 
 0000
+00
 ====
 0
 ====
 
*/
