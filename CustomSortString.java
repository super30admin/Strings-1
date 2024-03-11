// Time: O(m + n)
// Space: O(m) where m = length of string; Used in string builder

// Approach: Count all characters in string; place the ones in order 
// accordingly and remove from the map; Place the rest after

import java.util.HashMap;
import java.util.Map;

class CustomSortString {
    public String customSortString(String order, String s) {
        Map<Character, Integer> frequencyMap = new HashMap<>();
        for (char c : s.toCharArray()) {
            frequencyMap.put(c, frequencyMap.getOrDefault(c, 0) + 1);
        }

        StringBuilder res = new StringBuilder();
        for (int i = 0; i < order.length(); i++) {
            char current = order.charAt(i);
            if (frequencyMap.containsKey(current)) {
                int count = frequencyMap.get(current);
                while (count > 0) {
                    res.append(current);
                    count--;
                }
                frequencyMap.remove(current);
            }
        }

        for (char c : frequencyMap.keySet()) {
            int count = frequencyMap.get(c);
            while (count > 0) {
                res.append(c);
                count--;
            }
        }

        return res.toString();

    }
}