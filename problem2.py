# Time Complexity : O(2n)
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : YES

# Any problem you faced while coding this : NO
from collections import Counter
class Solution1:
    def customSortString(self, order: str, s: str) -> str:
        res = ""
        freq_s = Counter(s)

        for char in order:
            if char in freq_s:
                res += char * freq_s[char]
            del freq_s[char]
        
        for char, times in freq_s.items():
            res += char * times
        
        return res

# Time Complexity : O(n)
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : YES

# Any problem you faced while coding this : NO
class Solution2:
    def lengthOfLongestSubstring(self, s: str) -> int:
        l,r = 0,0
        res = 0
        seen = {}
        while r < len(s):
            if s[r] in seen and l <= seen[s[r]]:
                l = seen[s[r]] + 1
            seen[s[r]] = r
            res = max(res, r-l+1)
            r += 1
        
        return res