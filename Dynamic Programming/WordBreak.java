/*
139. Word Break
Medium

Given a string s and a dictionary of strings wordDict, 
return true if s can be segmented into a space-separated
 sequence of one or more dictionary words.

Note that the same word in the dictionary may be reused 
multiple times in the segmentation.

 

Example 1:

Input: s = "leetcode", wordDict = ["leet","code"]
Output: true
Explanation: Return true because "leetcode" can be 
segmented as "leet code".

Example 2:

Input: s = "applepenapple", wordDict = ["apple","pen"]
Output: true
Explanation: Return true because "applepenapple" can be 
segmented as "apple pen apple".
Note that you are allowed to reuse a dictionary word.

Example 3:

Input: s = "catsandog", wordDict = ["cats","dog","sand","and","cat"]
Output: false

 

Constraints:

    • 1 <= s.length <= 300
    • 1 <= wordDict.length <= 1000
    • 1 <= wordDict[i].length <= 20
    • s and wordDict[i] consist of only lowercase English letters.
    • All the strings of wordDict are unique.

*/



class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        int len = s.length();
        boolean segmentableBeforeIt[] = new boolean[len + 1];
        segmentableBeforeIt[0] = true;
    
        
        for(int i = 1; i <= len; i++){
            for(int j = 0; j < i; j++){
                if(segmentableBeforeIt[j] && wordDict.contains(s.substring(j,i))){
                    segmentableBeforeIt[i] = true;
                    break;
                }
            }
        }
        
        return segmentableBeforeIt[len];
    }
}


/**
 * APPROACH:
        E.g. =>

        s = "geekfor" 
        wordDict = {"geeks", "peek", "geek", "seek", "for", "geeksfor"}

   SOLUTION:
    segsegmantableBeforeIt[] = [F, F, F, F, F, F, F, F] => initially.

    The array signifies the point where the string is segmentable, by pointing that 
    particular location as True.
    E.g. [T,F,F,F,T,F,F,T] => it means that string is segmentable at position 0
    because a 0-length string is obviously segmentable. Then string is segmnentable at 
    position 4 because of ("geeks", "for") & at 7 because of end of the string "for"; 

    This boolean array signifies that at a given index x in this array if 
    the value is True[T], then the string is segmentable at that point else not.

   i  j -> -> -> -> -> -> -> -> ->
   ==================================
      0  1   2   3   4   5   6   7    => j
   1  N, g
   2  N, g   e
   3  N, g   e   e
   4  N, g   e   e   k
   5  N, g   e   e   k   f
   6  N, g   e   e   k   f   o
   7  N, g   e   e   k   f   o   r

   Here N means Null value String(0-length string).

                   segmentableBeforeIt[i]
                           |
                      <-----------> 
          substring(k,i)          substring(i,l)
          is segmentable.         is segmentable.

    where k and l are position of string where string is 
    segmentable before i and after i respectively.
 **/