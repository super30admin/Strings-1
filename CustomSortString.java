//Time Complexity: O(m + n) S and T Character Arrays
//Space Complexity: O(m)
import java.util.HashMap;
import java.util.Map;

public class CustomSortString {
	public String customSortString(String S, String T) {
		StringBuilder sb = new StringBuilder();
		HashMap<Character, Integer> map = new HashMap<>();
		for (Character c : T.toCharArray()) {
			map.put(c, map.getOrDefault(c, 0) + 1);
		}
		for (Character c : S.toCharArray()) {
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
			Character key = entry.getKey();
			int count = entry.getValue();
			while (count > 0) {
				sb.append(key);
				count--;
			}
		}
		return sb.toString();
	}
}
