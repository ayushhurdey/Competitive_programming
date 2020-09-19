/*
mplement strstr 
Your task is to implement the function strstr. The function takes two strings as arguments (s,x) and
locates the occurrence of the string x in the string s. The function returns and integer denoting the
first occurrence of the string x in s (0 based indexing).

Example 1:

Input:
s = GeeksForGeeks, x = Fr
Output: -1
Explanation: Fr is not present in the
string GeeksForGeeks as substring.
Example 2:

Input:
s = GeeksForGeeks, x = For
Output: 5
Explanation: For is present as substring
in GeeksForGeeks from index 5 (0 based
indexing).
Your Task:
You don't have to take any input. Just complete the strstr() function which takes two strings str,
target as an input parameter. The function returns -1 if no match if found else it returns an integer
denoting the first occurrence of the x in the string s.

Expected Time Complexity: O(|s|*|x|)
Expected Auxiliary Space: O(1)

Note : Try to solve the question in constant space complexity.

Constraints:
1 <= |s|,|x| <= 1000
*/




class GfG
{
    int strstr(String str, String subStr)
    {
       // Your code here
       Boolean flag = true;
       int retValue = -1,k;
       for(int i = 0; i < str.length(); i++){
            if(str.charAt(i) == (subStr.charAt(0))){
                 retValue = i;
                 k = i+1;
                 for(int j = 1; j < subStr.length(); j++){
                     flag = false;
                     if(k >= str.length() || (str.charAt(k++) != subStr.charAt(j)))
                        break;
                     flag = true;    // executes only if the character matches.
                 }
                 if(flag == true)
                     return retValue;
            }
       }
       return -1;
    }   
}
