// Time Complexity : O(n + m) where m and n are the lengths of the order and input string
// Space Complexity : O(1) since there are only 26 characters
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach

/**
 * Creating a hashmap of each character and its count in the input string. Then iterating over the order string to put occurrence of each order character in the result string based on its occurrence count.
 * Then putting the rest of the elements from source string in the response.
 */
class Solution {
    public String customSortString(String order, String s) {

        Map<Character, Integer> freq = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            freq.put(s.charAt(i), freq.getOrDefault(s.charAt(i), 0) + 1);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < order.length(); i++) {
            char ch = order.charAt(i);
            if (freq.containsKey(ch)) {
                int cnt = freq.get(ch);
                for (int j = 0; j < cnt; j++) {
                    sb.append(ch);
                }
                freq.remove(ch);
            }
        }
        for (char key : freq.keySet()) {
            int cnt = freq.get(key);
            for (int j = 0; j < cnt; j++) {
                sb.append(key);
            }
        }

        return sb.toString();
    }
}