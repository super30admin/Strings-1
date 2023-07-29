class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        n = len(s)
        ans = 0
        mp = {}
        slow = -1

        for j in range(n):
            if s[j] in mp:
                slow = max(mp[s[j]], slow)
    
            ans = max(ans, j - slow)
            mp[s[j]] = j
        
        return ans




