'''
Time Complexity - O(n)
Space Complexity - O(1)
'''


class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        hmap = {}
        slow = 0
        maximum = 0
        for i in range(len(s)):
            char = s[i]
            if char in hmap:
                slow = max(slow, hmap[char])
            maximum = max(maximum, i-slow+1)
            hmap[char] = i+1
        return maximum
