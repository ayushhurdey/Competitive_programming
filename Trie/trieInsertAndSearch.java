/*
Trie | (Insert and Search) 

Trie is an efficient information retrieval data structure. Use this data structure to
store Strings and search strings. Your task is to use the TRIE data structure and search
the given string A. If found print 1 else 0.

Expected Time Complexity: O(N * WORD_LEN + A_LEN).
Expected Auxiliary Space: O(N * WORD_LEN).

Input:
The first line of input contains a single integer T denoting the number of test cases.
Then T test cases follow. Each test case consists of three lines.First line of each test
case consist of a integer N, denoting the number of element in a Trie to be stored.
Second line of each test case consists of N space separated strings denoting the elements 
to be stored in the trie.Third line of each test case consists of a String A to be searched 
in the stored elements.

Output:
Print the respective output in the respective line.

Constraints:
1<=T<=20
1<=N<=20

Example:
Input:
1
8
the a there answer any by bye their
the
Output:
1
*/

import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
 {
    static ArrayList<Character> list = new ArrayList<Character>();
    static int i = 0;
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
	
	static int search(TrieNode root, String text){
	    for(int i = 0; i< text.length(); i++){
	       char ch = text.charAt(i);
	       if(!root.map.containsKey(ch))
	            return 0;
	       root = root.map.get(ch);     
	    }
	    return (root.isEnd ? 1 : 0);
	}
	
	static TrieNode insert(TrieNode root, char c, boolean isEnd){
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
		Scanner scan = new Scanner(System.in);
		testCases = Integer.parseInt(scan.nextLine());
		String input,text;
		while(testCases-- > 0){
		    TrieNode root = new TrieNode(' ',false);
		    n = Integer.parseInt(scan.nextLine());
            input = scan.nextLine();
            text = scan.nextLine();
            for(String str : input.split(" ")){
                TrieNode lastNode = root;
                int length = str.length();
                for(int i = 0; i < length; i++){
                    lastNode = insert(lastNode,str.charAt(i),(i == length - 1));
                }
            }
            System.out.println(search(root,text));
		}
        
	 }
}

/*
egde cases like : then their there the 
           find : the
              
are to be taken care of.
*/
