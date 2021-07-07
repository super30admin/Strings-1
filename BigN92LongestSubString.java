// Time complexity is O(n)
// Space complexity is O(n)
// This solution is submitted on Leetcode

import java.util.HashMap;

public class BigN92LongestSubString {
	class Solution {
		public int lengthOfLongestSubstring(String s) {
			// edge case
			if (s == null || s.length() == 0)
				return 0;
			HashMap<Character, Integer> map = new HashMap<>();
			int slow = 0;
			int fast = 0;
			int max = Integer.MIN_VALUE;
			while (fast < s.length()) {
				Character c = s.charAt(fast);
				if (map.containsKey(c)) {
					slow = Math.max(slow, map.get(c));
				}
				map.put(c, fast + 1);
				max = Math.max(max, fast - slow + 1);
				fast++;
			}
			return max;
		}
	}
}