/*

Merge k Sorted Arrays
Medium

Given K sorted arrays arranged in the form of a matrix of
size K*K. The task is to merge them into one sorted array.

Example 1:

Input:
K = 3
arr[][] = {{1,2,3},{4,5,6},{7,8,9}}
Output: 1 2 3 4 5 6 7 8 9
Explanation:Above test case has 3 sorted
arrays of size 3, 3, 3
arr[][] = [[1, 2, 3],
           [4, 5, 6], 
           [7, 8, 9]]
           
The merged list will be 
[1, 2, 3, 4, 5, 6, 7, 8, 9].

Example 2:

Input:
K = 4
arr[][]={{1,2,3,4},
        {2,2,3,4},
        {5,5,6,6},
        {7,8,9,9}}
Output:
1 2 2 2 3 3 4 4 5 5 6 6 7 8 9 9 
Explanation: Above test case has 4 sorted
arrays of size 4, 4, 4, 4
arr[][] = [[1, 2, 2, 2], [3, 3, 4, 4],
[5, 5, 6, 6]  [7, 8, 9, 9 ]]
The merged list will be 
[1, 2, 2, 2, 3, 3, 4, 4, 5, 5, 
6, 6, 7, 8, 9, 9 ].

Your Task:
You do not need to read input or print anything. Your task is
to complete mergeKArrays() function which takes 2 arguments, 
an arr[K][K] 2D Matrix containing K sorted arrays and an integer
K denoting the number of sorted arrays, as input and returns the
merged sorted array ( as a pointer to the merged sorted arrays 
in cpp, as an ArrayList in java, and list in python)

Expected Time Complexity: O(K2*Log(K))
Expected Auxiliary Space: O(K)

Constraints:
1 <= K <= 100
*/


class Solution{
    //Function to merge k sorted arrays.
    static class Node{
        int row;
        int element;
        int nextColumn;
        
        Node(int row, int element, int nextColumn){
            this.row = row;
            this.element = element;
            this.nextColumn = nextColumn;
        }
    }
    
    public static ArrayList<Integer> mergeKArrays(int[][] arr,int K) 
    {
        // Write your code here.
        int rows = arr.length;
        int columns = arr[0].length;
        
        PriorityQueue<Node> minHeap = new PriorityQueue<>(K, (a,b) -> a.element - b.element);
        ArrayList<Integer> list = new ArrayList<Integer>();
        
        for(int i = 0; i < rows; i++){
            minHeap.add(new Node(i, arr[i][0], 1));
        }
        
        while(minHeap.size() > 0){
            Node top = minHeap.poll();
            list.add(top.element);
            
            if(top.nextColumn < columns)
                minHeap.add(new Node(top.row, arr[top.row][top.nextColumn], top.nextColumn + 1));
        }
        return list;
        
    }
}


/*
APPROACH:
        - make a min heap storing a Node with
            current Row, current Element, next Column
        - Add first column of each row in min-heap initially.
        - while(minHeap is not empty)
            - top = pop minHeap's top element
            - add it to the list
            - if(top's nextColumn < totalColumns) // stop after we reach the edge of each column
                - add the new Node to min-heap based on popped node as:
                     row = top
                     element = arr[top.row][top.nextColumn]
                     nextColumn = top.nextColumn + 1;
*/
