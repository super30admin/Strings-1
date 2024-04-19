// Time Complexity : O(n+m),
// Space Complexity : O(n), 
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No

// Your code here along with comments explaining your approach
class Solution {
    public String customSortString(String order, String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        int count = 0;
        for (int i = 0; i < order.length(); i++) {
            char ch = order.charAt(i);
            if (map.containsKey(ch)) {
                count = map.get(ch);
                while (count > 0) {
                    sb.append(ch);
                    count--;
                }
                map.remove(ch);
            }
        }
        for (char key : map.keySet()) {
            count = map.get(key);
            while (count > 0) {
                sb.append(key);
                count--;
            }
        }
        return sb.toString();
    }
}