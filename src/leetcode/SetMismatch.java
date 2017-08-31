package leetcode;

import java.util.TreeSet;

public class SetMismatch {

	public static int[] findErrorNums(int[] nums) {
		TreeSet<Integer> ts = new TreeSet<Integer>();
		int[] ret = new int[2];
		
		int sum1 = 0;
		for (int n : nums) {
			ts.add(n);
			sum1 += n;
		}
		
		int sum2 = 0;
		for (int n : ts) {
			sum2 += n;
		}
		
		int diff = sum1 - sum2;
		ret[0] = diff;
		
		Integer[] newNums = new Integer[nums.length];
		
		ts.toArray(newNums);
		int i;
		for (i = 0; i < nums.length - 1; ++i) {
			if (newNums[i] != i + 1)
				break;
		}
		ret[1] = i + 1;
		return ret;
	}

	public static void main(String[] args) {
		int[] nums = new int[4];
		nums[0] = 1;
		nums[1] = 1;
//		nums[2] = 3;
//		nums[3] = 4;
		
		int[] r = findErrorNums(nums);
		for (int i: r) {
			System.out.println(i);
		}
	}

}
