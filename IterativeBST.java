import java.io.*;
import java.util.*;
public class IterativeBST
{
	ArrayList<Integer> treeList = new ArrayList<Integer>();
    Node root;
    public static void main(String[]args)
    {
    	IterativeBST tree = new IterativeBST();	//create tree
    	
        tree = tree.insertIter(tree, 10);	//add values to tree
        tree = tree.insertIter(tree, 7);
        tree = tree.insertIter(tree, 13);
        tree = tree.insertIter(tree, 5);
        tree = tree.insertIter(tree, 9);
        tree = tree.insertIter(tree, 11);
        tree = tree.insertIter(tree, 15);

        System.out.println("Minimum value in tree: " + tree.findMinIter(tree.root));	//find minimum value in tree
        System.out.println("Maximum value in tree: " + tree.findMaxIter(tree.root));	//find maximum value in tree
        System.out.println();
        
        tree.findNextIter(tree.root);			//test findNext
        tree.findNextIter(tree.root.left.left);
        tree.findNextIter(tree.root.left.right);
        tree.findNextIter(tree.root.right.left);
        tree.findNextIter(tree.root.right.right);
        System.out.println();
        
        tree.findPrevIter(tree.root);			//test findPrev
        tree.findPrevIter(tree.root.left.left);
        tree.findPrevIter(tree.root.left.right);
        tree.findPrevIter(tree.root.right.left);
        tree.findPrevIter(tree.root.right.right);
    }
    public IterativeBST insertIter(IterativeBST t, int value)	//inserts new value to tree
    {
    	Node toAdd = new Node(value);	//creates new node with value to be added
    	int levelsDown = 0;
    	if(t.root == null)		//if tree is empty, add new node to root
    	{
    		t.root = toAdd;
    		//System.out.println("Traversed " + levelsDown + " levels to add " + value);
    		return t;
    	}
    	
    	Node travel = t.root;		//set helper node to root
    	while(travel != null)		//use helper node to traverse through the tree
    	{
    		if(toAdd.value < travel.value)	//if value is less than current node, go to left child
    		{
    			if(travel.left != null)		//only go left is the left child is not empty
    			{
    				travel = travel.left;
    				levelsDown++;
    			}
    			else	//if left child is empty, add new node to left child
    			{
    				travel.left = toAdd;
    				levelsDown++;
    				break;
    			}
    		}
    		else if(toAdd.value > travel.value)	//if value is greater than current node, go to right child
    		{
    			if(travel.right != null)	//only go right if the right child is not empty
    			{
    				travel = travel.right;
    				levelsDown++;
    			}
    			else	//if right child is empty, add new node to right child
    			{
    				travel.right = toAdd;
    				levelsDown++;
    				break;
    			}
    		}
    	}
    	//System.out.println("Traversed " + levelsDown + " levels to add " + value);
    	return t;	//return tree
    }
    
    public IterativeBST deleteIter(IterativeBST t, int value)
    {
    	if(t.root == null)		//if tree is empty, return
    		return t;
    	
    	Node travel = t.root;		//set helper node to root
    	while(travel != null)		//use helper node to traverse through the tree
    	{
    		if(value < travel.value)	//if value is less than current node, go to left child
    		{
    			if(travel.left != null)		//only go left is the left child is not empty
    				travel = travel.left;
    			else	//if left child is empty, value is not found, so stop deletion process
    				break;
    		}
    		else if(value > travel.value)	//if value is greater than current node, go to right child
    		{
    			if(travel.right != null)	//only go right if the right child is not empty
    				travel = travel.right;
    			else	//if right child is empty, value is not found, so stop deletion process
    				break;
    		}
    		else	//the current node is the value to be deleted
    		{
    			//code to find smallest node of subtree
    		}
    	}
    	
    	return t;	//return tree
    }
    
    public void findNextIter(Node n)	//finds next largest node in tree
    {
    	treeList.clear();		//clear public ArrayList each call
    	Stack<Node> treeStack = new Stack<Node>();	//create stack for traversal
    	Node travel = root;		//set helper node to root
    	
    	//uses in-order traversal to add nodes to stack
    	while(travel != null || treeStack.size() > 0)	//while current node is not empty and stack is not empty
    	{
    		if(travel != null)		//go left while you can and add to stack		
    		{
    			treeStack.push(travel);
    			travel = travel.left;
    		}
    		else	//once you can't go left, take node off of stack, add to ArrayList, and go to the popped node's right child
    		{				
    			travel = treeStack.pop();
    			treeList.add(travel.value);
    			travel = travel.right;
    		}
    	}
    	
    	//by this point, ArrayList has been filled
    	
    	int i = treeList.indexOf(n.value);	//find index of parameter node
    	if(i == treeList.size()-1)		//if index is end of list, say there is no next node
    		System.out.println("There is no node after " + n.value);
    	else		//print out the node that is the next index of list
    		System.out.println("Next node after " + n.value + " is " + treeList.get(i+1));
    }
    
    public void findPrevIter(Node n)	//finds next smallest node in tree
    {
    	treeList.clear();		//clear public ArrayList each call
    	Stack<Node> treeStack = new Stack<Node>();	//create stack for traversal
    	Node travel = root;		//set helper node to root
    	
    	//use in-order traversal to add nodes to stack
    	while(travel != null || treeStack.size() > 0)	//while current node is not empty and stack is not empty
    	{
    		if(travel != null)	//go left while you can and add to stack
    		{
    			treeStack.push(travel);
    			travel = travel.left;
    		}
    		else	//once you can't go left, take node off of stack, add to ArrayList, and go to the popped node's right child
    		{
    			travel = treeStack.pop();
    			treeList.add(travel.value);
    			travel = travel.right;
    		}
    	}
    	
    	//by this point, ArrayList has been filled
    	
    	int i = treeList.indexOf(n.value);	//find index of parameter node
    	if(i == 0)	//if index is beginning of list, say there is no previous node
    		System.out.println("There is no node before " + n.value);
    	else	//print out the node that is the previous index of list
    		System.out.println("Previous node before " + n.value + " is " + treeList.get(i-1));
    }
    
    public int findMinIter(Node n)	//finds smallest node in tree
    {
    	if(n == null)		//if tree is empty, return -1
    		return -1;
    	while(n.left != null)	//go as far left as possible
    		n = n.left;
    	return n.value;		//once as far left as possible, return current node
    }
    
    public int findMaxIter(Node n)	//finds largest node in tree
    {
    	if(n == null)	//if tree is empty, return -1
    		return -1;
    	while(n.right != null)		//go as far right as possible
    		n = n.right;
    	return n.value;		//once as far right as possible, return current node
    }
}
