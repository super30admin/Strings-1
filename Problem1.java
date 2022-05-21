import java.util.HashMap;
import java.util.Map;

public class Problem1 {
    // TC : O (m + n)
    // SC : O (1)
    public String customSortString(String order, String s) {
        if (order == null || s == null) return null;

        Map<Character, Integer> map = new HashMap<>();
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

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
        for (char c : map.keySet()) {
            int count = map.get(c);
            for (int i = 0; i < count; i++) {
                result.append(c);
            }
        }
        return result.toString();
    }
}
