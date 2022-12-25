'''
Time Complexity -->
O(n)

Space Complexity -->
O(1)
'''
class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        if len(s)==0:
            return 0 
        start = 0
        max_len = 1
        map = {}
        for i in range(len(s)):
            if s[i] in map:
                start = max(start, map[s[i]])
            map[s[i]] = i+1
            max_len = max(max_len, (i-start)+1)
        return max_len
                