package leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/*
 * All DNA is composed of a series of nucleotides abbreviated as A, C, G, and T, for example: "ACGAATTCCG". When studying DNA, it is sometimes useful to identify repeated sequences within the DNA.
 * 
 * Write a function to find all the 10-letter-long sequences (substrings) that occur more than once in a DNA molecule.
 * 
 * For example,
 * 
 * Given s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT",
 * 
 * Return:
 * ["AAAAACCCCC", "CCCCCAAAAA"].
 */

public class RepeatedDNASequences {

	public static List<String> findRepeatedDnaSequences(String s) {
		
		HashSet<String> hs = new HashSet<String>();
		HashSet<String> hs1 = new HashSet<String>();
		
		for (int i = 0; i + 10 <= s.length(); ++i) {
			String subString = s.substring(i, i + 10);
			
			if (hs.contains(subString))
				hs1.add(subString);
			else
				hs.add(subString);
		}
		
		List<String> rl = new ArrayList<String>();
		for (String s1 : hs1)
			rl.add(s1);
		return rl;
	}

	public static void main(String[] args) {
		String s = "AAAAAAAAAAAAAA";
		
		List<String> l = findRepeatedDnaSequences(s);
		System.out.println(l);
	}

}
