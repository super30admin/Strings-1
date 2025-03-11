/*
Time Complexity (TC):
O(n) because each character is processed at most twice (once when i advances and once when slow advances).
Space Complexity (SC):
O(n) due to the space used by the HashMap to store the last seen index of each character.
Code Explanation:
The code uses a sliding window technique with two pointers (slow and i). A HashMap is used to track the last index of each character. 
When a duplicate is found, it moves the slow pointer to the next position after the last occurrence of that character, ensuring the substring contains only unique characters. 
The maximum length is updated throughout the process.
 */

 class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {  // Handle empty or null input string
            return 0;
        }
        
        int slow = 0;  // Pointer to track the start of the substring
        HashMap<Character, Integer> map = new HashMap<>();  // Map to store the last seen index of each character
        int maxLen = 0;  // Variable to store the maximum length of substring
        int n = s.length();  // Length of the input string
        
        for (int i = 0; i < n; i++) {  // Traverse through the string with 'i'
            char ch = s.charAt(i);  // Get the current character
            
            if (map.containsKey(ch)) {  // If character is already in the map, update 'slow' to skip the duplicate
                slow = Math.max(slow, map.get(ch) + 1);  // Move slow pointer to the next index after the duplicate
            }
            
            map.put(ch, i);  // Update the map with the current character's index
            maxLen = Math.max(maxLen, i - slow + 1);  // Update maxLen with the largest substring length
        }
        
        return maxLen;  // Return the length of the longest substring without repeating characters
    }
}
