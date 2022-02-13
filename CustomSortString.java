//  Time Complexity: O(max(len(order, s)))
//  Space Complexity: O(len(s))

import java.util.*;

public class CustomSortString {
    public String customSortString(String order, String s) {
        Map<Character, Integer> map = new HashMap<>();

        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        StringBuilder result = new StringBuilder();
        for (char c : order.toCharArray()) {
            if (map.containsKey(c)) {
                int count = map.get(c);
                for (int i = 0; i < count; ++i) {
                    result.append(c);
                }
                map.remove(c);
            }
        }

        for (char c : map.keySet()) {
            int count = map.get(c);
            for (int i = 0; i < count; ++i) {
                result.append(c);
            }
        }

        return result.toString();
    }
}
