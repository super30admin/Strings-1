import java.util.HashMap;
import java.util.Map;

//Time complexity is O(max of S or T)
//Space complexity is O(T)
//This solution is submitted on Leetcode

public class BigN91CustomSortString {
	class Solution {
		public String customSortString(String S, String T) {
			StringBuilder sb = new StringBuilder();
			// edge case
			if (S == null || T == null || S.length() == 0 || T.length() == 0)
				return sb.toString();
			HashMap<Character, Integer> map = new HashMap<>();
			for (int i = 0; i < T.length(); i++) {
				Character c = T.charAt(i);
				if (!map.containsKey(c)) {
					map.put(c, 1);
				} else
					map.put(c, map.get(c) + 1);
			}

			for (int i = 0; i < S.length(); i++) {
				Character c = S.charAt(i);
				if (map.containsKey(c)) {
					int count = map.get(c);
					while (count > 0) {
						sb.append(c);
						count--;
					}
					map.remove(c);
				}
			}
			for (Map.Entry<Character, Integer> entry : map.entrySet()) {
				int coun = entry.getValue();
				Character c = entry.getKey();
				while (coun > 0) {
					sb.append(c);
					coun--;
				}
			}
			return sb.toString();
		}
	}
}