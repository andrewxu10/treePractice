package treeHomework;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Stack;

public class Tree {
	static Object[] array; //not sure about private static
	
	public Tree () { //initialization
		array = new Object [100];
	}
	
	public boolean empty () { //empty?
		return (array[1] == null);
	}
	
	public int size () { //size even if empty
		//return array.length;
		int j = 0;
		for(int i = 0; i < array.length; i++) {
			if (array[i] != null) j++;
		}
		return j;
	}
	
	
	//calculate indices for..
	public static int left (int i ) { return (2*i); };
	public static int right (int i ) { return (2*i) + 1; };
	public static int parent (int i ) { return i / 2; };
	
	public static Object getData (int i) { //getter & setter
		if (i < 0 || i >= array.length) return null;
		return array[i];
	}
	public void setData (int i, Object obj) {
		if (i < 0 || i >= array.length) return;
		array[i] = obj;
	}
	
	public boolean isaBST(int i) {
		if (getData (i) == null) return true; //don't flag for nonexistent node
		if (getData (left(i)) != null 
				&& (int) getData (left(i)) > (int) getData(i) 		
				|| getData (right(i)) != null 
				&& (int) getData (right(i)) < (int) getData(i) ) 
			return false;
		
		return isaBST(right(i)) && isaBST(left(i));
	}
	
	public void printPreorder (int i) { 
        if (getData (i) == null) return; 
        System.out.println (getData (i)); //Root
        printPreorder (left (i)); //L
        printPreorder (right (i)); //R
    }
	
	public void printPostorder (int i) { 
        if (getData (i) == null) return;       
        printPostorder (left (i)); //L
        printPostorder (right (i)); //R
        System.out.println (getData (i)); //Root 
    } 
	
	public void postOrderNoRecursion() {
		Stack<Integer> s1 = new Stack<Integer>();
		Stack<Integer> output = new Stack<Integer>();
		s1.push(1); //seed root
		
		while(!s1.isEmpty()) { //build output stack with help from s1 stack
			output.push(s1.pop());
			if(getData(left(output.peek())) != null) s1.push(left(output.peek()));
			if(getData(right(output.peek())) != null) s1.push(right(output.peek()));
		}
		while(!output.isEmpty()) { //empty out the output
			System.out.println(getData(output.pop()));
		}
	}
	
	public void printInorder (int i) {
		if (getData (i) == null) return;       
		printInorder (left (i)); //L
		System.out.println (getData (i)); //Root
		printInorder (right (i)); //R
	}
	
	public void printAllPaths() { //handler
		//int[] arr = new int[10]; //NOTE! set to height of the tree
		int[] arr = new int[log2(size()) + 1]; //+1 just in case. will investigate later
		printAllPathsRecursion(1, arr, 0);
	}
	
	private int log2(int input) {
		// TODO Auto-generated method stub
		return (int) (Math.log(input) / Math.log(2));
	}

	private void printAllPathsRecursion(int node, int[] arr, int level) {
		if(node == 1) { //root
			arr[level] = (int) getData(node);
			level++;
		}
		if(getData(left(node)) != null) {
			arr[level] = (int) getData(left(node));
			printAllPathsRecursion(left(node), arr, level+1);
		}
		if(getData(right(node)) != null) {
			arr[level] = (int) getData(right(node));
			printAllPathsRecursion(right(node), arr, level+1);
		}
		if(getData(right(node)) == null && getData(left(node)) == null) {
			System.out.println(Arrays.toString(arr));
		}
		//arr[level] = null; //why don't i need to reset the values..? figure this out
	}
	
//	public DoublyLinkedListImpl flatten (int node) { //turn tree into sorted doubly linked list
//		if(isLeaf(node)) {
//			DoublyLinkedListImpl<Integer> left = new DoublyLinkedListImpl();
//			left.addFirst((Integer) getData(left(node)));
//			
//			DoublyLinkedListImpl<Integer> middle = new DoublyLinkedListImpl();
//			middle.addFirst((Integer) getData(node));
//			
//			DoublyLinkedListImpl<Integer> right = new DoublyLinkedListImpl();
//			right.addFirst((Integer) getData(right(node)));
//			
//			combineDoubLists(left, middle);
//			combineDoubLists(left, right);
//			//generateDoubList(flatten(left(node)), node, flatten(right(node)))
//		} else {
//			DoublyLinkedListImpl<Integer> middle = new DoublyLinkedListImpl();
//			middle.addFirst((Integer) getData(node));
//			
//			//combineDoubLists(flatten(left(node)), middle);
//			combineDoubLists()
//		}
//	}
//	
//	public static void combineDoubLists(DoublyLinkedListImpl left, DoublyLinkedListImpl right) {
//		while(right.size() > 0) {
//			left.addLast(right.removeLast());
//		}
//	}
	
	private boolean isLeaf(int node) {
		if(getData(left(node)) != null || getData(right(node)) !=null) {
			return true;
		} else {
			return false;
		}
	}
}