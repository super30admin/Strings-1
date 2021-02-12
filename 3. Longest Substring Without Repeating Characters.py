# T = O(n)
# S = O(1)

class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        maxx = 0
        if not s:
            return maxx
        low = 0
        dictt = {}
        for i in range(len(s)):
            c = s[i]
            if c in dictt and low <= dictt[c]:
                low = dictt[c]
            dictt[c] = i+1
            maxx = max(maxx, i-low+1)
        return(maxx)