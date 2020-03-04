import java.io.*;
import java.util.*;
public class IterativeBBST
{
	ArrayList<Integer> treeList = new ArrayList<Integer>();
	Node root;
	public static void main(String[]args)
	{
		IterativeBBST tree1 = new IterativeBBST();	//create tree
		IterativeBBST tree2 = new IterativeBBST();	//create tree
		IterativeBBST tree3 = new IterativeBBST();	//create tree
		IterativeBBST tree4 = new IterativeBBST();	//create tree
		
		//RIGHT ROTATION TEST
		System.out.println("RIGHT ROTATION TEST");
		tree1 = tree1.insertIter(tree1, 13);
		tree1 = tree1.insertIter(tree1, 10);
		tree1 = tree1.insertIter(tree1, 15);
		tree1 = tree1.insertIter(tree1, 5);
		tree1 = tree1.insertIter(tree1, 11);
		tree1 = tree1.insertIter(tree1, 16);
		tree1 = tree1.insertIter(tree1, 4);
		tree1 = tree1.insertIter(tree1, 8);
		System.out.println("Before rotation:");
		System.out.println(tree1.root.value == 13);
		System.out.println(tree1.root.left.value == 10);
		System.out.println(tree1.root.left.left.value == 5);
		tree1 = tree1.insertIter(tree1, 3);
		//System.out.println();
		System.out.println("After rotation");
		System.out.println(tree1.root.value == 13);
		System.out.println(tree1.root.left.value == 5);
		System.out.println(tree1.root.left.left.value == 4);
		System.out.println(tree1.root.left.left.left.value == 3);
		System.out.println(tree1.root.left.right.value == 10);
		System.out.println(tree1.root.left.right.left.value == 8);
		System.out.println();
		
		
		//LEFT ROTATION TEST
		System.out.println("LEFT ROTATION TEST");
		tree2 = tree2.insertIter(tree2, 30);
		tree2 = tree2.insertIter(tree2, 5);
		tree2 = tree2.insertIter(tree2, 35);
		tree2 = tree2.insertIter(tree2, 32);
		tree2 = tree2.insertIter(tree2, 40);
		System.out.println("Before rotation");
		System.out.println(tree2.root.value == 30);
		System.out.println(tree2.root.right.value == 35);
		System.out.println(tree2.root.right.right.value == 40);
		tree2 = tree2.insertIter(tree2, 45);
		//System.out.println();
		System.out.println("After rotation");
		System.out.println(tree2.root.value == 35);
		System.out.println(tree2.root.left.value == 30);
		System.out.println(tree2.root.right.value == 40);
		System.out.println(tree2.root.left.right.value == 32);
		System.out.println(tree2.root.right.right.value == 45);
		System.out.println();
		
		//LEFT-RIGHT ROTATION TEST
		System.out.println("LEFT-RIGHT ROTATION TEST");
		tree3 = tree3.insertIter(tree3, 13);
		tree3 = tree3.insertIter(tree3, 10);
		tree3 = tree3.insertIter(tree3, 15);
		tree3 = tree3.insertIter(tree3, 5);
		tree3 = tree3.insertIter(tree3, 11);
		tree3 = tree3.insertIter(tree3, 16);
		tree3 = tree3.insertIter(tree3, 4);
		tree3 = tree3.insertIter(tree3, 6);
		System.out.print("Before rotation");
		System.out.println(tree3.root.value == 13);
		System.out.println(tree3.root.left.value == 10);
		System.out.println(tree3.root.left.right.value == 11);
		System.out.println(tree3.root.left.left.value == 5);
		System.out.println(tree3.root.left.left.left.value == 4);
		System.out.println(tree3.root.left.left.right.value == 6);
		tree3 = tree3.insertIter(tree3, 7);
		//System.out.println();
		System.out.println("After rotation");
		System.out.println(tree3.root.value == 13);
		System.out.println(tree3.root.left.value == 6);
		System.out.println(tree3.root.left.left.value == 5);
		System.out.println(tree3.root.left.right.value == 10);
		System.out.println(tree3.root.left.left.left.value == 4);
		System.out.println(tree3.root.left.right.left.value == 7);
		System.out.println(tree3.root.left.right.right.value == 11);
		System.out.println();
		
		//RIGHT-LEFT ROTATION TEST
		System.out.println("RIGHT-LEFT ROTATION TEST");
		tree4 = tree4.insertIter(tree4, 5);
		tree4 = tree4.insertIter(tree4, 2);
		tree4 = tree4.insertIter(tree4, 7);
		tree4 = tree4.insertIter(tree4, 1);
		tree4 = tree4.insertIter(tree4, 4);
		tree4 = tree4.insertIter(tree4, 6);
		tree4 = tree4.insertIter(tree4, 9);
		tree4 = tree4.insertIter(tree4, 3);
		tree4 = tree4.insertIter(tree4, 16);
		System.out.println("Before rotation");
		System.out.println(tree4.root.value == 5);
		System.out.println(tree4.root.right.value == 7);
		System.out.println(tree4.root.right.left.value == 6);
		System.out.println(tree4.root.right.right.value == 9);
		System.out.println(tree4.root.right.right.right.value == 16);
		tree4 = tree4.insertIter(tree4, 15);
		//System.out.println();
		System.out.println("After rotation");
		System.out.println(tree4.root.value == 5);
		System.out.println(tree4.root.right.value == 7);
		System.out.println(tree4.root.right.left.value == 6);
		System.out.println(tree4.root.right.right.value == 15);
		System.out.println(tree4.root.right.right.left.value == 9);
		System.out.println(tree4.root.right.right.right.value == 16);
	}
	
	public IterativeBBST insertIter(IterativeBBST t, int value)
	{
		Node toAdd = new Node(value);	//creates new node with value to be added
		int levelsDown = 0;	//level traversal variable
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
    				levelsDown++;	//increment levels down
    			}
    			else	//if left child is empty, add new node to left child
    			{
    				travel.left = toAdd;
    				travel.left.parent = travel;	//set parent variable of new node to travel
    				levelsDown++;	//increment levels down
    				break;
    			}
    		}
    		else if(toAdd.value > travel.value)	//if value is greater than current node, go to right child
    		{
    			if(travel.right != null)	//only go right if the right child is not empty
    			{
    				travel = travel.right;
    				levelsDown++;	//increment levels down
    			}
    			else	//if right child is empty, add new node to right child
    			{
    				travel.right = toAdd;
    				travel.right.parent = travel;	//set parent variable of new node to travel
    				levelsDown++;	//increment levels down
    				break;
    			}
    		}
    	}
    	//System.out.println("Traversed " + levelsDown + " levels to add " + value);	//print out how many levels were traversed to add node
    	
    	//after adding node to the tree:
       	calculateNodeHeights();	//call method to calculate height of every node
       	calculateNodeBFs();	//call method to calculate BF of every node
       	
       	while(travel.parent != null)	//traverse back up the tree and find BF of every node
       	{
       		if(travel.BF == 1 || travel.BF == -1 || travel.BF == 0)	//if BF is good, continue traversing up
       		{
       			travel = travel.parent;
       			if(travel.parent != null)	//as long as parent isn't null(so on the root), do next while loop iteration
       				continue;
       		}
       		//at this point, travel has gotten to the node where the rotation needs to be done
       		
       		Node parentNode = travel.parent;	//store parent node of original node
       		boolean isLeft = false, isRight = false;	//used to determine if rotation is being done of the parent's left or right child
       		if(parentNode != null)
       		{
	       		if(parentNode.left != null && parentNode.left.value == travel.value)
	       			isLeft = true;
	       		else if(parentNode.right != null && parentNode.right.value == travel.value)
	       			isRight = true;
       		}

   			if(travel.BF > 1 && value < travel.left.value)
       		{
       			travel = rightRotation(travel);	//perform rotation
       			travel.parent = parentNode;	//reassign parent variable
       			if(travel.parent == null)	//if parent is null(so the root), reassign root
       			{
       				travel.parent = null;
       				root = travel;
       				calculateNodeHeights();		//recalculate heights
           			calculateNodeBFs();		//recalculate BFs
       			}
       			else	//assign parent's left or right child to new node
       			{
       				if(isLeft)
       					parentNode.left = travel;
       				else if(isRight)
       					parentNode.right = travel;
       				//parentNode.left = travel;
       				calculateNodeHeights();		//recalculate heights
           			calculateNodeBFs();		//recalculate BFs
           			travel = travel.parent;		//continue traversal
       			}
       		}
       		//Right-Right Case (does left rotation)
       		else if(travel.BF < -1 && value > travel.right.value)
       		{
       			travel = leftRotation(travel);	//perform rotation
       			travel.parent = parentNode;		//reassign parent variable
       			if(travel.parent == null)	//if parent is null(so the root), reassign root
       			{
       				travel.parent = null;
       				root = travel;
       				calculateNodeHeights();		//recalculate heights
           			calculateNodeBFs();		//recalculate BFs
       			}
       			else	//assign parent's left or right child to new node
       			{
       				if(isLeft)
       					parentNode.left = travel;
       				else if(isRight)
       					parentNode.right = travel;
       				//parentNode.right = travel;
       				calculateNodeHeights();		//recalculate heights
           			calculateNodeBFs();		//recalculate BFs
       				travel = travel.parent;		//continue traversal
       			}
       		}
       		//Left-Right Case (does left rotation then right rotation)
       		else if(travel.BF > 1 && value > travel.left.value)
       		{
       			travel.left = leftRotation(travel.left);	//perform left rotation
       			travel.left.parent = travel;
       			calculateNodeHeights();		//recalculate heights
       			travel = rightRotation(travel);				//perform right rotation
       			travel.parent = parentNode;		//reassign parent variable
       			if(travel.parent == null)	//if parent is null(so the root), reassign root
       			{
       				travel.parent = null;
       				root = travel;
       				calculateNodeHeights();		//recalculate heights
           			calculateNodeBFs();			//recalculate BFs
       			}
       			else		//assign parent's left or right child to new node
       			{	
       				if(isLeft)
       					parentNode.left = travel;
       				else if(isRight)
       					parentNode.right = travel;
       				//parentNode.left = travel;
       				calculateNodeHeights();		//recalculate heights
           			calculateNodeBFs();			//recalculate BFs
       				travel = travel.parent;		//continue traversal
       			}
       		}
       		//Right-Left Case (does right rotation then left rotation)
       		else if(travel.BF < -1 && value < travel.right.value)
       		{
       			travel.right = rightRotation(travel.right);	//perform right rotation
       			travel.right.parent = travel;
       			calculateNodeHeights();		//recalculate heights
       			travel = leftRotation(travel);		//perform left rotation
       			travel.parent = parentNode;		//reassign parent variable
       			if(travel.parent == null)		//if parent is null(so the root), reassign root
       			{
       				travel.parent = null;
       				root = travel;
       				calculateNodeHeights();		//recalculate heights
           			calculateNodeBFs();		//recalculate BFs
       			}
       			else		//assign parent's left or right child to new node
       			{
       				if(isLeft)
       					parentNode.left = travel;
       				else if(isRight)
       					parentNode.right = travel;
       				//parentNode.right = travel;
       				calculateNodeHeights();		//recalculate heights
           			calculateNodeBFs();		//recalculate BFs
       				travel = travel.parent;		//continue traversal
       			}
       		}
       	}
       	
    	return t;	//return tree
	}
	
	public IterativeBBST delete(IterativeBBST t, int value)
	{
		Node travel = t.root;		//set helper node to root
    	int levelsDown = 0;
		if(t.root == null)		//if tree is empty, return
		{
			System.out.println("Traversed " + levelsDown + " levels to delete " + value);
    		return t;
		}
    	while(travel != null)		//use helper node to traverse through the tree
    	{
    		if(value < travel.value)	//if value is less than current node, go to left child
    		{
    			if(travel.left != null)		//only go left is the left child is not empty
    			{
    				travel = travel.left;
    				levelsDown++;
    			}
    			else	//if left child is empty, value is not found, so stop deletion process
    			{
    				System.out.println(value + " was not in the tree");
    				break;
    			}
    		}
    		else if(value > travel.value)	//if value is greater than current node, go to right child
    		{
    			if(travel.right != null)	//only go right if the right child is not empty
    			{
    				travel = travel.right;
    				levelsDown++;
    			}
    			else	//if right child is empty, value is not found, so stop deletion process
    			{
    				System.out.println(value + " was not in the tree");
    				break;
    			}
    		}
    		else	//the current node is the value to be deleted
    		{
    			System.out.println("Traversed " + levelsDown + " levels to delete " + value);
    			//code to find smallest node of subtree
    		}
    	}
    	
    	return t;	//return tree
	}
	
	public void calculateNodeHeights()	//traverse through the tree and calculate the height of every node
	{
		Stack<Node> treeStack = new Stack<Node>();	//create stack for traversal
    	Node travel = root;		//set helper node to root
    	travel.height = calculateHeight(travel);
    	
    	//uses in-order traversal to add nodes to stack
    	while(travel != null || treeStack.size() > 0)	//while current node is not empty and stack is not empty
    	{
    		if(travel != null)		//go left while you can and add to stack		
    		{
    			treeStack.push(travel);
    			travel = travel.left;
    			if(travel != null)	//update height if node isn't null
    				travel.height = calculateHeight(travel);
    		}
    		else	//once you can't go left, take node off of stack, add to ArrayList, and go to the popped node's right child
    		{				
    			travel = treeStack.pop();
    			travel = travel.right;
    			if(travel != null)	//update height if node isn't null
    				travel.height = calculateHeight(travel);
    		}
    	}
	}
	
	public int calculateHeight(Node n)	//calculate height of node
	{
		 if (n == null) 	//if node is empty, return 0
			 return 0; 
		   
		 Queue<Node> q = new LinkedList<Node>();	//create Queue for storage
		 q.add(n); 
		 int height = 0; 	//height counter variable
		 while (true)
		 {
			 int nodeCount = q.size();
			 if (nodeCount == 0)	//once all nodes have been accounted for, return height
				 return height;
			 
			 height++;	//increment height
			 
			 while (nodeCount > 0)		//add nodes to queue, and traverse left or right
			 { 
				 Node temp = q.peek();
				 q.remove();
				 if (temp.left != null)
					 q.add(temp.left);
				 if (temp.right != null)
					 q.add(temp.right);
				 nodeCount--;
			}
		} 
	}
	
	public void calculateNodeBFs()	//traverse through the tree and calculate the balance factor of every node
	{
		Stack<Node> treeStack = new Stack<Node>();	//create stack for traversal
    	Node travel = root;		//set helper node to root
    	travel.BF = calculateBF(travel);
    	
    	//uses in-order traversal to add nodes to stack
    	while(travel != null || treeStack.size() > 0)	//while current node is not empty and stack is not empty
    	{
    		if(travel != null)		//go left while you can and add to stack		
    		{
    			treeStack.push(travel);
    			travel = travel.left;
    			if(travel != null)	//update height if node isn't null
    				travel.BF = calculateBF(travel);
    		}
    		else	//once you can't go left, take node off of stack, add to ArrayList, and go to the popped node's right child
    		{				
    			travel = treeStack.pop();
    			travel = travel.right;
    			if(travel != null)	//update height if node isn't null
    				travel.BF = calculateBF(travel);
    		}
    	}
	}
	
	public int calculateBF(Node n)	//returns the calculated balance factor of a node
	{
		if(n == null)	//if node is empty, return
			return 0;
		
		return (getHeight(n.left) - getHeight(n.right));
	}
	
	public int getHeight(Node n)	//return the height of a node
	{
		if(n == null)	//if node is empty, return
			return 0;
		
		return n.height;
	}
	
	public int getMax(int a, int b)	//return the max of two integers, used for height calculation
	{
		if(a > b)
			return a;
		else
			return b;
	}
	
	public Node leftRotation(Node n)	//does left rotation on parameter node
	{
		Node temp = n.right; 	//get the value of right child
		Node T2 = temp.left; 	//get left subtree of n's right child        
  
        temp.left = n; 	//swap values to do rotation
        n.right = T2; 	//swap values to do rotation
  
        n.height = getMax(getHeight(n.left), getHeight(n.right)) + 1;	//recalculate heights 
        temp.height = getMax(getHeight(temp.left), getHeight(temp.right)) + 1; 	//recalculate heights
        
        return temp;	//return new node
	}
	
	public Node rightRotation(Node n)	//does right rotation on parameter node
	{
		Node temp = n.left; 	//get the value of left child
		Node T2 = temp.right; 	//get right subtree of n's left child
        
        temp.right = n; 	//swap values to do rotation
        n.left = T2; 	//swap values to do rotation
  
        n.height = getMax(getHeight(n.left), getHeight(n.right)) + 1;	//recalculate heights 
        temp.height = getMax(getHeight(temp.left), getHeight(temp.right)) + 1; 	//recalculate heights
  
        return temp;	//return new node 
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
    	int levelsDown = 0;
    	if(n == null)		//if tree is empty, return -1
    	{
    		System.out.println("The tree is empty");
    		return -1;
    	}
    	while(n.left != null)	//go as far left as possible
    	{
    		n = n.left;
    		levelsDown++;
    	}
    	System.out.println("Traversed " + levelsDown + " levevls to find the minimum value of " + n.value);
    	return n.value;		//once as far left as possible, return current node
    }
    
    public int findMaxIter(Node n)	//finds largest node in tree
    {
    	int levelsDown = 0;
    	if(n == null)	//if tree is empty, return -1
    	{
    		System.out.println("The tree is empty");
    		return -1;
    	}
    	while(n.right != null)		//go as far right as possible
    	{
    		n = n.right;
    		levelsDown++;
    	}
    	System.out.println("Traversed " + levelsDown + " levevls to find the maximum value of " + n.value);
    	return n.value;		//once as far right as possible, return current node
    }
}