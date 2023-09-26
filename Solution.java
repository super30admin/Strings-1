import java.util.*;

public class Solution {
    // TC : O(n) SC : O(1)
    public String customSortString(String order, String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        StringBuilder result = new StringBuilder();
        // Frequency Map
        for (int i = 0; i < s.length(); i++) {
            char curr = s.charAt(i);
            map.put(curr, map.getOrDefault(curr, 0) + 1);
        }
        // check which chars are in order and add to sb
        for (int i = 0; i < order.length(); i++) {
            char c = order.charAt(i);
            if (map.containsKey(c)) {
                int count = map.get(c);
                for (int j = 0; j < count; j++) {
                    result.append(c);
                }
                map.remove(c);
            }
        }
        // add all the leftover chars that were not in order string
        for (Character c : map.keySet()) {
            int count = map.get(c);
            for (int j = 0; j < count; j++) {
                result.append(c);
            }
        }
        return result.toString();
    }
}

class LongestSubStringWithoutRepetingChars {
    // TC : O(n) SC : O(1)
    public int lengthOfLongestSubstring(String s) {
        int slow = 0;
        int max = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (map.containsKey(ch)) {
                slow = Math.max(map.get(ch) + 1, slow);
            }
            map.put(ch, i);
            max = Math.max(max, i - slow + 1);
        }
        return max;
    }
}