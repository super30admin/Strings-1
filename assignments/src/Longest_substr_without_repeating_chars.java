import java.util.*;
// Time: O(2n) = O(n)
// Space: O(min(m,n))
public class Longest_substr_without_repeating_chars {

    public int lengthOfLongestSubstring(String s) {

        Map<Character, Integer> freqMap = new HashMap();
        int left = 0, right = 0, res = 0;

        while (right < s.length()) {
            char r = s.charAt(right);
            freqMap.put(r, freqMap.getOrDefault(r,0) + 1);

            while (freqMap.get(r) > 1) {
                char l = s.charAt(left);
                freqMap.put(l, freqMap.get(l) - 1);
                left++;
            }

            res = Math.max(res, right - left + 1);
            right++;
        }
        return res;
    }
}