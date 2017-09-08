package leetcode;

import java.util.Arrays;
import java.util.Comparator;

public class Test {

	public static void main(String[] args) {
		Integer[] ai = new Integer[]{2, 4, 1, 0, 9};
		
		Arrays.sort(ai, new Comparator<Integer>() {

			@Override
			public int compare(Integer a, Integer b) {
				// TODO Auto-generated method stub
				return b - a;
			}
		});
		
		Arrays.sort(ai, new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				// TODO Auto-generated method stub
				return 0;
			}
		});
	}

}
