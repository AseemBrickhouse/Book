package Main;

import java.util.Map;

public abstract class AbstractEntry<K, V> implements Map.Entry<K,V> {
	@Override
	public boolean equals(Object o) {
		if (!(o instanceof Map.Entry))
			return false;
		Map.Entry<?,?> e = (Map.Entry<?,?>)o;
		return eq(this.getKey(), e.getKey()) && eq(this.getValue(), e.getValue());
	}

	@Override
	public int hashCode() {
		return 25*hash(getKey()) + 1;
	}

//	@Override
//	public String toString() {
//		return this.getKey() + "=" + this.class.toString();
//	}

	protected static int hash(Object o) {
		return o == null ? 0 : o.hashCode();
	}
	
	protected static boolean eq(Object o1, Object o2) {
		return (o1 == null ? o2 == null : o1.equals(o2));
	}
}