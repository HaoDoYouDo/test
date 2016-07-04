import java.util.Iterator;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;




public class RandomizedQueue<Item> implements Iterable<Item> {
	private class RandomQueueIterator implements Iterator<Item> {
//		private int C = N;
		private Item[] clone = (Item[]) new Object[N]; 
		private int C = clone.length;
		public RandomQueueIterator() {
			for (int i = 0; i<C; i++)
				clone[i] = rq[i];
		}
		@Override
		public boolean hasNext() {
			// TODO Auto-generated method stub
			return C != 0;
		}

		@SuppressWarnings("unchecked")
		@Override
		public Item next() {
			// TODO Auto-generated method stub
			if(C == 0) throw new java.util.NoSuchElementException();
			int randindex = StdRandom.uniform(C);
			   Item item = clone[randindex];			   
			   clone[randindex] =clone[C-1];
			   clone[C-1] = null;
			   C--;
			   if (C == 1/4*clone.length) {
				   int newLength = 1/2*clone.length;
				   Item[] copy = (Item[]) new Object[newLength];
				   for	(int i = 0 ; i< C; i ++ ) {
					   copy[i] = clone[i];
					   
				   }
				   clone = copy;
			   }
			   return item;
		}

		@Override
		public void remove() {
			// TODO Auto-generated method stub
			throw new java.lang.UnsupportedOperationException();
		}

	}
	private Item[] rq;
	private int N = 0 ;
	@SuppressWarnings("unchecked")
	public RandomizedQueue() {
		rq = (Item[]) new Object[1];
	}                 // construct an empty randomized queue
	public boolean isEmpty() {
		return N == 0 ;
	}// is the queue empty?
	public int size() {
		return N;
	}                      // return the number of items on the queue
	@SuppressWarnings("unchecked")
	public void enqueue(Item item) {
		if (item == null) throw new java.lang.NullPointerException();
		if (N == rq.length ) {
			 int newLength = 2*rq.length;
			Item[] copy = (Item[]) new Object[newLength];//double size
			 for (int i = 0; i< N; i++) {
				 copy[i] = rq[i];
			 }
			 rq = copy;
		}
		 rq[N++] = item;
	}          // add the item; resizing array; double size when array is full 
	@SuppressWarnings("unchecked")
	public Item dequeue() {
		if (isEmpty()) throw new java.util.NoSuchElementException();
		if (N == 1) {
			N--;
			Item item = rq[0];
			rq[0] = null;
			return item;
		}
	   int randindex = StdRandom.uniform(N);
	   Item item = rq[randindex];
	   rq[randindex] = rq[N-1];
	   rq[N-1] = null;
	   N--;
	   if (N == 1/4*rq.length) {
		   int newLength = 1/2*rq.length;
		   Item[] copy = (Item[]) new Object[newLength];
		   for	(int i = 0 ; i< N; i ++ ) {
			   copy[i] = rq[i];
			   
		   }
		   rq = copy;
	   }
	   return item;
	}                  // remove and return a random item; half size when array is a quater full
	public Item sample() {
		if (isEmpty()) throw new java.util.NoSuchElementException();
		int randindex = StdRandom.uniform(N);
		   Item item = rq[randindex];
		   return item;
	}                    // return (but do not remove) a random item
	@Override
	public Iterator<Item> iterator() {
		// TODO Auto-generated method stub
		return  new RandomQueueIterator();  // return an independent iterator over items in random order
	}
	public static void main(String[] args) {
		RandomizedQueue<Integer> rq = new RandomizedQueue<Integer> ();
//		String s1 = "a";String s2 = "a1";String s3 = "a2";String s4 = "a3";
		rq.size();
		rq.size();
		rq.enqueue(0);
		rq.sample();
		rq.sample();
		rq.dequeue();
		rq.isEmpty();
//		rq.isEmpty();
//		rq.size();
		rq.enqueue(47);
		for (int s: rq){
			StdOut.println(s);
		}
//		int a = 0;
//		int[] aa = new int[1];
//		aa[a++] = 2;
	}  // unit testing
	}
