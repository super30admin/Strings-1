class Solution:
    """
    Time Complexity: O(N)
    Space Complexity: O(1)
    """
    def lengthOfLongestSubstring(self, s: str) -> int:
        frq_map = {}  # Dictionary to store frequency of characters
        i = 0  # Start index of the current window
        max_len = 0  # Variable to store the length of the longest substring

        # Iterate through the string
        for j in range(len(s)):
            if s[j] not in frq_map:
                frq_map[s[j]] = 0
            frq_map[s[j]] += 1  # Increment the frequency of the current character

            # Check if the current window has more unique characters than allowed
            while j - i + 1 > len(frq_map):
                frq_map[s[i]] -= 1  # Decrease the frequency of the leftmost character
                if frq_map[s[i]] == 0:
                    del frq_map[s[i]]  # Remove the character from the map if its frequency is 0
                i += 1  # Shrink the window from the left

            # Update the maximum length of the substring found so far
            max_len = max(max_len, j - i + 1)

        return max_len  # Return the length of the longest substring without repeating characters
