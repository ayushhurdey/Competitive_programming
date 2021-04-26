/*
32. Longest Valid Parentheses
Hard

Given a string containing just the characters '(' and ')', find the length
of the longest valid (well-formed) parentheses substring.

 

Example 1:

Input: s = "(()"
Output: 2
Explanation: The longest valid parentheses substring is "()".

Example 2:

Input: s = ")()())"
Output: 4
Explanation: The longest valid parentheses substring is "()()".

Example 3:

Input: s = ""
Output: 0

 

Constraints:

    0 <= s.length <= 3 * 104
    s[i] is '(', or ')'.
*/


class Solution {
    public int longestValidParentheses(String s) {
        int open = 0, close = 0;
        int max = 0;
        
        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            if(ch == '(')
                open++;
            else
                close++;
            
            if(open == close){
                int len = open + close;
                max = Math.max(len, max);
            }
            if(close > open)
                open = close = 0;
        }
        
        
        open = close = 0;
        for(int i = s.length() -1 ; i >= 0; i--){
            char ch = s.charAt(i);
            if(ch == '(')
                open++;
            else
                close++;
            
            if(open == close){
                int len = open + close;
                max = Math.max(len, max);
            }
            if(open > close)
                open = close = 0;
        }
        
        return max;
    }
}

/*
APPROACH: For a valid string, moving from left to right
          and right to left
          No. of open parentheses = No. of close parentheses
          
          if moving from left to right
          close parantheses > open parentheses then 
          dismiss previous count of open and close.
          &
          if moving form right to left
          open > close
          dismiss previous count of open and close;
          
          & if (open == close) then parentheses is added in length
          of longest parenteses.
*/
