package leetcode;

public class SetMismatch3 {

	public static int[] findErrorNums(int[] nums) {
		int[] ret = new int[2];

		int[] newNums = new int[nums.length];

		for (int i = 0; i < nums.length; ++i) {
            ret[1] ^= (i + 1) ^ nums[i]; 
			if (++newNums[nums[i] - 1] == 2)
				ret[0] = nums[i];
		}
		
		ret[1] ^= ret[0];

		return ret;
	}

	public static void main(String[] args) {
		int[] nums = new int[4];
		nums[0] = 1;
		nums[1] = 2;
		nums[2] = 2;
		nums[3] = 4;

		int[] r = findErrorNums(nums);
		for (int i : r) {
			System.out.println(i);
		}
	}

}
