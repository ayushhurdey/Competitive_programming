/*
Sort an array of 0s, 1s and 2s

Given an array of size N containing only 0s, 1s, and 2s; sort the
array in ascending order.

Example 1:

Input: 
N = 5
arr[]= {0 2 1 2 0}
Output: 0 0 1 2 2
Explanation: 0s 1s and 2s are segregated 
into ascending order.

Example 2:

Input: 
N = 3
arr[] = {0 1 0}
Output: 0 0 1
Explanation: 0s 1s and 2s are segregated 
into ascending order.


Your Task:
You don't need to read input or print anything. Your task is to 
complete the function sort012() that takes array and n as input 
parameters and sorts the array in-place. 

Expected Time Complexity: O(nLogn)
Expected Auxiliary Space: O(n) 

Constraints:
1 <= N <= 10^5
0 <= A[i] <= 2
*/

using namespace std;

void sortArray(int);
void printArray(int);
void swap(int, int);
int *arr = NULL;

int main() {
	int tests,n;
 	cin >> tests;
	
	while(tests--){
	    cin >> n;
	    arr = new int[n];
	    for(int i = 0; i < n; i++)
	        cin >> arr[i];
	    sortArray(n);
	    printArray(n);
	}
	return 0;
}

void printArray(int n){
    for(int i = 0; i < n; i++)
        cout << arr[i] << " ";
    cout << "\n";    
}

void swap(int current, int pointer){
    int temp = arr[pointer];
    arr[pointer] = arr[current];
    arr[current] = temp;
}

void sortArray(int n){
    int current = 0;
    int zeroPointer = 0;
    int twoPointer = n-1;
    
    while(current <= twoPointer){
        
        if(arr[current] == 2){
            swap(current,twoPointer);
            twoPointer--;
        }   
        else if(arr[current] == 0){
            swap(current,zeroPointer);
            zeroPointer++;
            current++;
        }
        else
            current++;
    }
}
