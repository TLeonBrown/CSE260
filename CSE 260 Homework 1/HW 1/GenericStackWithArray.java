//Tian Brown, 111597217
public class GenericStackWithArray<E> {
	private E list[];
	private final static int DEFAULT_SIZE = 10;
	private int size;
	
	public GenericStackWithArray () {
		list = (E[])new Object[DEFAULT_SIZE];
	}
	
	public GenericStackWithArray (int s) {
		list = (E[])new Object[s];
	}
	
	public int getSize () {
		return list.length;
	}
	
	public E peek () {
		return list[list.length-1];
	}
	
	public void push (E o) {
		//creates new array with twice the size of the first one
		E list2 [] = (E[])new Object[list.length*2];
		//puts object o into the first index of list2
		list2[0] = o;
		//copies the elements from list1 over
		for (int i = 0; i < list2.length-1; i++) {
			list2[i+1] = list[i];
		}
	}
	
	public E pop () {
		E lastElement = list[list.length-1];
		return lastElement;
	}
	
	public boolean isEmpty () {
		if (list.length == 0)
			return true;
		else
			return false;
	}
	
	public String toString () {
		return list.toString();
	}

}
