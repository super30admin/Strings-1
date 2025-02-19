// In this problem, using a hashmap to store the characters of the string and its value as the index next to it, so that when we 
// find a repeat of this char we know that we should move our start to the value present in map. Keeping a max variable to store the
// the max length of substring.

// Time Complexity : O(n) where n is the length of the string
// Space Complexity : O(1)  at max 26 characters, so constant
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

class Solution {
    public int lengthOfLongestSubstring(String s) {
        // Base case
        if (s == null || s.length() == 0) {
            return 0;
        }
        // Declare start and max
        int start = 0;
        int max = 0;
        // Hashmap for storing characters
        HashMap<Character, Integer> map = new HashMap<>();
        // Loop through the string
        for (int i = 0; i < s.length(); i++) {
            // Take one char at a time
            char c = s.charAt(i);
            // Check if that char present in map, that means its a repeating char
            if (map.containsKey(c)) {
                // In that case, update the start of the substring, keep the max value of new
                // start and old start because we dont want to go backwards if the new start
                // value is less than the old start
                start = Math.max(start, map.get(c));
            }
            // Calc max length
            max = Math.max(max, i - start + 1);
            // Put in map or update the map
            map.put(c, i + 1);
        }
        // Return max
        return max;
    }
}