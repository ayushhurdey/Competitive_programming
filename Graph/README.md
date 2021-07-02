## When is it practical to use Depth-First Search (DFS) vs Breadth-First Search (BFS)



That heavily depends on the structure of the search tree and the number and location of solutions (aka searched-for items).

    If you know a solution is not far from the root of the tree, a breadth first search (BFS) might be better.

    If the tree is very deep and solutions are rare, depth first search (DFS) might take an extremely long time, but BFS could be faster.

    If the tree is very wide, a BFS might need too much memory, so it might be completely impractical.

    If solutions are frequent but located deep in the tree, BFS could be impractical.

    If the search tree is very deep you will need to restrict the search depth for depth first search (DFS), anyway (for example with iterative deepening).

But these are just rules of thumb; you'll probably need to experiment.

Another issue is parallelism: if you want to parallelize BFS you would need a shared datastructure 
between threads, which is a bad thing. DFS might be easier to distribute even between connected machines 
if you don't insist on the exact order of visiting the nodes.


    Comparing BFS and DFS, the big advantage of DFS is that it has much lower memory requirements
    than BFS, because it’s not necessary to store all of the child pointers at each level. Depending
    on the data and what you are looking for, either DFS or BFS could be advantageous.

    For example, given a family tree if one were looking for someone on the tree who’s still alive, 
    then it would be safe to assume that person would be on the bottom of the tree. This means that
    a BFS would take a very long time to reach that last level. A DFS, however, would find the goal
    faster. But, if one were looking for a family member who died a very long time ago, then that 
    person would be closer to the top of the tree. Then, a BFS would usually be faster than a DFS.
    So, the advantages of either vary depending on the data and what you’re looking for.

    One more example is Facebook; Suggestion on Friends of Friends. We need immediate friends 
    for suggestion where we can use BFS. May be finding the shortest path or detecting the cycle
    (using recursion) we can use DFS. 
