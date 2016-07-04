import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
public class Subset {
	public static void main(String[] args) {
		RandomizedQueue<String> rq = new RandomizedQueue<String> ();
//		In in = new In("input1.txt");
		int k_num = Integer.parseInt(args[0]);
//		int k_num = 5;
		int count = 1;
		
		while(!StdIn.isEmpty()){
			String s = StdIn.readString();
			if (count<k_num+1 && k_num != 0) rq.enqueue(s);	
			else if (k_num >=  StdRandom.uniform(count)+1 && k_num != 0) {
				rq.dequeue();
				rq.enqueue(s);
			}
			count++;
		}	
		
		for (String e: rq){
			StdOut.println(e);
		}
		//get k of N outputs with uniform distribution. The size of queue is k. 
//		int num_output = (int) Math.round(Math.random()*(rq.size()-1));
		
//		while (num_output != 0) {
//			num_output--;
//			StdOut.println(rq.dequeue());			
//		}
	}
}
