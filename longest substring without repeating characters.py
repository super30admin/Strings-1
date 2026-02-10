class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:

        map={}

        l=0
        max_len=0
       

        for r in range(len(s)):
            if s[r] in map and map[s[r]]>=l:
                l=map[s[r]]+1

            map[s[r]]=r

            max_len=max(max_len,r-l+1)

        return max_len