/*
Longest Common Prefix in an Array 

Given a array of N strings, find the longest common prefix among all strings present in the array.

Input:
The first line of the input contains an integer T which denotes the number of test cases to follow.
Each test case contains an integer N. Next line has space separated N strings.

Output:
Print the longest common prefix as a string in the given array. If no such prefix exists print "-1"(without quotes).

Constraints:
1 <= T <= 103
1 <= N <= 103
1 <= |S| <= 103

Example:
Input:
2
4
geeksforgeeks geeks geek geezer
3
apple ape april

Output:
gee
ap

Explanation:
Testcase 1: Longest common prefix in all the given string is gee.
*/


import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
 {
    static ArrayList<Character> list;
	static class TrieNode{
	    char c;
	    boolean isEnd;
	    HashMap<Character,TrieNode> map;
	    TrieNode(char c, boolean isEnd){
	        this.c = c;
	        this.isEnd = isEnd;
	        this.map = new HashMap<Character, TrieNode>();
	    }
	}
	
	static void search(TrieNode root){
	    list.add(root.c);
	    if(root.map.size() > 1 || root.isEnd == true)
	        return;
	    root.map.forEach((k,v) -> search(root.map.get(k)));     
	}
	
	static TrieNode insert(TrieNode root, char c,boolean isEnd){
	     TrieNode node = root.map.getOrDefault(c,new TrieNode(c,isEnd));
	     if(!node.isEnd)
	        node.isEnd = isEnd;
	     root.map.put(c,node);
	     return node;
	} 
    
    
	public static void main (String[] args)
	 {
	 //code
		int testCases,n;
		String input;
		Scanner scan = new Scanner(System.in);
		testCases = Integer.parseInt(scan.nextLine());
		
		while(testCases-- > 0){
		    list = new ArrayList<Character>();
		    TrieNode root = new TrieNode(' ', false);
		    n = Integer.parseInt(scan.nextLine());
            input = scan.nextLine();
            
            for(String str : input.split(" ")){
                TrieNode lastNode = root;
                int length = str.length();
                for(int i = 0; i < length; i++){
                    lastNode = insert(lastNode,str.charAt(i),(i == length - 1));
                }
            }
            search(root);
            for(int i = 1; i < list.size(); i++)
                System.out.print(list.get(i));
            if(list.size()==1)
                System.out.print(-1);    
            System.out.println();    
		}
	 }
}


/*
 edge case: ab, abc, abcd, abcde 
 so used (root.isEnd == true) for handling this in line 54.


input: geeksfor, geek, geeks, geezer                     input : ab, abc, abcd, abcde 
                   g                                              a
                  /                                               |
                 e                                                b <- true  ==> first encounter of true will return longest common prefix
                /                                                 |
               e                                                  c <- true
              /  \                                                |
             k    z                                               d <- true
            /      \                                              |
           s         e                                            e <- true
          /           \                                        
         f             r
        /
       o
      /
     r
     
 longest common prefix : gee
 
 */
