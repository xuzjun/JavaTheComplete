package leetcode;


/*
 * Design a data structure that supports all following operations in average O(1) time.
 * 
 * insert(val): Inserts an item val to the set if not already present.
 * remove(val): Removes an item val from the set if present.
 * getRandom: Returns a random element from current set of elements. Each element must have the same probability of being returned.
 * Example:
 * 
 * // Init an empty set.
 * RandomizedSet randomSet = new RandomizedSet();
 * 
 * // Inserts 1 to the set. Returns true as 1 was inserted successfully.
 * randomSet.insert(1);
 * 
 * // Returns false as 2 does not exist in the set.
 * randomSet.remove(2);
 * 
 * // Inserts 2 to the set, returns true. Set now contains [1,2].
 * randomSet.insert(2);
 * 
 * // getRandom should return either 1 or 2 randomly.
 * randomSet.getRandom();
 * 
 * // Removes 1 from the set, returns true. Set now contains [2].
 * randomSet.remove(1);
 * 
 * // 2 was already in the set, so return false.
 * randomSet.insert(2);
 * 
 * // Since 2 is the only number in the set, getRandom always return 2.
 * randomSet.getRandom();
 */

public class RandomizedSet {

	final private int BUCKET_SIZE = 4 * 1024; // 4K

	class Node {
		int val;
		Node next;

		Node(int val) {
			this.val = val;
		}
	}

	class BucketItem {
		int size;
		Node list;
	}

	BucketItem[] bucket;

	private int get_pos(int val) {
		return Math.abs(Integer.hashCode(val) % BUCKET_SIZE);
	}

	/** Initialize your data structure here. */
	public RandomizedSet() {
		bucket = new BucketItem[BUCKET_SIZE];
	}

	/**
	 * Inserts a value to the set. Returns true if the set did not already
	 * contain the specified element.
	 */
	public boolean insert(int val) {

		int pos = get_pos(val);
		if (bucket[pos] != null) {
			Node n = bucket[pos].list;
			Node p = n;
			while (n != null) {
				if (n.val == val)
					return false;
				p = n;
				n = n.next;
			}
			p.next = new Node(val);
		} else {
			bucket[pos] = new BucketItem();
			bucket[pos].list = new Node(val);
		}
		bucket[pos].size++;
		return true;
	}

	/**
	 * Removes a value from the set. Returns true if the set contained the
	 * specified element.
	 */
	public boolean remove(int val) {

		int pos = get_pos(val);
		if (bucket[pos] != null) {
			Node n = bucket[pos].list;
			Node p = n;
			while (n != null) {
				if (n.val == val) {
					if (p == bucket[pos].list) {
						bucket[pos].list = n.next;
						bucket[pos].size--;
						if (bucket[pos].list == null)
							bucket[pos] = null;
					} else {
						p.next = n.next;
						bucket[pos].size--;
					}
					return true;
				}
				p = n;
				n = n.next;
			}
		}

		return false;
	}

	/** Get a random element from the set. */
	public int getRandom() {

		int rand = (int) (Math.random() * BUCKET_SIZE);
		for (int i = rand; (i + 1) % BUCKET_SIZE != rand; i = (++i) % BUCKET_SIZE) {
			if (bucket[i] == null)
				continue;

			int rand2 = (int) (Math.random() * bucket[i].size);

			Node p = bucket[i].list;
			for (int j = 0; j < rand2; ++j)
				p = p.next;

			return p.val;
		}
		return 0;
	}

	public static void main(String[] args) {
		RandomizedSet rs = new RandomizedSet();

		boolean r = rs.insert(2);
		System.out.println(r);
		r = rs.insert(1);
		System.out.println(r);
		r = rs.remove(2);
		System.out.println(r);
		r = rs.insert(3);
		r = rs.insert(90);
		r = rs.insert(31023);
		r = rs.insert(200);
		System.out.println(r);
		for (int j = 0; j < 1000; ++j) {
			int i = rs.getRandom();
			System.out.println(i);
		}
	}

}
