// Time Complexity : O(N+ k) = O(N) where K is just 26 letters of order and N is string of max 200 length
// Space Complexity : O(1) as only english letters
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    public String customSortString(String order, String s) {
        if (s == null || s.length() == 0) return s;
        Map<Character, Integer> map = new HashMap<>();
        StringBuilder res = new StringBuilder();
        //update count in map
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        //placing characters in order in the stringBuilder
        for (int i = 0; i < order.length(); i++) {
            char ch = order.charAt(i);
            if (map.containsKey(ch)) {
                int count = map.get(ch);
                while (count > 0) {
                    res.append(ch);
                    count--;
                }
                map.remove(ch);
            }
        }

        for (char key : map.keySet()) {
            int count = map.get(key);
            while (count > 0) {
                res.append(key);
                count--;
            }
        }
        return res.toString();
    }
}