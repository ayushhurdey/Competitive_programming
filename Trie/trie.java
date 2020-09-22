/*
Implementation of trie.
*/

import java.util.*;
import java.lang.*;

class Main{
    static ArrayList<Character> list = new ArrayList<Character>();
    static int i = 0;
	static class TrieNode{
	    char c;
	    HashMap<Character,TrieNode> map;
	    TrieNode(char c){
	        this.c = c;
	        this.map = new HashMap<Character, TrieNode>();
	    }
	}
	
	static void traverse(TrieNode root){
	    list.add(root.c);
	    if(root.map.isEmpty()){
	        for(int i = 1; i < list.size(); i++)
                    System.out.print(list.get(i)); 
            System.out.println();
	    }
	    
	    for(Map.Entry<Character, TrieNode> mapElement : root.map.entrySet()) { 
            char key = (char)mapElement.getKey();
            traverse((TrieNode)mapElement.getValue());
        }
        list.remove(list.size() - 1);
	}
	
	static TrieNode insert(TrieNode root, char c){
	     TrieNode node = root.map.getOrDefault(c,new TrieNode(c));
	     root.map.put(c,node);
	     return node;
	}
	
	public static void main(String args[]){
		TrieNode root = new TrieNode(' ');
		
        ArrayList<String> strs = new ArrayList<String>(Arrays.asList("Ayush", 
                          "Ankit","Akash","Vishal","Vikrant","Any","Many","More",
                          "Ankur"));
        for(String str : strs){
            TrieNode lastNode = root;
            for(char ch : str.toCharArray()){
                lastNode = insert(lastNode,ch);
            }
        }
        
        traverse(root);
	}
}




// Another Implementation with slight difference of input.

/*
// { Driver Code Starts
import java.lang.Math;
import java.util.*;
class UniqueRows{
public static void main(String[] args)
 {  Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		while(t-->0){
			int r=sc.nextInt();
			int c=sc.nextInt();
			int[][] a=new int [r][c];
			for(int i=0;i<r;i++)
				for(int j=0;j<c;j++)
					a[i][j]=sc.nextInt();
			GfG g=new GfG();
			ArrayList<ArrayList<Integer>> arr = g.uniqueRow(a,r,c);
			for(int i = 0;i<arr.size();i++){
			    ArrayList<Integer> demo = arr.get(i);
			    for(int j = 0;j<demo.size();j++){
			        System.out.print(demo.get(j)+" ");
			    }
			    System.out.print("$");
			}
			System.out.println();
		}
 }
}// } Driver Code Ends


class GfG
{
    static ArrayList<Integer> list;
    static ArrayList<ArrayList<Integer>> result;
    static int i = 0;
	static class TrieNode{
	    int c;
	    HashMap<Integer,TrieNode> map;
	    TrieNode(int c){
	        this.c = c;
	        this.map = new HashMap<Integer, TrieNode>();
	    }
	}
	
	static void traverse(TrieNode root){
	    list.add(root.c);
	    
	    if(root.map.isEmpty()){
	        ArrayList<Integer> tmp = new ArrayList<Integer>();
	        for(int i=1;i<list.size();i++) tmp.add(list.get(i));
	        result.add(tmp);
	    }
	    
	    for(Map.Entry<Integer, TrieNode> mapElement : root.map.entrySet()) { 
            int key = mapElement.getKey();
            traverse(mapElement.getValue());
        }
        list.remove(list.size() - 1);
	}
	
	static TrieNode insert(TrieNode root, int c){
	     TrieNode node = root.map.getOrDefault(c,new TrieNode(c));
	     root.map.put(c,node);
	     return node;
	}
    public static ArrayList<ArrayList<Integer>> uniqueRow(int a[][],int r, int c)
    {
        list = new ArrayList<Integer>();
        result = new ArrayList<ArrayList<Integer>>();
        //add code here.
        TrieNode root = new TrieNode(-1);
		
        for(int []row : a){
            TrieNode lastNode = root;
            for(int ele : row){
                lastNode = insert(lastNode,ele);
            }
        }
        
        traverse(root);
        return result;
    }
}
*/
