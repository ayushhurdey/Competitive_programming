// Selection Sort

#include <stdio.h>

void swap(int *a, int *b){
  int temp = *a;
  *a = *b;
  *b = temp;
}

void selectionSort(int arr[],int n){
    int i,j;
    for(i = 0; i < n-1; i++){
        int minIndex = i;
        for(j = i+1; j < n; j++){
            if(arr[minIndex] > arr[j]){
                minIndex = j;
            }
        }
        swap(&arr[minIndex],&arr[i]);
    }
}

int main(void) {
  int sizeArr,i;
  int arr[100];
  printf("Enter size of array:");
  scanf("%d",&sizeArr);
  printf("Enter %d array elements:",sizeArr);
  for(i = 0;i < sizeArr; i++){
      scanf("%d",&arr[i]);
  }
  
  selectionSort(arr,sizeArr);
  
  printf("Sorted Array:\n");
  for(i = 0; i < sizeArr; i++){
      printf("%d ",arr[i]);
  }
  return 0;
}
