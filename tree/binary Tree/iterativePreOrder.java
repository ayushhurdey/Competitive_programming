// Iterative solution for PreOrder..


class BinaryTree
{
    /* Computes the number of nodes in a tree. */
    static ArrayList<Integer> preorder(Node root)
    {
        // Code here
        ArrayList<Integer> list = new ArrayList<Integer>();
        Stack<Node> s = new Stack<Node>();
        Node curr = root;
        
        while(curr != null || !s.empty()){
            if(curr != null){
                list.add(curr.data);
                s.push(curr);
                curr = curr.left;
            }
            else{
                curr = s.pop();
                curr = curr.right;
            }
        }
        return list;
    }
}
