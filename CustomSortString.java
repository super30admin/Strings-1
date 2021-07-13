// Time Complexity : O(n+m)
// Space Complexity :O(1) //max of 26 chars
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :no

import java.util.HashMap;
import java.util.Map;

public class CustomSortString {
	public String customSortString(String order, String str) {
		Map<Character, Integer> map = new HashMap<>();
		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			map.compute(c, (k, v) -> v == null ? 1 : v + 1);
		}

		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < order.length(); i++) {
			char c = order.charAt(i);
			int count = map.getOrDefault(c, -1);
			if (count > -1) {
				for (int j = 1; j <= count; j++) {
					sb.append(c);
				}
				map.remove(c);
			}
		}

		for (char c : map.keySet()) {
			int count = map.get(c);
			if (count > -1) {
				for (int i = 1; i <= count; i++) {
					sb.append(c);
				}
			}
		}
		return sb.toString();
	}
}
