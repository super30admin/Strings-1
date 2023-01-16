// Approach: Use a frequency map to store frequencies of chars in i/p string s
// Time: O(m + n) where m = length of string s and n = length of string order
// Space: O(m) where m = length of string s

import java.util.*;
// Approach: Use a frequency map to store frequencies of chars in i/p string s, append to StringBuilder
// its frequency times as soon as we found a char matching to order in our freqMap
// Time: O(m + n) where m = length of string s and n = length of string order
// Space: O(m) where m = length of string s
class Custom_sort_string {
    public String customSortString(String order, String s) {

        Map<Character, Integer> freqMap = new HashMap();
        for (char c : s.toCharArray()) {
            freqMap.put(c, freqMap.getOrDefault(c,0) + 1);
        }

        StringBuilder sb = new StringBuilder();
        for (char ch : order.toCharArray()) {
            if (freqMap.containsKey(ch)) {
                int count = freqMap.get(ch);
                for (int i = 0; i<count; i++) {
                    sb.append(ch);
                }
                freqMap.remove(ch);
            }
        }

        for (char ch : freqMap.keySet()) {
            int count = freqMap.get(ch);
            for (int i = 0; i<count; i++) {
                sb.append(ch);
            }
        }

        return sb.toString();
    }
}