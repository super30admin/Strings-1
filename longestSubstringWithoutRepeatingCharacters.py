"""
Approach: have a hashmap of latest occurrence of a char and whenver you come to the same char reduce the window
to the last occurance + 1 position.
t.c. = O(n)
s.c. => O(1)
"""
from collections import defaultdict
class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        usedChardMap = defaultdict(int)

        l = 0
        maxLen = 0
        for r in range(len(s)):
            if s[r] in usedChardMap and usedChardMap[s[r]] >= l:
                l = usedChardMap[s[r]] + 1
            maxLen = max(maxLen, r - l + 1)
            usedChardMap[s[r]] = r
        return maxLen