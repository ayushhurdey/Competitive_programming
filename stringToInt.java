/*
Implement Atoi 
Your task  is to implement the function atoi. The function takes a string(str) as argument and converts
it to an integer and returns it.

Example 1:

Input:
str = 123
Output: 123

Example 2:

Input:
str = 21a
Output: -1
Explanation: Output is -1 as all
characters are not digit only.
Your Task:
Complete the function atoi() which takes a string as input parameter and returns integer value of it. 
if the input string is not a numerical string then returns 1..

Expected Time Complexity: O(|S|), |S| = length of string S.
Expected Auxiliary Space: O(1)

Constraints:
1<=length of (s,x)<=10
*/

class GfG
{
    int atoi(String str)
    {
    	// Your code here
	    Boolean isNegative = false;
	    int currentChar = 0;
	    int digit = 0;
	    int lenStr = str.length();
      
	    if(str.charAt(0) == '-'){        // Handling the negative numbers separately...
	        isNegative = true;
	        currentChar += 1;
	        lenStr -= 1;
	    }
      
	    while(lenStr-- > 0){
	        if(!Character.isDigit(str.charAt(currentChar)))
	            return -1;
	        digit = digit*10 + Character.getNumericValue(str.charAt(currentChar));
	        currentChar++;
	    }
      
	    if(isNegative)
	        return (-digit);
	    else 
	        return digit;
    }
}
