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


// OR



class Tree
{
    // Return a list containing the inorder traversal of the given tree
    ArrayList<Integer> preOrder(Node root)
    {
        // Code
        ArrayList<Integer> list = new ArrayList<Integer>();
        if(root == null)
            return list;
        
        Stack<Node> stack = new Stack<Node>();
        stack.push(root);
        
        while(!stack.isEmpty()){
            Node node = stack.peek();
            list.add(node.data);
            stack.pop();
            
            if(node.right != null)
                stack.push(node.right);
            if(node.left != null)
                stack.push(node.left);
        }
        return list;
    }
    
    
}
