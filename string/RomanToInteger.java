/**
13. Roman to Integer
Easy

Roman numerals are represented by seven 
different symbols: I, V, X, L, C, D and M.

Symbol       Value
I             1
V             5
X             10
L             50
C             100
D             500
M             1000

For example, 2 is written as II in Roman numeral, 
just two one's added together. 12 is written as XII,
 which is simply X + II. The number 27 is written as
  XXVII, which is XX + V + II.

Roman numerals are usually written largest to smallest
 from left to right. However, the numeral for four is 
 not IIII. Instead, the number four is written as IV. 
 Because the one is before the five we subtract it making four.
  The same principle applies to the number nine, which is 
  written as IX. There are six instances where subtraction is used:

    I can be placed before V (5) and X (10) to make 4 and 9. 
    X can be placed before L (50) and C (100) to make 40 and 90. 
    C can be placed before D (500) and M (1000) to make 400 and 900.

Given a roman numeral, convert it to an integer.

 

Example 1:

Input: s = "III"
Output: 3
Explanation: III = 3.

Example 2:

Input: s = "LVIII"
Output: 58
Explanation: L = 50, V= 5, III = 3.

Example 3:

Input: s = "MCMXCIV"
Output: 1994
Explanation: M = 1000, CM = 900, XC = 90 and IV = 4.

 

Constraints:

    1 <= s.length <= 15
    s contains only the characters ('I', 'V', 'X', 'L', 'C', 'D', 'M').
    It is guaranteed that s is a valid roman numeral in the range [1, 3999].

 */



 class Solution {
    public int romanToInt(String s) {
        int len = s.length();
        int[] arr = new int[len];
        
        for(int i = 0; i < len; i++){
            char c = s.charAt(i);
            switch(c){
                case 'I':
                    arr[i] = 1; break;
                case 'V':
                    arr[i] = 5; break;
                case 'X':
                    arr[i] = 10; break;
                case 'L':
                    arr[i] = 50; break;
                case 'C':
                    arr[i] = 100; break;
                case 'D':
                    arr[i] = 500; break;
                case 'M':
                    arr[i] = 1000; break;
            }
        }
        
        
        int sum = 0;
        for(int i =0; i < len - 1; i++){
            if(arr[i] < arr[i+1]){
                sum -= arr[i];
            }
            else 
                sum += arr[i];
        }
        
        sum += arr[len-1];
        
        return sum;
    }
}


/**
APPROACH:
        The only really tricky thing about counting in roman 
        numerals is when a numeral is used as a subtractive 
        value rather than an additive value. In "IV" for example,
        the value of "I", 1, is subtracted from the value of "V", 5.
        Otherwise, you're simply just adding the values of all the numerals.

        The one thing we should realize about the subtractive 
        numerals is that they're identifiable because they appear
        before a larger number.

        During iteration from left to right if we come across
        a letter value that's smaller than the next element's value,
        it should be subtracted rather than added.

 */