/*
Longest Common Subsequence

Given two sequences, find the length of longest subsequence present in both of them.
Both the strings are of uppercase.

Example 1:

Input:
A = 6, B = 6
str1 = ABCDGH
str2 = AEDFHR
Output: 3
Explanation: LCS for input Sequences
“ABCDGH” and “AEDFHR” is “ADH” of
length 3.

Example 1:

Input:
A = 3, B = 2
str1 = ABC
str2 = AC
Output: 2
Explanation: LCS of "ABC" and "AC" is
"AC" of length 2.

Your Task:
Complete the function lcs() which takes the length of two strings respectively
and two strings as input parameters and returns the length of the longest 
subsequence present in both of them.

Expected Time Complexity : O(|str1|*|str2|)
Expected Auxiliary Space: O(|str1|*|str2|)

Constraints:
1<=size(str1),size(str2)<=100
*/




class LCS{

    static int lcs(int p, int q, String s1, String s2){
        int[][] lcsDp = new int[p + 1][q + 1];
        
        for(int i = 1; i <= p; i++)
            lcsDp[i][0] = 0; 
        
        for(int j = 1; j <= q; j++)
            lcsDp[0][j] = 0;
        
        for(int i = 1; i <= p; i++){
            for(int j = 1; j <= q; j++){
                if(s1.charAt(i-1) == s2.charAt(j-1))
                    lcsDp[i][j] = lcsDp[i-1][j-1] + 1;
                else
                    lcsDp[i][j] = Math.max(lcsDp[i-1][j] , lcsDp[i][j-1]);
            }
        }
        return lcsDp[p][q];
                
    }
    
}
