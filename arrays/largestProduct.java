/*
Largest product
Basic Accuracy: 30.72% Submissions: 3547 Points: 1

Given an array consisting of N positive integers, and an integer k.
You have to find the maximum product of k contiguous elements in the
array. Your task is to complete the function which takes three arguments.
The first argument  is the array A[ ] and second argument is an integer N
denoting the size of the array A[ ] and the third argument  is an integer
k.The function will return and value denoting the largest product of 
sub-array of size k.

Input:
The first line of input is an integer T denoting the no of test cases. 
Then T test casesfollow . The first line of each test case are two 
integer N and K separated by space .The next line contains N space 
separated values of the array A[ ].

Output:
Output of each test case will be an integer denoting the largest 
product of subarray of size k.

Constraints:
1 <=T<= 100
1 <=N<= 10
1 <=K<= N
1<=A[]<=10

Example:
Input
1
4 2
1 2 3 4
Output
12 

Explanation:
The sub-array of size 2 will be 3 4 and the product is 12.
*/


class GfG{
    long findMaxProduct(int A[], int n, int k){
	    // Your code here
	    int product = 1;
	    int lastNumberInx = 0;
	    int currentProduct = 1;
	    for(int i = 0; i < k; i++){
	        product = product * A[i];
	    }
	    currentProduct = product;
	    for(int i = k; i < n; i++){
	        currentProduct = (currentProduct/A[lastNumberInx])*A[i];
	        //System.out.println("currentP = "+ currentProduct);
	        if(currentProduct > product)
	            product = currentProduct;
	        lastNumberInx++;
	    }
        return product;
    }
}
