// In this problem, storing the characters in string s with its frequency in hashmap, then iterating through the order string
// and checking if the current char in hashmap, then append it to our result string that many times, then remove it from hashmap.
// Then whatever remains in hashmap, append that to the string.

// Time Complexity : O(m+n)
// Space Complexity : O(m)  length of string
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

class Solution {
    public String customSortString(String order, String s) {
        // Base Case
        if (order == null || order.length() == 0) {
            return s;
        }
        // Frequency map
        HashMap<Character, Integer> map = new HashMap<>();
        // Stringbuilder so that it doesn't generate new string every time we append to
        // it
        StringBuilder sb = new StringBuilder();
        // Iterate through the string and put in hashmap
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);

        }
        // Iterate through order and check if present in hashmap
        for (int i = 0; i < order.length(); i++) {
            char ca = order.charAt(i);
            if (map.containsKey(ca)) {
                // If present then check how many times
                int times = map.get(ca);
                // Run a loop that many times and append it to our stringbuilder
                for (int j = 0; j < times; j++) {
                    sb.append(ca);
                }
            }
            // Then remove from hashmap
            map.remove(ca);
        }
        // Then whatever left in hashmap (bcoz it was not present in order)
        for (char sd : map.keySet()) {
            // Check how many times
            int times = map.get(sd);
            // Run a loop that many times and append it to our stringbuilder
            for (int i = 0; i < times; i++) {
                sb.append(sd);
            }

        }
        // Convert to string and return
        return sb.toString();
    }
}