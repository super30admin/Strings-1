# Runs on Leetcode
    # Runtime - O(n)
    # Memory - O(1) as we have only 26 unique characters possible, the max size of hashmap is O(26)

class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        if not s:
            return 0
        result = 0
        d = {}
        slow = 0
        fast = 0
        while fast < len(s):
            if s[fast] in d:
                slow = max(d[s[fast]], slow)
            d[s[fast]] = fast+1
            result = max(result, fast-slow+1)
            fast += 1
        return result
