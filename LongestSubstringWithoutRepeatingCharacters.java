import java.util.HashMap;
import java.util.HashSet;
//tc : O(n); n = len of string
//sc : O(n)
public class LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0 || s == null) return 0;
        HashMap<Character, Integer> map = new HashMap<>();

        int max = 0;
        int start = 0;

        for (int end = 0; end < s.length(); end++) {
            char ch = s.charAt(end);
            if (map.containsKey(ch)) {
                start = Math.max(start, map.get(ch));

            }
            map.put(ch, end + 1);
            max = Math.max(max, end - start + 1);
        }

        return max;
    }
}
