// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


import java.util.HashMap;
import java.util.Map;

class Solution {

    public String customSortString(String order, String s) {
        return helper(order, s);
    }

    //TC: O(2n + m) [n: length so String S; m: length of String Order]
    //SC: O(m)
    private String helper(String order, String s) {
        StringBuilder sb = new StringBuilder();
        Map<Character, Integer> sMap = new HashMap<>();

        for (char c : s.toCharArray()) {
            sMap.put(c, sMap.getOrDefault(c, 0) + 1);
        }

        for (char c : order.toCharArray()) {
            if (sMap.containsKey(c)) {
                for (int i = 0; i < sMap.get(c); i++) {
                    sb.append(c);
                }
                sMap.remove(c);
            }
        }

        for (char c : sMap.keySet()) {
            for (int i = 0; i < sMap.get(c); i++) {
                sb.append(c);
            }
        }

        return sb.toString();
    }
}