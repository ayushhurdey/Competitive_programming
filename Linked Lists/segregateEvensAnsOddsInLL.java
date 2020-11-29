/*
Segregate even and odd nodes in a Linked List

Given a Linked List of integers, write a function to modify the linked list 
such that all even numbers appear before all the odd numbers in the modified 
linked list. Also, keep the order of even and odd numbers same.

Input:

The first line of input contains an integer T denoting the number of test cases.
The first line of each test case is N,N is the number of elements in Linked List.
The second line of each test case contains N input,elements in Linked List.

Output:

Print the all even numbers then odd numbers in the modified Linked List.

Constraints:

1 ≤ T ≤ 100
1 ≤ N ≤ 100
1 ≤ size of elements ≤ 1000

Example:

Input
3
7
17 15 8 9 2 4 6
4
1 3 5 7
7
8 12 10 5 4 1 6

Output
8 2 4 6 17 15 9
1 3 5 7
8 12 10 4 6 5 1
*/


import java.util.*;
import java.lang.*;
import java.io.*;
class GFG{
    
    private static void segregateList(LinkedList<Integer> list){
        LinkedList<Integer> evens = new LinkedList<Integer>();
        LinkedList<Integer> odds = new LinkedList<Integer>();
        for(int each : list){
            if(each % 2 == 0)
                evens.add(each);
            else
                odds.add(each);
        }
        
        for(int even : evens)
            System.out.print(even + " ");
        for(int odd : odds)
            System.out.print(odd + " ");
            
        System.out.println();
    }
    
	public static void main (String[] args){
	 //code
    	 Scanner scan = new Scanner(System.in);
    	 int noOfInputs = Integer.parseInt(scan.nextLine());
    	 for(int i = 0; i < noOfInputs; i++){
    	    int n = Integer.parseInt(scan.nextLine());
    	    LinkedList<Integer> list = new LinkedList<Integer>();
    	    String s[] = scan.nextLine().split(" ");
    	    for(int j = 0; j < n; j++)
    	        list.add(Integer.parseInt(s[j]));
    	    segregateList(list);
    	 }
    }
}
