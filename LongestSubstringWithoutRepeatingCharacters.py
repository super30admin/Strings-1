#Time Complexity: O(n)
#Space Complexity: O(1)

class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        if s==" ":
            return 1
        d = {}
        maximum = 0
        i=0
        for j in range(len(s)):
            if s[j] in d:
                i = max(i,d[s[j]]+1)
            d[s[j]] = j 
            maximum = max(maximum,j-i+1)       
        return maximum