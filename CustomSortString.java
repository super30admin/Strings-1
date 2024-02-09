import java.util.HashMap;
import java.util.Map;

public class CustomSortString {
    // TC: O(M + N) where M is length of S and N is length of order
    // SC: O(1)
    public String customSortString(String order, String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (char ch : s.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        StringBuilder sb = new StringBuilder();
        for (char ch : order.toCharArray()) {
            if (map.containsKey(ch)) {
                int freq = map.get(ch);
                while (freq-- > 0) {
                    sb.append(ch);
                }
                map.remove(ch);
            }
        }
        for (char ch : map.keySet()) {
            int freq = map.get(ch);
            while (freq-- > 0) {
                sb.append(ch);
            }
        }
        return sb.toString();
    }
}
