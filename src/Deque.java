import java.util.Iterator;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Deque<Item> implements Iterable<Item> {
	private class MyIterator implements Iterator<Item> {
		private Node current = first;
		@Override
		public boolean hasNext() {
			// TODO Auto-generated method stub
			return current != null;
		}

		@Override
		public Item next() {
			// TODO Auto-generated method stub
			if (current == null) throw new java.util.NoSuchElementException();
			Item item = current.item;
			current = current.next;			
			return item;
		}

		@Override
		public void remove() {
			// TODO Auto-generated method stub
			throw new java.lang.UnsupportedOperationException();
		}
	}
	private class Node {
		Item item;
		Node next;
		Node pre;
	}
	private Node first;
	private Node last;
	private int N = 0;
	public Deque(){
		first = null;
		last = null;
	}                           // construct an empty deque
	public boolean isEmpty()                 // is the deque empty?
	{
//		return first.item == null;
		return N == 0;
	}
	public int size() {
//		int len = 0;
//		if (isEmpty()) {return len;}
//		else {
//		Node current = first;
//		while (current.next != null) {
//			len++;
//			current = current.next;
//			}
//		}
		return N;
	}                        // return the number of items on the deque
	public void addFirst(Item item){
		if (item ==null) {throw new java.lang.NullPointerException();}
		Node oldfirst = first;
		first = new Node();
		first.item = item;
		first.pre = null;
		first.next = oldfirst;
		if (oldfirst != null) oldfirst.pre = first;
		else last =first;
		N++;
//		oldfirst.pre = first;
//		if (oldfirst.item == null) last = first;
	}          // add the item to the front
	public void addLast(Item item){
		if (item == null) {throw new java.lang.NullPointerException();}
		else{
		Node oldlast = last;
		last = new Node();
		last.item = item;
		last.next = null;
		last.pre = oldlast;
		if (oldlast != null) oldlast.next = last;
		else first = last;
		N++;
		}
}           // add the item to the end
	public Item removeFirst() {
		Item item;
		if (isEmpty()) {throw new java.util.NoSuchElementException();}
		else{
			item = first.item;
			N--;
			first = first.next;
			if (first == null)  {
				last = first;
				return item;
			}
			
			else first.pre = null;			
		}		
		return item; 
	}                // remove and return the item from the front
	public Item removeLast() {
		
		Item item;
		if (isEmpty()) {throw new java.util.NoSuchElementException();}
		else{
			item = last.item;
			N--;
			last = last.pre;
			if (last == null) { 
				first = last;
				return item;
				}
			else last.next = null;
//			if (last.pre.item == null) {last = first;}			
		}
		return item;
	}                // remove and return the item from the end
	@Override
	public Iterator<Item> iterator() {
		// TODO Auto-generated method stub	
		return new MyIterator();
	}
	
	public static void main(String[] args)   // unit testing
	{
		Deque<String> deque = new Deque<String> ();
		deque.addFirst("GFAFNBYJYC");
        deque.addFirst("NQLRPPAYMP");
        deque.addLast("BXTBKMRTSV");
        deque.removeLast();      
        deque.removeLast();  
        deque.addFirst("LYTGJWJCRY");
        deque.addLast("ULAILRJDHB");
        deque.removeLast();    //  ==> ULAILRJDHB
        deque.removeFirst();     //==> LYTGJWJCRY
        deque.removeFirst();     //==> NQLRPPAYMP
        deque.removeFirst(); 
//		while(!StdIn.isEmpty()){
//			String s = StdIn.readString();
//			
//			if (s.equals("-")) StdOut.print(deque.removeLast());
//			else deque.addFirst(s);
//
//			int le = deque.size();
//			StdOut.println(le);
//		}
//		String s1 = "a";String s2 = "a1";String s3 = "a2";String s4 = "a3";
//		deque.addLast(s1);deque.addLast(s2);deque.addLast(s3);deque.addLast(s4);
//		StdOut.println(deque.removeFirst());
//		StdOut.println(deque.removeFirst());
//		StdOut.println(deque.removeFirst());
//		StdOut.println(deque.removeFirst());
//		StdOut.println(deque.removeLast());
//		for (String x: deque){
//			StdOut.println(x);
//		}
	}
}
