/*
Unique rows in boolean matrix 
Easy Accuracy: 37.51% Submissions: 7908 Points: 2
Given a binary matrix your task is to find all unique rows of the given matrix.

Example 1:

Input:
row = , col = 
M[][] = {{1 1 0 1},{1 0 0 1},{1 1 0 1}}
Output: 1 1 0 1 $1 0 0 1 $
Explanation: Above the matrix of size 3x4
looks like
1 1 0 1
1 0 0 1
1 1 0 1
The two unique rows are 1 1 0 1 and
1 0 0 1 .
Your Task:
You only need to implement the given function uniqueRow(). The function takes three arguments
the first argument is a matrix M and the next two arguments are row and col denoting the rows 
and columns of the matrix. The function should return the list of the unique row of the martrix.
Do not read input, instead use the arguments given in the function.

Note: The drivers code print the rows "$" separated.

Expected Time Complexity: O(row * col)
Expected Auxiliary Space: O(row * col)

Constraints:
1<=row,col<=40
0<=M[][]<=1
*/

class GfG
{
    static ArrayList<ArrayList<Integer>> result;
    
    public static ArrayList<ArrayList<Integer>> uniqueRow(int a[][],int r, int c)
    {
        result = new ArrayList<ArrayList<Integer>>();
        LinkedHashSet<String> set = new LinkedHashSet<String>();
        String str;
        
        //add code here.
        for(int []row : a){
            StringBuilder string = new StringBuilder();
            for (int i = 0; i < c; i++)
                string.append(row[i]);
            //System.out.println("-> " + string.toString());
            set.add(string.toString());
        }
        
        Iterator<String> itr = set.iterator();    
        while(itr.hasNext()){    
            str = itr.next();
            int size = str.length();
            ArrayList<Integer> arr = new ArrayList<Integer>();
            for(int i = 0; i < size; i++)
                arr.add(Character.getNumericValue(str.charAt(i)));
            result.add(arr);
        }    
    
        return result;
    }
}
