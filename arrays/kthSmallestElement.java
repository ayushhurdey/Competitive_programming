/*
Kth smallest element 

Given an array arr[] and a number K where K is smaller than size of array,
the task is to find the Kth smallest element in the given array. It is given
that all array elements are distinct.

Input:
The first line of input contains an integer T, denoting the number of testcases.
Then T test cases follow. Each test case consists of three lines. First line of
each testcase contains an integer N denoting size of the array. Second line contains
N space separated integer denoting elements of the array. Third line of the test case
contains an integer K.

Output:
Corresponding to each test case, print the kth smallest element in a new line.

Expected Time Complexity: O(N).
Expected Auxiliary Space: O(1).

Constraints:
1 <= T <= 100
1 <= N <= 105
1 <= arr[i] <= 105
1 <= K <= N

Example:
Input:
2
6
7 10 4 3 20 15
3
5
7 10 4 20 15
4
Output:
7
15

Explanation:
Testcase 1: 3rd smallest element in the given array is 7.
Testcase 2: 4th smallest elemets in the given array is 15.
*/

import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
 {
    private static int kthSmallest(int[] arr, int k){
       
        int kthMinimum=0;
        PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>(); 
        for(int i = 0; i < arr.length; i++)
            minHeap.add(arr[i]);
        for(int i = 0; i < k; i++)
            kthMinimum = minHeap.poll();
            
        return kthMinimum;
    }
    
	public static void main (String[] args){
	 //code
	 
	 Scanner scan = new Scanner(System.in);
	 int tests;
	 int n, k;
	 int [] arr;
	 tests = Integer.parseInt(scan.nextLine());
	 
	 while(tests-- > 0){
	     n = Integer.parseInt(scan.nextLine());
	     arr = new int[n];
	     String str[] = scan.nextLine().split(" ");
	     for(int i = 0; i < n; i++)
	         arr[i] = Integer.parseInt(str[i]);
	     k = Integer.parseInt(scan.nextLine());
	     int kthMinimum = kthSmallest(arr,k);
	     System.out.println(kthMinimum);
	 }
   }
}
// O(n + klogn) solution
// n = size of array. & k = kth element in array.




// Quick Select Method:
// Time Complexity: Average : O(n), but worst: O(n^2) even worse than min heap or max heap method.
 class Solution{  
    private static int partition(int[] arr, int left, int right){
        int pivot = right;
        int back = left;
        int temp;
        
        for(int j = left; j <= right; j++){
            if(arr[j] < arr[right]){
                temp = arr[j];
                arr[j] = arr[back];
                arr[back] = temp;
                back++;
            }
        }
        
        temp = arr[right];
        arr[right] = arr[back];
        arr[back] = temp;
        
        
        return back;
    }
    
    // using Quick select Algorithm
    public static int kthSmallest(int[] arr, int l, int r, int k) 
    { 
        //Your code here
        int pivot = partition(arr,l,r);
        
        if(pivot == k-1)
            return arr[pivot];
        else if(pivot > k-1)
            return kthSmallest(arr, l, pivot-1, k);
        else
            return kthSmallest(arr, pivot + 1, r, k);
    }  
    
   public static void main (String[] args){
	 //code
	 Scanner scan = new Scanner(System.in);
	 int tests;
	 int n, k;
	 int [] arr;
	 tests = Integer.parseInt(scan.nextLine());
	 
	 while(tests-- > 0){
	     n = Integer.parseInt(scan.nextLine());
	     arr = new int[n];
	     String str[] = scan.nextLine().split(" ");
	     for(int i = 0; i < n; i++)
	         arr[i] = Integer.parseInt(str[i]);
	     k = Integer.parseInt(scan.nextLine());
	     int kthMinimum = kthSmallest(arr, 0, n - 1, k);
	     System.out.println(kthMinimum);
	 }
   }

 }
