/*
Winner of an election

Given an array of names (consisting of lowercase characters) of candidates 
in an election. A candidate name in array represents a vote casted to the 
candidate. Print the name of candidate that received Max votes. If there
is tie, print lexicographically smaller name.

Example 1:

Input:
N = 13
Votes[] = {john,johnny,jackie,johnny,john 
jackie,jamie,jamie,john,johnny,jamie,
johnny,john}
Output: john 4
Explanation: john has 4 votes casted for 
him, but so does johny. john is 
lexicographically smaller, so we print 
john and the votes he received.

Example 2:

Input:
N = 3
Votes[] = {andy,blake,clark}
Output: andy 1
Explanation: All the candidates get 1 
votes each. We print andy as it is 
lexicographically smaller.

Your Task:
You only need to complete the function winner() that takes an array of 
strings arr, and n as parameters and returns the name of the candiate 
with maximum votes and the number of votes the candidate got as an array 
of size 2.

Expected Time Complexity: O(N)
Expected Auxiliary Space: O(N)

Constraints:
1 <= N <= 105
*/


class Sol
{
    public static String[] winner(String arr[], int n)
    {
        // add your code
        HashMap<String,Integer> map = new HashMap<String, Integer>();
        String winner = arr[0];
        
        for(int i = 0; i < n; i++){
            if(!map.containsKey(arr[i]))
                map.put(arr[i],1);
            else
                map.put(arr[i], map.get(arr[i]) + 1);
                
            if(map.get(arr[i]) > map.get(winner))
                winner = arr[i];
            else if(map.get(arr[i]) == map.get(winner) && arr[i].compareTo(winner) < 0)
                winner = arr[i];
        }
        return new String[]{winner,Integer.toString(map.get(winner))};
    }
}
