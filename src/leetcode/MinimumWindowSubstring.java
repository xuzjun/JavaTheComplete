package leetcode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.TreeSet;

/*
 * Given a string S and a string T, find the minimum window in S which will contain all the characters in T in complexity O(n).
 * 
 * For example,
 * S = "ADOBECODEBANC"
 * T = "ABC"
 * Minimum window is "BANC".
 * 
 * Note:
 * If there is no such window in S that covers all characters in T, return the empty string "".
 * 
 * If there are multiple such windows, you are guaranteed that there will always be only one unique minimum window in S.
 */

public class MinimumWindowSubstring {

	class Element {
		int val;
		int idx;
		int row;

		public Element(int val, int idx, int row) {
			this.val = val;
			this.idx = idx;
			this.row = row;
		}
	}

	public String minWindow(String s, String t) {

		List<ArrayList<Integer>> posOfT = new ArrayList<ArrayList<Integer>>();
		TreeSet<Integer> ts = new TreeSet<Integer>();

		int k = 0;
		ArrayList<Integer> al = null;
		for (char c : t.toCharArray()) {
			k = 0;
			char[] cs = s.toCharArray();
			al = new ArrayList<Integer>();
			for (int i = 0; i < s.length(); ++i) {
				if (c == cs[i]) {
					al.add(i);
					k++;
					ts.add(i);
				}
			}
			if (k == 0)
				return "";
			posOfT.add(al);
		}

		int[] r = smallestRange(posOfT);
		if (r.length == 0)
			return "";
		return s.substring(r[0], r[1] + 1);
	}

	public int[] smallestRange(List<ArrayList<Integer>> nums) {

		PriorityQueue<Element> pq = new PriorityQueue<Element>(new Comparator<Element>() {

			@Override
			public int compare(Element a, Element b) {
				return a.val - b.val;
			}
		});

		int max = Integer.MIN_VALUE;
		for (int i = 0; i < nums.size(); ++i) {
			Element e = new Element(nums.get(i).get(0), 0, i);
			pq.offer(e);
			max = Math.max(max, e.val);
		}

		int range = Integer.MAX_VALUE;
		int start = -1;
		int end = -1;
		while (pq.size() == nums.size()) {
			Element curr = pq.poll();
			if (max - curr.val < range) {
				range = max - curr.val;
				start = curr.val;
				end = max;
			}

			if (curr.idx + 1 < nums.get(curr.row).size()) {
				curr.idx++;
				curr.val = nums.get(curr.row).get(curr.idx);
				pq.offer(curr);
				if (curr.val > max)
					max = curr.val;
			}
		}

		return new int[] { start, end };
	}

	public static void main(String[] args) {
		String s = "ADOBECODEQBANCTOUEQ";
		String t = "ABOCQ";

		MinimumWindowSubstring mws = new MinimumWindowSubstring();
		String r = mws.minWindow(s, t);
		System.out.println(r);
	}
}
