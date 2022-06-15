// Time Complexity : O(n) where n = String.length()
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes

import java.util.*;

public class CustomSortString {
    public String customSortString(String order, String s) {
        // null case
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        StringBuilder result = new StringBuilder();
        for(int i = 0; i < order.length(); i++) {
            char c = order.charAt(i);
            if(map.containsKey(c)) {
                int count = map.get(c);
                while(count > 0) {
                    result.append(c);
                    count--;
                }
                map.remove(c);
            }
        }
        for(char c: map.keySet()) {
            int count = map.get(c);
            while(count > 0) {
                result.append(c);
                count--;
            }
        }
        return result.toString();
    }
}
