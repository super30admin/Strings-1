
// Time Complexity - 0(n + m) 
// Space Complexity - 0(n)
import java.util.HashMap;

class Solution {
    public String customSortString(String order, String s) {
        if (s == null || s.length() == 0) {
            return s;
        }
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < order.length(); i++) {
            char c = order.charAt(i);
            if (map.containsKey(c)) {
                int times = map.get(c);
                for (int j = 0; j < times; j++) {
                    result.append(c);
                }
                map.remove(c);
            }
        }
        for (char key : map.keySet()) {
            int times = map.get(key);
            for (int j = 0; j < times; j++) {
                result.append(key);
            }
        }
        return result.toString();
    }
}