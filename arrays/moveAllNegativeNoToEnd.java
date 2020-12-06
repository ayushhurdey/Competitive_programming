/*
Move all negative elements to end
Easy Accuracy: 40.8% Submissions: 9397 Points: 2

Given an unsorted array having both negative and positive integers.
The task is place all negative element at the end of array without
changing the order of positive element and negative element.

Examples:

Input : A[] = {1, -1, 3, 2, -7, -5, 11, 6 }
Output : 1  3  2  11  6  -1  -7  -5 

Input : A[] = {-5, 7, -3, -4, 9, 10, -1, 11}
Output : 7  9  10  11  -5  -3  -4  -1  


Input:
The first line of input contains an integer T denoting the number of 
test cases. The description of T test cases follows. The first line 
of each test case contains a single integer N denoting the size of 
array. The second line contains N space-separated integers A1, A2, ..., AN 
denoting the elements of the array.

Output:
For each test case in a new line output the modified array.

Constraints:
1<=T<=100
1<=N<=100
-1000<=A[]<=1000

Example:
Input:
2
8
1 -1 3 2 -7 -5 11 6
8
-5 7 -3 -4 9 10 -1 11
Output:
1 3 2 11 6 -1 -7 -5
7 9 10 11 -5 -3 -4 -1

*/


import java.util.*;
import java.lang.*;
import java.io.*;
class GFG{
    
    private static void arrangeElements(int[] arr, int n){
        int[] newArr = new int[n];
        int k = 0;
        
        for(int i = 0; i < n; i++){
            if(arr[i] >= 0)
                newArr[k++] = arr[i];
        }
        
        if(k == n){
            printArray(newArr,n);
            return;
        }    
        
       
        for(int i = 0; i < n; i++){
            if(arr[i] < 0)
                newArr[k++] = arr[i];
        }
        printArray(newArr,n);
        
    }
    
    private static void printArray(int[] arr, int n){
        for(int i = 0; i < n; i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
    
	public static void main (String[] args){
	    //code
	    Scanner scan = new Scanner(System.in);
	    int tests = Integer.parseInt(scan.nextLine());
	    
	    while(tests-- > 0){
	        int size = Integer.parseInt(scan.nextLine());
	        
	        if(size == 1){
	            System.out.println(Integer.parseInt(scan.nextLine().trim()));
	            continue;
	        }
	        String[] line = scan.nextLine().trim().split(" ");
	        int[] arr = new int[size];
	        for(int i = 0; i < size; i++){
	            arr[i] = Integer.parseInt(line[i]);
	        } 
	  
	        arrangeElements(arr,size);
	    }
	}
}
