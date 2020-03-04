import java.util.*;
import java.io.*;
public class Test
{
	public static void main(String[] args)
	{
		Test test1 = new Test();	//test 1, random list
		
		int[] list = {5, 1, 6, 2, 7, 10, 3, 8, 4, 9};
		test1.mySort(list);
		System.out.println();
		
		int[] list2 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};	//test 2, already sorted list
		test1.mySort(list2);
		System.out.println();
		
		int[] list3 = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1};	//test 3, descending order list
		test1.mySort(list3);
		System.out.println();
		
		ArrayList<Integer> testArray1 = test1.getRandomArray(20);
		for(int i = 0; i < testArray1.size(); i++)
			System.out.print(testArray1.get(i) + " ");
		System.out.println();
		
		ArrayList<Integer> testArray2 = test1.getSortedArray(20);
		for(int i = 0; i < testArray2.size(); i++)
			System.out.print(testArray2.get(i) + " ");
	}
	
	public ArrayList<Integer> getRandomArray(int n)		//returns a list of random numbers
	{
		Random rand = new Random();		
		ArrayList<Integer> myList = new ArrayList<Integer>();	//create empty list
		int count = 0;		//used to track how many numbers have been added to list
		Integer randomNum;
		while(count < n)	//add numbers while count is less than parameter number
		{
			randomNum = rand.nextInt(n) + 1;
			if(myList.contains(randomNum) == false)	//only add if the number is not in the list already
			{
				myList.add(randomNum);
				count++;
			}
		}
		return myList;		//return list
	}
	
	public ArrayList<Integer> getSortedArray(int n)		//returns a list of sorted descending numbers
	{
		ArrayList<Integer> myList = new ArrayList<Integer>();	//creates empty list
		for(int i = n; i > 0; i--)	//traverse starting at n going down
		{
			myList.add(i);		//add to list
		}
		return myList;		//return list
	}
	
	public void mySort(int[] list)	//problem 2c, a sort that utilizes BST properties
	{
		if(list.length == 0)	//if list is empty, return
			return;
		
		int pivot = list[0];	//chooses first index of list as 'root'
		ArrayList<Integer> left = new ArrayList<Integer>();	//creates ArrayList for less than values
		ArrayList<Integer> right = new ArrayList<Integer>();	//creates ArrayList for greater than values
		for(int i = 1; i < list.length; i++)	//go through list, and add values to appropriate lists
		{
			if(list[i] < pivot)
				left.add(list[i]);
			else
				right.add(list[i]);
		}
		
		int[] leftA = new int[left.size()];	//creates list and moves values from ArrayList to list
		for(int a = 0; a < left.size(); a++)
			leftA[a] = left.get(a);
		
		int[] rightA = new int[right.size()];	//creates list and move values from ArrayList to list
		for(int b = 0; b < right.size(); b++)
			rightA[b] = right.get(b);
		
		mySort(leftA);	//call sort on the less than values of root
		System.out.print(pivot + " ");	//print out root value
		mySort(rightA);	//call sort on the greater than values of root
	}
}