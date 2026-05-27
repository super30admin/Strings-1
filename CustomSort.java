// Time Complexity : O(n) where n is the length of the input string s.
// Space Complexity : O(26) which is O(1) since we are only storing the frequency of characters in the input string s.
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
// 1. Create a HashMap to store the frequency of characters in the input string s.
// 2. Iterate through the order string and for each character, check if it exists in the HashMap. If it does, append it to the StringBuilder as many times as its frequency and remove it from the HashMap.
// 3. After iterating through the order string, append any remaining characters in the HashMap to the StringBuilder.
// 4. Finally, return the StringBuilder as a string.    

import java.util.*;

class Solution {
    public String customSortString(String order, String s) {

        HashMap<Character, Integer> map = new HashMap<>();

        // Count frequencies
        for (char ch : s.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        StringBuilder sb = new StringBuilder();

        // Add chars according to order
        for (char ch : order.toCharArray()) {

            if (map.containsKey(ch)) {

                int count = map.get(ch);

                for (int i = 0; i < count; i++) {
                    sb.append(ch);
                }

                map.remove(ch);
            }
        }

        // Add remaining chars
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {

            char ch = entry.getKey();
            int count = entry.getValue();

            for (int i = 0; i < count; i++) {
                sb.append(ch);
            }
        }

        return sb.toString();
    }
}