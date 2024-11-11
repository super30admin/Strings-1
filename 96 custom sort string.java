// Time Complexity : 0(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    //aesha
    public String customSortString(String order, String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        StringBuilder result = new StringBuilder();
        for (char c : order.toCharArray()) {
            if (map.containsKey(c)) {
                int freq = map.get(c);
                for (int i = 0; i < freq; i++) {
                    result.append(c);
                }
                map.remove(c);
            }
        }
        for (char c : map.keySet()) {
            int freq = map.get(c);
            for (int i = 0; i < freq; i++) {
                result.append(c);
            }
        }
        return result.toString();
    }
}