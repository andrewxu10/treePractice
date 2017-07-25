package treeHomework;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public class treeTraversals {
	public static void main(String[] args) {
		
		int root = 1;
		
		Tree tree = new Tree();
		tree.setData(1, 5);
		tree.setData(2, 2);
		tree.setData(3, 8);
		tree.setData(4, 1);
		tree.setData(5, 3);
		tree.setData(6, 7);
		tree.setData(7, 9);
		
		System.out.println(Arrays.toString(tree.array));
		//tree.postOrderNoRecursion();
		tree.printAllPaths();
		
		//inOrderPrint(tree,1);
		//System.out.println("end");
		
		Tree tree1 = new Tree();
		tree1.setData(1, 15);
		tree1.setData(2, 12);
		tree1.setData(3, 18);
		tree1.setData(4, 11);
		tree1.setData(5, 13);
		tree1.setData(6, 17);
		tree1.setData(7, 19);
		
		
		
	//		int[] a = {1, 2, 3, 5, 7, 8, 9, 11, 12, 13, 15, 17, 18, 19};
	//		Tree input = new Tree();
	//		Tree trial = buildTree(a, 0, a.length - 1, 1, input);
	//		trial.printInorder(1);

//		Tree treeA = (mergeTrees(tree,tree1));
//		treeA.printInorder(1);

		//treeA.printInorder(1);
		

		
//		//set data to level
//		for (int i = 1; i <= tree.size(); i++) {
//			tree.setData(i, log2(i));
//			//System.out.println("set index " + i + " : to " + log2(i));
//		}
		
		//System.out.println(tree.isaBST(1));
		//tree.printInorder(1);
		
//		ArrayList<Integer> input = new ArrayList<Integer>(); //input
//		int[] output = arrayInorder(tree, 1, input); //output
//		System.out.println(Arrays.toString(output)); //printing it
		
		
		
//		int[] b = {2, 3, 4};
		
		//System.out.println(Arrays.toString(mergeArrays(a,b)));
		//tree.printInorder(mergeArrays(a,b));
		
		
	}
	
	public static void postOrderPrint(Tree tree1, int node) { //left, right, then node
		if(tree1.getData(node) == null) return;
		postOrderPrint(tree1, node*2);
		postOrderPrint(tree1, node*2 + 1);
		System.out.println(tree1.getData(node));
	}
	
	public static void preOrderPrint(Tree tree1, int node) { //node, left, right
		if(tree1.getData(node) == null) return;
		System.out.println(tree1.getData(node));
		preOrderPrint(tree1, Tree.left(node));
		preOrderPrint(tree1, tree1.right(node));
	}
	
	public static void inOrderPrint(Tree tree1, int node) { //left,node, right
		if(tree1.getData(node) == null) return;
		inOrderPrint(tree1, Tree.left(node));
		System.out.println(tree1.getData(node));
		inOrderPrint(tree1, Tree.right(node));
	}
	
	public static Tree mergeTrees(Tree a, Tree b) {
		ArrayList<Integer> input1 = new ArrayList<Integer>();
		ArrayList<Integer> input2 = new ArrayList<Integer>();
		
		int[] output1 = arrayInorder(a, 1, input1); //output
		int[] output2 = arrayInorder(b, 1, input2); //output
		
		int[] combine = mergeArrays(output1, output2);
		System.out.println(Arrays.toString(combine));
		Tree input = new Tree(); //create
		Tree finalOutput = buildTree(combine, 0, combine.length - 1, 1, input);
		return finalOutput;
	}
	
//	int[] a = {1, 2, 3, 5, 7, 8, 9};
//	Tree input = new Tree();
//	Tree trial = buildTree(a, 0, 6, 1, input);
//	trial.printInorder(1);
	
	private static Tree buildTree(int[] combine, int start, int end, int treeIndex, Tree output) {
		//find halfway in the array
		
		if(start == -1 || end == -1) {
			return output;
		}
		
		if(end == start){
			output.setData(treeIndex, combine[start]);
			return output;
		}
		
		int halfwayIndex = ((end - start) / 2) + start;
		
		if(start==end) {
			halfwayIndex = start;
		}
		
		//System.out.println("halfwayIndex: " + halfwayIndex);
		int halfway = combine[halfwayIndex];
		//System.out.println("halfway: " + halfway);
		//add to root
		//System.out.println("set treeIndex : " + treeIndex + "to : " + halfway);
		output.setData(treeIndex, halfway);
		
		if(end!=start) {
			//set left as buildTree(combine, start, halfway - 1, left(treeIndex));
			buildTree(combine, start, halfwayIndex - 1, 2*treeIndex, output);
			//set right as buildTree(combine, halfway + 1, end, right(treeIndex));
			buildTree(combine, halfwayIndex + 1, end, 2*treeIndex+1, output);
		}
		
		
		return output;
	}

	public static int[] mergeArrays(int[] a, int[] b) {
		int i = 0; int j = 0; int z = 0;
		int[] output = new int[a.length + b.length];
		while(i < a.length && j < b.length) {
			if (a[i] < b[j]) {
				output[z] = a[i];
				z++; i++;
			} else {
				output[z] = b[j];
				z++; j++;
			}
		}
		if(i == a.length) {
			while(j < b.length) {
				output[z] = b[j];
				z++; j++;
			}
		}
		if(j == b.length) {
			while(i < a.length) {
				output[z] = a[i];
				z++; i++;
			}
		}
		return output;
	}
	
	public static int[] arrayInorder (Tree tree, int i, ArrayList<Integer> output) {
		if (tree.getData(i) == null) return null;       
		arrayInorder(tree, tree.left(i), output); //L
		output.add((Integer) tree.getData(i)); //root
		arrayInorder(tree, tree.right(i), output); //R
		return convertIntegers(output); //convert that
	}
	
	public static int[] convertIntegers(ArrayList<Integer> integers)
	{
	    int[] ret = new int[integers.size()];
	    Iterator<Integer> iterator = integers.iterator();
	    for (int i = 0; i < ret.length; i++)
	    {
	        ret[i] = iterator.next().intValue();
	    }
	    return ret;
	}
	
//	public void printPreorder (int i) { 
//        if (getData (i) == null) return; 
//        System.out.println (getData (i)); //Root
//        printPreorder (left (i)); //L
//        printPreorder (right (i)); //R
//    }
	
//	public static void printInOrder(Tree tree) {
//		if (tree.getData(1) == null) {
//			System.out.println("empty");
//		}
//		if (tree.getData(left(root)) != null) {
//			
//		}
//	}
	public static int log2(int n)
	{
	    return (int) (Math.log(n) / Math.log(2));
	}

}
