package Main;

import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

import java.util.NoSuchElementException;


public class TreeMap<K,V> extends AbstractMap<K,Person_Info> {

	private static class Node<K,V> extends DefaultEntry<K,Person_Info> {
		
		Node<K,Person_Info> left, right, next;
		
		Node(K k, Person_Info v) {
			super(k,v);
			left = right = next = null;
		}
	}

	private Comparator <K> comparator;
	private Node<K,Person_Info> root;
	private final Node<K,Person_Info> dummy = new Node<>(null,null);
	private int numPeople = 0;
	private int version = 0;
	
	@SuppressWarnings("unchecked")
	public TreeMap() {
		comparator = (x,y) -> ((Comparable<K>) x ).compareTo(y);
	}
	
	public TreeMap(Comparator<K> c) {
		if(c == null) throw new IllegalArgumentException("Comprator cannot be null.");
		comparator = c;
	}
	
	private int count(Node<K, Person_Info> root) {
		if(root == null) return 0;
		return count(root.left) + 1 + count(root.right);
	}
	
	/**
	 *  Contains the number of people in this map
	 * @return Total number of people in this map
	 */
	public int count() {
		return numPeople;
	}
	
	/**
	 * Gets the person given a inserted value. Checks to see if they are in the map.
	 * @param k Where k is the person to look for.
	 * @return the node that contains the person if found
	 */
	public Node<K,Person_Info> getPerson(K k){
		Node<K, Person_Info> person = null;
		if(root == null) {
			return null;
		}
		person = getPersonHelp(k,root);
		if(person == null) { System.out.println(k + " could not be found in database.\n" ); }
		else {System.out.println(k); }
		return person;
	}
	
	/**
	 * Helper method for getPerson(), Looks for the person given any root in the map. 
	 * @param k Where k is the person to look for.
	 * @param v Where v is the node to start at. Usually starts at the root unless specified.
	 * @return The node containing the person/info.
	 */
	private Node<K,Person_Info> getPersonHelp(K k , Node<K, Person_Info> v) {
		Node<K, Person_Info> info = null;
		if(k == null || v == null) return null;
		String c1 = (String) k;
		String c2 = (String) v.key;
		info = v;
		int res = c1.compareTo(c2);
		if(res == 0) return info;
		if(res < 0) {
			return info = getPersonHelp(k,info.left);
		}else {
			return info = getPersonHelp(k,info.right);
		}
	}
	
	/**
	 * Associates the specified value with the specified key in this map(optional operation). If the map previously contained a mapping for
	 * the key, the old value is replaced by the specified value. (A map m is said to contain a mapping for a key k if and only
	 * if m.containsKey(k) would return true.)
	 * Checks bases and the call helper method toPut which helps add value k,v to the tree. Checks the map before adding the value in.
	 * 
	 * @param k Where k is the name of the person
	 * @param v Where v is the personal info of the given person k.
	 * @return info Where info is the personal info if they were added to the list or replaced in the list.
	 * @throws IllegalStateException When the person k is null
	 */
	public Person_Info put(K k, Person_Info v) {
		if(k == null) throw new IllegalStateException("Name to add is null.");
		Person_Info info;
		Node<K,Person_Info> node = getPerson(k);
		if(node != null) {
			info = node.value;
			node.value = v;
		}else {
			info = null;
			root = toPut(root,k,v,dummy);
		}
		return info;
	}
	
	/**
	 *  Helper method for put. Recursively goes through the map to find where to put the newly created node.
	 *  
	 * @param cur Where cur is the current node to start on. Base case starts at the root unless specified to start else-where.
	 * @param k Where k is the persons name to search for. Cannot be null.
	 * @param v Where v is the info of the given person k.
	 * @param before The node to link current nodes next to because the map uses threading.  Helps sets the links to the right locations
	 * @return cur Where current node is the newly added node or changed node. Cannot be null.
	 */
	public Node<K, Person_Info> toPut(Node<K, Person_Info> cur, K k, Person_Info v, Node<K, Person_Info> before){
		if(cur == null) {
			++numPeople;
			cur = new Node<K,Person_Info>(k,v);
			cur.next = before.next;
			before.next = cur;
			++version;
			return cur;
		}
		String c1 = (String) k;
		String c2 = (String) cur.key;
		int result = c1.compareTo(c2);
		if(result < 0) {
			cur.left = toPut(cur.left,k,v,before);
		} else {
			cur.right = toPut(cur.right,k,v,cur);
		}	
		return cur;
	}
	
	/**
	 *  Prints the list using threading. This can print in 3 different ways given specified values.
	 *  1) From start to end of the map. All the nodes in the tree.
	 *  2) From a specified node to the end of the map. All the nodes from the given start node to the end of this list.
	 *  3) From a specified node to a specified end node. All the nodes in between those 2 given nodes.
	 * @param k1 Where k1 is the start node given a specified node. If no node is specified k1 will be null and starts from the farthest left node.
	 * @param k2 Where k2 is the end node given a specified node. If no node is specified, k2 will be null and ends at the farthest right node.
	 */
	public void print(K k1, K k2) {
		Node<K, Person_Info> track = null;
		if(k1 == null) { track = dummy.next; }
		else { track = getPerson(k1);}
		if(k2 != null && getPerson(k2) == null) return;
			while(track != null && track.key != k2) {
				System.out.println(track.key);
				System.out.println(track.value);
				System.out.println("______________________________________");
				track = track.next;
			}
	}
	
	/**
	 * Removes the mapping for a key from this map if it is present(optional operation). More formally, if this map contains a mapping
	 * from key k to value v such that Objects.equals(key, k), that mapping
	 * is removed. (The map can contain at most one such mapping.) 
	 * Returns the value to which this map previously associated the key,or null if the map contained no mapping for the key. 
	 * If this map permits null values, then a return value of null does not necessarily indicate that the map
	 * contained no mapping for the key; it's also possible that the map
	 * explicitly mapped the key to null. 
	 * The map will not contain a mapping for the specified key once the call returns.
	 * @param key Where key is the person to be removed from the map.
	 * @return person.getValue() The personal info of the person given the key. If they are successfully removed the personal info of the person is returned.
	 *@throws NullpointerException key of the person to find cannot be null. 
	 *@throws NoSuchElementException If the given key to find is not present in the map. 
	 */
	@SuppressWarnings("unchecked")
	public Person_Info remove(Object key) {
		if(key == null) throw new NullPointerException("Key to remove cannot be null.");
		Node<K, Person_Info> person = getPerson((K)key);
		if(root != null && person != null) {
			doRemove(person, root);
		}else {
			throw new NoSuchElementException("Person not in list.");
		}
		return person.getValue();
	}
	
	/**
	 *  Helper method for remove. Responsible for removing the node from the map and re-adjusting the left and right nodes as well as the next node for threading.
	 * @param curNode The node that is trying to be removed.
	 * @param start The node to start from. Usually starts at the root unless specified. 
	 * @return curNode Where the current node is the node to be removed from the tree. Can extract the key and value from the given node.
	 */
	private Node<K, Person_Info> doRemove(Node<K, Person_Info> curNode, Node<K, Person_Info> start) {
		
		Node<K, Person_Info> person = null;
		String c1 = (String) curNode.key;
		String c2 = (String) start.key;
		int res = c1.compareTo(c2);
		
		if(res < 0) {
			start.left = doRemove(curNode, start.left);
		}else if(res > 0) {
			start.right = doRemove(curNode, start.right);
		}else {
			while(root != start) {
				root = root.next;
					if(root.next == start) {
						person = root.next;
						person.next = start.next;
					}
			}
			if(start.right != null) {
				toPut(root,start.right.key,start.right.value,dummy);
			}
			if(start.left != null) {
				toPut(root,start.left.key,start.left.value,dummy);
			}
		}
		return curNode;
	}
	
	/**
	 * Gets the current personal information given a person key. If the person exist in the map, their personal information is displayed 
	 * using info.getValue()
	 * @param k Where k is the person to look for.
	 */
	public void getInfo(K k) {
		Node<K,Person_Info> info = null;
		info = getPerson(k);
			if(info != null) System.out.println(  info.getValue() );
			else throw new NoSuchElementException("The given person " + k + " is not present in the current map.");
		}

	/**
	 * Implemented for efficiency reasons, because we already know the size of the map, instead of counting through the map again
	 * we can simply see if the number of people in the map is equal to 0
	 * @return True if the number of people in the map is 0 or False if there are people in the map
	 */
	@Override
	public boolean isEmpty() {
		return numPeople == 0;
	}

	/**
	 * Returns true if this map maps one or more keys to the
	 * specified value. More formally, returns true if and only if
	 * this map contains at least one mapping to a value v such that Objects.equals(value, v).
	 * @param value Where the value is the current personal information a unknown person
	 * @return True if the personal info is in the map. False is the personal info  is not in the list
	 * @throws NullPointerException When the value to look for is null.
	 */
	@Override
	public boolean containsValue(Object value) {
		// TODO Auto-generated method stub
		if(value == null) throw new NullPointerException("Value to find cannot be null");
		for(Node<K,Person_Info> curNode = dummy.next; curNode != null; curNode = curNode.next) {
			if(curNode.getValue() == value) return true;
		}
		return false;
	}

	/**
	 * Returns true if this map contains a mapping for the specified
	 * key. More formally, returns true if and only if
	 * this map contains a mapping for a key k such that Objects.equals(key, k). (There can beat most one such mapping.)
	 * @param key Where key is the name of a person, cannot be null.
	 * @return True if the persons name is in the map. False is the persons name is not in the list
	 * @throws NullPointerException When the key to find is null.
	 */
	@SuppressWarnings("unchecked")
	@Override
	public boolean containsKey(Object key) {
		if(key == null) throw new NullPointerException("The given name cannot be null.");
		if(!equals(key)) return false;
		Node<K,Person_Info> person = getPerson((K)key);
		if(person == null)return false;
		return true;
	}
	/**
	 * This implementation first checks if the specified object is this map;if so it returns true. Then, it checks if the specified
	 * object is a map whose size is identical to the size of this map; if
	 * not, it returns false. If so, it iterates over this map's entrySet collection, and checks that the specified map
	 * contains each mapping that this map contains. If the specified map
	 * fails to contain such a mapping, false is returned. If the
	 * iteration completes, true is returned.
	 * @param o The object to be compared
	 * @return true if the specified object is equal to this map false it not
	 */
	@Override
	public boolean equals(Object o) {
		if((o instanceof Node<?,?>) )return true; //fix
		return true;
	}
	
	
	/**
	 * Copies all of the mappings from the specified map to this map(optional operation). The effect of this call is equivalent to that
	 * of calling put(k, v) on this map once for each mapping from key k to value v in the
	 * specified map. The behavior of this operation is undefined if the specified map is modified while the operation
	 *  is in progress.
	 *  @param toAdd Where m is the map containing all the nodes that need to be added to this map
	 *  @throws NullPointerException if the map to be added is null or contains null keys or values.
	 *  @throws IllegalArgumentException if invalid info pertaining to the current map is trying to be added.
	 */
	@Override
	public void putAll(Map<? extends K, ? extends Person_Info> toAdd) {
		
	}
	
	/**
	 * Add all planets from this collection.
	 * @param coll collection to add planets, must not be null.
	 */
	public void addAll(Collection<K> coll) {
		if(coll == null) throw new NullPointerException("Collection of planets cannot be null.");
		
		for( K  p: coll) {} 

	}

	
	private class EntrySet extends AbstractSet<Entry<K,V>> {

		@Override
		public Iterator<Entry<K, V>> iterator() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public int size() {
			// TODO Auto-generated method stub
			return TreeMap.this.numPeople;
		}
		  
	  }


	@Override
	public Set<Entry<K, Person_Info>> entrySet() {
		// TODO Auto-generated method stub
		return null;
	}
	
}



