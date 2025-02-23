import java.util.HashMap;

/**
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 * Did this code successfully run on Leetcode: Yes
 * Any problem you faced while coding this: None

 * Approach:
 * 1. Go over the string and check if the character exists in map
 * 2. If exists, that means it is a repeating character, so the start should be an index + 1 of the seen character
 * 3. Put the charcter and its index to map
 * 4. Get the max length of substring - (end - start + 1), here 'i' is tracking the end
 */

public class LongestSubstringWithNoRepeats {
    public int lengthOfLongestSubstring(String s) {
        int start, max;
        start = 0; max = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (map.containsKey(c)) {
                start = Math.max(start, map.get(c));
            }

            max = Math.max(max, i - start + 1);
            map.put(c, i + 1);
        }

        return max;
    }

    public static void main(String[] args) {
        // Your code here

        LongestSubstringWithNoRepeats obj = new LongestSubstringWithNoRepeats();
        int len = obj.lengthOfLongestSubstring("ababsjywbabaabya");
        System.out.println(len);
        assert(len == 6);
    }
}