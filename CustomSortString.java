// Time Complexity : O(N)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
import java.util.HashMap;

class Solution {
    public String customSortString(String order, String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        StringBuilder result = new StringBuilder();
        for (char c : order.toCharArray()) {
            if (map.containsKey(c)) {
                int n = map.get(c);
                for (int i = 0; i < n; i++) {
                    result.append(c);
                }
                map.remove(c);
            }
        }
        for (char c : map.keySet()) {
            int n = map.get(c);
            for (int i = 0; i < n; i++) {
                result.append(c);
            }
        }
        return result.toString();
    }
}