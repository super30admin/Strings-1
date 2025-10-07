class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        n=len(s)
        smap={}
        slow=0
        max_len=0

        for i in range(n):
            c=s[i]
            if c in smap:
                slow=max(slow, smap[c]+1)
            smap[c]=i
            max_len=max(max_len,i-slow+1)
        return max_len


        