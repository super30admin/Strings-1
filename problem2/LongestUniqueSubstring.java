//Time Complexity : O(n), n -> Length of String 
// Space Complexity : O(1), No matter what the string length is, max length of map is constant
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
package problem2;

import java.util.HashMap;
import java.util.Map;

public class LongestUniqueSubstring {
	/********************* TwoPass *********************/
	public int lengthOfLongestSubstringArray(String s) {
		if (s == null || s.length() == 0) {
			return 0;
		}

		int[] cnt = new int[128];
		int ans = 0;
		int left = 0;
		int right = 0;

		while (right < s.length()) {
			char ch_right = s.charAt(right);
			cnt[ch_right]++;

			while (cnt[ch_right] > 1) {
				char ch_left = s.charAt(left);
				cnt[ch_left]--;
				left++;
			}
			ans = Math.max(right - left + 1, ans);
			right++;
		}
		return ans;
	}

	/********************* OnePass *********************/
	public int lengthOfLongestSubstring(String s) {
		if (s == null || s.length() == 0) {
			return 0;
		}

		Map<Character, Integer> map = new HashMap<Character, Integer>();
		int ans = 0;
		int ptr = 0;

		for (int i = 0; i < s.length(); i++) {
			char ch = s.charAt(i);
			// Update start pointer of sliding window
			if (map.containsKey(ch)) {
				ptr = Math.max(ptr, map.get(ch));
			}
			// Update index
			map.put(ch, i + 1);
			// Update max length
			ans = Math.max(ans, i - ptr + 1);
		}

		return ans;
	}

	public static void main(String[] args) {
		LongestUniqueSubstring obj = new LongestUniqueSubstring();
		String str = "abcabcbb";
		System.out.println("Length of longest substring with unique characters in \'" + str + "\': "
				+ obj.lengthOfLongestSubstring(str));
	}

}
