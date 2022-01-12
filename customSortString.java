// Time Complexity : O(m+n)
// Space Complexity : O(n), where n is used in StringBuilder of size string s
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :No


// Your code here along with comments explaining your approach
class Solution {
    public String customSortString(String order, String s) {
        if (s == null || s.length() == 0) return "";

        Map<Character, Integer> map = new HashMap<>();
        StringBuilder sb = new StringBuilder();

        // Itterate over the string s, and add them to the map with the count of each character
        for (int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        // Itterate over each character in the order string, get the info from map and append to StringBuilder
        for (int i=0; i<order.length(); i++) {
            char ch = order.charAt(i);

            if(map.containsKey(ch)) {
                int count = map.get(ch);
                for (int j=0; j<count; j++) {
                    sb.append(ch);
                }
                map.remove(ch);             // remove after its use is done, so that in the next step we dont get it again
            }
        }

        // add the remaining characters to the result
        for(Character c: map.keySet()) {
            int count = map.get(c);
            for (int j=0; j<count; j++) {
                sb.append(c);
            }
        }

        return sb.toString();
    }
}