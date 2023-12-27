/**
 * 
 * approach :
 * for s, build a map, with character and it's frequency
 * now, move over order, and check for it's occurrence in s, if exist, first
 * build a stringbuilder, and append the freq*char into tha sb.
 * after going over all ORDER string, go over left keys in map.
 * TC: O(m+n)
 * sc: O(1) // map - at most 26 characters + O(n) stringbuilder ; n = len of s;
 * m = len of order
 * 
 */

class Solution {
    public String customSortString(String order, String s) {

        // base case
        if (order == null || s == null)
            return "";

        // build a map of frequency
        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < order.length(); i++) {
            char c = order.charAt(i);
            if (map.containsKey(c)) {
                int count = map.get(c);

                while (count > 0) {
                    sb.append(c);
                    count--;
                }
                map.remove(c);
            }
        }

        // for the left over keys
        for (char c : map.keySet()) {
            int count = map.get(c);

            while (count > 0) {
                sb.append(c);
                count--;
            }
        }

        return sb.toString();
    }
}