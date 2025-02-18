import java.util.HashMap;

class Solution2 {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int start = 0;
        int max = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (map.containsKey(ch)) {
                start = Math.max(start, map.get(ch));
            }
            map.put(ch, i + 1);
            max = Math.max(max, i - start + 1);
        }
        return max;
    }
}