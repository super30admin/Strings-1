import java.util.HashMap;

/**
 * Time Complexity: O(m+n) where m is length of s and n is length of order
 * Space Complexity: O(1), at max there could be only 26 characters keys in the map
 * Did this code successfully run on Leetcode: Yes
 * Any problem you faced while coding this: None

 * Approach:
 * 1. Iterate over "s" and get all the frequencies of characters in s
 * 2. Then find the occurences in map based on the "order" and remove all the key once all occurrences are accounted for.
 * 3. Add remaining characters to the result
 */

public class CustomSortString {
    public String customSortString(String order, String s) {
        if(order == null || order.length() == 0) {
            return s;
        }
        HashMap<Character, Integer> map = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        for(int i = 0; i < order.length(); i++) {
            char c = order.charAt(i);
            if(map.containsKey(c)) {
                int times = map.get(c);
                for(int j = 0; j < times; j++) {
                    sb.append(c);
                }
                map.remove(c);
            }
        }
        for(char key : map.keySet()) {
            int times = map.get(key);
            for(int j = 0; j < times; j++) {
                sb.append(key);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        // Your code here
        CustomSortString obj = new CustomSortString();
        String result = obj.customSortString("gylh", "alllbclgyah");
        System.out.println(result);
    }
}