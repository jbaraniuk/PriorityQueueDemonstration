/**
 * @author Justin Baraniuk
 * @date 2019/03/20
 */
import java.util.Comparator;

public class DefaultComparator<E> implements Comparator<E> {
	public int compare(E a, E b) throws ClassCastException {
		return ((Comparable<E>) a).compareTo(b);
	}
}
