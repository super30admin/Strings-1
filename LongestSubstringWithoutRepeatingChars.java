import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LongestSubstringWithoutRepeatingChars {
    public int lengthOfLongestSubstring(String s) {
        return lengthOfLongestSubstringUsingMap(s);
        // return lengthOfLongestSubstringUsingSet(s);
    }
    
    // TC: O(N) where N is length of s
    // SC: O(1)
    private int lengthOfLongestSubstringUsingSet(String s) {
        int start = 0, res = 0;
        Set<Character> set = new HashSet<>();
        for (int end = 0; end < s.length(); end++) {
            char currChar = s.charAt(end);
            if (set.contains(currChar)) {
                while (set.contains(currChar)) {
                    set.remove(s.charAt(start));
                    start++;
                }
            }
            res = Math.max(res, end - start + 1);
            set.add(currChar);
        }
        return res;
    }

    // TC: O(N) where N is length of s
    // SC: O(1)
    private int lengthOfLongestSubstringUsingMap(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int start = 0, res = 0;
        for (int end = 0; end < s.length(); end++) {
            char currChar = s.charAt(end);
            if (map.containsKey(currChar)) {
                start = Math.max(start, map.get(currChar) + 1);
            }
            res = Math.max(res, end - start + 1);
            map.put(currChar, end);
        }
        return res;
    }
}
