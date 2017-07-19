package treeHomework;

public class Tree {
	Object[] array;
	
	public Tree () { //initialization
		array = new Object [8];
	}
	
	public boolean empty () { //empty?
		return (array[1] == null);
	}
	
	public int size () { //size even if empty
		return array.length;
	}
	
	
	//calculate indices for..
	public int left (int i ) { return (2*i); };
	public int right (int i ) { return (2*i) + 1; };
	public int parent (int i ) { return i / 2; };
	
	public Object getData (int i) { //getter & setter
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
	
	public void printInorder (int i) {
		if (getData (i) == null) return;       
		printInorder (left (i)); //L
		System.out.println (getData (i)); //Root
		printInorder (right (i)); //R
	}

	
}
