import java.util.ArrayList;

public class RecursiveBST
{
	ArrayList<Integer> treeList = new ArrayList<Integer>();
    Node root;
    public static void main(String[]args)
    {
    	RecursiveBST tree = new RecursiveBST();	//create tree
        tree.insertRec(10);		//adds values to tree
        tree.insertRec(7);
        tree.insertRec(13);
        tree.insertRec(5);
        tree.insertRec(9);
        tree.insertRec(11);
        tree.insertRec(15);
    	
        System.out.println("Minimum value in tree: " + tree.findMinRec(tree.root).value);	//find minimum value of tree
        System.out.println("Maximum value in tree: " + tree.findMaxRec(tree.root).value);	//find maximum value of tree
        System.out.println();
        
        tree.findNextRec(tree.root);			//test findNext
        tree.findNextRec(tree.root.left.left);
        tree.findNextRec(tree.root.left.right);
        tree.findNextRec(tree.root.right.left);
        tree.findNextRec(tree.root.right.right);
        System.out.println();
        
        tree.findPrevRec(tree.root);		//test findPrev
        tree.findPrevRec(tree.root.left.left);
        tree.findPrevRec(tree.root.left.right);
        tree.findPrevRec(tree.root.right.left);
        tree.findPrevRec(tree.root.right.right);
    }
    public void insertRec(int value) //insertion function that calls helper method
    {
    	root = insert(root, value);
    }
    
    public Node insert(Node n, int value) //insertion helper method
    {
        if(n == null)	//if the current spot I'm at is null, add new node
        {
        	n = new Node(value);
        	return n;
        }
        if(value < n.value)		//if value is less than current node, go to left child
        {
        	n.left = insert(n.left, value);
        }
        else if(value > n.value)	//if value is greater than current node, go to right child
        {
            n.right = insert(n.right, value);
        }
             
        return n;	//need this because of java logic
    }
    
    public void deleteRec(int value)	//deletion function that calls helper method
    {
    	root = delete(root, value);
    }
    
    public Node delete(Node n, int value)	//deletion helper method
    {
    	if(n == null)	//if current spot I'm at is null, return. this means value is not found
    		return n;
    	
        if(value < n.value)		//if value is less than current node, go to left child
        	n.left = delete(n.left, value);
        else if(value > n.value)	//if value is greater than current node, go to right child
            n.right = delete(n.right, value);
        else	//the current node is the value to be deleted
        {
        	//code to find smallest element for replacement
        }
        
        return n;	//need this because of java logic
    }
    
    public void findNextRec(Node n)		//find next largest node in tree
    {
    	treeList.clear();		//clear public ArrayList each call
    	traversal(root);		//call recursive traversal method to add nodes to public ArrayList
    	
    	int i = treeList.indexOf(n.value);	//finds index of parameter node
    	if(i == treeList.size()-1)	//if node is last element in list, say there is no next node
    		System.out.println("There is no node after " + n.value);
    	else	//print out the node that is the next index of the list
    		System.out.println("Next node after " + n.value + " is " + treeList.get(i+1));
    }
    
    public void findPrevRec(Node n)		//find next smallest node in tree
    {
    	treeList.clear();		//clear public ArrayList each call
    	traversal(root);		//call recursive traversal method to add nodes to public ArrayList
    	
    	int i = treeList.indexOf(n.value);	//find index of parameter node
    	if(i == 0)	//if node is the first in the list, say there is no previous node
    		System.out.println("There is no node before " + n.value);
    	else	//print out the node that is the previous index of the list
    		System.out.println("Previous node before " + n.value + " is " + treeList.get(i-1));
    }
    
    public void traversal(Node n)	//in-order traversal, which traverses tree from smallest to largest
    {
    	if(n == null)
    		return;
    	
    	traversal(n.left);
    	treeList.add(n.value);	//adds value to public ArrayList
    	traversal(n.right);
    }
    
    public Node findMinRec(Node n)	//find the minimum node in the tree
    {   
        if(n.left != null)		//go as far left as possible in the tree
            return findMinRec(n.left);

        return n;		//once as far left as possible, return current node
    }
    
    public Node findMaxRec(Node n)	//find the maximum node in the tree
    {
        if(n.right != null)		//go as far right as possible in the tree
            return findMaxRec(n.right);

        return n;		//once as far right aas possible, return current node
    }
}
