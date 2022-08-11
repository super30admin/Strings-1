class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        if(len(s)==0):
            return None
        tab = dict()
        x = 0
        ans = 0
        for i in range(len(s)):
            if(tab.get(s[i]) is not None):
                x = max(x, tab[s[i]]+1)
            tab[s[i]] = i
            ans = max(ans, i-x+1)
        return ans
            
        