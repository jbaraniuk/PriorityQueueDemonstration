/**
 * @author Justin Baraniuk
 * @date 2019/03/20
 */
import java.util.Comparator; 

public class LinkedHeapPriorityQueue<K,V> extends AbstractPriorityQueue<K,V> {
	
	protected LinkedBinaryTree<Entry<K,V>> heap = new LinkedBinaryTree<>();
	public LinkedHeapPriorityQueue() { super(); }
	public LinkedHeapPriorityQueue(Comparator<K> comp) { super(comp); }

	public int size() { return heap.size(); }
	
	public Entry<K,V> min() {
		if (heap.isEmpty()) return null;
		return heap.root().getElement();
	}

	public Entry<K,V> insert(K key, V value) throws IllegalArgumentException {
		checkKey(key);
		Entry<K,V> newest = new PQEntry<>(key, value);

		if (heap.isEmpty()) 
			heap.addRoot(newest);
		else {
			
			// Find next available position
			String binaryPath = Integer.toBinaryString(heap.size()+1);
			
			// Traverse heap to last parent position
			Position<Entry<K,V>> position = heap.root();
			for (int i = 1; i < binaryPath.length()-1; i++) {
				if (binaryPath.charAt(i) == '0')
					position = heap.left(position);
				else
					position = heap.right(position);
			}
			
			// Add position containing entry to left or right position
			if (Integer.parseInt(binaryPath) % 2 == 0) {
				heap.addLeft(position, newest);
				position = heap.left(position);
			} else {
				heap.addRight(position, newest);
				position = heap.right(position);
			}
			
			// Ensure (entry key > parent key)
			upheap(position);
		}

		return newest;
	}

	public Entry<K,V> removeMin() {
		if(heap.isEmpty()) return null;
		Entry<K,V> answer = heap.root().getElement();
		swap(heap.root(), getLastPosition());
		heap.remove(getLastPosition());
		downheap(heap.root());
		return answer;
	}
	
	
	protected void swap(Position<Entry<K,V>> p1, Position<Entry<K,V>> p2) {
		Entry<K,V> temp = p1.getElement();
		heap.set(p1, p2.getElement());
		heap.set(p2, temp);
	}
	
	protected void upheap(Position<Entry<K,V>> p) {
		while (p != heap.root()) {
			Position<Entry<K,V>> parent = heap.parent(p);
			if (compare(p.getElement(), parent.getElement()) >= 0)
				break;
			swap(p, parent);
			p = parent;
		}
	}
	
	protected void downheap(Position<Entry<K,V>> p) {
		if (p != null) {
			while (heap.left(p) != null) {
				Position<Entry<K,V>> leftPosition = heap.left(p);
				Position<Entry<K,V>> smallChildPosition = leftPosition;
				if (heap.right(p) != null) {
					Position<Entry<K,V>> rightPosition = heap.right(p);
					if (compare(leftPosition.getElement(), rightPosition.getElement()) > 0)
						smallChildPosition = rightPosition;
				}
				if (compare(smallChildPosition.getElement(), p.getElement()) >= 0)
					break;
				swap(p, smallChildPosition);
				p = smallChildPosition;
			}
		}
	}
	
	protected Position<Entry<K,V>> getLastPosition() {	
		// binary path to last position
		String binaryPath = Integer.toBinaryString(heap.size());
					
		// Traverse heap to last position
		Position<Entry<K,V>> position = heap.root();
		for (int i = 1; i < binaryPath.length(); i++) {
			if (binaryPath.charAt(i) == '0')
				position = heap.left(position);
			else
				position = heap.right(position);
		}
		return position;
	}
	
	public String toString() {
		return heap.toString();
	}
}
