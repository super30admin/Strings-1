import java.util.HashMap;

// Time Complexity : O(m+n)
// Space Complexity : O(m)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Creating an HashMap to store the occurrences of source string and then creating a result string out of that
// occurrences according to the order.      

public class customSortString {
    public String customSortString(String order, String s) {
        HashMap<Character, Integer> map1 = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            map1.put(s.charAt(i), map1.getOrDefault(s.charAt(i), 0) + 1);
        }

        StringBuilder result = new StringBuilder();

        for (int i = 0; i < order.length(); i++) {
            char c = order.charAt(i);
            if (map1.containsKey(c)) {
                int cnt = map1.get(c);
                for (int k = 0; k < cnt; k++) {
                    result.append(c);
                }
                map1.remove(c);
            }
        }

        for (char c : map1.keySet()) {
            int cnt = map1.get(c);
            for (int k = 0; k < cnt; k++) {
                result.append(c);
            }
        }
        return result.toString();
    }
}
