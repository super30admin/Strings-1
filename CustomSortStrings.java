import java.util.HashMap;
import java.util.Map;

// TC: O(n) as characters in s are traversed to store its frequency in map.
// SC: O(n) for using Map.

// Run successfully on Leetcode.
// Storing the count in map and appending it based on the order.
public class CustomSortStrings {

    public static void main(String[] args) {
        System.out.println(customSortString("cba", "cbad"));// cbad
        System.out.println(customSortString("bcafg", "abcd"));// bcad
    }

    public static String customSortString(String order, String s) {
        if (order == null || order.length() == 0)
            return s;
        Map<Character, Integer> sMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            sMap.put(s.charAt(i), sMap.getOrDefault(s.charAt(i), 0) + 1);
        }
        StringBuilder sb = new StringBuilder();
        for (char o : order.toCharArray()) {
            if (sMap.containsKey(o)) {
                int val = sMap.get(o);
                while (val-- > 0)
                    sb.append(o);
                sMap.remove(o);
            }
        }
        for (char key : sMap.keySet()) {
            int val = sMap.get(key);
            while (val-- > 0)
                sb.append(key);
        }
        return sb.toString();
    }
}