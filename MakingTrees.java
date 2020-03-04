import java.util.*;
import java.io.*;
public class MakingTrees
{
	public static void main(String[]args)
	{
		Test arrays = new Test();
		
		//QUESTION 5a
		System.out.println("QUESTION 5a");
		System.out.println();
		RecursiveBST recTree5a = new RecursiveBST();	//create Recursive BST
		IterativeBBST iterAVL5a = new IterativeBBST();	//create Iterative BST
		ArrayList<Integer> randomList5a = arrays.getRandomArray(50);	//generate random array
		
		System.out.println("Start making recursive tree");
		long startTimeRec5a = System.currentTimeMillis();	//track time
		for(int i = 0; i < randomList5a.size(); i++)	//add numbers to recursive BST
			recTree5a.insertRec(randomList5a.get(i));
		long endTimeRec5a = System.currentTimeMillis();	//track time
		System.out.println("Done making recursive tree");
		System.out.println("Total time in milliseconds: " + ((endTimeRec5a-startTimeRec5a)));
		System.out.println();
	
		System.out.println("Start making iterative AVL");
		long startTimeAVL5a = System.currentTimeMillis();	//track time
		for(int i = 0; i < randomList5a.size(); i++)	//add numbers to iterative BST
			iterAVL5a = iterAVL5a.insertIter(iterAVL5a, randomList5a.get(i));
		long endTimeAVL5a = System.currentTimeMillis();	//track time
		System.out.println("Done making iterative AVL");
		System.out.println("Total time in milliseconds: " + ((endTimeAVL5a-startTimeAVL5a)));
		System.out.println();
		
		
		//QUESTION 5c
		System.out.println("QUESTION 5c");
		System.out.println();
		IterativeBST iterTree5c = new IterativeBST();	//create Iterative BST
		IterativeBBST iterAVL5c = new IterativeBBST();	//create Iterative AVL
		ArrayList<Integer> randomList5c = arrays.getRandomArray(50);	//generate random array
		
		System.out.println("Start making iterative tree");
		long startTime5c = System.currentTimeMillis();	//track time
		for(int i = 0; i < randomList5c.size(); i++)	//add numbers to iterative BST
			iterTree5c = iterTree5c.insertIter(iterTree5c, randomList5c.get(i));
		long endTime5c = System.currentTimeMillis();	//track time
		System.out.println("Done making iterative tree");
		System.out.println("Total time in milliseconds: " + ((endTime5c-startTime5c)));
		System.out.println();
		
		System.out.println("Start making iterative AVL");
		long startTimeAVL5c = System.currentTimeMillis();	//track time
		for(int i = 0; i < randomList5c.size(); i++)		//add numbers to iterative AVL
			iterAVL5c = iterAVL5c.insertIter(iterAVL5c, randomList5c.get(i));
		long endTimeAVL5c = System.currentTimeMillis();	//track time
		System.out.println("Done making iterative AVL");
		System.out.println("Total time in milliseconds: " + ((endTimeAVL5c-startTimeAVL5c)));
		System.out.println();
		
		//QUESTION 6b
		System.out.println("QUESTION 6b");
		System.out.println();
		IterativeBST iterTree6b = new IterativeBST();	//create Iterative BST
		IterativeBBST iterAVL6b = new IterativeBBST();	//create Iterative AVL
		ArrayList<Integer> randomList6b = arrays.getRandomArray(50);	//create random array
				
		System.out.println("Start making iterative tree");
		long startTime6b = System.currentTimeMillis();	//track time
		for(int i = 0; i < randomList6b.size(); i++)	//add numbers to iterative BST
			iterTree6b = iterTree6b.insertIter(iterTree6b, randomList6b.get(i));
		long endTime6b = System.currentTimeMillis();	//track time
		System.out.println("Done making iterative tree");
		System.out.println("Total time in milliseconds: " + ((endTime6b-startTime6b)));
		System.out.println();
				
		System.out.println("Start making iterative AVL");
		long startTimeAVL6b = System.currentTimeMillis();	//track time
		for(int i = 0; i < randomList6b.size(); i++)		//add numbers to iterative AVL
			iterAVL6b = iterAVL6b.insertIter(iterAVL6b, randomList6b.get(i));
		long endTimeAVL6b = System.currentTimeMillis();	//track time
		System.out.println("Done making iterative AVL");
		System.out.println("Total time in milliseconds: " + ((endTimeAVL6b-startTimeAVL6b)));
		System.out.println();
		
		
		//QUESTION 6c
		System.out.println("QUESTION 6c");
		System.out.println();
		IterativeBST iterTree6c = new IterativeBST();	//create Iterative BST
		IterativeBBST iterAVL6c = new IterativeBBST();	//create Iterative AVL
		ArrayList<Integer> randomList6c = arrays.getSortedArray(50);	//create sorted array
		
		System.out.println("Start making iterative tree");
		long startTime6c = System.currentTimeMillis();	//track time
		for(int i = 0; i < randomList6c.size(); i++)	//add numbers to iterative BST
			iterTree6c = iterTree6c.insertIter(iterTree6c, randomList6c.get(i));
		long endTime6c = System.currentTimeMillis();	//track time
		System.out.println("Done making iterative tree");
		System.out.println("Total time in milliseconds: " + ((endTime6c-startTime6c)));
		System.out.println();
		
		System.out.println("Start making iterative AVL");
		long startTimeAVL6c = System.currentTimeMillis();	//track time
		for(int i = 0; i < randomList6c.size(); i++)		//add numbers to iterative AVL
			iterAVL6c = iterAVL6c.insertIter(iterAVL6c, randomList6c.get(i));
		long endTimeAVL6c = System.currentTimeMillis();	//track time
		System.out.println("Done making iterative AVL");
		System.out.println("Total time in milliseconds: " + ((endTimeAVL6c-startTimeAVL6c)));
	}
}