// Time Complexity : O(N)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

public class CustomSortString {
    public String customSortString(String order, String s) {
        StringBuilder res = new StringBuilder();
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        for (int i = 0; i < order.length(); i++) {
            char c = order.charAt(i);
            if (map.containsKey(c)) {
                int count = map.get(c);
                while (count > 0) {
                    res.append(c);
                    count--;
                }
            }
            map.remove(c);
        }
        for (Character key : map.keySet()) {
            int count = map.get(key);
            while (count > 0) {
                res.append(key);
                count--;
            }
        }
        return res.toString();
    }
}