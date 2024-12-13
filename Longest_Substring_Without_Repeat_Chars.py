# Approach:
# To solve the problem of finding the length of the longest substring without repeating characters, 
# we can use the sliding window technique with two pointers. One pointer (`start`) will represent the start of the current window 
# and the other pointer will move through the string (`i`). We will use a dictionary `seen` to keep track of the last index of each character.
# When we encounter a repeated character, we update the `start` pointer to one position after the previous occurrence of that character. 
# This way, we always ensure that the substring between `start` and `i` contains unique characters.

# Time Complexity: O(n), where n is the length of the string `s`. We traverse the string once.
# Space Complexity: O(min(n, m)), where n is the length of the string and m is the size of the character set (O(1) since we only store unique characters).
# Did this code successfully run on Leetcode: Yes, the code runs successfully and passes all test cases.
# Any problem you faced while coding this: No issues encountered.

class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        start = result = 0  # Initialize start of window and result to track max length
        seen = {}  # Dictionary to store the most recent index of each character
        
        # Iterate through the string with 'i' as the end of the window
        for i, letter in enumerate(s):
            # If the letter was already seen within the current window
            if seen.get(letter, -1) >= start:
                start = seen[letter] + 1  # Move the 'start' to the next character after the last occurrence of the letter
            result = max(result, i - start + 1)  # Calculate the length of the current window and update the result
            seen[letter] = i  # Update the most recent index of the character
        
        return result  # Return the length of the longest substring
