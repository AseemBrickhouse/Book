package Main;


/**
 * A default implementation of entries in a Map
 * @see {@link java.util.Map.Entry}
 */
public class DefaultEntry<K,V> extends AbstractEntry<K, V> {

	protected K key;
	protected V value;
	
	/**
	 * Create an entry with the given arguments.
	 * @param k
	 * @param v
	 */
	public DefaultEntry(K k, V v) { key = k; value = v; }

	@Override
	public V getValue() {
		return (V) value;
	}

	@SuppressWarnings("unchecked")
	@Override
	public V setValue(V v) {
		V old = v;
		this.value = (V) v;
		return old;
	}

	@Override
	public K getKey() {
		return key;
	}
}