package Main;


/**
 * A default implementation of entries in a Map
 * @see {@link java.util.Map.Entry}
 */
public class DefaultEntry<K,V> extends AbstractEntry<K, Person_Info> {

	protected K key;
	protected V value;
	
	/**
	 * Create an entry with the given arguments.
	 * @param k
	 * @param v
	 */
	public DefaultEntry(K k, V v) { key = k; value = v; }

	@Override
	public Person_Info getValue() {
		return (Person_Info) value;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Person_Info setValue(Person_Info value) {
		Person_Info old = value;
		this.value = (V) value;
		return old;
	}

	@Override
	public K getKey() {
		return key;
	}
}