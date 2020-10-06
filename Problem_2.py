# 3. Longest Substring Without Repeating Characters

# Code:

class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        if len(s)==0:
            return 0
        
        start = 0
        end = 0
        mapping = {}
        
        maxx = float('-inf')
        
        while end<len(s):
            char = s[end]
            if char in mapping:
                start = max(start, mapping[char])
            
            mapping[char]=end+1
            maxx = max(maxx, end-start+1)
            end+=1
        
        return maxx

# Time : O(N)
# Space: O(N)
# Accepted on leetcode: Yes