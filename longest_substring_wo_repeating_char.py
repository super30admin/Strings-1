class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        
        # T.C = O(n)
        # S.C = O(1)

        hm = {}
        start = 0
        mx = 0

        for i in range(len(s)):
            if s[i] in hm.keys():
                start = max(start, hm[s[i]])
            hm[s[i]] = i + 1
            mx = max(mx, i - start + 1)
        
        return mx
        