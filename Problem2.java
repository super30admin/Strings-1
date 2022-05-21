import java.util.HashMap;
import java.util.Map;

public class Problem2 {
    // Sliding Window
    // TC : O(n)
    // SC : O(1)
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) return 0;

        Map<Character, Integer> map = new HashMap<>();
        int slow = 0;
        int max = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)) {
                slow = Math.max(slow, map.get(c));
            }
            map.put(c, i + 1);
            max = Math.max(max, i - slow + 1);
        }
        return max;
    }
}
