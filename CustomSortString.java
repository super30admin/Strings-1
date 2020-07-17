// Time Complexity : O(m + n) --> where m and n are the lengths of input string
// Space Complexity : O(1)
// Did this code successfully run on Leetcode (791): Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

class Solution {
    public String customSortString(String S, String T) {
        StringBuilder sb = new StringBuilder();
        HashMap<Character, Integer> map = new HashMap<>();
        
        // insert all characters in map and get their relevean counts
        for (int i = 0; i < T.length(); i++) {
            char c = T.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        
        // put the char from map into string builder acc. to the S string order
        for (int i = 0; i < S.length(); i++) {
            char c = S.charAt(i);
            if (map.containsKey(c)) {
                int count = map.get(c);
                while (count > 0) {
                    sb.append(c);
                    count--;
                } 
                map.remove(c);
            }
        }
        
        // traverse through the map and put all char into string builder
        for (Map.Entry<Character, Integer> entry: map.entrySet()) {
            char c = entry.getKey();
            int count = entry.getValue();
            while (count > 0) {
                sb.append(c);
                count--;
            } 
        }
        
        return sb.toString();
    }
}