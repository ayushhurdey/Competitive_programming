/**
28. Implement strStr()
Easy

Implement strStr().

Given two strings needle and haystack, return the 
index of the first occurrence of needle in haystack,
 or -1 if needle is not part of haystack.

Clarification:

What should we return when needle is an empty string? 
This is a great question to ask during an interview.

For the purpose of this problem, we will return 0 when
 needle is an empty string. This is consistent to C's 
 strstr() and Java's indexOf().

 

Example 1:

Input: haystack = "hello", needle = "ll"
Output: 2

Example 2:

Input: haystack = "aaaaa", needle = "bba"
Output: -1

 

Constraints:

    1 <= haystack.length, needle.length <= 10^4
    haystack and needle consist of only lowercase English characters.
 */


public int strStr(String haystack, String needle) {
    int hLen = haystack.length();
    int nLen = needle.length();
        
    if(hLen == 0 || nLen > hLen)
        return -1;
    if(nLen == 0)
        return 0;

  for (int i = 0; ; i++) { // The length of haystack
    for (int j = 0; ; j++) { // The length of needle
      if (j == nLen) return i; // If at this point we have navigated through the entire length of needle, we have found a solution, haystack[i].
      if (i + j == hLen) return -1; // This happens when we run out of elements in haystack, but there are still elements in needle. 
      if (needle.charAt(j) != haystack.charAt(i + j)) break; // We stop comparing after needle[j], so i will be incremented and cycle repeats itself. 
    }
  }
}