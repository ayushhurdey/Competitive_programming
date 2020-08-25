// Merge Sort

#include <iostream>
using namespace std;

void merge(int arr[], int leftStart, int rightEnd){
    int middle = (leftStart + rightEnd) / 2;
    int i = leftStart;
    int j = middle + 1;
    int k = leftStart;
    int temp[100];

    while(i <= middle && j <= rightEnd){
      if(arr[i] < arr[j])
        temp[k++] = arr[i++];
      else
        temp[k++] = arr[j++]; 
    }
    while(i <= middle){
        temp[k++] = arr[i++];
    }
    while(j <= rightEnd){
        temp[k++] = arr[j++];
    }
    //putting back elements into the original array.
    for(i = leftStart; i <= rightEnd; i++){
        arr[i] = temp [i];   
    }
 }

void mergeSort(int arr[], int leftStart, int rightEnd){
     // base case on single element or to divide there  should be atlest two elements...
     if(leftStart >= rightEnd) 
        return;
     int middle = (leftStart + rightEnd) / 2;
     //divide
     mergeSort(arr, leftStart, middle);
     mergeSort(arr, middle + 1, rightEnd);
     //sort and merge
     merge(arr,leftStart, rightEnd);
}


int main(void) {
  int arr[] = {2,4,18,3,7,5,9,10,23,1};
  int i;
  int sizeArr = sizeof(arr)/sizeof(arr[0]);
  mergeSort(arr,0,sizeArr-1);
  for(i=0; i < sizeArr; i++){
      printf("%d ",arr[i]);
  }
  return 0;
}

/*
               2,4,18,3,7,5,9,10,23,1
            2,4,18,3,7         5,9,10,23,1
        2,4,18   3,7        5,9,10      23,1
     2,4   18   3,7       5,9     10    23,1
      2,4,18     3,7        5,9,10       1,23
   2,3,4,7,18              1,5,9,10,23
         1,2,3,4,5,7,9,10,18,23
*/        


