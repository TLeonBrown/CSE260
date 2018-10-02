import java.util.*;
public class GenericStackExtendsArrayList<E> {
	
	private ArrayList<E> l;
	
	public GenericStackExtendsArrayList (int capacity) {
		l = new ArrayList<E>(capacity);
	}
	
	public GenericStackExtendsArrayList () {
		l = new ArrayList<E>();
	}
	
	public int getSize() {
		return l.size();
	}
	
	public E peek () {
		return l.get(getSize() - 1);
	}
	
	public void push (E obj) {
		l.add(obj);
	}
	
	public E pop () {
		E obj = l.get(l.size()-1);
		l.remove(l.size()-1);
		return obj;
	}
	
	public boolean isEmpty () {
		if (l.isEmpty()){
			return true;
		}
		return false;
	}
	
	public String toString () {
		return "stack: " + l.toString();
	}
	
	

	public static void main(String[] args) {
		GenericStackExtendsArrayList<Integer> l = new GenericStackExtendsArrayList<Integer>();
		l.push(1);
		l.push(3);
		l.push(5);
		l.push(2);
		l.push(4);
		System.out.println(l.isEmpty());	
		System.out.println(l.toString());
		System.out.println(l.pop());
		System.out.println(l.peek());
		System.out.println(l.getSize());

	}

}
