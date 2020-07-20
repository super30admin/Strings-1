
//TC - O(M + N)
//SC- O(N)
import java.util.*;

class Solution {
	public String customSortString(String S, String T) {
		StringBuilder sb = new StringBuilder();
		HashMap<Character, Integer> hmap = new HashMap<>();
		for (int i = 0; i < T.length(); i++) {
			hmap.put(T.charAt(i), hmap.getOrDefault(T.charAt(i), 0) + 1);
		}
		for (int j = 0; j < S.length(); j++) {
			if (hmap.containsKey(S.charAt(j))) {
				int count = hmap.get(S.charAt(j));
				while (count > 0) {
					sb.append(S.charAt(j));
					count--;
				}
				hmap.remove(S.charAt(j));
			}
		}
		for (Map.Entry<Character, Integer> entry : hmap.entrySet()) {
			int count = entry.getValue();
			char c = entry.getKey();
			while (count > 0) {
				sb.append(c);
				count--;
			}
		}
		return sb.toString();
	}
}