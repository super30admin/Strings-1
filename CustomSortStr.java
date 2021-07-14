// Time Complexity : O((n + m)),where m and n are length of two strings
// Space Complexity : O(1), at max hashmap will only have 26 characters
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :    No
package strings1;

import java.util.*;

public class CustomSortStr {

    public String customSortString(String order, String str) {
        StringBuilder res = new StringBuilder();
        if (str == null || str.length() == 0) {
            return res.toString();
        }
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        for (int i = 0; i < order.length(); i++) {
            char c = order.charAt(i);
            if (map.containsKey(c)) {
                int count = map.get(c);
                while (count > 0) {
                    res.append(c);
                    count--;
                }
                map.remove(c);
            }
        }
        for (char key : map.keySet()) {
            int count = map.get(key);
            while (count > 0) {
                res.append(key);
                count--;
            }
        }
        return res.toString();
    }
}
