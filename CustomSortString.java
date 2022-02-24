import java.util.*;
import java.util.Map.*;

public class CustomSortString {
    public String customSortString(String order, String s) {
        HashMap<Character, Integer> h = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!h.containsKey(c)) {
                h.put(c, 1);
            } else {
                h.put(c, h.get(c) + 1);
            }
        }
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < order.length(); i++) {
            char c = order.charAt(i);
            if (h.containsKey(c)) {
                for (int j = 0; j < h.get(c); j++) {
                    sb.append(c);
                }
                h.remove(c);
            }
        }
        for (Entry<Character, Integer> entry : h.entrySet()) {
            char c = entry.getKey();
            for (int i = 0; i < entry.getValue(); i++) {
                sb.append(c);
            }
        }

        return sb.toString();
    }
}
// O(n)

// https://leetcode.com/problems/custom-sort-string/