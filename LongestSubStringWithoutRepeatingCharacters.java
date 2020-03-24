// Time Complexity :O(n)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :No

// Your code here along with comments explaining your approach

import java.util.*;

public class LongestSubStringWithoutRepeatingCharacters {

	public int lengthOfLongestSubstring(String s) {
		
		if(s.length() == 0 || s == null) {
			return 0;
		}

		int maxLen = 0, len = s.length();
		int start = 0, end = 0;

		HashSet<Character> set = new HashSet<>();

		while (end < len) {
			char chStart = s.charAt(start);
			char chEnd = s.charAt(end);
			
			while (set.contains(chEnd)) {
				
				set.remove(chStart);
				start++;
				chStart = s.charAt(start);

			}
			
			set.add(chEnd);
			maxLen = Math.max(maxLen, end-start+1);
			end++;
			
		}

		return maxLen;

	}

	public static void main(String[] args) {

		LongestSubStringWithoutRepeatingCharacters l = new LongestSubStringWithoutRepeatingCharacters();
		int len = l.lengthOfLongestSubstring("pwwkew");
		System.out.println(len);

	}

}
