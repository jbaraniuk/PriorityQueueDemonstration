/**
 * @author Justin Baraniuk
 * @date 2019/03/20
 */

public class PriorityQueueDriver {

	public static void main(String[] args) {
		PriorityQueue<Integer, Integer> lhpq = new LinkedHeapPriorityQueue<>();			
		System.out.println("Demonstration of a linked heap priority queue:\n");
		System.out.println("size():\n" + lhpq.size() + "\n");
		
		lhpq.insert(8,8);
		lhpq.insert(6,6);
		lhpq.insert(7,7);
		lhpq.insert(5,5);
		lhpq.insert(3,3);
		lhpq.insert(0,0);
		lhpq.insert(9,9);
		System.out.println("insert(): 8, 6, 7, 5, 3, 0, 9\n" + lhpq + "\n");
		
		// size():
		System.out.println("size():\n" + lhpq.size() + "\n");
		
		// min():
		System.out.println("min():\n" + lhpq.min() + "\n");
		
		// removeMin():
		lhpq.removeMin();
		System.out.println("removeMin():\n" + lhpq + "\n");
		
		// size():
		System.out.println("size():\n" + lhpq.size() + "\n");
	}
}
