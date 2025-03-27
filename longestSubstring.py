"""
TC = O(n)
SC - O(1) since only 26 chars
"""


class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        if s is None or len(s) == 0: return 0

        n = len(s)
        hMap = {}
        p1 = 0
        p2 = 0

        for i in range(n):
            if s[i] in hMap:
                # get index of duplicate char from hMap and move pointer p1 to the index next to
                # original duplicate char found in the str
                p1 = max(p1, hMap[s[i]])
            # The next valid position after encountering a duplicate must be one step ahead of the
            # previous occurrence.
            # Storing i+1 allows us to move p1 forward correctly when duplicates appear.
            hMap[s[i]] = i + 1
            p2 = max(p2, i - p1 + 1)
        return p2