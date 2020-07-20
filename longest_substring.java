
//TC - O(N)
//SC - O(1)
import java.util.*;

class Solution1 {
	public int lengthOfLongestSubstring(String s) {
		if (s == null || s.length() == 0)
			return 0;
		HashMap<Character, Integer> hmap = new HashMap<>();
		int slow = 0;
		int fast = 0;
		int max = 0;
		while (fast < s.length()) {
			char c = s.charAt(fast);
			if (hmap.containsKey(c)) {
				slow = Math.max(slow, hmap.get(c));
			}
			hmap.put(c, fast + 1);
			max = Math.max(max, fast - slow + 1);
			fast++;
		}
		return max;
	}
}