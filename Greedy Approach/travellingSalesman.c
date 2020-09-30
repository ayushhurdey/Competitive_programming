/*
Travelling Salesman Problem
*/



#include <stdio.h>

int main(void) {
   int i,j,k;
   int row = 4, col =4 ,top=0, lastAccess;
   int min = 0, inx, startingIndex, totalCost = 0;
   int visited[4] = {0};
   int path[10] = {-1};
   int cost[4][4] = {
                {0,4,1,3},
                {4,0,2,1},
                {1,2,0,5},
                {3,1,5,0}
              }; 
              
  printf("Enter the starting index: ");
  scanf("%d",&startingIndex);
  if(startingIndex >= row){
     printf("Please Enter appropriate index:");
     return 0;
  }   
  lastAccess = startingIndex;
  path[top++] = startingIndex;
  visited[startingIndex] = 1;
  
  for(i = 0; i < row; i++){
    min = 9999;
    for(j = 0; j < col; j++){
       if(cost[startingIndex][j] != 0 && cost[startingIndex][j] < min && visited[j] != 1){
          min = cost[startingIndex][j];
          inx = j;
       }
    }
    if(min == 9999) min = 0;
    totalCost += min;
    path[top++] = inx;
    visited[inx] = 1;
    startingIndex = inx;
  }
  
  totalCost += cost[startingIndex][lastAccess];  // cost of going back to starting index.
  
  printf("Path: ");
  for(i = 0; i < row; i++)
     printf("%d ",path[i]);
  printf("%d ",lastAccess);
  
  printf("\ncost: %d", totalCost); 
    
  return 0;
}
