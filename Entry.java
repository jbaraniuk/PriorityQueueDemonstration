/**
 * @author Justin Baraniuk
 * @date 2019/03/20
 */

public interface Entry<K,V> {
	K getKey();
	V getValue();
}
