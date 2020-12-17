/*
N-Queen Problem
Hard Accuracy: 32.75% Submissions: 33976 Points: 8

The n-queens puzzle is the problem of placing n queens on an n×n 
chessboard such that no two queens attack each other. Given an
integer n, print all distinct solutions to the n-queens puzzle.
Each solution contains distinct board configurations of the
n-queens’ placement, where the solutions are a permutation of 
[1,2,3..n] in increasing order, here the number in the ith place
denotes that the ith-column queen is placed in the row with that
number. For eg below figure represents a chessboard [3 1 4 2].


Input:
The first line of input contains an integer T denoting the no of
test cases. Then T test cases follow. Each test case contains an
integer n denoting the size of the chessboard.

Output:
For each test case, output your solutions on one line where each 
solution is enclosed in square brackets '[', ']' separated by a 
space . The solutions are permutations of {1, 2, 3 …, n} in 
increasing order where the number in the ith place denotes the 
ith-column queen is placed in the row with that number, if no 
solution exists print -1.

Constraints:
1 <= T <= 10
1 <= n <= 10

Example:
Input
2
1
4
Output:
[1 ]

[2 4 1 3 ] [3 1 4 2 ]

*/



import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
 {
    static int[] x = new int[11];
    
    private static boolean place(int k, int i){
        for(int j = 1; j <= k-1; j++){
            if((x[j] == i) || (Math.abs(x[j] - i) == Math.abs(j - k)))
                return false;
        }
        return true;
    }
    
    private static void NQueen(int k, int n){
        for(int i = 1; i <= n; i++){
            if(place(k,i) == true){
                x[k] = i;
                if(k == n){
                    //System.out.println("\n\ni: " + i + ", k: " + k);
                    print(n);
                }    
                else{
                    //System.out.println("\n\nQueen i: " + i + ", k: " + k);
                    NQueen(k+1, n);
                }
            }
        }
    }
    
    private static void print(int n){
        System.out.print("[");
        for(int i = 1; i <= n; i++)
            System.out.print("" + (x[i]) + " ");
        System.out.print("] ");
    }
    
	public static void main (String[] args)
	 {
	    //code
	    Scanner scan = new Scanner(System.in);
	    int tests = Integer.parseInt(scan.nextLine());
	    while(tests-- > 0){
	        int n = Integer.parseInt(scan.nextLine());
	        if(n == 1)
	            System.out.println("[1 ]");
	        else if(n == 2 || n == 3)
	            System.out.println(-1);
	        else{
	            NQueen(1,n);
	            System.out.println();
	        }
	    }
	 
	 }
}
