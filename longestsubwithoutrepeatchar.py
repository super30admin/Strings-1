class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        hmap = {}
        i = 0 
        j = 0
        n = len(s)
        max = 0
        if n == 1:
            return 1
        while(i < n):
            if s[i] not in hmap:
                hmap[s[i]] = i
                i += 1
            else:
                if hmap[s[i]] >= j:
                    j = hmap[s[i]]+1
                hmap[s[i]] = i
                i += 1

            if i-j>max:
                max = i-j
                
        return max
