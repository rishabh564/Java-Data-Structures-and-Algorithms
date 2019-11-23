package ivanmarkovic.algorithms.queue.stacksimplementation;

public class Main {

	public static void main(String[] args) {
		Queue<Integer> q = new Queue<>();
		
		//q.dequeue();
		q.enqueue(2);
		q.enqueue(15);
		
		for(int i = 100; i <= 500; i+= 100)
			q.enqueue(i);
		
		while (!q.isEmpty()) {
			System.out.println(q.dequeue());
		}

	}

}