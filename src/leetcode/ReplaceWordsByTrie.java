package leetcode;

import java.util.ArrayList;
import java.util.List;

public class ReplaceWordsByTrie {
	class Trie {
		Trie[] child;

		boolean isWord;

		Trie() {
			child = new Trie[27];
		}
	}

	Trie root = new Trie();
	
	public String replaceWords(List<String> dict, String sentence) {

		if (dict == null || sentence == null) {
			return null;
		}

		for (String s : dict) {
			addToTrie(s, 0, root);
		}

		StringBuilder sb = new StringBuilder();

		for (String s : sentence.split(" ")) {

			String f = find(s, root, 0);

			if (f != null) {
				sb.append(f);
			} else {
				sb.append(s);
			}
			sb.append(" ");

		}
		return sb.toString().trim();

	}

	Trie addToTrie(String st, int p, Trie root) {
		if (st == null || st.length() == p) {
			return null;
		}
		char ch = st.charAt(p);
		if (root.child[ch - 'a'] == null) {
			root.child[ch - 'a'] = new Trie();
		}
		Trie t = addToTrie(st, p + 1, root.child[ch - 'a']);
		if (t == null) {
			root.child[ch - 'a'].isWord = true;
		}
		return root;
	}

	String find(String st, Trie root, int p) {

		if (st == null || root == null) {
			return null;
		}
		if (st.length() == p) {
			return null;
		}
		Trie child = root.child[st.charAt(p) - 'a'];
		if (child == null) {
			return null;
		}
		if (child.isWord) {
			return st.substring(0, p + 1);
		}

		return find(st, child, p + 1);

	}

	public static void main(String[] args) {
		String sentence = "the cattle was rattled by the battery";

		List<String> dict = new ArrayList<String>();
		dict.add("cat");
		dict.add("bat");
		dict.add("rat");

		ReplaceWordsByTrie rwByTrie = new ReplaceWordsByTrie();
		String rString = rwByTrie.replaceWords(dict, sentence);

		System.out.println(rString);
	}

}
