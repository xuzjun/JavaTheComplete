package leetcode;

import java.util.ArrayList;
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

public class RepeatedDNASequencesByTrie {
	
	class Trie {
		
		Trie[] child;
		
		int hasAdded;
		
		Trie() {
			child = new Trie[4];
			hasAdded = -1;
		}
	}
	
	static List<String> rl;
	
	public List<String> findRepeatedDnaSequences(String s) {
		
		Trie root = new Trie();
		rl = new ArrayList<String>();
		int r;
		for (int i = 0; i + 10 <= s.length(); ++i) {
			String subString = s.substring(i, i + 10);
			
			r = addToTrie(subString, root);
			if (r == 1)
				rl.add(subString);
		}
		
		return rl;
	}

	private int addToTrie(String s, Trie root) {
		
		Trie t = root;
		int index = 0;
		for (int i = 0; i < s.length(); ++i) {
			char ch = s.charAt(i);
			switch (ch) {
			case 'A':
				index = 0;
				break;
			case 'C':
				index = 1;
				break;
			case 'G':
				index = 2;
				break;
			case 'T':
				index = 3;
				break;
			}
			
			if (t.child[index] == null)
				t.child[index] = new Trie();

			t = t.child[index];
		}
		if (t.hasAdded == -1) {
			t.hasAdded = 0;
		} else if (t.hasAdded == 0) {
			t.hasAdded = 1;
			return 1;
		}
			
		return 0;
	}

	public static void main(String[] args) {
		String s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTTGGGGGGGTTTGGGG";
		
		RepeatedDNASequencesByTrie r = new RepeatedDNASequencesByTrie();
		List<String> l = r.findRepeatedDnaSequences(s);
		System.out.println(l);
	}

}
