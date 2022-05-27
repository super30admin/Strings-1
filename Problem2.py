#Time Complexity - O(N)
#Space Complexity - O(M)
class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        sett = set()
        res = 0
        left = 0
        for right in range(len(s)):
            while s[right] in sett:
                sett.remove(s[left])
                left+=1
                
            sett.add(s[right])
            
            res = max(res, right - left + 1)
            
        return res