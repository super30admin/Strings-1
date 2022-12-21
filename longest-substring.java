
//tc is O(n)
//sc is O(1)
import java.util.*;

class Solution {
    public int lengthOfLongestSubstring(String s) {

        if (s == null || s.length() == 0)
            return 0;

        HashMap<Character, Integer> map = new HashMap<>();

        int start = 0;
        int maxLength = 0;

        for (int i = 0; i < s.length(); i++) {

            char c = s.charAt(i);

            if (map.containsKey(c)) {
                start = Math.max(map.get(c), start);
            }
            map.put(c, i + 1);

            maxLength = Math.max(maxLength, i - start + 1);
        }

        return maxLength;

    }
}