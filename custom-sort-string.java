// Time Complexity : O(M + N)
// Space Complexity : O(M + N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    // TC = O(m + n), SC = O(m + n), StringBuilder + order HashMap
    public String customSortString(String order, String s) {
        // null
        if(order == null || order.length() == 0) return s;
        StringBuilder sb = new StringBuilder();
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < s.length(); i++) { // noting the frequency of chars in s
            char c = s.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        for(int i = 0; i < order.length(); i++) { // putting in the order of order
            char c = order.charAt(i);
            if(map.containsKey(c)) {
                int times = map.get(c); // putting that many times
                for(int j = 0; j < times; j++) {
                    sb.append(c);
                }
                map.remove(c);
            }
        }
        for(char key : map.keySet()) { // appending remaining chars in the map ac to their frequency
            int times = map.get(key);
            for(int i = 0; i < times; i++) {
                sb.append(key);
            }
        }
        return sb.toString();
    }
}