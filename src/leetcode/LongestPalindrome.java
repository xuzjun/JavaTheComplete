package leetcode;

/*
 * Given a string which consists of lowercase or uppercase letters, 
 * find the length of the longest palindromes that can be built with those letters.
 * 
 * This is case sensitive, for example "Aa" is not considered a palindrome here.
 * 
 * Note:
 * Assume the length of given string will not exceed 1,010.
 * 
 * Example:
 * 
 * Input:
 * "abccccdd"
 *  
 * Output:
 * 7
 * 
 * Explanation:
 * One longest palindrome that can be built is "dccaccd", whose length is 7.
 */

public class LongestPalindrome {
	
	class SuffixTree {
		
		SuffixTree[] st;
		
		boolean isEnd;
		
		public SuffixTree() {
			st = new SuffixTree[52];
		}
	}
	
	SuffixTree root = new SuffixTree();
	
    public int longestPalindrome(String s) {
    	
    	for (int i = 0; i < s.length(); ++i) {
    		String subString = s.substring(i);
    		
    		addToSuffixTree(root, subString);
    	}
    	
		return 0;
    }

	private void addToSuffixTree(SuffixTree root, String subString) {
		
		SuffixTree st = root;
		for (char ch : subString.toCharArray()) {
			st = new SuffixTree();
			if (ch <= 'Z') {
				st.st[ch -'A'] = st;
			} else {
				st.st[ch - 'a'] = st;
			}
		}
	}

	public static void main(String[] args) {
		
	}

}
