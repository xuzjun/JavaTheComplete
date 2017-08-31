package leetcode;

public class SetMismatch2 {

	public static int[] findErrorNums(int[] nums) {
		int[] ret = new int[2];

		int[] newNums = new int[nums.length];

		for (int i : nums) {
			if (++newNums[i - 1] == 2)
				ret[0] = i;
		}
		
		for (int i = 0; i < nums.length; ++i)
			if (newNums[i] == 0)
				ret[1] = i + 1;

		return ret;
	}

	public static void main(String[] args) {
		int[] nums = new int[4];
		nums[0] = 1;
		nums[1] = 1;
		nums[2] = 3;
		nums[3] = 4;

		int[] r = findErrorNums(nums);
		for (int i : r) {
			System.out.println(i);
		}
	}

}
