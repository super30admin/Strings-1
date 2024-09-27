// Time Complexity :O(Length of string S + Length of string T)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :YEs
// Any problem you faced while coding this :No

// Your code here along with comments explaining your approach
import java.util.*;

public class CustomSortString {

	public String customSortStringMap(String S, String T) {

		StringBuffer s = new StringBuffer();
		HashMap<Character, Integer> map = new HashMap<>();

		for (char ch : T.toCharArray()) {
			map.put(ch, map.getOrDefault(ch, 0) + 1);
		}

		for (char ch : S.toCharArray()) {
			int count = map.get(ch);
			append(s, count, ch);
			map.remove(ch);
		}

		if (!map.isEmpty()) {
			for (Map.Entry<Character, Integer> entry : map.entrySet()) {

				char ch = entry.getKey();
				int count = entry.getValue();
				append(s, count, ch);

			}
		}

		return s.toString();
	}

	public String customSortString(String S, String T) {
		
		

		StringBuffer s = new StringBuffer();
		int[] charArr = new int[26];

		for (char ch : T.toCharArray()) {
			int index = ch - 'a';
			charArr[index]++;
		}

		for (char ch : S.toCharArray()) {
			int index = ch - 'a';
			int count = charArr[index];
			append(s, count, ch);
			charArr[index] = 0;

		}

		for (int i = 0; i < charArr.length; i++) {

			int count = charArr[i];
			char ch = (char) (i + 'a');
			append(s, count, ch);

		}

		return s.toString();
	}

	private void append(StringBuffer s, int count, char ch) {
		while (count > 0) {

			s.append(ch);
			count--;
		}

	}

	public static void main(String[] args) {

		CustomSortString c = new CustomSortString();
		String s = c.customSortString("cba", "abcabcgfh");
		System.out.println(s);

	}

}
