/**
 * @author Justin Baraniuk
 * @date 2019/03/20
 */

public interface Queue<E> {
	int size();
	boolean isEmpty();
	void enqueue(E e);
	E first();
	E dequeue();
}
