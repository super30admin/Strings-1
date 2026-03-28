# Problem 2
# https://leetcode.com/problems/longest-substring-without-repeating-characters/
class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        slow_ptr = 0
        n = len(s)
        map_val = {}
        max_val = 0
        for i in range(n):
            ch = s[i]
            if ch in map_val:
                slow_ptr = max(slow_ptr,map_val[ch]+1)
            map_val[ch] = i
            max_val = max(max_val,i-slow_ptr+1)
        return max_val