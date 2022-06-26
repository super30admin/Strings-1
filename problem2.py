class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        if(len(s)==0):
            return 0
        m = 0
        st = 0
        hashmap = dict()
        for i in range(len(s)):
            c = s[i]
            if(c in hashmap):
                st = max(st,hashmap[c])
            m = max(i-st+1,m)
            hashmap[c] = i+1
        return m
            