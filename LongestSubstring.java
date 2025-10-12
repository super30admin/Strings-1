import java.util.HashMap;
import java.util.Map;

//TC: O(n), SC: O(n)
public class LongestSubstring {

    public int lengthOfLongestSubstring(String s) {
        int length = s.length();
        if (length <= 1) return length;

        final Map<Character, Integer> indexMap = new HashMap<>();
        int left = 0, max = 0;

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (indexMap.containsKey(ch)) {
                left = Math.max(left, indexMap.get(ch) + 1);
            }

            max = Math.max(max, i - left + 1);
            indexMap.put(ch, i);
        }

        return max;
    }
}
