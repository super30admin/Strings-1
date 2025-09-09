// Time Complexity : O(n + m), n -> size of source string, m -> size of order string
// Space Complexity : O(n), n-> size of source string
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no
// Approach:
// 1. Iterate over input string and update its frequency in char hash map
// 2. Iterate over order string, if each char is present in map, append to string builder and remove from map
// 3. Append the rest of items from hash map to string builder and return the string

import java.util.HashMap;
import java.util.Map;

public class CustomSort {
    public String customSortString(String order, String s) {
        Map<Character, Integer> charMap = new HashMap<>();

        for(int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            charMap.put(c, charMap.getOrDefault(c, 0)+1);
        }

        StringBuilder result = new StringBuilder();

        for(int i=0; i<order.length(); i++) {
            char c = order.charAt(i);

            if(charMap.containsKey(c)) {
                for(int j=0; j<charMap.get(c); j++) {
                    result.append(c);
                }
                charMap.remove(c);
            }
        }

        charMap.forEach((key, val) -> {
            result.append(String.valueOf(key).repeat(val));
        });

        return result.toString();
    }
}
