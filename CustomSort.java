// Time Complexity : O(n) // n is the length of s
// Space Complexity : O(1) //at max 26 characters would be stored at once
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// Your code here along with comments explaining your approach

import java.util.*;

class Solution {
    public String customSortString(String order, String s) {
        if (order.length() == s.length() && order.equals(s))
            return s;

        StringBuilder result = new StringBuilder();
        Map<Character, Integer> freqMap = new HashMap<>();
        // creating a freq maop for s
        for (char ch : s.toCharArray()) {
            freqMap.put(ch, freqMap.getOrDefault(ch, 0) + 1);
        }
        // iterate through order and get the chars and add in to result
        for (char ch : order.toCharArray()) {
            if (freqMap.containsKey(ch)) {
                int count = freqMap.get(ch);
                while (count > 0) {
                    result.append(ch);
                    count--;
                    // remove char from map
                    if (count == 0)
                        freqMap.remove(ch);
                }
            }
        }
        // check for remaining characters in freqMap
        for (char ch : freqMap.keySet()) {
            int count = freqMap.get(ch);
            while (count > 0) {
                result.append(ch);
                count--;
            }
        }
        // convert stringbuilder back to string
        return result.toString();
    }
}