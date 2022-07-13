// Time Complexity : O(m+n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

//791. Custom Sort String
//https://leetcode.com/problems/custom-sort-string/

class Solution {
    // time: O(m+n)
    // space: O(1)
    public String customSortString(String order, String s) {

        // Use hashmap to store the string s chars and its count
        HashMap<Character, Integer> map = new HashMap<>();

        int m = order.length();
        int n = s.length();

        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (!map.containsKey(c)) {
                map.put(c, 1);
            } else {
                map.put(c, map.get(c) + 1);
            }
        }
        // Make a resultant stringbuilder
        StringBuilder sb = new StringBuilder();

        // Iterate over order string, append the resultant string, and reduce count of
        // the characters just added to the resultant string or remove it from the
        // hashmap
        for (int j = 0; j < m; j++) {
            char cHar = order.charAt(j);
            if (map.containsKey(cHar)) {
                for (int k = 0; k < map.get(cHar); k++) {
                    sb.append(cHar);
                }
                map.remove(cHar);
            }
        }

        // Iterate over the hashmap to append the remaining string
        for (Map.Entry mapElement : map.entrySet()) {

            String key = (String) mapElement.getKey().toString();
            int val = (int) mapElement.getValue();

            for (int t = 0; t < val; t++) {
                sb.append(key);
            }
            map.remove(key);
        }

        // Return the resultant string
        return sb.toString();

    }
}