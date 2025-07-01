//Time Complexity : O(n)
//Space Complexity : O(1)
/* Approach : To find the length of the longest substring without repeating characters involves using a sliding window technique with 
two pointers. We maintain a HashMap to store the latest positions of characters. As we iterate through the string with the right pointer,
if a character is already in the map, we move the left pointer to the right of the last occurrence of that character to ensure no 
duplicates in the current window. We update the character's position in the map and calculate the maximum length of the substring 
during each iteration. This ensures we efficiently find the longest substring without repeating characters.
 */
class Solution {
    public int lengthOfLongestSubstring(String s) {
        // Get the length of the input string
        int l = s.length();
        
        // If the string is empty, return 0
        if (l < 1) return 0;
        
        // Initialize pointers for the sliding window and the maximum length variable
        int left = 0;
        int max = 0;
        
        // Create a HashMap to store the characters and their latest positions
        HashMap<Character, Integer> map = new HashMap<>();
        
        // Iterate through the string with the right pointer
        for (int right = 0; right < l; right++) {
            char c = s.charAt(right);
            
            // If the character is already in the map, move the left pointer
            // to the right of the same character's last occurrence
            if (map.containsKey(c)) {
                left = Math.max(left, map.get(c) + 1);
            }
            
            // Update the character's latest position in the map
            map.put(c, right);
            
            // Calculate the maximum length of the substring without repeating characters
            max = Math.max(max, right - left + 1);
        }
        
        // Return the maximum length found
        return max;
    }
}
