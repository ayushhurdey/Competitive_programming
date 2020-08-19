/*
Heap Sorting includes two steps:
  1. Heapify the given array by heapifying all its internal nodes.
  2. for sorting - delete first node 
      i).   swap first node with last node 
      ii).  reduce the size of heap by 1;
      iii). heapify again from the root.
*/

#include <iostream>
using namespace std;

void heapSort(int [], int);
void max_heapify(int [],int ,int);

int main() {
  int sizeArr;
  cout << "Enter the size of array:";
  cin >> sizeArr;
  int *arr = new int[sizeArr];
  for(int i = 0; i < sizeArr; i++)
      cin >> arr[i];
      
  heapSort(arr,sizeArr);
  
  for(int i = 0; i< sizeArr; i++)
    cout << arr[i] << " ";
    
  return 0;
}

void heapSort(int arr[], int n){
  
  // heapifying the given array...
   for(int i = n/2-1; i >= 0; i--){
       maxHeapify(arr,i,n);
   }
   
   // sorting the heapified array...
   for(int i = n-1; i > 0; i--){
       swap(arr,0,i);
       maxHeapify(arr,0,i);
   }
}

void maxHeapify(int arr[], int i, int n){
    int currLargest = i;
    int left = 2 * i + 1;
    int right = 2 * i + 2;
    
    if(left < n && arr[left] > arr[currLargest])  //if leftchild is greater than the root.
        currLargest = left;
    if(right < n && arr[right] > arr[currLargest]) //if rightchild is greater than the leftchild or root.  
        currLargest = right;
    if(currLargest != i){                         // when either left or right child is greater than root.
          swap(arr, i ,currLargest);
          maxHeapify(arr,currLargest,n);
    }    
}
