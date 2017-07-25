package treeHomework;

public class Tree {
	private static Object[] array; //not sure about private static
	
	public Tree () { //initialization
		array = new Object [100];
	}
	
	public boolean empty () { //empty?
		return (array[1] == null);
	}
	
	public int size () { //size even if empty
		return array.length;
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
	
	public static void postOrderNoRecursion() {
		int i = 1;
		while (getData(left(i)) != null) {
			i = left(i);
		}
		System.out.println(getData(i)); //check where we are..
		while (i!=1) { //loops
			if (getData(left(i)) != null) {
				i = left(i);
			} else if (getData(right(i)) != null) {
				i = right(i);
			} else if (getData(parent(i)) != null) {
				i = parent(i);
			}
			System.out.println(getData(i));
		}
	}
	
	public void printInorder (int i) {
		if (getData (i) == null) return;       
		printInorder (left (i)); //L
		System.out.println (getData (i)); //Root
		printInorder (right (i)); //R
	}

	
}
