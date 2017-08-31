package leetcode;

import java.util.ArrayList;
import java.util.HashMap;

/*
 * Given the root of a tree, you are asked to find the most frequent subtree sum.
 * The subtree sum of a node is defined as the sum of all the node values formed by the subtree rooted at that node (including the node itself).
 * So what is the most frequent subtree sum value? If there is a tie, return all the values with the highest frequency in any order.
 * 
 * Examples 1
 * Input:
 * 
 *   5
 *  /  \
 * 2   -3
 * return [2, -3, 4], since all the values happen only once, return all of them in any order.
 * Examples 2
 * Input:
 * 
 *   5
 *  /  \
 * 2   -5
 * return [2], since 2 happens twice, however -5 only occur once.
 * Note: You may assume the sum of values in any subtree is in the range of 32-bit signed integer.
 */

public class MostFrequentSubtreeSum {
	
	HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
	
    public int[] findFrequentTreeSum(TreeNode root) {
    	
    	if (root == null)
    		return new int[0];
    	
    	calTreeSumAndAddToMap(root);
    	
    	int count = 0;
    	ArrayList<Integer> al = new ArrayList<Integer>();
    	for (Integer key : hm.keySet()) {
    		if (hm.get(key) >= count) {
    			if (hm.get(key) > count) {
    				al.clear();
    				count = hm.get(key);
    			}
    			al.add(key);
    		}
    	}
    	
    	int[] re = new int[al.size()];
    	int j = 0;
    	for (Integer i : al) {
    		re[j++] = i.intValue();
    	}
		return re;
        
    }

	private void calTreeSumAndAddToMap(TreeNode root) {
		if (root.left != null)
			calTreeSumAndAddToMap(root.left);
		
		if (root.right != null)
			calTreeSumAndAddToMap(root.right);
		
		if (root.left != null)
			root.val += root.left.val;
		if (root.right != null)
			root.val += root.right.val;
		
		hm.put(root.val, hm.getOrDefault(root.val, 0) + 1);
	}
	
	public static void main(String[] args) {
		TreeNode root = new TreeNode(5);
		TreeNode rl = new TreeNode(2);
		TreeNode rr = new TreeNode(-3);
		
		root.left = rl;
		root.right = rr;
		
		TreeNode rll = new TreeNode(7);
		TreeNode rlr = new TreeNode(4);
		TreeNode rrl = new TreeNode(9);
		
		rl.left = rll;
		rl.right = rlr;
		rr.left = rrl;
		
		MostFrequentSubtreeSum mfss = new MostFrequentSubtreeSum();
		int[] r = mfss.findFrequentTreeSum(root);
		
		for (int i: r) {
			System.out.println(i);
		}
		
	}
}
