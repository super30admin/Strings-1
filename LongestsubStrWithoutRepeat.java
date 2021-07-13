// Time Complexity : O(n)
// Space Complexity :O(1) //max of 256 chars
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :no

/*
 * 1. maintain 2 pointers
 * 2. define a hashmap to hold last occurrence of a character
 * 3. loop through string and move right pointer and find length.
 * 4. if an character is repeated move left pointer to that index+1 and also check left pointer is already ahead
 */
import java.util.HashMap;
import java.util.Map;

public class LongestsubStrWithoutRepeat {
	public int lengthOfLongestSubstring(String s) {
		if (s == null || s.length() < 1)
			return 0;
		int leftp = 0;
		Map<Character, Integer> map = new HashMap<>();
		map.put(s.charAt(0), 0);
		int max = 1;
		for (int i = 1; i < s.length(); i++) {
			char c = s.charAt(i);
			if (map.containsKey(c)&&leftp<=map.get(c)) {
				leftp = map.get(c) + 1;
			}
			map.put(c, i);
			max = Math.max(max, i - leftp + 1);
		}
		return max;
	}
	
	public static void main(String[] args) {
		System.out.println(new LongestsubStrWithoutRepeat().lengthOfLongestSubstring("abba"));
	}
}
