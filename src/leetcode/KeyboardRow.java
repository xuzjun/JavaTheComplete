package leetcode;

import java.util.ArrayList;

public class KeyboardRow {
	
	private boolean containsWords(String row, String words) {
		for (int i = 0; i < words.length(); ++i) {
			String t = words.substring(i, i + 1);
			if (!row.contains(t))
				return false;
		}
		return true;
	}
	
	public String[] findWords(String[] words) {
		String row1 = "QWERTYUIOPqwertyuiop";
		String row2 = "ASDFGHJKLasdfghjkl";
		String row3 = "ZXCVBNMzxcvbnm";
		
		ArrayList<String> r = new ArrayList<String>();
		for (String word : words) {
			if (containsWords(row1, word)) {
				r.add(word);
			} else if (containsWords(row2, word)) {
				r.add(word);;
			} else if (containsWords(row3, word)) {
				r.add(word);
			}
		}
		String[] rs = new String[r.size()];
		r.toArray(rs);
		return rs;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
