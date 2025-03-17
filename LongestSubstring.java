// Time complexity:- O(n)
// Space complexity:- O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach in three sentences only
/**
 * Approach: 
 * This problem is about finding the length of the longest substring without repeating characters.
 * I used a sliding window technique where two pointers (start and end) are used to track the window, and a HashSet ensures only unique characters are present.
 * The start pointer is moved forward when a duplicate character is found, and the maximum window length is updated as we go through the string.
 */ 
class Solution {
    public int lengthOfLongestSubstring(String s) {
        // HashSet to store unique characters in the current sliding window
        HashSet<Character> set = new HashSet<>();

        // start will represent the start index of the sliding window
        int start = 0;
        // Variable to keep track of the maximum length of the substring without repeating characters
        int maxLength = 0;
        
        // Iterate through the string using the 'end' pointer
        for(int end = 0; end < s.length(); end++) {
            // Get the current character at the 'end' pointer
            char ch = s.charAt(end);
            // If the character at 'end' is not in the set, it's a unique character for the window
            if(!set.contains(ch)) {
                // Add the character to the set
                set.add(ch);
                // Calculate the length of the current window (end - start + 1
                int curLength = (end - start + 1);
                // If the current window's length is larger than the previous maxLength, update maxLength
                if(maxLength < curLength) {
                    maxLength = curLength;
                }
            } else {
                // If the character is already in the set, it means we've encountered a duplicate
                // Remove characters from the start of the window until the duplicate character is removed
                while (s.charAt(start) != ch) {
                    set.remove(s.charAt(start));
                    start ++; // Move 'start' to the right to shrink the window
                }
                // Move 'start' one more step to the right to remove the duplicate character
                start = start + 1;
            }
        }
        // Return the maximum length found for substrings with unique characters
        return maxLength;
    }
}
