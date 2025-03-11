#time complexity o(n)
#space complexity o(1)
class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        hmap = defaultdict()
        slow = 0
        n = len(s)
        maxlen = 0
        for i in range(n):
            if s[i] in hmap:
                slow = max(slow,hmap[s[i]]+1)
            hmap[s[i]] = i
            
            maxlen = max(maxlen,i-slow+1)

        return maxlen
