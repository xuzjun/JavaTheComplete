package leetcode;

import java.util.ArrayList;
import java.util.List;

/*
 * In English, we have a concept called root, which can be followed by some other words to form another longer word - let's call this word successor.
 * For example, the root an, followed by other, which can form another word another.
 *
 * Now, given a dictionary consisting of many roots and a sentence. You need to replace all the successor in the sentence with the root forming it.
 * If a successor has many roots can form it, replace it with the root with the shortest length.
 *
 * You need to output the sentence after the replacement.
 *
 * Example 1:
 * Input: dict = ["cat", "bat", "rat"]
 * sentence = "the cattle was rattled by the battery"
 * Output: "the cat was rat by the bat"
 * Note:
 *   The input will only have lower-case letters.
 *   1 <= dict words number <= 1000
 *   1 <= sentence words number <= 1000
 *   1 <= root length <= 100
 *   1 <= sentence words length <= 1000
 */
public class ReplaceWords {

	static public String replaceWords(List<String> dict, String sentence) {
		String[] swords = sentence.split(" ");
		StringBuffer sBuffer = new StringBuffer();

		for (String s : swords) {
			if (s.length() == 0)
				continue;
			
			String tmp = s;
			for (String s2 : dict) {
				if (s.startsWith(s2)) {
					if (tmp.equals("") || tmp.length() > s2.length())
						tmp = s2;
				}
			}
			if (sBuffer.length() == 0)
				sBuffer.append(tmp);
			else
				sBuffer.append(" " + tmp);
		}

		return new String(sBuffer);
	}

	public static void main(String[] args) {
		String sentence = "the cattle was rattled by the battery";

		List<String> dict = new ArrayList<String>();
		dict.add("cat");
		dict.add("bat");
		dict.add("rat");

		String rString = replaceWords(dict, sentence);

		System.out.println(rString);
	}

}
