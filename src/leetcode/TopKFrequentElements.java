package leetcode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.TreeSet;

/*
 * Given a non-empty array of integers, return the k most frequent elements.
 * 
 * For example,
 * Given [1,1,1,2,2,3] and k = 2, return [1,2].
 * 
 * Note: 
 * You may assume k is always valid, 1 ¡Ü k ¡Ü number of unique elements.
 * Your algorithm's time complexity must be better than O(n log n), where n is the array's size.
 */

public class TopKFrequentElements {

	class TreeNode {
		int val;
		int frequence;

		TreeNode(int val, int frequence) {
			this.val = val;
			this.frequence = frequence;
		}
	}

	class MyComp implements Comparator<TreeNode> {

		@Override
		public int compare(TreeNode t1, TreeNode t2) {
			return t2.frequence - t1.frequence;
		}

	}

	public List<Integer> topKFrequent(int[] nums, int k) {

		HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();

		for (int i : nums) {
			hm.put(i, hm.getOrDefault(i, 0) + 1);
		}

		TreeSet<TreeNode> ts = new TreeSet<TreeNode>(new MyComp());
		for (int key : hm.keySet()) {
			TreeNode tn = new TreeNode(key, hm.get(key));
			ts.add(tn);
		}

		List<Integer> l = new ArrayList<Integer>();
		Iterator<TreeNode> it = ts.iterator();
		while (it.hasNext() && k-- > 0) {
			TreeNode itn = it.next();
			l.add(itn.val);
		}

		return l;
	}
}
