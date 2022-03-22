class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        hmap = {}
        i= slow = m = 0
        print(len(s))
        for i in range(len(s)):
            if s[i] in hmap:
                slow = max(slow, hmap.get(s[i]))
            hmap[s[i]] = i + 1
            m = max(m, i-slow + 1)
        return m
        
