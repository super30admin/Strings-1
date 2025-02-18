#size: O(1)
# Time: O(n)
class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        if len(s) == None:
            return 0
        hmap= dict()
        start = 0
        mx= 0
        for i in range(len(s)):
            if s[i] in hmap:
                start= max(start, hmap[s[i]]+1)
            hmap[s[i]]= i
            mx = max(i - start + 1, mx)
        return mx
        
