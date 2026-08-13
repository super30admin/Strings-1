## Problem2 

# Longest Substring Without Repeating Characters(https://leetcode.com/problems/longest-substring-without-repeating-characters/)
class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        """
        Solution 1: Optimized Sliding Window using Hash Map (Last Seen Indices)
        
        LOGIC OVERVIEW:
        - We use a sliding window defined by two pointers: `left` and `right`.
        - As `right` iterates through the string, `seen` keeps track of the most recent 
          index of each character.
        - If we encounter a character already in `seen` and its previous index is >= `left` 
          (meaning it falls inside our current window), we have found a duplicate.
        - We update `maxlen` for the window right before the repeat, then jump `left` 
          forward to `seen[ch] + 1` to skip past the duplicate character.
        - If the character is unique to the current window, we expand the window and 
          update `maxlen` continuously.

        TIME COMPLEXITY:
        - O(N): Where N is the length of the string `s`.
        - Each character is visited once by the `right` pointer. Looking up and updating 
          the hash map takes O(1) average time. Unlike a standard sliding window, `left` 
          jumps directly to the new index rather than moving step-by-step.

        SPACE COMPLEXITY:
        - O(min(N, M)): Where N is string length and M is the size of the character set 
          (e.g., 26 for lowercase English letters, 128 for ASCII, or 256 for extended ASCII).
        - In the worst case, the hash map `seen` stores at most M distinct characters.
        """
        n = len(s)
        if n == 0:
            return 0

        maxlen = -1
        seen = {}  # Maps character -> its most recent index in string `s`
        left = 0   # Left boundary of the sliding window

        for right in range(n):
            ch = s[right]

            # Check if character is repeating AND within the current active window
            if ch in seen and seen[ch] >= left:
                # Update maxlen with window size prior to duplicate: (right - left)
                maxlen = max(maxlen, (right - left))
                
                # Move left pointer past the previous occurrence of `ch`
                left = seen[ch] + 1
                
                # Update the last seen index for current character
                seen[ch] = right
            else:
                # Character is valid/new in the current window; update maxlen with current size: (right - left + 1)
                maxlen = max(maxlen, (right - left + 1))
                
                # Record the position of the character
                seen[ch] = right

        return maxlen


        """ 
        Solution 2 
        """
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