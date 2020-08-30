/*

Overlapping rectangles 
                  
Problems
Given two rectangles, find if the given two rectangles overlap or not. A rectangle is denoted by providing
the x and y co-ordinates of two points: the left top corner and the right bottom corner of the rectangle.

**Two rectangles sharing a side are considered overlapping.

Note : It may be assumed that the rectangles are parallel to the coordinate axis.

rectanglesOverlap  
                   l2 ____________________
                      |                  |
      l1  ____________|_________         |
          |           |        |         |
          |           |________|_________| r2
          |                    |
          |____________________| r1           

Input:
The first integer T denotes the number of testcases. For every test case, there are 2 lines of input. 
The first line consists of 4 integers: denoting the co-ordinates of the 2 points of the first rectangle.
The first integer denotes the x co-ordinate and the second integer denotes the y co-ordinate of the left 
topmost corner of the first rectangle. The next two integers are the x and y co-ordinates of right bottom 
corner. Similarly, the second line denotes the cordinates of the two points of the second rectangle in similar
fashion.

Output:
For each testcase, output (either 1 or 0) denoting whether the 2 rectangles are overlapping. 1 denotes the
rectangles overlap whereas 0 denotes the rectangles do not overlap.

Constraints:
1 <= T <= 10
-104 <= x, y <= 104

Example:
Input:
2
0 10 10 0
5 5 15 0
0 2 1 1
-2 -3 0 2

Output:
1
0

Explanation:
Testcase 1: According to the coordinates given as input ,two rectangles formed overlap with each other and thus answer returns 1.
*/



import java.util.*;
import java.lang.*;
import java.io.*;

class Point{
        int x, y;
        Point(int x, int y){
            this.x = x;
            this.y = y;
        }
}

class GFG{
    
    static int x1,x2,x3,x4;
	  static int y1,y2,y3,y4;
	
    public static void scanInputs(Scanner scan){
         x1 = scan.nextInt();
         y1 = scan.nextInt();
         x2 = scan.nextInt();
         y2 = scan.nextInt();
         x3 = scan.nextInt();
         y3 = scan.nextInt();
         x4 = scan.nextInt();
         y4 = scan.nextInt();
    }
    
    static boolean isOverlapping(Point l1, Point r1, Point l2, Point r2){
        if(l1.x > r2.x || l2.x > r1.x)
            return false;
        if(l1.y < r2.y || l2.y < r1.y)
            return false;
        return true; 
    }
    
	public static void main (String[] args){
	 //code
	       Scanner scan = new Scanner(System.in);
	       int tCases = scan.nextInt();
	       
	       while(tCases-- > 0){
	               scanInputs(scan);
	               Point l1 = new Point(x1,y1);
	               Point r1 = new Point(x2,y2);
	               Point l2 = new Point(x3,y3);
	               Point r2 = new Point(x4,y4);
                 
	               boolean result = isOverlapping(l1,r1,l2,r2);
	               if(result)
	                    System.out.println("1");
	               else
	                    System.out.println("0");
	                   
	       }
	}
}
