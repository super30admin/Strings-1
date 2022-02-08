class Solution {
    // Time Complexity : O(m+n), where m is the length of string order and n is the length of string s
    // Space Complexity : O(n)
    // Did this code successfully run on Leetcode : Yes
    // Any problem you faced while coding this : No
    public String customSortString(String order, String s) {
        HashMap<Character, Integer> map = new HashMap<>();

        for(int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0)+1);
        }
        StringBuilder sb = new StringBuilder();
        for(int j = 0; j < order.length(); j++) {
            char ch = order.charAt(j);
            if(map.containsKey(ch)) {
                int count = map.get(ch);
                for(int k = 0; k < count; k++) {
                    sb.append(ch);
                }
                map.remove(ch);
            }
        }

        for(Character c : map.keySet()) {
            int count = map.get(c);
            for(int k = 0; k < count; k++) {
                sb.append(c);
            }
        }
        return sb.toString();
    }
}