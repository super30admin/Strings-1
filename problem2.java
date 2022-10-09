//Problem2 - https://leetcode.com/problems/custom-sort-string/

// Time Complexity : O(n)
// Space Complexity : O(n) //Constant
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this: No

public class problem2 {
    public String customSortString(String order, String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        StringBuilder res = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        for (int i = 0; i < order.length(); i++) {
            if (map.containsKey(order.charAt(i))) {
                int value = map.get(order.charAt(i));
                while (value > 0) {
                    res.append(order.charAt(i));
                    value--;
                }
                map.remove(order.charAt(i));
            }
        }

        for (Character key : map.keySet()) {
            int value = map.get(key);
            while (value > 0) {
                res.append(key);
                value--;
            }
        }

        return res.toString();

    }
}
