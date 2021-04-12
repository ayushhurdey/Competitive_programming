/*

Toeplitz matrix
School Accuracy: 36.24% Submissions: 1477 Points: 0

A Toeplitz (or diagonal-constant) matrix is a matrix in 
which each descending diagonal from left to right is constant,
i.e., all elements in a diagonal are same.
Given a matrix A of order N X M your task is to complete the
function isToeplitz which returns true if the matrix is 
Toeplitz otherwise returns false.

Input:
The first line of input contains an integer T denoting the 
no of test cases .Then T test cases follow . Each test case 
contains two lines. The first line of each test case contains
two integers N and M denoting the order of the matrix . Then
in the next line are N*M space separated values of the matrix.

Output:
The output for each test case will be 1 if the matrix is 
Toeplitz else it will be 0.

Constraints:
1<=T<=50
1<=N,M<=40
1<=A[][]<=100

Example(To be used only for expected output):
Input
2
3 3
6 7 8 4 6 7 1 4 6
2 3
1 2 3 4 5 6
Output
1
0

Explanation
(i) The first test case represents a 3x3 matrix which looks like
     6 7  8
     4 6  7 
     1 4  6
     Output: 1(True) as values in all diagonals are same.

(ii) In second test case matrix of order 2x3 will be 
     1 2 3
     4 5 6
     Output: 0(False) as values in all diagonals are not same.

*/



class GfG
{
    /*You are required to complete this method*/
    boolean isToepliz(int mat[][], int N, int M)
    {
        // Your code here
        for(int row = 0; row < mat.length - 1; row++){
            for(int col = 0; col < mat[0].length - 1; col++){
                if(mat[row][col] != mat[row+1][col+1])
                    return false;
            }
        }
        return true;
    }
}

