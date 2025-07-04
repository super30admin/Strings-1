"""
hashset solution
Time - O(n)
Space - O(n)
"""
class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        start = 0
        max_length = 0
        seen = set()

        for end in range(len(s)):
            while s[end] in seen:
                seen.remove(s[start])
                start += 1
            seen.add(s[end])
            max_length = max(max_length, end - start + 1)

        return max_length
