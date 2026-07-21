# Problem2 : Longest Substring Without Repeating Characters(https://leetcode.com/problems/longest-substring-without-repeating-characters/)
# Time Complexity: O(n), each character is visited once by the right pointer
# Space Complexity: O(1), the map holds at most 128 distinct ASCII characters

# Approach:
# We slide a window over the string and store the latest index of every character in a map.
# When the new character already exists inside the window, we move the left edge just past its last occurrence.
# At every step we measure the current window size and keep the largest one seen.

class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        slow = 0                                    # left edge of the current window
        n = len(s)                                  # total number of characters to scan
        max_length = 0                              # best window size found so far, 0 handles empty string
        char_map = {}                               # character to the most recent index where it appeared

        for i in range(n):                            # i is the right edge, it only moves forward
            char = s[i]                                # the character entering the window

            if char in char_map:                       # we have seen this character at some point before
                slow = max(slow, char_map[char] + 1)   # jump past its last position, max stops slow going backward

            char_map[char] = i                         # always record the newest position of this character
            max_length = max(max_length, i - slow + 1)    # current window length, keep it if it beats the record

        return max_length                              # the longest window we ever formed
