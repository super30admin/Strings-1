## Problem2 

# Longest Substring Without Repeating Characters(https://leetcode.com/problems/longest-substring-without-repeating-characters/)
class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        # Time Complexity: O(N), where N is the length of the string. 
        # Each character is visited at most twice (once by the right pointer 'i' and once by the 'left' pointer).
        # Space Complexity: O(1).

        charSet = set() # Stores the unique characters in the current sliding window
        left = 0        # Left pointer of the sliding window
        maxLen = 0      # Keeps track of the maximum length found so far

        # 'i' acts as the right pointer, expanding the window
        for i in range(len(s)):
            char = s[i]
            
            # If the character is unique in the current window, add it and update the max length
            if char not in charSet:
                charSet.add(char)
                maxLen = max(maxLen, len(charSet))
            else:
                # If we find a duplicate character, we need to shrink the window from the left
                # Remove characters from the set until we remove the previous instance of 'char'
                while s[left] != char:
                    charSet.remove(s[left])
                    left += 1
                
                # Increment left one more time to effectively "skip" the duplicate character 
                # Note: We don't remove 'char' from the set here because the new 'char' at index 'i' replaces it
                left += 1

        return maxLen