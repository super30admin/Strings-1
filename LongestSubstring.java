import java.util.HashMap;
import java.util.Map;

public class LongestSubstring {

    // Sliding window approach
    // TC: O(n)
    // SC: O(1)
    public int lengthOfLongestSubstring(String s) {
        if(s == null || s.length() == 0) return 0;

        Map<Character, Integer> map = new HashMap<>();
        int slow = 0;
        int max = 0;

        for(int fast = 0; fast < s.length(); fast++) {
            char c = s.charAt(fast);
            if(map.containsKey(c)) {
                slow = Math.max(slow, map.get(c)); // updating slow in case we found the same character again
                                                    // if we encounter the same character again then store the greater index in a map
            }
            max = Math.max(max, fast - slow + 1);
            map.put(c, fast + 1); // fast + 1 because we don't have to add 1 later
        }
        return max;
    }

    // Follow up question - find the longest substring without repeating the character

    public String findLongestSubstring(String s) {
        if(s == null || s.length() == 0) return "";

        Map<Character, Integer> map = new HashMap<>();
        int slow = 0;
        int max = 0;
        int start = 0, end = 0;

        for(int fast = 0; fast < s.length(); fast++) {
            char c = s.charAt(fast);
            if(map.containsKey(c)) {
                slow = Math.max(slow, map.get(c));
            }
            if(fast - slow + 1 > max) {
                max = Math.max(max, fast - slow + 1);
                start = slow;
                end = fast;
            }
            map.put(c, fast + 1); // fast + 1 because we don't have to add 1 later
        }
        return s.substring(start, end + 1);
    }
}
