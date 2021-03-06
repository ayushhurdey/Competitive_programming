/*
Compare two linked lists 

Given two string, represented as linked lists (every character is a node->data in the linked list).
Write a function compare() that works similar to strcmp(), i.e., it returns 0 if both strings are
same, 1 if first linked list is lexicographically greater, and -1 if second is lexicographically greater.

Input:
First line of input contains number of testcases T. For each testcase, there will be 4 lines of input.
First line of which contains length of first linked list and next line contains the linked list, similarly
next two lines contains length and linked list respectively.

Output:
Comapare two strings represented as linked list.

User Task:
The task is to complete the function compare() which compares the strings through linked list and returns
0, 1 or -1 accordingly.

Constraints:
1 <= T <= 100
1 <= N, M <= 100

Example:
Input:
2
5
a b a b a
4
a b a a
3
a a b
3
a a b

Output:
1
0

Explanation:
Testcase 1: String consisting of nodes of first linked list is lexicographically greater than the
second one. So, the result is 1.
*/

class GfG
{
    int compare(Node node1, Node node2){
      //Your code here
      while(node1 != null && node2 != null){
            if(node1.data > node2.data)
                return 1;    
            else if(node1.data < node2.data)
                return -1;
            node1 = node1.next;
            node2 = node2.next;
      }
      if(node1 == null && node2 != null)
            return -1;
      else if(node2 == null && node1 != null)
            return 1;
      return 0;
    }
}
