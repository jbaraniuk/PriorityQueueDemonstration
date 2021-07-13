/**
 * @author Justin Baraniuk
 * @date 2019/03/20
 */

public interface Position<E> {
	E getElement() throws IllegalStateException;
}
