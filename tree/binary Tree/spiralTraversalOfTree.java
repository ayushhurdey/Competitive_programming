/*
Level order traversal in spiral form.
                                  
Problems
Complete the function to print spiral order traversal of a tree. For below tree, function should print 1, 2, 3, 4, 5, 6, 7.

Example 1:

Input:
      1
    /   \
   3     2
Output:1 3 2

Example 2:

Input:
           10
         /     \
        20     30
      /    \
    40     60
Output: 10 20 30 60 40 
Your Task:
The task is to complete the function printSpiral() which prints the elements in spiral form of level order traversal. The newline is automatically appended by the driver code.
Expected Time Complexity: O(N).
Expected Auxiliary Space: O(N).

Constraints:
0 <= Number of nodes <= 105
1 <= Data of a node <= 105
*/


class Spiral
{     
      void printArrayList(ArrayList<Integer> arr, Boolean leftToRight){
            if(leftToRight)
                for(int x : arr)
                    System.out.print(x + " ");
            else
               for(int i = arr.size()-1; i>=0; i--)
                    System.out.print(arr.get(i)+" ");
      }
      
      void printSpiral(Node node) 
      {
           // Your code here
           if(node == null) return;
           LinkedList<Node> q = new LinkedList<Node>();
           ArrayList<Integer> elemAtLevel = new ArrayList<Integer>();
           q.add(node);
           int counter = q.size();
           Boolean leftToRight = false;
           
           while(q.size() > 0){
               Node curr = q.poll();
               elemAtLevel.add(curr.data);
               counter--;
               if(curr.left != null)
                    q.add(curr.left);
               if(curr.right != null)
                    q.add(curr.right);
               if(counter == 0){
                   printArrayList(elemAtLevel, leftToRight);
                   counter = q.size();
                   elemAtLevel = new ArrayList<Integer>();
                   leftToRight = !leftToRight;
               }
           }
      }
}
