class Node
{
    int value, height, BF;
    Node left, right, parent;
        
    public Node(int item)
    {
        value = item;
        height = 1;
        BF = 0;
        left = right = parent = null;
    }
}