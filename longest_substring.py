#TC: O(n)
#SC: O(min(m, n))
class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        char_index = {}  # Store the index of each character in the string
        max_length = 0
        start = 0
        
        for end, char in enumerate(s):
            if char in char_index and char_index[char] >= start:
                start = char_index[char] + 1  # Move the start of the window
            char_index[char] = end
            max_length = max(max_length, end - start + 1)
        
        return max_length