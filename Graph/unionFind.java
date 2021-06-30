/*
  UNION FIND ALGORITHM in GRAPH
*/


 class NodeDS{
        int parent;
        int rank;
        
        NodeDS(int parent, int rank){
            this.parent = parent;
            this.rank = rank;
        }
  }
    
// compression find
int find(NodeDS[] nodeDS, int k){
    if(nodeDS[k].parent == -1)
        return k;
    return nodeDS[k].parent = find(nodeDS, nodeDS[k].parent);
}

// union by rank
void union(NodeDS[] nodeDS, int x, int y){
    if(nodeDS[x].rank > nodeDS[y].rank)
        nodeDS[y].parent = x;
    else if(nodeDS[y].rank > nodeDS[x].rank)
        nodeDS[x].parent = y;
    else{
        nodeDS[x].parent = y;
        nodeDS[y].rank += 1;
    }
}
