/*
Reverse an array: 
Eg.   1,2,3,4,5   -->   5,4,3,2,1
Input Format:
    * no of test cases
    *    size of array
    *    array....
    *    size of array
    *    array....
    *    .........
*/

#include <iostream>
using namespace std;


void reverseArr(int arr[], int n){
    int low = 0;
    int high = n-1;
    while(low <= high){
            swap(arr[low],arr[high]);
            low++;
            high--;
        
    }
    
    for(int i = 0; i < n; i++)
        cout << arr[i] << " ";
    cout << endl;        
}


int main() {
	//code
	int tests,sizeArr;
	cin >> tests;
	while(tests--){
	    cin >> sizeArr;
	    int *arr = new int[sizeArr];
	    for(int i = 0; i < sizeArr; i++)
	        cin >> arr[i];
	    reverseArr(arr,sizeArr);      
	}
	return 0;
}
