#TC - O(n)
#SC - O(k)
class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        l = 0 
        maxi = 0 
        freq = {}
        for r in range(len(s)):
            if s[r] not in freq:
                freq[s[r]] = 0
            freq[s[r]]+=1
            while freq[s[r]]>1:
                freq[s[l]]-=1
                
                l+=1
            maxi = max(maxi,(r-l+1))
        return maxi
        