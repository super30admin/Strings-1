// Time Complexity : O(n + m)
// Space Complexity : O(1) -> 26 characters
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


class Solution {
    public String customSortString(String order, String s) {
        if (s == null || s.length() == 0) {
            return s;
        }
        HashMap<Character, Integer> map = new HashMap<>(); // hashmap to store occurences and character
        StringBuilder sb = new StringBuilder(); // string builder
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1); // adding to map
        }
        for (int i = 0; i < order.length(); i++) { // iterating over the order string
            char c = order.charAt(i);
            if (map.containsKey(c)) {
                int times = map.get(c);
                for (int j = 0; j < times; j++) {
                    sb.append(c);
                }
                map.remove(c);
            }
        }
        for (char key : map.keySet()) { // iterating over the map to fill in left out elements
            int times = map.get(key);
            for (int j = 0; j < times; j++) {
                sb.append(key);
            }
        }

        return sb.toString();
    }
}