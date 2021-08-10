//Time Complexity : O(n), n -> Length of String 
// Space Complexity : O(1), No matter what the string length is, we have one array of size 128.
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
package problem2;

public class LongestUniqueSubstring {
	public int lengthOfLongestSubstring(String s) {
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

	public static void main(String[] args) {
		LongestUniqueSubstring obj = new LongestUniqueSubstring();
		String str = "abcabcbb";
		System.out.println("Length of longest substring with unique characters in \'" + str + "\': "
				+ obj.lengthOfLongestSubstring(str));
	}

}
