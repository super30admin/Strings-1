# Time Complexity : O(n), n = length of s
# Space Complexity : O(min(n, m)), m = size of charset (e.g., 26 for lowercase)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Explanation:
# 1. Use sliding window with two pointers (start, end) to track substring without repeats.
# 2. Maintain a set of characters in the current window.
# 3. Expand window by moving `end`; shrink from `start` when a duplicate is found.
# 4. Keep track of maximum length seen.

class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        char_set = set()
        left = 0
        max_len = 0
        
        for right, c in enumerate(s):
            while c in char_set:
                char_set.remove(s[left])
                left += 1
            char_set.add(c)
            max_len = max(max_len, right - left + 1)
        
        return max_len