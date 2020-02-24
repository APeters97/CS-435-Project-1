class Node
{
    int value;
    Node left, right;
        
    public Node(int item)
    {
        value = item;
        left = right = null;
    }
}
public class BinarySearchTree
{
    Node root;
    public static void main(String[]args)
    {
        BinarySearchTree tree = new BinarySearchTree();
        tree.insertRec(tree.root, 10);
        tree.insertRec(tree.root, 7);
        tree.insertRec(tree.root, 13);
        tree.insertRec(tree.root, 5);
        tree.insertRec(tree.root, 9);
        tree.insertRec(tree.root, 11);
        tree.insertRec(tree.root, 15);

        tree.printLevelOrder(tree.root);
    }
    public void insertRec(Node n, int value)
    {
        if(n == null)
            n = new Node(value);
        else if(value < n.value)
        {
            insertRec(n.left, value);
        }
        else if(value > n.value)
        {
            insertRec(n.right, value);
        }
    }
    public void deleteRec()
    {

    }
    public Node findNextRec()
    {
        return null;
    }
    public Node findPrevRec()
    {
        return null;
    }
    public Node findMinRec(Node n)
    {   
        if(n.left != null)
            return findMinRec(n.left);

        return n;

    }
    public Node findMaxRec(Node n)
    {
        if(n.right != null)
            return findMaxRec(n.left);

        return n;
    }
    public void printLevelOrder(Node root)
    {
        int h = height(root);  
        int i;  
        for (i = 1; i <= h; i++)  
            printGivenLevel(root, i);
    }
    public void printGivenLevel(Node  root, int level)
    {
        if (root == null)  
            return;  
        if (level == 1) 
            System.out.println(root.value + " "); 
        else if (level > 1)  
        {  
            printGivenLevel(root.left, level-1);  
            printGivenLevel(root.right, level-1);  
        } 
    }
    public int height(Node node)
    {
        if (node == null)  
            return 0;  
        else
        {
            int lheight = height(node.left);  
            int rheight = height(node.right);  
  
            if (lheight > rheight)  
                return(lheight + 1);  
            else
                return(rheight + 1);  
        }  
    }
}
