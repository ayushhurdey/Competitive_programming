/*
Anagram

Given two strings a and b consisting of lowercase characters.
The task is to check whether two given strings are an anagram
of each other or not. An anagram of a string is another string
that contains the same characters, only the order of characters
can be different. For example, “act” and “tac” are an anagram 
of each other.

Example 1:

Input:
a = geeksforgeeks, b = forgeeksgeeks
Output: YES
Explanation: Both the string have same
characters with same frequency. So, 
both are anagrams.

Example 2:

Input:
a = allergy, b = allergic
Output: NO
Explanation:Characters in both the strings
are not same, so they are not anagrams.

Your Task:
You don't need to read input or print anything.Your task is to
complete the function isAnagram() which takes the string a and
string b as input parameter and check if the two strings are an
anagram of each other. The function returns true if the strings
are anagram else it returns false.

Expected Time Complexity: O(|a|+|b|).
Expected Auxiliary Space: O(Number of distinct characters).

Note: |s| represents the length of string s.

Constraints:
1 ≤ |a|,|b| ≤ 105
*/



class Anagram{    
    /*  Function to check if two strings are anagram
    *   a, b: input string
    */
    
    public static boolean isAnagram(String a,String b)
    {
        // Your code here
        int count = 0;
        int len1 = a.length();
        int len2 = b.length();
        
        if(len1 != len2)
            return false;
            
        for(int i = 0; i < len1; i++){
            count += a.charAt(i);
        }
        for(int i = 0; i < len1; i++){
            count -= b.charAt(i);
        }
        
        return (count == 0);
    }
}

 
// Solution 2: 
 
class Anagram{      
    public static boolean isAnagram(String a,String b)
    {
        // Your code here
        
        int len1 = a.length();
        int len2 = b.length();
        int sum1 = 0;
        int prod1 = 1;
        int sum2 = 0;
        int prod2 = 1;
        
        if(len1 != len2)
            return false;
        
        for(int i = 0 ; i < len1; i++){
            char c1 = a.charAt(i);
            char c2 = b.charAt(i);
            
            sum1 += 256 | c1;
            prod1 *= 256 | c1;
            
            sum2 += 256 | c2;
            prod2 *= 256 | c2;
        }
        return sum1 + prod1 == sum2 + prod2;
    }
}
