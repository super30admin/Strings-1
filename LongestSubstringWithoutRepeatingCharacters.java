package strings1;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithoutRepeatingCharacters {
	//Time Complexity : O(n), where n is the length of order string
	//Space Complexity : O(n), string s for map
	//Did this code successfully run on Leetcode : Yes
	//Any problem you faced while coding this : No
	public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> lastSeen = new HashMap<>();
        
        int max = 0;
        int j = 0;
        for(int i=0; i<s.length(); i++) {
            if(lastSeen.containsKey(s.charAt(i)))
                j = Math.max(lastSeen.get(s.charAt(i)), j);
            lastSeen.put(s.charAt(i), i + 1);
            max = Math.max(max, i - j + 1);
        }
        
        return max;
    }
}
