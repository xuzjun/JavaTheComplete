package leetcode;

/*
 * Given two strings s and t, write a function to determine if t is an anagram of s.
 * 
 * For example,
 * s = "anagram", t = "nagaram", return true.
 * s = "rat", t = "car", return false.
 * 
 * Note:
 * You may assume the string contains only lowercase alphabets.
 * 
 * Follow up:
 * What if the inputs contain unicode characters? How would you adapt your solution to such case?
 */

public class ValidAnagram {
    public boolean isAnagram(String s, String t) {
    	
    	int[] smap = new int[26];
    	
    	for (char ch : s.toCharArray()) {
    		smap[ch - 'a']++;
    	}
    	
    	for (char ch : t.toCharArray()) {
    		smap[ch - 'a']--;
    	}
    	
    	for (int i : smap) {
    		if (i != 0) return false;
    	}
    	
		return true;
        
    }
}
