import java.util.HashMap;
    /**
     * Time Complexity: O(n), where n is the length of the string 's'.
     * Space Complexity: O(min(n, m)), where m is the character set size (256 for ASCII).
     */
class Solution {
    public int lengthOfLongestSubstring(String s) {
        // Edge case: if the input string is empty, return 0
        if (s.length() == 0) return 0;
        
        // HashMap to store the last seen index of each character
        HashMap<Character, Integer> lastSeen = new HashMap<>();
        
        // Initialize pointers for the sliding window
        int left = 0;
        int right = 0;
        
        // Variable to keep track of the length of the longest substring
        int result = 0; // Initialize to 0, as substring length cannot be negative
        
        // Traverse the string with the right pointer
        while (right < s.length()) {
            // Get the current character at the right pointer
            char current = s.charAt(right);
            
            // If the current character has been seen before and is within the current window
            if (lastSeen.containsKey(current)) {
                // Move the left pointer to the right of the last seen index of the current character
                // This avoids duplicate characters in the substring
                left = Math.max(left, lastSeen.get(current) + 1);
            }
            
            // Update the last seen index of the current character to the right pointer's index
            lastSeen.put(current, right);
            
            // Update the result with the maximum length of the substring found so far
            result = Math.max(result, right - left + 1);
            
            // Move the right pointer to the next character
            right++;
        }
        
        // Return the length of the longest substring without repeating characters
        return result;
    }
}
