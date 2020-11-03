# Time Complexity : - N*maxLen
# Space Complexity :- maxLen
# Ran on Leetcode - Yes


class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        
        
        i=0
        j=0
        n = len(s)
        
        maxLen = 0
        string = ""
        while i<=j and j!=n:
            char = s[j]
            if char not in string:
                string = s[i:j+1]

                if len(string) > maxLen:
                    maxLen = len(string)
                j = j+1
            else:
                string = s[i+1:j]
                i=i+1
            
        return maxLen
